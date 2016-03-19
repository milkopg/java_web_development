package bg.softuni.banking.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import bg.softuni.banking.constants.Constants;
import bg.softuni.banking.entities.Account;
import bg.softuni.banking.entities.Currency;
import bg.softuni.banking.security.User;

@Repository
public class AccountDaoImpl implements AccountDao{
	
	private static Logger logger = LoggerFactory.getLogger(AccountDaoImpl.class); 
	
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			logger.error("Cannot load driver");
		}
	}

	@Override
	public List<Account> getAllAccounts() {
		List<Account> students = new ArrayList<>();
		try (
			Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USERNAME	, Constants.DB_PASSWORD);
			Statement stmp = connection.createStatement()) {
			
			String sql = "SELECT * FROM tAccount";
			ResultSet rs = stmp.executeQuery(sql);
			
			while (rs.next()) {
				Account account = new Account();
				account.setId(rs.getLong("id"));
				account.setAccountNumber(rs.getString("account_no"));
				account.setUsername(rs.getString("username"));
				account.setCurrency(getCurrencyById(rs.getLong("currency")));
				account.setUser(getUserById(rs.getLong("created_by")));
				
				students.add(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return students;
	}

	@Override
	public boolean createAccount(Account account) {
		String sql = "INSERT INTO tAccount (id, account_no, username, amount, created_by, currency_id) VALUES (?,?,?,?,?,?)";
		try (
				
				Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USERNAME	, Constants.DB_PASSWORD);
				PreparedStatement prStmp = connection.prepareStatement(sql)) {
				
				prStmp.setLong(1, getMaxIndexFromTable("tAccount")+1);
				prStmp.setString(2, account.getAccountNumber());
				prStmp.setString(3, account.getUsername());
				prStmp.setBigDecimal(4, account.getInitialAmount());
				prStmp.setLong(5, getUserByUsername(account.getUser().getUsername()).getId()); 
				prStmp.setLong(6, account.getCurrency().getId());
				
				
				prStmp.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		return true;
	}

	@Override
	public Currency getCurrencyById(Long id) {
		String sql = "SELECT * FROM tCurrencies where id = ?";
		Currency currency = null;
		try (
				Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USERNAME	, Constants.DB_PASSWORD);
				
				
				PreparedStatement prStmp = connection.prepareStatement(sql)) {
				prStmp.setLong(1, id);
				ResultSet rs = prStmp.executeQuery();
				
				while (rs.next()) {
					currency = new Currency();
					currency.setId(rs.getLong("id"));
					currency.setName(rs.getString("name"));
					currency.setRate(rs.getBigDecimal("rate"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		return currency;
	}
	
	@Override
	public Currency getCurrencyByName(String name) {
		String sql = "SELECT * FROM tCurrencies where name = ?";
		Currency currency = null;
		try (
				Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USERNAME	, Constants.DB_PASSWORD);
				
				
				PreparedStatement prStmp = connection.prepareStatement(sql)) {
				prStmp.setString(1, name);
				ResultSet rs = prStmp.executeQuery();
				
				while (rs.next()) {
					currency = new Currency();
					currency.setId(rs.getLong("id"));
					currency.setName(rs.getString("name"));
					currency.setRate(rs.getBigDecimal("rate"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		return currency;
	}

	@Override
	public User getUserById(Long id) {
		String sql = "SELECT * FROM tUser where id = ?";
		User user = null;
		try (
				Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USERNAME	, Constants.DB_PASSWORD);
				
				PreparedStatement prStmp = connection.prepareStatement(sql)) {
				prStmp.setLong(1, id);
				ResultSet rs = prStmp.executeQuery();
				List<GrantedAuthority> authorities = new ArrayList<>();
				
				while (rs.next()) {
					authorities.add(new SimpleGrantedAuthority(rs.getString("role")));
					user = new User(rs.getString("username"), rs.getString("password"), authorities);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		return user;
	}

	@Override
	public Long getMaxIndexFromTable(String tableName) {
		String sql = "SELECT Max(id) id FROM " + tableName ;
		Long maxId = null;
		try (
				Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USERNAME	, Constants.DB_PASSWORD);
				
				Statement stmp = connection.createStatement()) {
				ResultSet rs = stmp.executeQuery(sql);
				
				while (rs.next()) {
					maxId = rs.getLong("id");
				}
			} catch (SQLException e) {
				logger.error("No Max(id) found from table:" + tableName);
				return new Long(0);
			}
		return maxId;
	}

	@Override
	public Account getAccountByAccountNumber(String accountNumber) {
		String sql = "SELECT * FROM tAccount where  account_no = ?";
		Account account = null;
		try (
				Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USERNAME	, Constants.DB_PASSWORD);
				
				PreparedStatement prStmp = connection.prepareStatement(sql)) {
				prStmp.setString(1, accountNumber);
				ResultSet rs = prStmp.executeQuery();
				
				while (rs.next()) {
					account = new Account();
					account.setAccountNumber(rs.getString("account_no"));
					account.setId(rs.getLong("id"));
					account.setCurrency(getCurrencyById(rs.getLong("currency_id")));
					account.setTotalAmount(rs.getBigDecimal("amount"));
					account.setUser(getUserById(rs.getLong("created_by")));
					account.setUsername(rs.getString("username"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		return account;
	}

	public static LinkedHashMap<String, BigDecimal> fillCurrencies() {
		String sql = "SELECT * FROM tCurrencies";
		LinkedHashMap<String, BigDecimal> currencies;
		try (
				Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USERNAME	, Constants.DB_PASSWORD);
				
				Statement stmp = connection.createStatement()) {
				ResultSet rs = stmp.executeQuery(sql);
				currencies = new LinkedHashMap<>();
				
				while (rs.next()) {
					currencies.put(rs.getString("name"), rs.getBigDecimal("rate"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		return currencies;
	}

	@Override
	public User getUserByUsername(String username) {
		String sql = "SELECT * FROM tUser where username = ?";
		User user = null;
		try (
				Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USERNAME	, Constants.DB_PASSWORD);
				
				PreparedStatement prStmp = connection.prepareStatement(sql)) {
				prStmp.setString(1, username);
				ResultSet rs = prStmp.executeQuery();
				List<GrantedAuthority> authorities = new ArrayList<>();
				
				while (rs.next()) {
					authorities.add(new SimpleGrantedAuthority(rs.getString("role")));
					user = new User(rs.getString("username"), rs.getString("password"), authorities);
					user.setId(rs.getLong("id"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		return user;
	}

	@Override
	public Account getAccountByCreationByUserId(Long id) {
		String sql = "SELECT * FROM tAccount WHERE created_by = ?";
		Account account = null;
		try (
				Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USERNAME	, Constants.DB_PASSWORD);
				
				PreparedStatement prStmp = connection.prepareStatement(sql)) {
				prStmp.setLong(1, id);
				ResultSet rs = prStmp.executeQuery();
					
				while (rs.next()) {
					account = new Account();
					account.setId(rs.getLong("id"));
					account.setAccountNumber(rs.getString("account_no"));
					account.setUsername(rs.getString("username"));
					account.setTotalAmount(rs.getBigDecimal("amount"));
					account.setUser(getUserById(rs.getLong("created_by")));
					account.setCurrency(getCurrencyById(rs.getLong("currency_id")));
					break;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		return account;
	}
}
