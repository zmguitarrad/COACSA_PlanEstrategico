package coacsantaanita.model.core.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the seguridades_usuario database table.
 * 
 */
@Entity
@Table(name="seguridades_usuario")
@NamedQuery(name="SeguridadesUsuario.findAll", query="SELECT s FROM SeguridadesUsuario s")
public class SeguridadesUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_usuario")
	private String idUsuario;

	private Boolean activo;

	private String apellidos;

	private String cedula;

	private String clave;

	private String correo;

	private String nombres;

	private Integer secuencial;
	
	@OneToMany(mappedBy="seguridadesUsuario")
	private List<SeguridadesUsuarioRole> seguridadesUsuarioRole;

	public SeguridadesUsuario() {
	}

	public String getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
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

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public Integer getSecuencial() {
		return this.secuencial;
	}

	public void setSecuencial(Integer secuencial) {
		this.secuencial = secuencial;
	}

	public List<SeguridadesUsuarioRole> getSeguridadesUsuarioRole() {
		return seguridadesUsuarioRole;
	}

	public void setSeguridadesUsuarioRole(List<SeguridadesUsuarioRole> seguridadesUsuarioRole) {
		this.seguridadesUsuarioRole = seguridadesUsuarioRole;
	}
	
	public SeguridadesUsuarioRole addSeguridadesUsuarioRole(SeguridadesUsuarioRole seguridadesUsuarioRole) {
		getSeguridadesUsuarioRole().add(seguridadesUsuarioRole);
		seguridadesUsuarioRole.setSeguridadesUsuario(this);

		return seguridadesUsuarioRole;
	}

	public SeguridadesUsuarioRole removeSeguridadesUsuarioRole(SeguridadesUsuarioRole seguridadesUsuarioRole) {
		getSeguridadesUsuarioRole().remove(seguridadesUsuarioRole);
		seguridadesUsuarioRole.setSeguridadesUsuario(null);
		return seguridadesUsuarioRole;
	}
	

}