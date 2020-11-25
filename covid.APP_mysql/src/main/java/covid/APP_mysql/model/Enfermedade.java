package covid.APP_mysql.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the enfermedades database table.
 * 
 */
@Entity
@Table(name="enfermedades")

public class Enfermedade implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String FIND_ALL = "Enfermedade.FIND_ALL";

	@Id
	@Column(name="id_enfermedad")
	private int idEnfermedad;

	@Column(name = "desripcion")
	private String descricion;

	public Enfermedade() {
	}

	public int getIdEnfermedad() {
		return this.idEnfermedad;
	}

	public void setIdEnfermedad(int idEnfermedad) {
		this.idEnfermedad = idEnfermedad;
	}

	public String getDescricion() {
		return this.descricion;
	}

	public void setDesripcion(String descricion) {
		this.descricion = descricion;
	}

}