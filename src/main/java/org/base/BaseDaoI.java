package org.base;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public interface BaseDaoI<T> {
	T findByID(Serializable id);
	
	void save(T o);
	
	void delete(T o);
	
	void deleteByID(Serializable id);
	
	List<T> list();
	
	void update(T o);
	
	void merge(T o);
	
	Date now();
	
	void setUTF8MB4();
	
	/**
	 * 使得对象与session脱离关系，这样对对象进行赋值将不会导致更新
	 * @param o
	 */
	void evict(Object o);
	
	List<T> listByIDs(List<Integer> ids);
	
	void flush();

	void clear();

}
