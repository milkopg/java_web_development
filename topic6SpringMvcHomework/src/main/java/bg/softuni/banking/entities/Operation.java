package bg.softuni.banking.entities;

import java.math.BigDecimal;

public class Operation {
	
	private Customer customer;
	private Boolean isDeposit;
	private BigDecimal amount;
	private String depositType;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Boolean getIsDeposit() {
		return isDeposit;
	}
	public void setIsDeposit(Boolean isDeposit) {
		this.isDeposit = isDeposit;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getDepositType() {
		return depositType;
	}
	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}
}
