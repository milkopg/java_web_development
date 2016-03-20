package bg.softuni.banking.entities;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

@Entity
@Table(name="tOperation")
public class Operation {
	@Id
	@TableGenerator(name="TABLE_GEN",table="TGENERATOR1", pkColumnName = "GEN_KEY", pkColumnValue = "SOFTUNI.TOPERATION", valueColumnName = "GEN_VALUE", initialValue = 1, allocationSize = 1 )
	@GeneratedValue(strategy = GenerationType.TABLE, generator="TABLE_GEN")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="account_id")
	private Account account;
	
	@Column(name="amount")
	private BigDecimal amount;
	
	@ManyToOne
	@JoinColumn(name="operation_type_id")
	private OperationType operationType;
	
	@Transient
	private String depositType;
	
	@Transient
	private String activeCurrency;
	
	@ManyToOne(optional=false, cascade={CascadeType.REFRESH})
	@JoinColumn(name="currency_id")
	private Currency currency;
	
	@ManyToOne(optional=false, cascade={CascadeType.REFRESH})
	@JoinColumn(name="performed_by_user_id")
	private User user;
	
	@Transient
	private List<Currency> currencies;
	
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
		this.id = id;
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
	public List<Currency> getCurrencies() {
		return currencies;
	}
	public void setCurrencies(List<Currency> currencies) {
		this.currencies = currencies;
	}
}
