package coacsantaanita.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the proceso_actividades database table.
 * 
 */
@Entity
@Table(name="proceso_actividades")
@NamedQuery(name="ProcesoActividade.findAll", query="SELECT p FROM ProcesoActividade p")
public class ProcesoActividade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer secuencial;

	private String entregables;

	@Column(name="nombre_actividad")
	private String nombreActividad;

	@Column(name="personal_apoyo")
	private String personalApoyo;

	//bi-directional many-to-one association to MandoIntegralPoaActividade
	@OneToMany(mappedBy="procesoActividade")
	private List<MandoIntegralPoaActividade> mandoIntegralPoaActividades;

	//bi-directional many-to-one association to IndicadoresIndicador
	@ManyToOne
	@JoinColumn(name="secuencial_indicador")
	private IndicadoresIndicador indicadoresIndicador;

	//bi-directional many-to-one association to ProcesoObservacion
	@ManyToOne
	@JoinColumn(name="secuencial_observacion")
	private ProcesoObservacion procesoObservacion;

	//bi-directional many-to-one association to SeguridadesRole
	@ManyToOne
	@JoinColumn(name="secuencial_roles")
	private SeguridadesRole seguridadesRole;

	public ProcesoActividade() {
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

	public String getPersonalApoyo() {
		return this.personalApoyo;
	}

	public void setPersonalApoyo(String personalApoyo) {
		this.personalApoyo = personalApoyo;
	}

	public List<MandoIntegralPoaActividade> getMandoIntegralPoaActividades() {
		return this.mandoIntegralPoaActividades;
	}

	public void setMandoIntegralPoaActividades(List<MandoIntegralPoaActividade> mandoIntegralPoaActividades) {
		this.mandoIntegralPoaActividades = mandoIntegralPoaActividades;
	}

	public MandoIntegralPoaActividade addMandoIntegralPoaActividade(MandoIntegralPoaActividade mandoIntegralPoaActividade) {
		getMandoIntegralPoaActividades().add(mandoIntegralPoaActividade);
		mandoIntegralPoaActividade.setProcesoActividade(this);

		return mandoIntegralPoaActividade;
	}

	public MandoIntegralPoaActividade removeMandoIntegralPoaActividade(MandoIntegralPoaActividade mandoIntegralPoaActividade) {
		getMandoIntegralPoaActividades().remove(mandoIntegralPoaActividade);
		mandoIntegralPoaActividade.setProcesoActividade(null);

		return mandoIntegralPoaActividade;
	}

	public IndicadoresIndicador getIndicadoresIndicador() {
		return this.indicadoresIndicador;
	}

	public void setIndicadoresIndicador(IndicadoresIndicador indicadoresIndicador) {
		this.indicadoresIndicador = indicadoresIndicador;
	}

	public ProcesoObservacion getProcesoObservacion() {
		return this.procesoObservacion;
	}

	public void setProcesoObservacion(ProcesoObservacion procesoObservacion) {
		this.procesoObservacion = procesoObservacion;
	}

	public SeguridadesRole getSeguridadesRole() {
		return this.seguridadesRole;
	}

	public void setSeguridadesRole(SeguridadesRole seguridadesRole) {
		this.seguridadesRole = seguridadesRole;
	}

}