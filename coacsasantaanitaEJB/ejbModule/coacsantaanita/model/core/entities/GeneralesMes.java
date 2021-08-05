package coacsantaanita.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the generales_meses database table.
 * 
 */
@Entity
@Table(name="generales_meses")
@NamedQuery(name="GeneralesMes.findAll", query="SELECT g FROM GeneralesMes g")
public class GeneralesMes implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer secuencial;

	@Column(name="nombre_mes")
	private String nombreMes;

	//bi-directional many-to-one association to MandoIntegralPoaMaestro
	@OneToMany(mappedBy="generalesMes")
	private List<MandoIntegralPoaMaestro> mandoIntegralPoaMaestros;

	public GeneralesMes() {
	}

	public Integer getSecuencial() {
		return this.secuencial;
	}

	public void setSecuencial(Integer secuencial) {
		this.secuencial = secuencial;
	}

	public String getNombreMes() {
		return this.nombreMes;
	}

	public void setNombreMes(String nombreMes) {
		this.nombreMes = nombreMes;
	}

	public List<MandoIntegralPoaMaestro> getMandoIntegralPoaMaestros() {
		return this.mandoIntegralPoaMaestros;
	}

	public void setMandoIntegralPoaMaestros(List<MandoIntegralPoaMaestro> mandoIntegralPoaMaestros) {
		this.mandoIntegralPoaMaestros = mandoIntegralPoaMaestros;
	}

	public MandoIntegralPoaMaestro addMandoIntegralPoaMaestro(MandoIntegralPoaMaestro mandoIntegralPoaMaestro) {
		getMandoIntegralPoaMaestros().add(mandoIntegralPoaMaestro);
		mandoIntegralPoaMaestro.setGeneralesMes(this);

		return mandoIntegralPoaMaestro;
	}

	public MandoIntegralPoaMaestro removeMandoIntegralPoaMaestro(MandoIntegralPoaMaestro mandoIntegralPoaMaestro) {
		getMandoIntegralPoaMaestros().remove(mandoIntegralPoaMaestro);
		mandoIntegralPoaMaestro.setGeneralesMes(null);

		return mandoIntegralPoaMaestro;
	}

}