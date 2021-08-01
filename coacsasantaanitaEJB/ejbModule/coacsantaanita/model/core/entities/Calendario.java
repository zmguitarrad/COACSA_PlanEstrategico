package coacsantaanita.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the calendario database table.
 * 
 */
@Entity
@NamedQuery(name="Calendario.findAll", query="SELECT c FROM Calendario c")
public class Calendario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer secuencial;

	private Integer anio;

	private Integer mes;

	//bi-directional many-to-one association to PoaMaestro
	@OneToMany(mappedBy="calendario")
	private List<PoaMaestro> poaMaestros;

	public Calendario() {
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

	public Integer getMes() {
		return this.mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public List<PoaMaestro> getPoaMaestros() {
		return this.poaMaestros;
	}

	public void setPoaMaestros(List<PoaMaestro> poaMaestros) {
		this.poaMaestros = poaMaestros;
	}

	public PoaMaestro addPoaMaestro(PoaMaestro poaMaestro) {
		getPoaMaestros().add(poaMaestro);
		poaMaestro.setCalendario(this);

		return poaMaestro;
	}

	public PoaMaestro removePoaMaestro(PoaMaestro poaMaestro) {
		getPoaMaestros().remove(poaMaestro);
		poaMaestro.setCalendario(null);

		return poaMaestro;
	}

}