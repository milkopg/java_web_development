package bg.softuni.banking.services;
import bg.softuni.banking.entities.Customer;

public interface CustomerService {
	public boolean addCustomer (Customer customer);
	public Customer getCustomer(String accountNumber);
}
