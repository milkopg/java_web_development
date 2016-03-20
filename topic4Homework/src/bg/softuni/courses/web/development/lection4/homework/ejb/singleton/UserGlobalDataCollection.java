package bg.softuni.courses.web.development.lection4.homework.ejb.singleton;

import java.math.BigDecimal;
import java.util.Map;

import bg.softuni.courses.web.development.lection4.homework.model.Customer;

public interface UserGlobalDataCollection {
	public static final String CURRENCY_BGL = "BGL";
	public static final String CURRENCY_EUR = "EUR";
	public static final String CURRENCY_USD = "USD";
	public BigDecimal getBalanceForUser(Customer customer);
	public Map<String, Customer> getAllUsers();
	public Customer getUserByAccountNumber(String accountNumber);
	public boolean checkIfCustomerExists(String accountNumber);
}
