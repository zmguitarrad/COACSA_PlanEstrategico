package coacsantaanita.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estado database table.
 * 
 */
@Entity
@NamedQuery(name="Estado.findAll", query="SELECT e FROM Estado e")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer secuencial;

	@Column(name="nombre_estado")
	private String nombreEstado;

	//bi-directional many-to-one association to PoaMaestro
	@OneToMany(mappedBy="estado")
	private List<PoaMaestro> poaMaestros;

	public Estado() {
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

	public List<PoaMaestro> getPoaMaestros() {
		return this.poaMaestros;
	}

	public void setPoaMaestros(List<PoaMaestro> poaMaestros) {
		this.poaMaestros = poaMaestros;
	}

	public PoaMaestro addPoaMaestro(PoaMaestro poaMaestro) {
		getPoaMaestros().add(poaMaestro);
		poaMaestro.setEstado(this);

		return poaMaestro;
	}

	public PoaMaestro removePoaMaestro(PoaMaestro poaMaestro) {
		getPoaMaestros().remove(poaMaestro);
		poaMaestro.setEstado(null);

		return poaMaestro;
	}

}