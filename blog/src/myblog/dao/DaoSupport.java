package myblog.dao;

import java.util.List;

import javax.annotation.Resource;

import myblog.bean.QueryResult;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public abstract class DaoSupport extends HibernateDaoSupport implements DAO {

	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry)
	{
		super.setSessionFactory(sessionFacotry);
	}

	@Override
	public void save(Object o)
	{
		this.getHibernateTemplate().save(o);
	}
	
	@Override
	public void delete(Object o)
	{
		this.getHibernateTemplate().delete(o);
	}

	@Override
	public void update(Object o)
	{
		this.getHibernateTemplate().update(o);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T find(Class<T> entityClass,String wherehql)
	{
		String hql = "from " + entityClass.getSimpleName() + " u "+(wherehql==null?"":wherehql);
		return (T) this.getHibernateTemplate().find(hql).get(0);
	}

	@Override
	public <T> QueryResult<T> getScrollData(Class<T> entityClass, int first,
			int max, String wherehql)
	{
		QueryResult<T> qr = new QueryResult<T>();
		// from User u where wherehql
		String hql = "from " + entityClass.getSimpleName() + " u "
				+ (wherehql == null ? "" : wherehql);
		System.out.println("=========" + hql);
		Query query = this.getSession().createQuery(hql);

		List list = query.list();
		System.out.println(list.toString());
		if (first != -1 && max != -1)
			query.setFirstResult(first).setMaxResults(max);
		qr.setResultlist(query.list());
		// select count(u) from User u
		query = this.getSession().createQuery(
				"select count(u) from " + entityClass.getSimpleName() + " u");
		qr.setTotalRecord((Long) query.uniqueResult());
		return qr;
	}

	@Override
	public <T> QueryResult<T> getScrollData(Class<T> entityClass, int first,
			int max)
	{
		return getScrollData(entityClass, first, max, null);
	}

	@Override
	public <T> QueryResult<T> getScrollData(Class<T> entityClass)
	{
		return getScrollData(entityClass, -1, -1);
	}
	
	@Override
	public <T> QueryResult<T> findByName(Class<T> entity, String wherehql)
	{
		return getScrollData(entity,-1,-1,wherehql);
	}
	
	@Override
	public <T> void delete(Class<T> entity,String wherehql)
	{
		this.getHibernateTemplate().delete(find(entity,wherehql));
	}
	

	

}
/*
 * public <T> QueryResult<T> getScrollData(Class<T> entityClass, int
 * firstIndex, int maxResult, LinkedHashMap<String, String> orderBy) {
 * QueryResult qr = new QueryResult<T>(); String entityname =
 * getEntityName(entityClass); Query query = em.createQuery("select o from "
 * + entityname + " o " + buildOrderby(orderBy));
 * query.setFirstResult(firstIndex).setMaxResults(maxResult);
 * qr.setResultlist(query.getResultList()); query =
 * em.createQuery("select count(o) from " + entityname + " o");
 * qr.setTotalRecord((Long) query.getSingleResult()); return qr; }
 */