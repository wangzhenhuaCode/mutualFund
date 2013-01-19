package Hibernate.DAO;

import Hibernate.BaseDAO.BaseHibernateDAO;
import Hibernate.PO.Position;

public class PositionDAO extends BaseHibernateDAO<Position> implements IPositionDAO {
	public void initDAO(){
		super.init(Position.class.getName());
	}
}