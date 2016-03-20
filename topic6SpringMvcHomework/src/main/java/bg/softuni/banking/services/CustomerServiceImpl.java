package bg.softuni.banking.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import bg.softuni.banking.entities.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	private static Map <String, Customer> customersMap = new HashMap<>();
	
	@Override
	public boolean addCustomer(Customer customer) {
		customersMap.putIfAbsent(customer.getAccountNumber(), customer);
		return true;
	}

	@Override
	public Customer getCustomer(String accountNumber) {
		if (customersMap.containsKey(accountNumber))  {
			return customersMap.get(accountNumber);
		}
		return null;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		if (customer == null) return false;
		if (customersMap.containsKey(customer.getAccountNumber())) {
			customersMap.replace(customer.getAccountNumber(), customer);
			return true;
		}
		return false;
	}
}
