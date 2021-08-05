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
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private SeguridadesUsuario seguridadesUsuario;
	
	@ManyToOne
	@JoinColumn(name="secuencial_roles")
	private SeguridadesRole seguridadesRoles;

	public SeguridadesUsuarioRole() {
	}

	public Integer getSecuencial() {
		return this.secuencial;
	}

	public void setSecuencial(Integer secuencial) {
		this.secuencial = secuencial;
	}

	
	public SeguridadesUsuario getSeguridadesUsuario() {
		return seguridadesUsuario;
	}

	public void setSeguridadesUsuario(SeguridadesUsuario seguridadesUsuario) {
		this.seguridadesUsuario = seguridadesUsuario;
	}

	public SeguridadesRole getSeguridadesRoles() {
		return seguridadesRoles;
	}

	public void setSeguridadesRoles(SeguridadesRole seguridadesRoles) {
		this.seguridadesRoles = seguridadesRoles;
	}

	

}