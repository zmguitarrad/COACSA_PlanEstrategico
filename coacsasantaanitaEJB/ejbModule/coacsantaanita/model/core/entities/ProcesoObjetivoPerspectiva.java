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

	//bi-directional many-to-one association to ProcesoPerspectiva
	@ManyToOne
	@JoinColumn(name="secuencial_perspectiva")
	private ProcesoPerspectiva procesoPerspectiva;

	//bi-directional many-to-one association to IndicadoresIndicador
	@OneToMany(mappedBy="procesoObjetivoPerspectiva")
	private List<IndicadoresIndicador> indicadoresIndicadors;

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

	public ProcesoPerspectiva getProcesoPerspectiva() {
		return this.procesoPerspectiva;
	}

	public void setProcesoPerspectiva(ProcesoPerspectiva procesoPerspectiva) {
		this.procesoPerspectiva = procesoPerspectiva;
	}

	public List<IndicadoresIndicador> getIndicadoresIndicadors() {
		return this.indicadoresIndicadors;
	}

	public void setIndicadoresIndicadors(List<IndicadoresIndicador> indicadoresIndicadors) {
		this.indicadoresIndicadors = indicadoresIndicadors;
	}

	public IndicadoresIndicador addIndicadoresIndicador(IndicadoresIndicador indicadoresIndicador) {
		getIndicadoresIndicadors().add(indicadoresIndicador);
		indicadoresIndicador.setProcesoObjetivoPerspectiva(this);

		return indicadoresIndicador;
	}

	public IndicadoresIndicador removeIndicadoresIndicador(IndicadoresIndicador indicadoresIndicador) {
		getIndicadoresIndicadors().remove(indicadoresIndicador);
		indicadoresIndicador.setProcesoObjetivoPerspectiva(null);

		return indicadoresIndicador;
	}

}