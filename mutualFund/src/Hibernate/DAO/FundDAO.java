package Hibernate.DAO;

import Hibernate.BaseDAO.BaseHibernateDAO;
import Hibernate.BaseDAO.IBaseHibernateDAO;
import Hibernate.PO.Employee;

public class FundDAO extends BaseHibernateDAO<FundDAO> implements IBaseHibernateDAO<FundDAO> {
	public void initDAO(){
		super.init(FundDAO.class.getName());
	}
}
