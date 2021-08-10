package coacsantaanita.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the seguridades_usuarios database table.
 * 
 */
@Entity
@Table(name="seguridades_usuarios")
@NamedQuery(name="SeguridadesUsuario.findAll", query="SELECT s FROM SeguridadesUsuario s")
public class SeguridadesUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String secuencial;

	private Boolean activo;

	private String apellidos;

	private String cedula;

	private String clave;

	private String correo;

	private Integer id;

	private String nombres;

	//bi-directional many-to-one association to SeguridadesUsuarioRole
	@OneToMany(mappedBy="seguridadesUsuario")
	private List<SeguridadesUsuarioRole> seguridadesUsuarioRoles;

	public SeguridadesUsuario() {
	}

	public String getSecuencial() {
		return this.secuencial;
	}

	public void setSecuencial(String secuencial) {
		this.secuencial = secuencial;
	}

	public Boolean getActivo() {
		return this.activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public List<SeguridadesUsuarioRole> getSeguridadesUsuarioRoles() {
		return this.seguridadesUsuarioRoles;
	}

	public void setSeguridadesUsuarioRoles(List<SeguridadesUsuarioRole> seguridadesUsuarioRoles) {
		this.seguridadesUsuarioRoles = seguridadesUsuarioRoles;
	}

	public SeguridadesUsuarioRole addSeguridadesUsuarioRole(SeguridadesUsuarioRole seguridadesUsuarioRole) {
		getSeguridadesUsuarioRoles().add(seguridadesUsuarioRole);
		seguridadesUsuarioRole.setSeguridadesUsuario(this);

		return seguridadesUsuarioRole;
	}

	public SeguridadesUsuarioRole removeSeguridadesUsuarioRole(SeguridadesUsuarioRole seguridadesUsuarioRole) {
		getSeguridadesUsuarioRoles().remove(seguridadesUsuarioRole);
		seguridadesUsuarioRole.setSeguridadesUsuario(null);

		return seguridadesUsuarioRole;
	}

}