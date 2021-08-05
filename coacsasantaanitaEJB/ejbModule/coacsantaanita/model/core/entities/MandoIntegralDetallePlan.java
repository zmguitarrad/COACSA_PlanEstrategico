package coacsantaanita.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mando_integral_detalle_plan database table.
 * 
 */
@Entity
@Table(name="mando_integral_detalle_plan")
@NamedQuery(name="MandoIntegralDetallePlan.findAll", query="SELECT m FROM MandoIntegralDetallePlan m")
public class MandoIntegralDetallePlan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer secuencial;

	@Column(name="nombre_plan")
	private String nombrePlan;

	//bi-directional many-to-one association to MandoIntegralPlanEstrategico
	@OneToMany(mappedBy="mandoIntegralDetallePlan")
	private List<MandoIntegralPlanEstrategico> mandoIntegralPlanEstrategicos;

	public MandoIntegralDetallePlan() {
	}

	public Integer getSecuencial() {
		return this.secuencial;
	}

	public void setSecuencial(Integer secuencial) {
		this.secuencial = secuencial;
	}

	public String getNombrePlan() {
		return this.nombrePlan;
	}

	public void setNombrePlan(String nombrePlan) {
		this.nombrePlan = nombrePlan;
	}

	public List<MandoIntegralPlanEstrategico> getMandoIntegralPlanEstrategicos() {
		return this.mandoIntegralPlanEstrategicos;
	}

	public void setMandoIntegralPlanEstrategicos(List<MandoIntegralPlanEstrategico> mandoIntegralPlanEstrategicos) {
		this.mandoIntegralPlanEstrategicos = mandoIntegralPlanEstrategicos;
	}

	public MandoIntegralPlanEstrategico addMandoIntegralPlanEstrategico(MandoIntegralPlanEstrategico mandoIntegralPlanEstrategico) {
		getMandoIntegralPlanEstrategicos().add(mandoIntegralPlanEstrategico);
		mandoIntegralPlanEstrategico.setMandoIntegralDetallePlan(this);

		return mandoIntegralPlanEstrategico;
	}

	public MandoIntegralPlanEstrategico removeMandoIntegralPlanEstrategico(MandoIntegralPlanEstrategico mandoIntegralPlanEstrategico) {
		getMandoIntegralPlanEstrategicos().remove(mandoIntegralPlanEstrategico);
		mandoIntegralPlanEstrategico.setMandoIntegralDetallePlan(null);

		return mandoIntegralPlanEstrategico;
	}

}