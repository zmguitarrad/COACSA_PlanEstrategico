package coacsantaanita.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mando_integral_poa_maestro database table.
 * 
 */
@Entity
@Table(name="mando_integral_poa_maestro")
@NamedQuery(name="MandoIntegralPoaMaestro.findAll", query="SELECT m FROM MandoIntegralPoaMaestro m")
public class MandoIntegralPoaMaestro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer secuencial;

	//bi-directional many-to-one association to GeneralesEstado
	@ManyToOne
	@JoinColumn(name="secuencial_estado")
	private GeneralesEstado generalesEstado;

	//bi-directional many-to-one association to GeneralesMes
	@ManyToOne
	@JoinColumn(name="secuencial_meses")
	private GeneralesMes generalesMes;

	//bi-directional many-to-one association to MandoIntegralPlanEstrategico
	@ManyToOne
	@JoinColumn(name="secuencial_plan_estrategico")
	private MandoIntegralPlanEstrategico mandoIntegralPlanEstrategico;

	//bi-directional many-to-one association to ProcesoActividad
	@ManyToOne
	@JoinColumn(name="secuencial_actividad")
	private ProcesoActividad procesoActividad;

	public MandoIntegralPoaMaestro() {
	}

	public Integer getSecuencial() {
		return this.secuencial;
	}

	public void setSecuencial(Integer secuencial) {
		this.secuencial = secuencial;
	}

	public GeneralesEstado getGeneralesEstado() {
		return this.generalesEstado;
	}

	public void setGeneralesEstado(GeneralesEstado generalesEstado) {
		this.generalesEstado = generalesEstado;
	}

	public GeneralesMes getGeneralesMes() {
		return this.generalesMes;
	}

	public void setGeneralesMes(GeneralesMes generalesMes) {
		this.generalesMes = generalesMes;
	}

	public MandoIntegralPlanEstrategico getMandoIntegralPlanEstrategico() {
		return this.mandoIntegralPlanEstrategico;
	}

	public void setMandoIntegralPlanEstrategico(MandoIntegralPlanEstrategico mandoIntegralPlanEstrategico) {
		this.mandoIntegralPlanEstrategico = mandoIntegralPlanEstrategico;
	}

	public ProcesoActividad getProcesoActividad() {
		return this.procesoActividad;
	}

	public void setProcesoActividad(ProcesoActividad procesoActividad) {
		this.procesoActividad = procesoActividad;
	}

}