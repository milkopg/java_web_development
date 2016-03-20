package bg.softuni.banking.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

@Entity
@Table(name="tAccount")
public class Account {
	@Id
	@Column(name="id")
	@TableGenerator(name="TABLE_GEN",table="TGENERATOR1", pkColumnName = "GEN_KEY", pkColumnValue = "SOFTUNI.TACCOUNT", valueColumnName = "GEN_VALUE", initialValue = 1, allocationSize = 1 )
	@GeneratedValue(strategy = GenerationType.TABLE, generator="TABLE_GEN")
	private Long id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="account_no")
	private String accountNumber;
	
	@Column(name="amount")
	private BigDecimal totalAmount;
	
	@Transient
	private BigDecimal initialAmount;
	
	@ManyToOne(optional=false, cascade={CascadeType.REFRESH})
	@JoinColumn(name="currency_id")
	private Currency currency;
	
	@ManyToOne(optional=false, cascade={CascadeType.REFRESH})
	@JoinColumn(name="created_by")
	private User user;
	
	@Transient
	private List<String> errors;
	
	@Transient
	private List<Currency> currencies;
	
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

	public List<Currency> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(List<Currency> currencies) {
		this.currencies = currencies;
	}
	
}
