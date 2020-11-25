package covid.APP_mysql.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the historico_decretos database table.
 * 
 */
@Entity
@Table(name="historico_decretos")

public class HistoricosDecreto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String FIND_ALL = "HistoricosDecreto.FIND_ALL";

	@Id
	@Column(name="id_historico")
	private int idHistorico;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_decreto")
	private Date fechaDecreto;

	@Column(name="id_ciudad")
	private int idCiudad;
	
	@Column(name = "id_decreto")
	private int idDecreto;

	private String url;

	public HistoricosDecreto() {
	}

	public int getIdHistorico() {
		return this.idHistorico;
	}

	public void setIdHistorico(int idHistorico) {
		this.idHistorico = idHistorico;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaDecreto() {
		return this.fechaDecreto;
	}

	public void setFechaDecreto(Date fechaDecreto) {
		this.fechaDecreto = fechaDecreto;
	}

	public int getIdCiudad() {
		return this.idCiudad;
	}

	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}
	
    public int getIdDecreto() {
		return idDecreto;
	}

	public void setIdDecreto(int idDecreto) {
		this.idDecreto = idDecreto;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}