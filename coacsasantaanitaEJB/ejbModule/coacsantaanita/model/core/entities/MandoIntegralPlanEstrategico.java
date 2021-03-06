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

	@Column(name="anio_fin")
	private Integer anioFin;

	@Column(name="anio_inicio")
	private Integer anioInicio;

	@Column(name="nombre_plan_estrategico")
	private String nombrePlanEstrategico;

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

	public Integer getAnioFin() {
		return this.anioFin;
	}

	public void setAnioFin(Integer anioFin) {
		this.anioFin = anioFin;
	}

	public Integer getAnioInicio() {
		return this.anioInicio;
	}

	public void setAnioInicio(Integer anioInicio) {
		this.anioInicio = anioInicio;
	}

	public String getNombrePlanEstrategico() {
		return this.nombrePlanEstrategico;
	}

	public void setNombrePlanEstrategico(String nombrePlanEstrategico) {
		this.nombrePlanEstrategico = nombrePlanEstrategico;
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