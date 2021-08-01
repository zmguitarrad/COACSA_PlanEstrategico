package coacsantaanita.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the plan_estrategico database table.
 * 
 */
@Entity
@Table(name="plan_estrategico")
@NamedQuery(name="PlanEstrategico.findAll", query="SELECT p FROM PlanEstrategico p")
public class PlanEstrategico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer secuencial;

	@Column(name="anio_fin")
	private Integer anioFin;

	@Column(name="anio_inicio")
	private Integer anioInicio;

	private String nombre;

	//bi-directional many-to-one association to Perspectiva
	@OneToMany(mappedBy="planEstrategico")
	private List<Perspectiva> perspectivas;

	//bi-directional many-to-one association to PoaMaestro
	@OneToMany(mappedBy="planEstrategico")
	private List<PoaMaestro> poaMaestros;

	public PlanEstrategico() {
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Perspectiva> getPerspectivas() {
		return this.perspectivas;
	}

	public void setPerspectivas(List<Perspectiva> perspectivas) {
		this.perspectivas = perspectivas;
	}

	public Perspectiva addPerspectiva(Perspectiva perspectiva) {
		getPerspectivas().add(perspectiva);
		perspectiva.setPlanEstrategico(this);

		return perspectiva;
	}

	public Perspectiva removePerspectiva(Perspectiva perspectiva) {
		getPerspectivas().remove(perspectiva);
		perspectiva.setPlanEstrategico(null);

		return perspectiva;
	}

	public List<PoaMaestro> getPoaMaestros() {
		return this.poaMaestros;
	}

	public void setPoaMaestros(List<PoaMaestro> poaMaestros) {
		this.poaMaestros = poaMaestros;
	}

	public PoaMaestro addPoaMaestro(PoaMaestro poaMaestro) {
		getPoaMaestros().add(poaMaestro);
		poaMaestro.setPlanEstrategico(this);

		return poaMaestro;
	}

	public PoaMaestro removePoaMaestro(PoaMaestro poaMaestro) {
		getPoaMaestros().remove(poaMaestro);
		poaMaestro.setPlanEstrategico(null);

		return poaMaestro;
	}

}