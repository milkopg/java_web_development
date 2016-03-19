package bg.softuni.banking.dao;

import bg.softuni.banking.entities.Operation;
import bg.softuni.banking.entities.OperationType;

public interface OperationDao {
	public boolean calculateAmount(Operation operation);
	public boolean updateTotalAmount(Operation operation);
	public OperationType getOperationTypeById(Long id);
	public OperationType getOperationTypeByName(String name);
}
