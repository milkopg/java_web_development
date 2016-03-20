package bg.softuni.courses.web.development.lection4.homework.ejb.session;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Local;

import bg.softuni.courses.web.development.lection4.homework.model.Customer;

@Local
public interface BankOperationsStateless {
	public void withdrawMoney(Customer customer, BigDecimal amount, boolean isDeposit, String currency);
	public BigDecimal getTotalAmount(Customer customer);
	public Customer createCustomer(String accountNumber);
	public void saveUser(Customer customer, boolean isDeposit);
}
