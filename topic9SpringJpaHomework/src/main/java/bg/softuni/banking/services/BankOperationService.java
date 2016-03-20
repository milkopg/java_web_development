package bg.softuni.banking.services;

import java.util.List;

import bg.softuni.banking.entities.Operation;

public interface BankOperationService {
	public static final String ERROR_WITHDRAW_BIGGER_AMOUNT = "Withdraw amount is greater that total amount";
	public static final String ERROR_WITHDRAW_HALF_AMOUNT = "Withdraw amount can't be more than half of total amount";
	public static final String ERROR_WITHDRAW_GREATER_THAN_ZERO = "Withdraw amount can't negative value";
	public static final String ERROR_MANDATORY = "{0} field is mandatory";
	public static final String ERROR_ACCOUNT_NUMBER_NOT_FOUND = "{0} account number is not found";
	public static final String ERROR_ACCOUNT_NUMBER_ALREADY_EXISTS = "{0} Account number already exists";
	public static final String ERROR_OPERATION_NOT_ALOWED = "Current user does not have access to other accounts. Please enter your account number!";

	public List<String> validateOperation(Operation operation);
	public boolean calculateAmount(Operation operation);
}
