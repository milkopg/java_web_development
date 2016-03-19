package bg.softuni.banking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bg.softuni.banking.constants.Constants;
import bg.softuni.banking.entities.Operation;
import bg.softuni.banking.entities.OperationType;
import bg.softuni.banking.utility.UserUtils;

@Repository
public class OperationDaoImpl implements OperationDao{
	
	private static Logger logger = LoggerFactory.getLogger(AccountDaoImpl.class);
	
	@Autowired
	AccountDao accountDao;
	
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			logger.error("Cannot load driver");
		}
	}

	@Override
	public OperationType getOperationTypeById(Long id) {
		String sql = "SELECT * FROM tOperationType where id = ?";
		OperationType operationType = null;
		try (
				Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USERNAME	, Constants.DB_PASSWORD);
				
				PreparedStatement prStmp = connection.prepareStatement(sql)) {
				prStmp.setLong(1, id);
				ResultSet rs = prStmp.executeQuery(sql);
				
				while (rs.next()) {
					operationType = new OperationType();
					operationType.setId(rs.getLong("id"));
					operationType.setName(rs.getString("name"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		return operationType;
	}

	@Override
	public OperationType getOperationTypeByName(String name) {
		String sql = "SELECT * FROM tOperation_Type where name = ?";
		OperationType operationType = null;
		try (
				Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USERNAME	, Constants.DB_PASSWORD);
				
				PreparedStatement prStmp = connection.prepareStatement(sql)) {
				prStmp.setString(1, name);
				ResultSet rs = prStmp.executeQuery();
				
				while (rs.next()) {
					operationType = new OperationType();
					operationType.setId(rs.getLong("id"));
					operationType.setName(rs.getString("name"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		return operationType;
	}

	@Override
	public boolean calculateAmount(Operation operation) {
		String sql = "INSERT INTO tOperation (id, account_id, operation_type_id, amount, currency_id, performed_by_user_id) VALUES (?,?,?,?,?,?)";
		try (
				
				Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USERNAME	, Constants.DB_PASSWORD);
				PreparedStatement prStmp = connection.prepareStatement(sql)) {
				
				prStmp.setLong(1, accountDao.getMaxIndexFromTable("tOperation")+1);
				prStmp.setLong(2, accountDao.getAccountByAccountNumber(operation.getAccount().getAccountNumber()).getId());
				prStmp.setLong(3, getOperationTypeByName(operation.getDepositType()).getId());
				prStmp.setBigDecimal(4, operation.getAmount());
				prStmp.setLong(5, accountDao.getCurrencyByName(operation.getActiveCurrency()).getId()); 
				prStmp.setLong(6, accountDao.getUserByUsername(UserUtils.getUser().getUsername()).getId());
			
				prStmp.execute();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		return true;
	}

	@Override
	public boolean updateTotalAmount(Operation operation) {
		String sql = "UPDATE tAccount set amount = ? where account_no = ?";
		try (
				
				Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USERNAME	, Constants.DB_PASSWORD);
				PreparedStatement prStmp = connection.prepareStatement(sql)) {
				
				prStmp.setBigDecimal(1, operation.getAccount().getTotalAmount());
				prStmp.setString(2, operation.getAccount().getAccountNumber());
			
				prStmp.execute();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		return true;
	}
}
