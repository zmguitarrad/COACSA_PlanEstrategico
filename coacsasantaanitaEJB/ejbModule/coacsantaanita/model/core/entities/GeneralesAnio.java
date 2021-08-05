package coacsantaanita.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the generales_anio database table.
 * 
 */
@Entity
@Table(name="generales_anio")
@NamedQuery(name="GeneralesAnio.findAll", query="SELECT g FROM GeneralesAnio g")
public class GeneralesAnio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer secuencial;

	private Integer anio;

	//bi-directional many-to-one association to MandoIntegralPlanEstrategico
	@OneToMany(mappedBy="generalesAnio")
	private List<MandoIntegralPlanEstrategico> mandoIntegralPlanEstrategicos;

	public GeneralesAnio() {
	}

	public Integer getSecuencial() {
		return this.secuencial;
	}

	public void setSecuencial(Integer secuencial) {
		this.secuencial = secuencial;
	}

	public Integer getAnio() {
		return this.anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public List<MandoIntegralPlanEstrategico> getMandoIntegralPlanEstrategicos() {
		return this.mandoIntegralPlanEstrategicos;
	}

	public void setMandoIntegralPlanEstrategicos(List<MandoIntegralPlanEstrategico> mandoIntegralPlanEstrategicos) {
		this.mandoIntegralPlanEstrategicos = mandoIntegralPlanEstrategicos;
	}

	public MandoIntegralPlanEstrategico addMandoIntegralPlanEstrategico(MandoIntegralPlanEstrategico mandoIntegralPlanEstrategico) {
		getMandoIntegralPlanEstrategicos().add(mandoIntegralPlanEstrategico);
		mandoIntegralPlanEstrategico.setGeneralesAnio(this);

		return mandoIntegralPlanEstrategico;
	}

	public MandoIntegralPlanEstrategico removeMandoIntegralPlanEstrategico(MandoIntegralPlanEstrategico mandoIntegralPlanEstrategico) {
		getMandoIntegralPlanEstrategicos().remove(mandoIntegralPlanEstrategico);
		mandoIntegralPlanEstrategico.setGeneralesAnio(null);

		return mandoIntegralPlanEstrategico;
	}

}