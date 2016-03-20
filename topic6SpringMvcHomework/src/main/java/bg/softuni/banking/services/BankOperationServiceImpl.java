package bg.softuni.banking.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.softuni.banking.constants.Constants;
import bg.softuni.banking.entities.Customer;
import bg.softuni.banking.entities.Operation;

@Service
public class BankOperationServiceImpl implements BankOperationService{
	
	@Autowired
	CustomerServiceImpl customerService;
	
	@Override
	public List<String> validateOperation(Operation operation) {
		List<String> errors = new ArrayList<>();
		if ((operation == null) || (operation.getCustomer() == null)) return errors;
		Customer customer = operation.getCustomer();
		
		if ((customer.getFullName() == null) || ("".equals(customer.getFullName()))) errors.add(ERROR_MANDATORY.replace("{0}", "Full name"));
		if ((customer.getAccountNumber() == null) ||  "".equals(customer.getAccountNumber())) errors.add(ERROR_MANDATORY.replace("{0}", "Account number"));
		if (operation.getDepositType() == null) errors.add(ERROR_MANDATORY.replace("{0}", "Deposit type"));
		if (operation.getAmount() == null || (operation.getAmount().signum() == 0)) errors.add(ERROR_MANDATORY.replace("{0}", "Amount"));
		
		if (Constants.DEPOSIT_TYPE_WITHDRAW.equals(operation.getDepositType())) {
			if (operation.getAmount().compareTo(customer.getTotalAmount()) == 1) {
				errors.add(ERROR_WITHDRAW_BIGGER_AMOUNT);
			}
			
			if (customer.getTotalAmount().divide(new BigDecimal(2)).compareTo(operation.getAmount()) == -1) {
				errors.add(ERROR_WITHDRAW_HALF_AMOUNT);
			}
		} 
		
		if (operation.getAmount().signum() <=0 ) {
			errors.add(ERROR_WITHDRAW_GREATER_THAN_ZERO);
		}
		return errors;
	}

	public static LinkedHashMap<String, BigDecimal>  fillCurrencies() {
		LinkedHashMap<String, BigDecimal> currenciesMap = new LinkedHashMap<>();
		currenciesMap.put(Constants.CURRENCY_BGL, new BigDecimal(1).setScale(5, BigDecimal.ROUND_CEILING));
		currenciesMap.put(Constants.CURRENCY_USD, new BigDecimal(1.75).setScale(5, BigDecimal.ROUND_CEILING));
		currenciesMap.put(Constants.CURRENCY_EUR, new BigDecimal(1.9558).setScale(5, BigDecimal.ROUND_CEILING));
		return currenciesMap;
	}

	@Override
	public boolean withdrawOrDeposit(Operation operation) {
		Customer customerFromHashMap  = customerService.getCustomer(operation.getCustomer().getAccountNumber());
		
		//existing customer
		if (customerFromHashMap != null) {
			if (Constants.DEPOSIT_TYPE_DEPOSIT.equals(operation.getDepositType())) {
				operation.getCustomer().setTotalAmount(operation.getAmount().add(customerService.getCustomer(operation.getCustomer().getAccountNumber()).getTotalAmount()));
			} else {
				operation.getCustomer().setTotalAmount(customerService.getCustomer(operation.getCustomer().getAccountNumber()).getTotalAmount().subtract(operation.getAmount()));
			}
		} else {
			customerService.addCustomer(operation.getCustomer());
			if (Constants.DEPOSIT_TYPE_DEPOSIT.equals(operation.getDepositType())) {
				operation.getCustomer().setTotalAmount(operation.getAmount().add(operation.getCustomer().getTotalAmount()));
			} else {
				operation.getCustomer().setTotalAmount(operation.getCustomer().getTotalAmount().subtract(operation.getAmount()));
			}
		}
		return true;
	}
}
