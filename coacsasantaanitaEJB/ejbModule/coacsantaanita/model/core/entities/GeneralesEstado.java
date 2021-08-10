package coacsantaanita.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the generales_estado database table.
 * 
 */
@Entity
@Table(name="generales_estado")
@NamedQuery(name="GeneralesEstado.findAll", query="SELECT g FROM GeneralesEstado g")
public class GeneralesEstado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer secuencial;

	@Column(name="nombre_estado")
	private String nombreEstado;

	//bi-directional many-to-one association to MandoIntegralPoaActividade
	@OneToMany(mappedBy="generalesEstado")
	private List<MandoIntegralPoaActividade> mandoIntegralPoaActividades;

	public GeneralesEstado() {
	}

	public Integer getSecuencial() {
		return this.secuencial;
	}

	public void setSecuencial(Integer secuencial) {
		this.secuencial = secuencial;
	}

	public String getNombreEstado() {
		return this.nombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}

	public List<MandoIntegralPoaActividade> getMandoIntegralPoaActividades() {
		return this.mandoIntegralPoaActividades;
	}

	public void setMandoIntegralPoaActividades(List<MandoIntegralPoaActividade> mandoIntegralPoaActividades) {
		this.mandoIntegralPoaActividades = mandoIntegralPoaActividades;
	}

	public MandoIntegralPoaActividade addMandoIntegralPoaActividade(MandoIntegralPoaActividade mandoIntegralPoaActividade) {
		getMandoIntegralPoaActividades().add(mandoIntegralPoaActividade);
		mandoIntegralPoaActividade.setGeneralesEstado(this);

		return mandoIntegralPoaActividade;
	}

	public MandoIntegralPoaActividade removeMandoIntegralPoaActividade(MandoIntegralPoaActividade mandoIntegralPoaActividade) {
		getMandoIntegralPoaActividades().remove(mandoIntegralPoaActividade);
		mandoIntegralPoaActividade.setGeneralesEstado(null);

		return mandoIntegralPoaActividade;
	}

}