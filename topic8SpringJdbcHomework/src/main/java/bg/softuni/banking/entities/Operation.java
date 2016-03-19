package bg.softuni.banking.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import bg.softuni.banking.constants.Constants;
import bg.softuni.banking.security.User;

public class Operation {
	
	private static Long id;
	private Account account;
	private BigDecimal amount;
	private OperationType operationType;
	private String depositType;
	private String activeCurrency;
	private Currency currency;
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Long getId() {
		return id == null ? new Long(1) : id;
	}
	public void setId(Long id) {
		Operation.id = id;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public BigDecimal getAmount() {
		return amount == null ? new BigDecimal(0) : amount;
	}
	public void setAmount(BigDecimal amount) {
		if (currency == null) {
			currency = new Currency();
			currency.setId(1L);
			currency.setName("BGN");
			currency.setRate(new BigDecimal(1.00));
		} 
		this.amount = amount;
	}
	
	public Currency getCurrency() {
		return currency;
	}
	
	public OperationType getOperationType() {
		return operationType;
	}
	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
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
