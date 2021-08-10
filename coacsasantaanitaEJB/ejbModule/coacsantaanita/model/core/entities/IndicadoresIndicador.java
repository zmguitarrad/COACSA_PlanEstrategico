package coacsantaanita.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the indicadores_indicador database table.
 * 
 */
@Entity
@Table(name="indicadores_indicador")
@NamedQuery(name="IndicadoresIndicador.findAll", query="SELECT i FROM IndicadoresIndicador i")
public class IndicadoresIndicador implements Serializable {
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

	//bi-directional many-to-one association to ProcesoActividade
	@OneToMany(mappedBy="indicadoresIndicador")
	private List<ProcesoActividade> procesoActividades;

	public IndicadoresIndicador() {
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

	public List<ProcesoActividade> getProcesoActividades() {
		return this.procesoActividades;
	}

	public void setProcesoActividades(List<ProcesoActividade> procesoActividades) {
		this.procesoActividades = procesoActividades;
	}

	public ProcesoActividade addProcesoActividade(ProcesoActividade procesoActividade) {
		getProcesoActividades().add(procesoActividade);
		procesoActividade.setIndicadoresIndicador(this);

		return procesoActividade;
	}

	public ProcesoActividade removeProcesoActividade(ProcesoActividade procesoActividade) {
		getProcesoActividades().remove(procesoActividade);
		procesoActividade.setIndicadoresIndicador(null);

		return procesoActividade;
	}

}