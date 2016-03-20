package bg.softuni.courses.web.development.lection4.homework.ejb.session;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

import bg.softuni.courses.web.development.lection4.homework.model.Customer;

@Stateful
public class BankOperationsStateFullImpl implements BankOperationsStateFull{

	@Override
	public List<String> validateUserAndReturnErrorList(Customer customer, boolean isDeposit) {
		List<String> errors = new ArrayList<>();
		if (customer == null) return errors;
		
		if (!isDeposit) {
			if (customer.getAmount().compareTo(customer.getTotalAmount()) == 1) {
				errors.add(ERROR_WITHDRAW_BIGGER_AMOUNT);
			}
			
			if (customer.getTotalAmount().divide(new BigDecimal(2)).compareTo(customer.getAmount()) == -1) {
				errors.add(ERROR_WITHDRAW_HALF_AMOUNT);
			}
			
		} 
		
		if (customer.getAmount().signum() <=0 ) {
			errors.add(ERROR_WITHDRAW_GREATER_THAN_ZERO);
		}
		return errors;
	}

}
