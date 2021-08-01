package coacsantaanita.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
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

	//bi-directional many-to-one association to Actividade
	@OneToMany(mappedBy="usuario")
	private List<Actividade> actividades;

	//bi-directional many-to-one association to Role
	@OneToMany(mappedBy="usuario")
	private List<Role> roles;

	public Usuario() {
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

	public List<Actividade> getActividades() {
		return this.actividades;
	}

	public void setActividades(List<Actividade> actividades) {
		this.actividades = actividades;
	}

	public Actividade addActividade(Actividade actividade) {
		getActividades().add(actividade);
		actividade.setUsuario(this);

		return actividade;
	}

	public Actividade removeActividade(Actividade actividade) {
		getActividades().remove(actividade);
		actividade.setUsuario(null);

		return actividade;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Role addRole(Role role) {
		getRoles().add(role);
		role.setUsuario(this);

		return role;
	}

	public Role removeRole(Role role) {
		getRoles().remove(role);
		role.setUsuario(null);

		return role;
	}

}