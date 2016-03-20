package bg.softuni.banking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bg.softuni.banking.dao.AccountDao;
import bg.softuni.banking.entities.Account;
import bg.softuni.banking.entities.Currency;
import bg.softuni.banking.entities.User;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountDao accountDao;
	
	@Override
	public boolean addAccount(Account customer) {
		return accountDao.createAccount(customer);
	}

	@Override
	public List<Account> getAllAccounts() {
		return accountDao.getAllAccounts();
	}

	@Override
	public Account getAccount(String accountNumber) {
		return accountDao.getAccountByAccountNumber(accountNumber);
	}


	@Override
	public Currency getCurrencyByName(String name) {
		return accountDao.getCurrencyByName(name);
	}

	@Override
	public User getUserById(Long id) {
		return accountDao.getUserById(id);
	}

	@Override
	public User getUserByUsername(String username) {
		return accountDao.getUserByUsername(username);
	}

	@Override
	public List<Currency> fillCurrencies() {
		return accountDao.fillCurrencies();
	}

	@Override
	public Account getAccountByCreationByUsername(String username) {
		return accountDao.getAccountByCreationByUsername(username);
	}
}
