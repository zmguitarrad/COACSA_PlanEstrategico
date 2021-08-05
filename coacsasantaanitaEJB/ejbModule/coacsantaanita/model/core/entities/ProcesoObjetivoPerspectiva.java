package coacsantaanita.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the proceso_objetivo_perspectiva database table.
 * 
 */
@Entity
@Table(name="proceso_objetivo_perspectiva")
@NamedQuery(name="ProcesoObjetivoPerspectiva.findAll", query="SELECT p FROM ProcesoObjetivoPerspectiva p")
public class ProcesoObjetivoPerspectiva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer secuencial;

	@Column(name="nombre_objetivo_perspectiva")
	private String nombreObjetivoPerspectiva;

	//bi-directional many-to-one association to IndicadoresIndicadore
	@OneToMany(mappedBy="procesoObjetivoPerspectiva")
	private List<IndicadoresIndicadore> indicadoresIndicadores;

	//bi-directional many-to-one association to ProcesoPerspectiva
	@ManyToOne
	@JoinColumn(name="secuencial_perspectiva")
	private ProcesoPerspectiva procesoPerspectiva;

	public ProcesoObjetivoPerspectiva() {
	}

	public Integer getSecuencial() {
		return this.secuencial;
	}

	public void setSecuencial(Integer secuencial) {
		this.secuencial = secuencial;
	}

	public String getNombreObjetivoPerspectiva() {
		return this.nombreObjetivoPerspectiva;
	}

	public void setNombreObjetivoPerspectiva(String nombreObjetivoPerspectiva) {
		this.nombreObjetivoPerspectiva = nombreObjetivoPerspectiva;
	}

	public List<IndicadoresIndicadore> getIndicadoresIndicadores() {
		return this.indicadoresIndicadores;
	}

	public void setIndicadoresIndicadores(List<IndicadoresIndicadore> indicadoresIndicadores) {
		this.indicadoresIndicadores = indicadoresIndicadores;
	}

	public IndicadoresIndicadore addIndicadoresIndicadore(IndicadoresIndicadore indicadoresIndicadore) {
		getIndicadoresIndicadores().add(indicadoresIndicadore);
		indicadoresIndicadore.setProcesoObjetivoPerspectiva(this);

		return indicadoresIndicadore;
	}

	public IndicadoresIndicadore removeIndicadoresIndicadore(IndicadoresIndicadore indicadoresIndicadore) {
		getIndicadoresIndicadores().remove(indicadoresIndicadore);
		indicadoresIndicadore.setProcesoObjetivoPerspectiva(null);

		return indicadoresIndicadore;
	}

	public ProcesoPerspectiva getProcesoPerspectiva() {
		return this.procesoPerspectiva;
	}

	public void setProcesoPerspectiva(ProcesoPerspectiva procesoPerspectiva) {
		this.procesoPerspectiva = procesoPerspectiva;
	}

}