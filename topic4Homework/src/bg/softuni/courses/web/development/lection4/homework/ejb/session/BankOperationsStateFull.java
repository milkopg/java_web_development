package bg.softuni.courses.web.development.lection4.homework.ejb.session;

import java.util.List;

import bg.softuni.courses.web.development.lection4.homework.model.Customer;

public interface BankOperationsStateFull {
	public static final String ERROR_WITHDRAW_BIGGER_AMOUNT = "Withdraw amount is greater that total amount";
	public static final String ERROR_WITHDRAW_HALF_AMOUNT = "Withdraw amount can't be more than total amount";
	public static final String ERROR_WITHDRAW_GREATER_THAN_ZERO = "Withdraw amount can't negative value";
	public List<String> validateUserAndReturnErrorList(Customer customer, boolean isDeposit);
}
