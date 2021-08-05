package coacsantaanita.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the proceso_perspectiva database table.
 * 
 */
@Entity
@Table(name="proceso_perspectiva")
@NamedQuery(name="ProcesoPerspectiva.findAll", query="SELECT p FROM ProcesoPerspectiva p")
public class ProcesoPerspectiva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer secuencial;

	@Column(name="nombre_perspectiva")
	private String nombrePerspectiva;

	//bi-directional many-to-one association to ProcesoObjetivoPerspectiva
	@OneToMany(mappedBy="procesoPerspectiva")
	private List<ProcesoObjetivoPerspectiva> procesoObjetivoPerspectivas;

	//bi-directional many-to-one association to MandoIntegralPlanEstrategico
	@ManyToOne
	@JoinColumn(name="secuencial_plan_estrategico")
	private MandoIntegralPlanEstrategico mandoIntegralPlanEstrategico;

	public ProcesoPerspectiva() {
	}

	public Integer getSecuencial() {
		return this.secuencial;
	}

	public void setSecuencial(Integer secuencial) {
		this.secuencial = secuencial;
	}

	public String getNombrePerspectiva() {
		return this.nombrePerspectiva;
	}

	public void setNombrePerspectiva(String nombrePerspectiva) {
		this.nombrePerspectiva = nombrePerspectiva;
	}

	public List<ProcesoObjetivoPerspectiva> getProcesoObjetivoPerspectivas() {
		return this.procesoObjetivoPerspectivas;
	}

	public void setProcesoObjetivoPerspectivas(List<ProcesoObjetivoPerspectiva> procesoObjetivoPerspectivas) {
		this.procesoObjetivoPerspectivas = procesoObjetivoPerspectivas;
	}

	public ProcesoObjetivoPerspectiva addProcesoObjetivoPerspectiva(ProcesoObjetivoPerspectiva procesoObjetivoPerspectiva) {
		getProcesoObjetivoPerspectivas().add(procesoObjetivoPerspectiva);
		procesoObjetivoPerspectiva.setProcesoPerspectiva(this);

		return procesoObjetivoPerspectiva;
	}

	public ProcesoObjetivoPerspectiva removeProcesoObjetivoPerspectiva(ProcesoObjetivoPerspectiva procesoObjetivoPerspectiva) {
		getProcesoObjetivoPerspectivas().remove(procesoObjetivoPerspectiva);
		procesoObjetivoPerspectiva.setProcesoPerspectiva(null);

		return procesoObjetivoPerspectiva;
	}

	public MandoIntegralPlanEstrategico getMandoIntegralPlanEstrategico() {
		return this.mandoIntegralPlanEstrategico;
	}

	public void setMandoIntegralPlanEstrategico(MandoIntegralPlanEstrategico mandoIntegralPlanEstrategico) {
		this.mandoIntegralPlanEstrategico = mandoIntegralPlanEstrategico;
	}

}