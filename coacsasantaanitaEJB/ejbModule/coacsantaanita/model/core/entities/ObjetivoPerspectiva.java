package coacsantaanita.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the objetivo_perspectiva database table.
 * 
 */
@Entity
@Table(name="objetivo_perspectiva")
@NamedQuery(name="ObjetivoPerspectiva.findAll", query="SELECT o FROM ObjetivoPerspectiva o")
public class ObjetivoPerspectiva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer secuencial;

	@Column(name="nombre_objetivo")
	private String nombreObjetivo;

	//bi-directional many-to-one association to Actividade
	@OneToMany(mappedBy="objetivoPerspectiva")
	private List<Actividade> actividades;

	//bi-directional many-to-one association to Indicadore
	@OneToMany(mappedBy="objetivoPerspectiva")
	private List<Indicadore> indicadores;

	//bi-directional many-to-one association to Perspectiva
	@ManyToOne
	@JoinColumn(name="secuencial_perspectiva")
	private Perspectiva perspectiva;

	public ObjetivoPerspectiva() {
	}

	public Integer getSecuencial() {
		return this.secuencial;
	}

	public void setSecuencial(Integer secuencial) {
		this.secuencial = secuencial;
	}

	public String getNombreObjetivo() {
		return this.nombreObjetivo;
	}

	public void setNombreObjetivo(String nombreObjetivo) {
		this.nombreObjetivo = nombreObjetivo;
	}

	public List<Actividade> getActividades() {
		return this.actividades;
	}

	public void setActividades(List<Actividade> actividades) {
		this.actividades = actividades;
	}

	public Actividade addActividade(Actividade actividade) {
		getActividades().add(actividade);
		actividade.setObjetivoPerspectiva(this);

		return actividade;
	}

	public Actividade removeActividade(Actividade actividade) {
		getActividades().remove(actividade);
		actividade.setObjetivoPerspectiva(null);

		return actividade;
	}

	public List<Indicadore> getIndicadores() {
		return this.indicadores;
	}

	public void setIndicadores(List<Indicadore> indicadores) {
		this.indicadores = indicadores;
	}

	public Indicadore addIndicadore(Indicadore indicadore) {
		getIndicadores().add(indicadore);
		indicadore.setObjetivoPerspectiva(this);

		return indicadore;
	}

	public Indicadore removeIndicadore(Indicadore indicadore) {
		getIndicadores().remove(indicadore);
		indicadore.setObjetivoPerspectiva(null);

		return indicadore;
	}

	public Perspectiva getPerspectiva() {
		return this.perspectiva;
	}

	public void setPerspectiva(Perspectiva perspectiva) {
		this.perspectiva = perspectiva;
	}

}