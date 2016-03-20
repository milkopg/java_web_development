package bg.softuni.banking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import bg.softuni.banking.entities.Account;
import bg.softuni.banking.entities.Currency;
import bg.softuni.banking.manager.JpaManager;

@Repository
public class AccountDaoImpl implements AccountDao{
	
	@PersistenceContext
	private EntityManager em;
	
	

	@Override
	public List<Account> getAllAccounts() {
		TypedQuery<Account> q;
		
		q = em.createQuery("SELECT o FROM Account o ORDER BY o.id", Account.class);
		return q.getResultList();
	}

	@Override
	public boolean createAccount(Account account) {
		em.persist(account);
		return true;
	}

	@Override
	public Currency getCurrencyById(Long id) {
		TypedQuery<Currency> q;
		
		q = em.createQuery("SELECT o FROM Currency o WHERE o.id = :id ORDER BY o.id", Currency.class);
		q.setParameter("id", id);
		return JpaManager.getSingleResult(q);
	}
	
	@Override
	public Currency getCurrencyByName(String name) {
		TypedQuery<Currency> q;
		
		q = em.createQuery("SELECT o FROM Currency o WHERE o.name = :name ORDER BY o.id", Currency.class);
		q.setParameter("name", name);
		return JpaManager.getSingleResult(q);
	}

	@Override
	public bg.softuni.banking.entities.User getUserById(Long id) {
		TypedQuery<bg.softuni.banking.entities.User> q;
		
		q = em.createQuery("SELECT o FROM User o WHERE o.id = :id ORDER BY o.id", bg.softuni.banking.entities.User.class);
		q.setParameter("id", id);
		return JpaManager.getSingleResult(q);
	}


	@Override
	public Account getAccountByAccountNumber(String accountNumber) {
		TypedQuery<Account> q;
		
		q = em.createQuery("SELECT o FROM Account o WHERE o.accountNumber = :accountNumber", Account.class);
		q.setParameter("accountNumber", accountNumber);
		return JpaManager.getSingleResult(q);
				
	}

	public List<Currency> fillCurrencies() {
		TypedQuery<Currency> q;
		
		q = em.createQuery("SELECT o FROM Currency o ORDER BY o.id", Currency.class);
		return q.getResultList();
		
	}

	@Override
	public bg.softuni.banking.entities.User getUserByUsername(String username) {
		TypedQuery<bg.softuni.banking.entities.User> q;
		
		q = em.createQuery("SELECT o FROM User o WHERE o.username = :username ORDER BY o.id", bg.softuni.banking.entities.User.class);
		q.setParameter("username", username);
		return JpaManager.getSingleResult(q);
	}

<<<<<<< HEAD
=======
//	@Override
//	public Account getAccountByCreationByUserId(Long id) {
//
//		TypedQuery<Account> q;
//		
//		q = em.createQuery("SELECT o FROM Account o WHERE o.user.id = :id ", Account.class);
//		q.setParameter("id", id);
//		return JpaManager.getSingleResult(q);
//	}

>>>>>>> branch 'master' of https://github.com/milkopg/java_web_development.git
	@Override
	public Account getAccountByCreationByUsername(String username) {
		TypedQuery<Account> q;
		
		q = em.createQuery("SELECT o FROM Account o WHERE o.user.username = :username ", Account.class);
		q.setParameter("username", username);
		return JpaManager.getSingleResult(q);
	}
}
