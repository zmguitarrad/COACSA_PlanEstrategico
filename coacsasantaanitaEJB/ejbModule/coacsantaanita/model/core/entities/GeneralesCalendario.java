package coacsantaanita.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the generales_calendario database table.
 * 
 */
@Entity
@Table(name="generales_calendario")
@NamedQuery(name="GeneralesCalendario.findAll", query="SELECT g FROM GeneralesCalendario g")
public class GeneralesCalendario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer secuencial;

	private String mes;

	//bi-directional many-to-one association to GeneralesAnio
	@ManyToOne
	@JoinColumn(name="secuencial_anio")
	private GeneralesAnio generalesAnio;

	//bi-directional many-to-one association to MandoIntegralPoaActividade
	@OneToMany(mappedBy="generalesCalendario")
	private List<MandoIntegralPoaActividade> mandoIntegralPoaActividades;

	public GeneralesCalendario() {
	}

	public Integer getSecuencial() {
		return this.secuencial;
	}

	public void setSecuencial(Integer secuencial) {
		this.secuencial = secuencial;
	}

	public String getMes() {
		return this.mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public GeneralesAnio getGeneralesAnio() {
		return this.generalesAnio;
	}

	public void setGeneralesAnio(GeneralesAnio generalesAnio) {
		this.generalesAnio = generalesAnio;
	}

	public List<MandoIntegralPoaActividade> getMandoIntegralPoaActividades() {
		return this.mandoIntegralPoaActividades;
	}

	public void setMandoIntegralPoaActividades(List<MandoIntegralPoaActividade> mandoIntegralPoaActividades) {
		this.mandoIntegralPoaActividades = mandoIntegralPoaActividades;
	}

	public MandoIntegralPoaActividade addMandoIntegralPoaActividade(MandoIntegralPoaActividade mandoIntegralPoaActividade) {
		getMandoIntegralPoaActividades().add(mandoIntegralPoaActividade);
		mandoIntegralPoaActividade.setGeneralesCalendario(this);

		return mandoIntegralPoaActividade;
	}

	public MandoIntegralPoaActividade removeMandoIntegralPoaActividade(MandoIntegralPoaActividade mandoIntegralPoaActividade) {
		getMandoIntegralPoaActividades().remove(mandoIntegralPoaActividade);
		mandoIntegralPoaActividade.setGeneralesCalendario(null);

		return mandoIntegralPoaActividade;
	}

}