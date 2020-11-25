package com.usta.covidapp_ejb.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.usta.covidapp_ejb.interfaces.IObjectQuery;

import covid.APP_mysql.model.Login;

@Stateless
@Local
@TransactionManagement(TransactionManagementType.CONTAINER)

public class DaoObjectPostgreSQL<T> implements IObjectQuery<T> {
	@PersistenceContext(unitName="postgreSQL")
	   EntityManager postgresEntity;

	@Override
	public void create(T t) throws Exception {
		 postgresEntity.persist(t);
		
	}

	@Override
	public List<T> findALL(Class<T> t) throws Exception {
	  
		List<T> object = new ArrayList<T>();
		Query querySql = (Query) postgresEntity.createNamedQuery(t.getSimpleName()+ ".FIND_ALL");
		object = ((javax.persistence.Query) querySql).getResultList();
		
		return object;
	}
	@Override
	public T findById(Integer id, Class<T> object) throws Exception {
		
		T t = null;
		t = postgresEntity.find(object, id);
		return t;
	}

	@Override
	public void update(T t) throws Exception {
		postgresEntity.merge(t);
		
	}

	@Override
	public void delete(Integer id, Class<T> object) throws Exception {
		T t = findById(id, object);
		if(t!=null) {
			postgresEntity.remove(t);
		}

	}

	@Override
	public T searchUser(String user, String password) throws Exception {
		
		T t= null;
		
		try {
			Query q = (Query) postgresEntity.createNamedQuery(Login.FIND_USER_CREDENTIALS);
			((javax.persistence.Query) q).setParameter("us", user);
			((javax.persistence.Query) q).setParameter("ps", password);
		
		    t = (T) ((javax.persistence.Query) q).getSingleResult();
		} catch (Exception e) {
			t = null;
			
		}
		return t;
	}

	

}
