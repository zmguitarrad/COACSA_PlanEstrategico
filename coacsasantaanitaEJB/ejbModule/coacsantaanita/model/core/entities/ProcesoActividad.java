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

	//bi-directional many-to-one association to MandoIntegralPoaMaestro
	@OneToMany(mappedBy="procesoActividad")
	private List<MandoIntegralPoaMaestro> mandoIntegralPoaMaestros;

	//bi-directional many-to-one association to IndicadoresIndicadore
	@ManyToOne
	@JoinColumn(name="secuencial_indicador")
	private IndicadoresIndicadore indicadoresIndicadore;

	//bi-directional many-to-one association to SeguridadesUsuarioRole
	@ManyToOne
	@JoinColumn(name="secuencial_usuario_roles")
	private SeguridadesUsuarioRole seguridadesUsuarioRole;

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

	public IndicadoresIndicadore getIndicadoresIndicadore() {
		return this.indicadoresIndicadore;
	}

	public void setIndicadoresIndicadore(IndicadoresIndicadore indicadoresIndicadore) {
		this.indicadoresIndicadore = indicadoresIndicadore;
	}

	public SeguridadesUsuarioRole getSeguridadesUsuarioRole() {
		return this.seguridadesUsuarioRole;
	}

	public void setSeguridadesUsuarioRole(SeguridadesUsuarioRole seguridadesUsuarioRole) {
		this.seguridadesUsuarioRole = seguridadesUsuarioRole;
	}

}