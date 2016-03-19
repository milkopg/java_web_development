package bg.softuni.banking.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import bg.softuni.banking.security.User;

public class Account {
	private Long id;
	private String username;
	private String accountNumber;
	private BigDecimal totalAmount;
	private BigDecimal initialAmount;
	private Currency currency;
	private User user;
	private List<String> errors;
	
	public List<String> getErrors() {
		if (errors == null) {
			errors = new ArrayList<>();
			setErrors(errors);
		}
		return errors;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getInitialAmount() {
		return initialAmount;
	}
	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public void setInitialAmount(BigDecimal initialAmount) {
		this.initialAmount = initialAmount;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount == null ? new BigDecimal(0) : totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
		public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	
}
