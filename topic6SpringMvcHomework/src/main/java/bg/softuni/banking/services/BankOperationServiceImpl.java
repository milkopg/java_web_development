package bg.softuni.banking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import bg.softuni.banking.entities.Operation;

@Service
public class BankOperationServiceImpl implements BankOperationService{

	@Override
	public List<String> validateOperation(Operation operation) {
		List<String> errors = new ArrayList<>();
		// TODO Auto-generated method stub
		return errors;
	}

	@Override
	public boolean withdrawOrDeposit(Operation operation) {
		if (operation.getIsDeposit()) {
			operation.getAmount().add(operation.getCustomer().getTotalAmount());
		} else {
			operation.getCustomer().getTotalAmount().subtract(operation.getAmount());
		}
		return true;
	}
}
