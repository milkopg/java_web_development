package bg.softuni.courses.web.development.lection4.homework.ejb.singleton;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import bg.softuni.courses.web.development.lection4.homework.model.Customer;

@Startup
@Singleton
public class UserGlobalDataCollectionImpl implements UserGlobalDataCollection{

	private Map <String, Customer> usersMap = new HashMap<String, Customer>();
	private static HashMap <String, Double> currencies;
	
	
	public static HashMap<String, Double> getCurrencies() {
		if (currencies == null) {
			currencies = new HashMap<>();
			currencies.put(CURRENCY_BGL, new Double(1));
			currencies.put(CURRENCY_USD, new Double(1.75));
			currencies.put(CURRENCY_EUR, new Double(1.9558));
		}
		return currencies;
	}

	@Override
	public BigDecimal getBalanceForUser(Customer user) {
		return user.getTotalAmount();
	}

	@Override
	public Map<String, Customer> getAllUsers() {
		return getUsersMap();
	}

	public Map<String, Customer> getUsersMap() {
		return usersMap;
	}

	@Override
	public Customer getUserByAccountNumber(String accountNumber) {
		if (accountNumber == null) return null;
		return usersMap.get(accountNumber);
	}

	@Override
	public boolean checkIfCustomerExists(String accountNumber) {
		if (accountNumber == null) return false;
		return (usersMap.containsKey(accountNumber)); 
	}
	
}
