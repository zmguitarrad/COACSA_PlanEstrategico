package coacsantaanita.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mando_integral_plan_estrategico database table.
 * 
 */
@Entity
@Table(name="mando_integral_plan_estrategico")
@NamedQuery(name="MandoIntegralPlanEstrategico.findAll", query="SELECT m FROM MandoIntegralPlanEstrategico m")
public class MandoIntegralPlanEstrategico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer secuencial;

	//bi-directional many-to-one association to GeneralesAnio
	@ManyToOne
	@JoinColumn(name="secuencial_anio")
	private GeneralesAnio generalesAnio;

	//bi-directional many-to-one association to MandoIntegralDetallePlan
	@ManyToOne
	@JoinColumn(name="secuencial_detalle_plan")
	private MandoIntegralDetallePlan mandoIntegralDetallePlan;

	//bi-directional many-to-one association to MandoIntegralPoaMaestro
	@OneToMany(mappedBy="mandoIntegralPlanEstrategico")
	private List<MandoIntegralPoaMaestro> mandoIntegralPoaMaestros;

	//bi-directional many-to-one association to ProcesoPerspectiva
	@OneToMany(mappedBy="mandoIntegralPlanEstrategico")
	private List<ProcesoPerspectiva> procesoPerspectivas;

	public MandoIntegralPlanEstrategico() {
	}

	public Integer getSecuencial() {
		return this.secuencial;
	}

	public void setSecuencial(Integer secuencial) {
		this.secuencial = secuencial;
	}

	public GeneralesAnio getGeneralesAnio() {
		return this.generalesAnio;
	}

	public void setGeneralesAnio(GeneralesAnio generalesAnio) {
		this.generalesAnio = generalesAnio;
	}

	public MandoIntegralDetallePlan getMandoIntegralDetallePlan() {
		return this.mandoIntegralDetallePlan;
	}

	public void setMandoIntegralDetallePlan(MandoIntegralDetallePlan mandoIntegralDetallePlan) {
		this.mandoIntegralDetallePlan = mandoIntegralDetallePlan;
	}

	public List<MandoIntegralPoaMaestro> getMandoIntegralPoaMaestros() {
		return this.mandoIntegralPoaMaestros;
	}

	public void setMandoIntegralPoaMaestros(List<MandoIntegralPoaMaestro> mandoIntegralPoaMaestros) {
		this.mandoIntegralPoaMaestros = mandoIntegralPoaMaestros;
	}

	public MandoIntegralPoaMaestro addMandoIntegralPoaMaestro(MandoIntegralPoaMaestro mandoIntegralPoaMaestro) {
		getMandoIntegralPoaMaestros().add(mandoIntegralPoaMaestro);
		mandoIntegralPoaMaestro.setMandoIntegralPlanEstrategico(this);

		return mandoIntegralPoaMaestro;
	}

	public MandoIntegralPoaMaestro removeMandoIntegralPoaMaestro(MandoIntegralPoaMaestro mandoIntegralPoaMaestro) {
		getMandoIntegralPoaMaestros().remove(mandoIntegralPoaMaestro);
		mandoIntegralPoaMaestro.setMandoIntegralPlanEstrategico(null);

		return mandoIntegralPoaMaestro;
	}

	public List<ProcesoPerspectiva> getProcesoPerspectivas() {
		return this.procesoPerspectivas;
	}

	public void setProcesoPerspectivas(List<ProcesoPerspectiva> procesoPerspectivas) {
		this.procesoPerspectivas = procesoPerspectivas;
	}

	public ProcesoPerspectiva addProcesoPerspectiva(ProcesoPerspectiva procesoPerspectiva) {
		getProcesoPerspectivas().add(procesoPerspectiva);
		procesoPerspectiva.setMandoIntegralPlanEstrategico(this);

		return procesoPerspectiva;
	}

	public ProcesoPerspectiva removeProcesoPerspectiva(ProcesoPerspectiva procesoPerspectiva) {
		getProcesoPerspectivas().remove(procesoPerspectiva);
		procesoPerspectiva.setMandoIntegralPlanEstrategico(null);

		return procesoPerspectiva;
	}

}