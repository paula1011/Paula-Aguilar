package covid.APP_mysql.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the departamentos database table.
 * 
 */
@Entity
@Table(name = "departamentos")

public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Departamento.FIND_ALL";

	@Id
	@Column(name = "id_departamento")
	private int idDepartamento;

	private String nombre;

	public Departamento() {
	}

	public int getIdDepartamento() {
		return this.idDepartamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}