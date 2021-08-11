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

	private Boolean activo;

	//bi-directional many-to-one association to SeguridadesRole
	@ManyToOne
	@JoinColumn(name="secuencial_roles")
	private SeguridadesRole seguridadesRole;

	//bi-directional many-to-one association to SeguridadesUsuario
	@ManyToOne
	@JoinColumn(name="secuencial_usuario")
	private SeguridadesUsuario seguridadesUsuario;

	public SeguridadesUsuarioRole() {
	}

	public Integer getSecuencial() {
		return this.secuencial;
	}

	public void setSecuencial(Integer secuencial) {
		this.secuencial = secuencial;
	}

	public Boolean getActivo() {
		return this.activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public SeguridadesRole getSeguridadesRole() {
		return this.seguridadesRole;
	}

	public void setSeguridadesRole(SeguridadesRole seguridadesRole) {
		this.seguridadesRole = seguridadesRole;
	}

	public SeguridadesUsuario getSeguridadesUsuario() {
		return this.seguridadesUsuario;
	}

	public void setSeguridadesUsuario(SeguridadesUsuario seguridadesUsuario) {
		this.seguridadesUsuario = seguridadesUsuario;
	}

}