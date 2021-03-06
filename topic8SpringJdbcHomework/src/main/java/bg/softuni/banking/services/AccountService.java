package bg.softuni.banking.services;
import java.util.List;

import bg.softuni.banking.entities.Account;
import bg.softuni.banking.entities.Currency;
import bg.softuni.banking.security.User;

public interface AccountService {
	public boolean addAccount(Account customer);
	public List<Account> getAllAccounts();
	public Account getAccount(String accountNumber);
	public Account getAccountByCreationByUserId(Long id);
	public Long getMaxIndexFromTable(String tableName);
	public Currency getCurrencyByName(String name);
	public User getUserById(Long id);
	public User getUserByUsername(String username);
	
}
