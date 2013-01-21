package Hibernate.BaseDAO;
//dashabi
import java.io.Serializable;
import java.util.Collection;
import java.util.List;


public interface IBaseHibernateDAO<T> {
	public Serializable save(T object);

	public void update(T object);

	public void delete(T object);
	
	public Integer count(final String queryString);
	
	public List<T> findByProperty(String propertyName, Object value);

	public List<T> findByTwoProperty(String propertyName1, Object value1,
			String propertyName2, Object value2);

	

	public List<T> findByQuery(String queryString);


	public List<T> getListByPage(final String hql, final int offset,
		final int length);
	
	public Integer updateBySQL(final String sql);
	
	public Integer max(final String queryString);

}
