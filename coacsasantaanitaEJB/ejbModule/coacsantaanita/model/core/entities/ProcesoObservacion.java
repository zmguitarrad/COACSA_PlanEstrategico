package coacsantaanita.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the proceso_observacion database table.
 * 
 */
@Entity
@Table(name="proceso_observacion")
@NamedQuery(name="ProcesoObservacion.findAll", query="SELECT p FROM ProcesoObservacion p")
public class ProcesoObservacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer secuencial;

	@Column(name="nombre_observacion")
	private String nombreObservacion;

	//bi-directional many-to-one association to ProcesoActividade
	@OneToMany(mappedBy="procesoObservacion")
	private List<ProcesoActividade> procesoActividades;

	public ProcesoObservacion() {
	}

	public Integer getSecuencial() {
		return this.secuencial;
	}

	public void setSecuencial(Integer secuencial) {
		this.secuencial = secuencial;
	}

	public String getNombreObservacion() {
		return this.nombreObservacion;
	}

	public void setNombreObservacion(String nombreObservacion) {
		this.nombreObservacion = nombreObservacion;
	}

	public List<ProcesoActividade> getProcesoActividades() {
		return this.procesoActividades;
	}

	public void setProcesoActividades(List<ProcesoActividade> procesoActividades) {
		this.procesoActividades = procesoActividades;
	}

	public ProcesoActividade addProcesoActividade(ProcesoActividade procesoActividade) {
		getProcesoActividades().add(procesoActividade);
		procesoActividade.setProcesoObservacion(this);

		return procesoActividade;
	}

	public ProcesoActividade removeProcesoActividade(ProcesoActividade procesoActividade) {
		getProcesoActividades().remove(procesoActividade);
		procesoActividade.setProcesoObservacion(null);

		return procesoActividade;
	}

}