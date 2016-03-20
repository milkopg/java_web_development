package bg.softuni.courses.web.development.lection4.homework.model;

import java.math.BigDecimal;
import java.util.List;

public class Customer {
	
	private String fullName;
	private String accountNumber;
	private BigDecimal amount;
	private BigDecimal totalAmount;
	private List<String> errors;
	
	public Customer(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public BigDecimal getAmount() {
		return amount == null ? new BigDecimal(0) : amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount == null ? new BigDecimal(0) : totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public List<String> getErrors() {
		return errors;
	}
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
}
