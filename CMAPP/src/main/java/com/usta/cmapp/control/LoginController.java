package com.usta.cmapp.control;

import java.io.Serializable;
import java.util.Properties;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;

import com.usta.cmapp.constants.EnumDataBase;
import com.usta.covidapp_ejb.service.ServicesDao;

import covid.APP_mysql.model.Login;

@ManagedBean(value = "login")
@SessionScoped
public class LoginController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String USER_AUTHENTICH = "user.app";

	public static final String AUTH_KEY = "app.user.name";

	private Properties properties; // lee el archivo messages.properties.

	private String user;

	private String password;

	@EJB
	private ServicesDao<Login> servicesDaoMysql;

	@EJB
	private ServicesDao<com.postgreSQL.model.Login> servicesDaoPostgres;

	/**
	 * method contructor from class
	 */
	public LoginController() {
		super();
		properties = new Properties();
		try {
			properties.load(LoginController.class.getResourceAsStream("messages.properties"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR: ", "NO PUEDE LEER ARCHIVOS DE PROPIEDADES"));
		}
	}

	@SuppressWarnings("unused")
	public String accessCheck() {
		String acces = null;
		try {

			Login login = servicesDaoMysql.searchUser(user, password, EnumDataBase.MYSQL.getId());

			if (login.getIdLogin() > 0) {
				acces = "pages/principal";

				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(USER_AUTHENTICH,
						login.getUsuario().trim());
			} else if (login == null) {
				com.postgreSQL.model.Login lpos = new com.postgreSQL.model.Login();

				lpos = servicesDaoPostgres.searchUser(user, password, EnumDataBase.POSTGRESQL.getId());

				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(USER_AUTHENTICH,
						lpos.getUsuario().trim());

				acces = "pages/principal";
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
						properties.getProperty("errorGeneral"), properties.getProperty("errorExistenciaUsuario")));

				acces = "login/login";

			}

		} catch (Exception e) {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					properties.getProperty("errorGeneral"), properties.getProperty("errorAutenticacion")));
		}

		return acces;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
