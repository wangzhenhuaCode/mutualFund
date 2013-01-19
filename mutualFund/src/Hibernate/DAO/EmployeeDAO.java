package Hibernate.DAO;

import Hibernate.BaseDAO.BaseHibernateDAO;
import Hibernate.PO.Employee;

public class EmployeeDAO extends BaseHibernateDAO<Employee> implements IEmployeeDAO {
	public void initDAO(){
		super.init(Employee.class.getName());
	}
}
