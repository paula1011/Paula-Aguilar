package com.usta.covidapp_ejb.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import com.usta.covidapp_ejb.beans.DaoObjectMysql;
import com.usta.covidapp_ejb.beans.DaoObjectPostgreSQL;

import covid.APP_mysql.model.Login;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class ServicesDao<T> {

	@EJB
	DaoObjectMysql<T> mysqlDao;

	@EJB
	DaoObjectPostgreSQL<T> postgresDao;

	/**
	 * metodo que se encarga de crear el objeto a persistir
	 * 
	 * @param t
	 * @throws Exception
	 */
	public void create(T t, int db) throws Exception {

		switch (db) {

		case 1: // mysql
			mysqlDao.create(t);

			break;

		case 2: // postgres
			postgresDao.create(t);

			break;
		}

	}

	/**
	 * metodo encargado de buscar y listar todos los objetos de la consulta que se
	 * haga
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<T> findALL(Class<T> t, int db) throws Exception {

		List<T> object = new ArrayList<T>();

		switch (db) {

		case 1: // mysql
			object = mysqlDao.findALL(t);

			break;

		case 2: // postgres
			object = postgresDao.findALL(t);

			break;
		}

		return null;
	}

	/**
	 * metodo para encontrar por el id el objeto buscado
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */

	public T findById(Integer id, Class<T> object, int db) throws Exception {

		T o = null;
		switch (db) {

		case 1: // mysql
			o = mysqlDao.findById(id, object);

			break;

		case 2: // postgres
			o = postgresDao.findById(id, object);

			break;
		}
		return null;
	}

	/**
	 * metodo para realizar culquier cambio o midificación sobre un dato de un
	 * objeto
	 * 
	 * @param t
	 * @throws Exception
	 */

	public void update(T t, int db) throws Exception {

		switch (db) {

		case 1: // mysql
			mysqlDao.update(t);

			break;

		case 2: // postgres
			postgresDao.update(t);

			break;
		}

	}

	/**
	 * elimina un objeto dependiendo el id que se solicita buscar
	 * 
	 * @param id
	 * @throws Exception
	 */

	public void delete(Integer id, Class<T> object, int db) throws Exception {

		switch (db) {

		case 1: // mysql
			mysqlDao.delete(id, object);

			break;

		case 2: // postgres
			postgresDao.delete(id, object);

			break;
		}
	}

	/**
	 * busca usuario segun credenciales
	 * 
	 * @param user
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public T searchUser(String user, String password, int bd) throws Exception {

		T t = null;
		switch (bd) {
		case 1:
			t = mysqlDao.searchUser(user, password);
			break;
		case 2:
			t = postgresDao.searchUser(user, password);
			break;
		}
		return t;
	}

}
