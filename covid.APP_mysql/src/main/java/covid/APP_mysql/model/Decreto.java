package covid.APP_mysql.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the decretos database table.
 * 
 */
@Entity
@Table(name = "decretos")

public class Decreto implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Decreto.FIND_ALL";

	@Id
	@Column(name = "id_decreto")
	private int idDecreto;

	@Column(name = "descripcion")
	private String descripcio;

	@Column(name = "numero_decreto")
	private String numeroDecreto;

	public Decreto() {
	}

	public int getIdDecreto() {
		return this.idDecreto;
	}

	public void setIdDecreto(int idDecreto) {
		this.idDecreto = idDecreto;
	}

	public String getDescripcio() {
		return this.descripcio;
	}

	public void setDescripcion(String descripcio) {
		this.descripcio = descripcio;
	}

	public String getNumeroDecreto() {
		return this.numeroDecreto;
	}

	public void setNumeroDecreto(String numeroDecreto) {
		this.numeroDecreto = numeroDecreto;
	}

}