package coacsantaanita.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mando_integral_poa_actividades database table.
 * 
 */
@Entity
@Table(name="mando_integral_poa_actividades")
@NamedQuery(name="MandoIntegralPoaActividade.findAll", query="SELECT m FROM MandoIntegralPoaActividade m")
public class MandoIntegralPoaActividade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer secuencial;

	//bi-directional many-to-one association to GeneralesCalendario
	@ManyToOne
	@JoinColumn(name="secuencial_calendario")
	private GeneralesCalendario generalesCalendario;

	//bi-directional many-to-one association to GeneralesEstado
	@ManyToOne
	@JoinColumn(name="secuencial_estado")
	private GeneralesEstado generalesEstado;

	//bi-directional many-to-one association to MandoIntegralPoaMaestro
	@ManyToOne
	@JoinColumn(name="secuencial_poa_maestro")
	private MandoIntegralPoaMaestro mandoIntegralPoaMaestro;

	//bi-directional many-to-one association to ProcesoActividade
	@ManyToOne
	@JoinColumn(name="secuencial_actividades")
	private ProcesoActividade procesoActividade;

	public MandoIntegralPoaActividade() {
	}

	public Integer getSecuencial() {
		return this.secuencial;
	}

	public void setSecuencial(Integer secuencial) {
		this.secuencial = secuencial;
	}

	public GeneralesCalendario getGeneralesCalendario() {
		return this.generalesCalendario;
	}

	public void setGeneralesCalendario(GeneralesCalendario generalesCalendario) {
		this.generalesCalendario = generalesCalendario;
	}

	public GeneralesEstado getGeneralesEstado() {
		return this.generalesEstado;
	}

	public void setGeneralesEstado(GeneralesEstado generalesEstado) {
		this.generalesEstado = generalesEstado;
	}

	public MandoIntegralPoaMaestro getMandoIntegralPoaMaestro() {
		return this.mandoIntegralPoaMaestro;
	}

	public void setMandoIntegralPoaMaestro(MandoIntegralPoaMaestro mandoIntegralPoaMaestro) {
		this.mandoIntegralPoaMaestro = mandoIntegralPoaMaestro;
	}

	public ProcesoActividade getProcesoActividade() {
		return this.procesoActividade;
	}

	public void setProcesoActividade(ProcesoActividade procesoActividade) {
		this.procesoActividade = procesoActividade;
	}

}