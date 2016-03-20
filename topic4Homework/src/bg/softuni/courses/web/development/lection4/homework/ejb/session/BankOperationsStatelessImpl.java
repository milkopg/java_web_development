package bg.softuni.courses.web.development.lection4.homework.ejb.session;

import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import bg.softuni.courses.web.development.lection4.homework.ejb.singleton.UserGlobalDataCollection;
import bg.softuni.courses.web.development.lection4.homework.ejb.singleton.UserGlobalDataCollectionImpl;
import bg.softuni.courses.web.development.lection4.homework.model.Customer;

@Stateless
public class BankOperationsStatelessImpl implements BankOperationsStateless{
	
	@EJB
	private UserGlobalDataCollection userGlobalDataCollection;
	
	@Override
	public void withdrawMoney(Customer customer, BigDecimal amount, boolean isDeposit, String currency) {
		BigDecimal signedAmount = new BigDecimal(isDeposit ? 1 : -1).multiply(amount);
		if (customer == null) return;
		
		if (!userGlobalDataCollection.checkIfCustomerExists(customer.getAccountNumber())) {
			customer.setTotalAmount(amount.multiply(new BigDecimal(UserGlobalDataCollectionImpl.getCurrencies().get(currency))));
		} else {
			customer.setTotalAmount(userGlobalDataCollection.getAllUsers().get(customer.getAccountNumber()).getTotalAmount().add(signedAmount).multiply(new BigDecimal(UserGlobalDataCollectionImpl.getCurrencies().get(currency))));
		}
	}

	@Override
	public BigDecimal getTotalAmount(Customer customer) {
		return customer == null ? null : customer.getTotalAmount();
	}

	@Override
	public Customer createCustomer(String accountNumber) {
		Customer customer = new Customer(accountNumber);
		customer.setAccountNumber(accountNumber);
		return customer;
	}

	@Override
	public void saveUser(Customer customer, boolean isDeposit) {
		if (customer == null) return;
		if (!userGlobalDataCollection.checkIfCustomerExists(customer.getAccountNumber())) {
			userGlobalDataCollection.getAllUsers().put(customer.getAccountNumber(), customer);
		} else {
			userGlobalDataCollection.getAllUsers().replace(customer.getAccountNumber(), customer);
		}
	}
}
