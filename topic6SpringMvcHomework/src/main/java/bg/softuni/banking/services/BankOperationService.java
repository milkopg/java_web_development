package bg.softuni.banking.services;

import java.util.List;

import bg.softuni.banking.entities.Operation;

public interface BankOperationService {
	public List<String> validateOperation(Operation operation);
	public boolean withdrawOrDeposit(Operation operation);
}
