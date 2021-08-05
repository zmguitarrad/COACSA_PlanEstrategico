package coacsantaanita.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the proceso_actividad database table.
 * 
 */
@Entity
@Table(name="proceso_actividad")
@NamedQuery(name="ProcesoActividad.findAll", query="SELECT p FROM ProcesoActividad p")
public class ProcesoActividad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer secuencial;

	private String entregables;

	@Column(name="nombre_actividad")
	private String nombreActividad;

	private String observaciones;

	@Column(name="personal_apoyo")
	private String personalApoyo;

	@Column(name="secuencial_indicador")
	private Integer secuencialIndicador;

	@Column(name="secuencial_usuario_roles")
	private Integer secuencialUsuarioRoles;

	//bi-directional many-to-one association to MandoIntegralPoaMaestro
	@OneToMany(mappedBy="procesoActividad")
	private List<MandoIntegralPoaMaestro> mandoIntegralPoaMaestros;

	public ProcesoActividad() {
	}

	public Integer getSecuencial() {
		return this.secuencial;
	}

	public void setSecuencial(Integer secuencial) {
		this.secuencial = secuencial;
	}

	public String getEntregables() {
		return this.entregables;
	}

	public void setEntregables(String entregables) {
		this.entregables = entregables;
	}

	public String getNombreActividad() {
		return this.nombreActividad;
	}

	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getPersonalApoyo() {
		return this.personalApoyo;
	}

	public void setPersonalApoyo(String personalApoyo) {
		this.personalApoyo = personalApoyo;
	}

	public Integer getSecuencialIndicador() {
		return this.secuencialIndicador;
	}

	public void setSecuencialIndicador(Integer secuencialIndicador) {
		this.secuencialIndicador = secuencialIndicador;
	}

	public Integer getSecuencialUsuarioRoles() {
		return this.secuencialUsuarioRoles;
	}

	public void setSecuencialUsuarioRoles(Integer secuencialUsuarioRoles) {
		this.secuencialUsuarioRoles = secuencialUsuarioRoles;
	}

	public List<MandoIntegralPoaMaestro> getMandoIntegralPoaMaestros() {
		return this.mandoIntegralPoaMaestros;
	}

	public void setMandoIntegralPoaMaestros(List<MandoIntegralPoaMaestro> mandoIntegralPoaMaestros) {
		this.mandoIntegralPoaMaestros = mandoIntegralPoaMaestros;
	}

	public MandoIntegralPoaMaestro addMandoIntegralPoaMaestro(MandoIntegralPoaMaestro mandoIntegralPoaMaestro) {
		getMandoIntegralPoaMaestros().add(mandoIntegralPoaMaestro);
		mandoIntegralPoaMaestro.setProcesoActividad(this);

		return mandoIntegralPoaMaestro;
	}

	public MandoIntegralPoaMaestro removeMandoIntegralPoaMaestro(MandoIntegralPoaMaestro mandoIntegralPoaMaestro) {
		getMandoIntegralPoaMaestros().remove(mandoIntegralPoaMaestro);
		mandoIntegralPoaMaestro.setProcesoActividad(null);

		return mandoIntegralPoaMaestro;
	}

}