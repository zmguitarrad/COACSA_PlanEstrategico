package coacsantaanita.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;


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

	@Column(name="secuencial_plan_estrategico")
	private Integer secuencialPlanEstrategico;

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

	public Integer getSecuencialPlanEstrategico() {
		return this.secuencialPlanEstrategico;
	}

	public void setSecuencialPlanEstrategico(Integer secuencialPlanEstrategico) {
		this.secuencialPlanEstrategico = secuencialPlanEstrategico;
	}

}