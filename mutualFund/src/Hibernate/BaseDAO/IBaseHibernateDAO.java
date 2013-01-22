package Hibernate.BaseDAO;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;


public interface IBaseHibernateDAO<T> {
	public Serializable save(T object);

	public void update(T object);

	public void delete(T object);
	
	public Integer count(String property, String value);
	
	public List<T> findByProperty(String propertyName, Object value);

	public List<T> findByTwoProperty(String propertyName1, Object value1,
			String propertyName2, Object value2);

	public List<T> findAll();
	
	public List<T> find(T object);

//	public List<T> findByQuery(String hqlquery);


	public List<T> getListByPage(final int offset,
			final int length, final String property, final String value);
	
//	public Integer updateBySQL(final String sql);
	

}
