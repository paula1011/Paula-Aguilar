package com.postgreSQL.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the empresas_logins database table.
 * 
 */
@Entity
@Table(name="empresas_logins")

public class EmpresasLogin implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String FIND_ALL = "Empresas_logings.FIND_ALL";

	@Id
	@Column(name="id_empresa_login")
	private Integer idEmpresaLogin;

	private Integer estado;

	@Column(name="fecha_creacion")
	@Temporal(TemporalType.TIMESTAMP) 
	private Date fechaCreacion;

	@Column(name="fecha_retiro")
	@Temporal(TemporalType.TIMESTAMP) 
	private Date fechaRetiro;

	@Column(name="id_empresa")
	private Integer idEmpresa;

	@Column(name="id_login")
	private Integer idLogin;

	public EmpresasLogin() {
	}

	public Integer getIdEmpresaLogin() {
		return this.idEmpresaLogin;
	}

	public void setIdEmpresaLogin(Integer idEmpresaLogin) {
		this.idEmpresaLogin = idEmpresaLogin;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaRetiro() {
		return this.fechaRetiro;
	}

	public void setFechaRetiro(Timestamp fechaRetiro) {
		this.fechaRetiro = fechaRetiro;
	}

	public Integer getIdEmpresa() {
		return this.idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Integer getIdLogin() {
		return this.idLogin;
	}

	public void setIdLogin(Integer idLogin) {
		this.idLogin = idLogin;
	}

}