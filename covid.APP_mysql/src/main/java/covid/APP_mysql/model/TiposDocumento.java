package covid.APP_mysql.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipodocumentos database table.
 * 
 */
@Entity
@Table(name="tipodocumentos")

public class TiposDocumento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String FIND_ALL = "TiposDocumento.FIND_ALL";

	@Id
	@Column(name="id_tipo_documento")
	private int idTipoDocumento;

	private String descripcion;

	public TiposDocumento() {
	}

	public int getIdTipoDocumento() {
		return this.idTipoDocumento;
	}

	public void setIdTipoDocumento(int idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}