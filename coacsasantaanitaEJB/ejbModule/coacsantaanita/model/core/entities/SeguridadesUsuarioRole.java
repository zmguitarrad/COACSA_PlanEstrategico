package coacsantaanita.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	//bi-directional many-to-one association to ProcesoActividad
	@OneToMany(mappedBy="seguridadesUsuarioRole")
	private List<ProcesoActividad> procesoActividads;

	//bi-directional many-to-one association to SeguridadesRole
	@ManyToOne
	@JoinColumn(name="secuencial_roles")
	private SeguridadesRole seguridadesRole;

	//bi-directional many-to-one association to SeguridadesUsuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private SeguridadesUsuario seguridadesUsuario;

	public SeguridadesUsuarioRole() {
	}

	public Integer getSecuencial() {
		return this.secuencial;
	}

	public void setSecuencial(Integer secuencial) {
		this.secuencial = secuencial;
	}

	public List<ProcesoActividad> getProcesoActividads() {
		return this.procesoActividads;
	}

	public void setProcesoActividads(List<ProcesoActividad> procesoActividads) {
		this.procesoActividads = procesoActividads;
	}

	public ProcesoActividad addProcesoActividad(ProcesoActividad procesoActividad) {
		getProcesoActividads().add(procesoActividad);
		procesoActividad.setSeguridadesUsuarioRole(this);

		return procesoActividad;
	}

	public ProcesoActividad removeProcesoActividad(ProcesoActividad procesoActividad) {
		getProcesoActividads().remove(procesoActividad);
		procesoActividad.setSeguridadesUsuarioRole(null);

		return procesoActividad;
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