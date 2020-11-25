package covid.APP_mysql.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the login database table.
 * 
 */
@Entity

public class Login implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String FIND_ALL = "Login.FIND_ALL";
	
	public static final String FIND_USER_CREDENTIALS = "Loging.FIND_USER_CREDENTIALS";

	@Id
	@Column(name="id_login")
	private int idLogin;

	private String clave;

	private String usuario;

	public Login() {
	}

	public int getIdLogin() {
		return this.idLogin;
	}

	public void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}