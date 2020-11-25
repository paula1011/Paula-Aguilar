package com.usta.cmapp.control;

import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ManagedBean(value = "principal")
@SessionScoped
public class PrincipalController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Properties properties;
	private String userAcces;
	private final static String PAGE_PRINCIPAL = "../login/login.faces";

	public PrincipalController() {
		try {
			properties = new Properties();
			userAcces = null;
			chargeProperties();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void chargeProperties() {
		try {
			
			properties.load(PrincipalController.class.getResourceAsStream("message.properties"));
            userAcces = ((String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(LoginController.USER_AUTHENTICH)).toUpperCase();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					properties.getProperty("errorGeneral"), properties.getProperty("rrorCargaPropiedades")));
		}
	}
	@PostConstruct
	public void chargeData() {
		try {
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					properties.getProperty("errorGeneral"), properties.getProperty("errorCargaPropiedades")));
		}
		
	}
	
	public void logout() {

		try {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("principal");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(LoginController.USER_AUTHENTICH);
		FacesContext.getCurrentInstance().getExternalContext().redirect(PAGE_PRINCIPAL);
		
	} catch (IOException e) {
		e.printStackTrace();
	}
		
	}

	public String getUserAcces() {
		return userAcces;
	}

	public void setUserAcces(String userAcces) {
		this.userAcces = userAcces;
	}
	 
	

}
