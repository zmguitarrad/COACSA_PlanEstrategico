package coacsantaanita.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the perspectiva database table.
 * 
 */
@Entity
@NamedQuery(name="Perspectiva.findAll", query="SELECT p FROM Perspectiva p")
public class Perspectiva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer secuencial;

	@Column(name="nombre_perspectiva")
	private String nombrePerspectiva;

	//bi-directional many-to-one association to ObjetivoPerspectiva
	@OneToMany(mappedBy="perspectiva")
	private List<ObjetivoPerspectiva> objetivoPerspectivas;

	//bi-directional many-to-one association to PlanEstrategico
	@ManyToOne
	@JoinColumn(name="secuencial_plan_estrategico")
	private PlanEstrategico planEstrategico;

	public Perspectiva() {
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

	public List<ObjetivoPerspectiva> getObjetivoPerspectivas() {
		return this.objetivoPerspectivas;
	}

	public void setObjetivoPerspectivas(List<ObjetivoPerspectiva> objetivoPerspectivas) {
		this.objetivoPerspectivas = objetivoPerspectivas;
	}

	public ObjetivoPerspectiva addObjetivoPerspectiva(ObjetivoPerspectiva objetivoPerspectiva) {
		getObjetivoPerspectivas().add(objetivoPerspectiva);
		objetivoPerspectiva.setPerspectiva(this);

		return objetivoPerspectiva;
	}

	public ObjetivoPerspectiva removeObjetivoPerspectiva(ObjetivoPerspectiva objetivoPerspectiva) {
		getObjetivoPerspectivas().remove(objetivoPerspectiva);
		objetivoPerspectiva.setPerspectiva(null);

		return objetivoPerspectiva;
	}

	public PlanEstrategico getPlanEstrategico() {
		return this.planEstrategico;
	}

	public void setPlanEstrategico(PlanEstrategico planEstrategico) {
		this.planEstrategico = planEstrategico;
	}

}