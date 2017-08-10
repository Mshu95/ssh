package org.yaoyan.base;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Transactional(rollbackFor=Throwable.class)
@Repository("baseDao")
public abstract  class BaseDaoImpl<T> implements BaseDaoI<T>{

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return this.sessionFactory.openSession();
	}
	protected Logger logger = LoggerFactory.getLogger(getClass());
	private Class<?> type;

	public BaseDaoImpl() {
	}

	public BaseDaoImpl(Class<?> type){
		this.type = type;
	}
	
	public void flush(){
		getSession().flush();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findByID(Serializable id) {
		return (T) getSession().get(type, id);
	}
	
	@Override
	public void save(T u) {
		getSession().save(u);
	}
	
	@Override
	public void delete(T o) {
		getSession().delete(o);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list() {
		return hqlQuery("from " + type.getSimpleName()).list();
	}

	@Override
	public void update(T o) {
		getSession().update(o);	
	}
	
	@Override
	public void merge(T o) {
		getSession().merge(o);
	}
	
	protected SQLQuery sqlQuery(String sql) {
		return getSession().createSQLQuery(sql);
	}
	
	protected Query hqlQuery(String hql) {
		return getSession().createQuery(hql);
	}
	
//	protected int intValSQLQuery(String sql) {
//		return SQLHelper.intVal(sqlQuery(sql).uniqueResult());
//	}
	
	@Override
	public Date now(){
		return (Date)(sqlQuery("select now()").uniqueResult());
	}
	
	@Override
	public void setUTF8MB4(){
		sqlQuery("set names utf8mb4").executeUpdate();
	}
	
	@Override
	public void evict(Object o){
		getSession().evict(o);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> listByIDs(List<Integer> ids){
		if(ids == null || ids.size() == 0) return null;
		
		return hqlQuery("from " + type.getSimpleName() + " where id in :ids")
				.setParameterList("ids", ids)
				.list();
	}
	
	@Override
	public void deleteByID(Serializable id){
		delete(findByID(id));
	}

	@Override
	public void clear(){
		getSession().clear();
	}


}
