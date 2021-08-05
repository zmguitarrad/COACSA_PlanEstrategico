package coacsantaanita.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the seguridades_roles database table.
 * 
 */
@Entity
@Table(name="seguridades_roles")
@NamedQuery(name="SeguridadesRole.findAll", query="SELECT s FROM SeguridadesRole s")
public class SeguridadesRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer secuencial;

	@Column(name="nombre_rol")
	private String nombreRol;

	@Column(name="ruta_acceso")
	private String rutaAcceso;

	public SeguridadesRole() {
	}

	public Integer getSecuencial() {
		return this.secuencial;
	}

	public void setSecuencial(Integer secuencial) {
		this.secuencial = secuencial;
	}

	public String getNombreRol() {
		return this.nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public String getRutaAcceso() {
		return this.rutaAcceso;
	}

	public void setRutaAcceso(String rutaAcceso) {
		this.rutaAcceso = rutaAcceso;
	}

}