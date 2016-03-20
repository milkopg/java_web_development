package bg.softuni.banking.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bg.softuni.banking.entities.Operation;
import bg.softuni.banking.entities.OperationType;
import bg.softuni.banking.manager.JpaManager;

@Repository
public class OperationDaoImpl implements OperationDao{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	AccountDao accountDao;
	
	@Override
	public OperationType getOperationTypeById(Long id) {
		TypedQuery<OperationType> q;
		
		q = em.createQuery("SELECT o FROM OperationType o where o.id = :id ORDER BY o.id", OperationType.class);
		q.setParameter("id", id);
		return JpaManager.getSingleResult(q);
	}

	@Override
	public OperationType getOperationTypeByName(String name) {
		TypedQuery<OperationType> q;
		
		q = em.createQuery("SELECT o FROM OperationType o where o.name = :name ORDER BY o.id", OperationType.class);
		q.setParameter("name", name);
		return JpaManager.getSingleResult(q);
	}

	@Override
	public boolean calculateAmount(Operation operation) {
		em.persist(operation);
		return true;
	}

	@Override
	public boolean updateTotalAmount(Operation operation) {
		try {
			em.merge(operation);
			return true;
		} catch (Exception e)  {
			logger.error("cannot update total amount in operation id:" + operation.getId());
			return false;
		}
	}
}
