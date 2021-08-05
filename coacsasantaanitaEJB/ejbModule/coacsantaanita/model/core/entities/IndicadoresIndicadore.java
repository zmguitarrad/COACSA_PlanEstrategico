package coacsantaanita.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the indicadores_indicadores database table.
 * 
 */
@Entity
@Table(name="indicadores_indicadores")
@NamedQuery(name="IndicadoresIndicadore.findAll", query="SELECT i FROM IndicadoresIndicadore i")
public class IndicadoresIndicadore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer secuencial;

	@Column(name="nombre_indicador")
	private String nombreIndicador;

	//bi-directional many-to-one association to ProcesoObjetivoPerspectiva
	@ManyToOne
	@JoinColumn(name="secuencial_objetivo_perspectiva")
	private ProcesoObjetivoPerspectiva procesoObjetivoPerspectiva;

	public IndicadoresIndicadore() {
	}

	public Integer getSecuencial() {
		return this.secuencial;
	}

	public void setSecuencial(Integer secuencial) {
		this.secuencial = secuencial;
	}

	public String getNombreIndicador() {
		return this.nombreIndicador;
	}

	public void setNombreIndicador(String nombreIndicador) {
		this.nombreIndicador = nombreIndicador;
	}

	public ProcesoObjetivoPerspectiva getProcesoObjetivoPerspectiva() {
		return this.procesoObjetivoPerspectiva;
	}

	public void setProcesoObjetivoPerspectiva(ProcesoObjetivoPerspectiva procesoObjetivoPerspectiva) {
		this.procesoObjetivoPerspectiva = procesoObjetivoPerspectiva;
	}

}