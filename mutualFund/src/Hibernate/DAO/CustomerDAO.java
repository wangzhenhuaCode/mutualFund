package Hibernate.DAO;

import Hibernate.BaseDAO.BaseHibernateDAO;
import Hibernate.PO.Customer;

public class CustomerDAO extends BaseHibernateDAO<Customer> implements ICustomerDAO {
	public void initDAO(){
		super.init(Customer.class.getName());
	}
}
