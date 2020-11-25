package covid.APP_mysql.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the empresa_login database table.
 * 
 */
@Entity
@Table(name="empresa_login")

public class EmpresasLogin implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String FIND_ALL = "EmpresasLogin.FIND_ALL";

	@Id
	@Column(name="id_empresa_login")
	private int idEmpresaLogin;

	private int estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_cancelado")
	private Date fechaRetiro;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Column(name="id_empresa")
	private int idEmpresa;

	@Column(name="id_login")
	private int idLogin;

	public EmpresasLogin() {
	}

	public int getIdEmpresaLogin() {
		return this.idEmpresaLogin;
	}

	public void setIdEmpresaLogin(int idEmpresaLogin) {
		this.idEmpresaLogin = idEmpresaLogin;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	
	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Date getFechaReiro() {
		return fechaRetiro;
	}

	public void setFechaReiro(Date fechaRetiro) {
		this.fechaRetiro = fechaRetiro;
	}

	public int getIdEmpresa() {
		return this.idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public int getIdLogin() {
		return this.idLogin;
	}

	public void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	}

	

}