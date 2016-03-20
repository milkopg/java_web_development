package bg.softuni.banking.dao;

import java.util.List;

import bg.softuni.banking.entities.Account;
import bg.softuni.banking.entities.Currency;
import bg.softuni.banking.entities.User;

public interface AccountDao {
	public List<Account> getAllAccounts();
	public boolean createAccount(Account account);
	public Account getAccountByAccountNumber(String accountNumber);
	public Account getAccountByCreationByUsername(String username);
	public Currency getCurrencyById(Long id);
	public Currency getCurrencyByName(String name);
	public User getUserById(Long id);
	public User getUserByUsername(String username);
	public List<Currency> fillCurrencies();
}
