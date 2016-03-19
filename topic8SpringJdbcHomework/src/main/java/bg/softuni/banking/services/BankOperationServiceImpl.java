package bg.softuni.banking.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.softuni.banking.constants.Constants;
import bg.softuni.banking.dao.AccountDao;
import bg.softuni.banking.dao.AccountDaoImpl;
import bg.softuni.banking.dao.OperationDao;
import bg.softuni.banking.entities.Account;
import bg.softuni.banking.entities.Operation;

@Service
public class BankOperationServiceImpl implements BankOperationService{
	@Autowired
	AccountServiceImpl customerService;
	
	@Autowired
	OperationDao operationDao;
	
	@Autowired
	AccountDao accountDao;
	
	@Override
	public List<String> validateOperation(Operation operation) {
		List<String> errors = new ArrayList<>();
		if ((operation == null) || (operation.getAccount() == null)) return errors;
		Account account = operation.getAccount();
		
		if ((account.getUsername() == null) || ("".equals(account.getUsername()))) errors.add(ERROR_MANDATORY.replace("{0}", "Username"));
		if ((account.getAccountNumber() == null) ||  "".equals(account.getAccountNumber())) errors.add(ERROR_MANDATORY.replace("{0}", "Account number"));
		if (operation.getDepositType() == null) errors.add(ERROR_MANDATORY.replace("{0}", "Deposit type"));
		if (operation.getAmount() == null || (operation.getAmount().signum() == 0)) errors.add(ERROR_MANDATORY.replace("{0}", "Amount"));
		if (Constants.ROLE_USER.equals(operation.getUser().getAuthorities().iterator().next().getAuthority()) && !operation.getUser().getUsername().equals(operation.getAccount().getUser().getUsername())) errors.add(ERROR_OPERATION_NOT_ALOWED);
			
		
		if (Constants.DEPOSIT_TYPE_WITHDRAW.equals(operation.getDepositType())) {
			if (operation.getAmount().compareTo(account.getTotalAmount()) == 1) {
				errors.add(ERROR_WITHDRAW_BIGGER_AMOUNT);
			}
			
			if (account.getTotalAmount().divide(new BigDecimal(2)).compareTo(operation.getAmount()) == -1) {
				errors.add(ERROR_WITHDRAW_HALF_AMOUNT);
			}
		} 
		
		if (operation.getAmount().signum() <=0 ) {
			errors.add(ERROR_WITHDRAW_GREATER_THAN_ZERO);
			operation.setAmount(new BigDecimal(0)); 
		}
		return errors;
	}

	public LinkedHashMap<String, BigDecimal>  fillCurrencies() {
		return AccountDaoImpl.fillCurrencies();
	}

	private BigDecimal getConvertRate(Operation operation) {
		if (operation.getActiveCurrency()== null) return new BigDecimal(1);
		BigDecimal basicRate = accountDao.getCurrencyById(operation.getAccount().getCurrency().getId()).getRate(); 
		BigDecimal rate  = accountDao.getCurrencyByName(operation.getActiveCurrency()).getRate();
		return rate.divide(basicRate, 5, RoundingMode.HALF_UP);
	}

	@Override
	public boolean calculateAmount(Operation operation) {
		
		boolean deposit = Constants.DEPOSIT_TYPE_DEPOSIT.equals(operation.getDepositType());
		BigDecimal convertRate = getConvertRate(operation);
		
		if (deposit) {
			operation.getAccount().setTotalAmount(customerService.getAccount(operation.getAccount().getAccountNumber()).getTotalAmount().add((operation.getAmount().multiply(convertRate))));
		} else {
			operation.getAccount().setTotalAmount(customerService.getAccount(operation.getAccount().getAccountNumber()).getTotalAmount().subtract((operation.getAmount().multiply(convertRate))));
		}
		operationDao.calculateAmount(operation);
		return operationDao.updateTotalAmount(operation);
	}
}
