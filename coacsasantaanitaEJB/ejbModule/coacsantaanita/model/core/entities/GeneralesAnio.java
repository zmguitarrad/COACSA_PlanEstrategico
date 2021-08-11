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

	//bi-directional many-to-one association to GeneralesCalendario
	@OneToMany(mappedBy="generalesAnio")
	private List<GeneralesCalendario> generalesCalendarios;

	//bi-directional many-to-one association to MandoIntegralPoaMaestro
	@OneToMany(mappedBy="generalesAnio")
	private List<MandoIntegralPoaMaestro> mandoIntegralPoaMaestros;

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

	public List<GeneralesCalendario> getGeneralesCalendarios() {
		return this.generalesCalendarios;
	}

	public void setGeneralesCalendarios(List<GeneralesCalendario> generalesCalendarios) {
		this.generalesCalendarios = generalesCalendarios;
	}

	public GeneralesCalendario addGeneralesCalendario(GeneralesCalendario generalesCalendario) {
		getGeneralesCalendarios().add(generalesCalendario);
		generalesCalendario.setGeneralesAnio(this);

		return generalesCalendario;
	}

	public GeneralesCalendario removeGeneralesCalendario(GeneralesCalendario generalesCalendario) {
		getGeneralesCalendarios().remove(generalesCalendario);
		generalesCalendario.setGeneralesAnio(null);

		return generalesCalendario;
	}

	public List<MandoIntegralPoaMaestro> getMandoIntegralPoaMaestros() {
		return this.mandoIntegralPoaMaestros;
	}

	public void setMandoIntegralPoaMaestros(List<MandoIntegralPoaMaestro> mandoIntegralPoaMaestros) {
		this.mandoIntegralPoaMaestros = mandoIntegralPoaMaestros;
	}

	public MandoIntegralPoaMaestro addMandoIntegralPoaMaestro(MandoIntegralPoaMaestro mandoIntegralPoaMaestro) {
		getMandoIntegralPoaMaestros().add(mandoIntegralPoaMaestro);
		mandoIntegralPoaMaestro.setGeneralesAnio(this);

		return mandoIntegralPoaMaestro;
	}

	public MandoIntegralPoaMaestro removeMandoIntegralPoaMaestro(MandoIntegralPoaMaestro mandoIntegralPoaMaestro) {
		getMandoIntegralPoaMaestros().remove(mandoIntegralPoaMaestro);
		mandoIntegralPoaMaestro.setGeneralesAnio(null);

		return mandoIntegralPoaMaestro;
	}

}