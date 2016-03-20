package bg.softuni.banking.entities;

import java.math.BigDecimal;
import java.util.List;

import bg.softuni.banking.constants.Constants;
import bg.softuni.banking.services.BankOperationServiceImpl;

public class Operation {
	
	private Customer customer;
	private BigDecimal amount;
	private String depositType;
	private List<String> errors;
	private String activeCurrency;
	
	public List<String> getErrors() {
		return errors;
	}
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public BigDecimal getAmount() {
		return amount == null ? new BigDecimal(0) : amount;
	}
	public void setAmount(BigDecimal amount) {
		if (activeCurrency == null) {
			activeCurrency = Constants.CURRENCY_BGL;
		} 
		this.amount = amount.multiply(BankOperationServiceImpl.fillCurrencies().get(activeCurrency));
	}
	public String getDepositType() {
		return depositType;
	}
	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}
	
	public String getActiveCurrency() {
		return activeCurrency;
	}
	public void setActiveCurrency(String activeCurrency) {
		this.activeCurrency = activeCurrency;
	}

}
