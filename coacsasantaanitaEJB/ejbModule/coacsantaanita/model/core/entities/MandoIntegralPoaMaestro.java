package coacsantaanita.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mando_integral_poa_maestro database table.
 * 
 */
@Entity
@Table(name="mando_integral_poa_maestro")
@NamedQuery(name="MandoIntegralPoaMaestro.findAll", query="SELECT m FROM MandoIntegralPoaMaestro m")
public class MandoIntegralPoaMaestro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer secuencial;

	private Boolean activo;

	@Column(name="nombre_poa_maestro")
	private String nombrePoaMaestro;

	//bi-directional many-to-one association to MandoIntegralPoaActividade
	@OneToMany(mappedBy="mandoIntegralPoaMaestro")
	private List<MandoIntegralPoaActividade> mandoIntegralPoaActividades;

	//bi-directional many-to-one association to GeneralesAnio
	@ManyToOne
	@JoinColumn(name="secuencial_anio")
	private GeneralesAnio generalesAnio;

	//bi-directional many-to-one association to MandoIntegralPlanEstrategico
	@ManyToOne
	@JoinColumn(name="secuencial_plan_estrategico")
	private MandoIntegralPlanEstrategico mandoIntegralPlanEstrategico;

	public MandoIntegralPoaMaestro() {
	}

	public Integer getSecuencial() {
		return this.secuencial;
	}

	public void setSecuencial(Integer secuencial) {
		this.secuencial = secuencial;
	}

	public Boolean getActivo() {
		return this.activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getNombrePoaMaestro() {
		return this.nombrePoaMaestro;
	}

	public void setNombrePoaMaestro(String nombrePoaMaestro) {
		this.nombrePoaMaestro = nombrePoaMaestro;
	}

	public List<MandoIntegralPoaActividade> getMandoIntegralPoaActividades() {
		return this.mandoIntegralPoaActividades;
	}

	public void setMandoIntegralPoaActividades(List<MandoIntegralPoaActividade> mandoIntegralPoaActividades) {
		this.mandoIntegralPoaActividades = mandoIntegralPoaActividades;
	}

	public MandoIntegralPoaActividade addMandoIntegralPoaActividade(MandoIntegralPoaActividade mandoIntegralPoaActividade) {
		getMandoIntegralPoaActividades().add(mandoIntegralPoaActividade);
		mandoIntegralPoaActividade.setMandoIntegralPoaMaestro(this);

		return mandoIntegralPoaActividade;
	}

	public MandoIntegralPoaActividade removeMandoIntegralPoaActividade(MandoIntegralPoaActividade mandoIntegralPoaActividade) {
		getMandoIntegralPoaActividades().remove(mandoIntegralPoaActividade);
		mandoIntegralPoaActividade.setMandoIntegralPoaMaestro(null);

		return mandoIntegralPoaActividade;
	}

	public GeneralesAnio getGeneralesAnio() {
		return this.generalesAnio;
	}

	public void setGeneralesAnio(GeneralesAnio generalesAnio) {
		this.generalesAnio = generalesAnio;
	}

	public MandoIntegralPlanEstrategico getMandoIntegralPlanEstrategico() {
		return this.mandoIntegralPlanEstrategico;
	}

	public void setMandoIntegralPlanEstrategico(MandoIntegralPlanEstrategico mandoIntegralPlanEstrategico) {
		this.mandoIntegralPlanEstrategico = mandoIntegralPlanEstrategico;
	}

}