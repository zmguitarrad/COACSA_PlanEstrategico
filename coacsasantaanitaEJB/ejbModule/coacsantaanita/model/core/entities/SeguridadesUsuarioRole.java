package coacsantaanita.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the seguridades_usuario_roles database table.
 * 
 */
@Entity
@Table(name="seguridades_usuario_roles")
@NamedQuery(name="SeguridadesUsuarioRole.findAll", query="SELECT s FROM SeguridadesUsuarioRole s")
public class SeguridadesUsuarioRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer secuencial;

	@Column(name="id_usuario")
	private String idUsuario;

	@Column(name="secuencial_roles")
	private Integer secuencialRoles;

	public SeguridadesUsuarioRole() {
	}

	public Integer getSecuencial() {
		return this.secuencial;
	}

	public void setSecuencial(Integer secuencial) {
		this.secuencial = secuencial;
	}

	public String getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getSecuencialRoles() {
		return this.secuencialRoles;
	}

	public void setSecuencialRoles(Integer secuencialRoles) {
		this.secuencialRoles = secuencialRoles;
	}

}