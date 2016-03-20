package bg.softuni.banking.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import bg.softuni.banking.entities.Operation;

public interface BankOperationService {
	public static final String ERROR_WITHDRAW_BIGGER_AMOUNT = "Withdraw amount is greater that total amount";
	public static final String ERROR_WITHDRAW_HALF_AMOUNT = "Withdraw amount can't be more than half of total amount";
	public static final String ERROR_WITHDRAW_GREATER_THAN_ZERO = "Withdraw amount can't negative value";
	public static final String ERROR_MANDATORY = "{0} field is mandatory";

	public List<String> validateOperation(Operation operation);
	public boolean withdrawOrDeposit(Operation operation);
}
