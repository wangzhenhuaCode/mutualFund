package Hibernate.DAO;

import Hibernate.BaseDAO.BaseHibernateDAO;
import Hibernate.PO.FundPriceHistory;

public class FundPriceHistoryDAO extends BaseHibernateDAO<FundPriceHistory> implements IFundPriceHistoryDAO {
	public void initDAO(){
		super.init(FundPriceHistory.class.getName());
	}
}
