package Hibernate.BaseDAO;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Iterator;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseHibernateDAO<T> extends HibernateDaoSupport implements
		IBaseHibernateDAO<T> {

	protected String entityName;

	protected String className;

	public Serializable save(T object) {
		try {
			return getHibernateTemplate().save(object);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void update(T object) {
		try {
			getHibernateTemplate().update(object);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(T object) {
		try {
			getHibernateTemplate().delete(object);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	public List<T> find(T object){
		try {
			return getHibernateTemplate().findByExample(object);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from " + entityName
					+ " as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	public List<T> findAll(){
		try {
			String queryString = "from " + entityName;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public Integer count(String property, String value){
		String hql="select count(*) from "+entityName;
		if(property!=null&&!property.equals("")){
			hql=hql+" where "+property+"="+value;
		}
		List<Long> list=getHibernateTemplate().find(hql);
		return (int)(long)list.get(0);
	}


	public void init(String _className) {
		this.className = _className;
		entityName = className.substring(_className.lastIndexOf(".") + 1);
	}

	@SuppressWarnings("unchecked")
	public List<T> findByTwoProperty(String propertyName1, Object value1,
			String propertyName2, Object value2) {
		try {
			String queryString = "from " + entityName
					+ " as model where model." + propertyName1
					+ "= ? and model." + propertyName2 + "=?";
			Object[] values = { value1, value2 };
			return getHibernateTemplate().find(queryString, values);
		} catch (RuntimeException re) {
			throw re;
		}
	}


	@SuppressWarnings("unchecked")
	public List<T> findByQuery(String hqlquery) {
		return getHibernateTemplate().find(hqlquery);
	}
	@SuppressWarnings("unchecked")
	public List<T> getListByPage( final int offset,
			final int length, final String property, final String value) {
		List<T> list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql="from " + entityName;
				if(property!=null&&!property.equals(""))
					hql=hql+" "+"where "+property+"="+value;
				Query query = session.createQuery(hql);
				query.setFirstResult(offset);
				query.setMaxResults(length);
				List<T> list = query.list();
				return list;
			}
		});
		return list;
	}
	public Integer updateBySQL(final String sql) {
		Integer status = (Integer)getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {

				Transaction tran=session.beginTransaction();
					try{
							Query query = session.createSQLQuery(sql);
							query.executeUpdate();
						tran.commit();
					}catch(Exception e){
						tran.rollback();
						System.out.println(e);
						return 0;
					}
					getHibernateTemplate().flush();
					getHibernateTemplate().clear();
					return 1;
			}
		});
		return status;
	}

}

