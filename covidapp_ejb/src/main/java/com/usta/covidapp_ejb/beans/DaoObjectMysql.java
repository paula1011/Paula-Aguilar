package com.usta.covidapp_ejb.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import com.usta.covidapp_ejb.interfaces.IObjectQuery;

import covid.APP_mysql.model.Login;

@Stateless 
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)

public class DaoObjectMysql<T> implements IObjectQuery<T>{
	
	
	@PersistenceContext(unitName ="covid.APP_mysql")
	EntityManager mysqlentity;

	@Override
	public void create(T t) throws Exception {
	mysqlentity.persist(t);
   
	}

	@Override
	public List<T> findALL(Class<T> t) throws Exception {
		List<T> object = new ArrayList<T>();
		
		Query querySql = (Query) mysqlentity.createNamedQuery(t.getSimpleName()+ ".FIND_ALL");
		
		object = ((javax.persistence.Query) querySql).getResultList();
		
		return object;
	}

	@Override
	public T findById(Integer id, Class<T> object) throws Exception {
		T t = null;
		t = mysqlentity.find(object, id);
		return t;
	}

	@Override
	public void update(T t) throws Exception {
		mysqlentity.merge(t);
		
	}

	@Override
	public void delete(Integer id, Class<T> object) throws Exception {
		T t= findById(id,object);
		
		if(t!=null) {
			mysqlentity.remove(t);
		}
		
		
	}

	@Override
	public T searchUser(String user, String password) throws Exception {
		T l = null; 
		Query q = (Query) mysqlentity.createNamedQuery(Login.FIND_USER_CREDENTIALS);
		((javax.persistence.Query) q).setParameter("us", user);
		((javax.persistence.Query) q).setParameter("ps", password);
		
		try {
			l = (T) ((javax.persistence.Query) q).getSingleResult();
		} catch (NoResultException e) {
			 l = null; 
			
		}
		return l;
	}

}
