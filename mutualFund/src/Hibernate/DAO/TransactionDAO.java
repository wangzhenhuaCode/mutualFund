package Hibernate.DAO;

import Hibernate.BaseDAO.BaseHibernateDAO;
import Hibernate.PO.Transaction;

public class TransactionDAO extends BaseHibernateDAO<Transaction> implements ITransactionDAO {
	public void initDAO(){
		super.init(Transaction.class.getName());
	}
}