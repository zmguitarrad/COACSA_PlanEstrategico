package coacsantaanita.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the poa_maestro database table.
 * 
 */
@Entity
@Table(name="poa_maestro")
@NamedQuery(name="PoaMaestro.findAll", query="SELECT p FROM PoaMaestro p")
public class PoaMaestro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer secuencial;

	private String entregable;

	private String observaciones;

	//bi-directional many-to-one association to Actividade
	@ManyToOne
	@JoinColumn(name="secuencial_actividades")
	private Actividade actividade;

	//bi-directional many-to-one association to Calendario
	@ManyToOne
	@JoinColumn(name="secuencial_calendario")
	private Calendario calendario;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="secuencial_estado")
	private Estado estado;

	//bi-directional many-to-one association to PlanEstrategico
	@ManyToOne
	@JoinColumn(name="secuencial_plan_estrategico")
	private PlanEstrategico planEstrategico;

	public PoaMaestro() {
	}

	public Integer getSecuencial() {
		return this.secuencial;
	}

	public void setSecuencial(Integer secuencial) {
		this.secuencial = secuencial;
	}

	public String getEntregable() {
		return this.entregable;
	}

	public void setEntregable(String entregable) {
		this.entregable = entregable;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Actividade getActividade() {
		return this.actividade;
	}

	public void setActividade(Actividade actividade) {
		this.actividade = actividade;
	}

	public Calendario getCalendario() {
		return this.calendario;
	}

	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public PlanEstrategico getPlanEstrategico() {
		return this.planEstrategico;
	}

	public void setPlanEstrategico(PlanEstrategico planEstrategico) {
		this.planEstrategico = planEstrategico;
	}

}