package coacsantaanita.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the indicadores database table.
 * 
 */
@Entity
@Table(name="indicadores")
@NamedQuery(name="Indicadore.findAll", query="SELECT i FROM Indicadore i")
public class Indicadore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer secuencial;

	@Column(name="nombre_indicador")
	private String nombreIndicador;

	//bi-directional many-to-one association to Actividade
	@OneToMany(mappedBy="indicadore")
	private List<Actividade> actividades;

	//bi-directional many-to-one association to ObjetivoPerspectiva
	@ManyToOne
	@JoinColumn(name="secuencial_objetivo")
	private ObjetivoPerspectiva objetivoPerspectiva;

	public Indicadore() {
	}

	public Integer getSecuencial() {
		return this.secuencial;
	}

	public void setSecuencial(Integer secuencial) {
		this.secuencial = secuencial;
	}

	public String getNombreIndicador() {
		return this.nombreIndicador;
	}

	public void setNombreIndicador(String nombreIndicador) {
		this.nombreIndicador = nombreIndicador;
	}

	public List<Actividade> getActividades() {
		return this.actividades;
	}

	public void setActividades(List<Actividade> actividades) {
		this.actividades = actividades;
	}

	public Actividade addActividade(Actividade actividade) {
		getActividades().add(actividade);
		actividade.setIndicadore(this);

		return actividade;
	}

	public Actividade removeActividade(Actividade actividade) {
		getActividades().remove(actividade);
		actividade.setIndicadore(null);

		return actividade;
	}

	public ObjetivoPerspectiva getObjetivoPerspectiva() {
		return this.objetivoPerspectiva;
	}

	public void setObjetivoPerspectiva(ObjetivoPerspectiva objetivoPerspectiva) {
		this.objetivoPerspectiva = objetivoPerspectiva;
	}

}