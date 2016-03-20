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
		customersMap.put(customer.getAccountNumber(), customer);
		return true;
	}

	@Override
	public Customer getCustomer(String accountNumber) {
		if (customersMap.containsKey(accountNumber))  {
			return customersMap.get(accountNumber);
		}
		return null;
	}
}
