package com.usta.covidapp_ejb.interfaces;

import java.util.List;

import javax.ejb.Remote;

import covid.APP_mysql.model.Login;

/**
 * Interfaz de tipo Bean que se encarga de definir los metodos 
 * para realizar los crud.
 * @author Administrador
 *@param <T> tipo de objecto que recibe.
 */

@Remote
public interface IObjectQuery<T> {
	
	/**
	 * metodo que se encarga de crear el objeto
	 * a persistir
	 * @param t
	 * @throws Exception
	 */
	public void create(T t) throws Exception;
/**
 * metodo encargado de buscar y listar
 * todos los objetos de la consulta
 * que se haga
 * @return
 * @throws Exception
 */
	public List<T> findALL(Class<T> t) throws Exception;
	
	/**
	 * metodo para encontrar por el id el objeto buscado
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	
	public T findById(Integer id, Class<T> object) throws Exception;
	
	/**
	 * metodo para realizar culquier
	 * cambio o midificación
	 * sobre un dato de un objeto
	 * @param t
	 * @throws Exception
	 */
	
	public void update(T t) throws Exception;
	
	/**
	 * elimina un objeto dependiendo el id 
	 * que se solicita buscar
	 * @param id
	 * @throws Exception
	 */
	
	public void delete(Integer id, Class<T> object) throws Exception;
	
	/**
	 * busca usuario segun credenciales
	 * @param user
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public T searchUser(String user, String password) throws Exception;
	
	
}
