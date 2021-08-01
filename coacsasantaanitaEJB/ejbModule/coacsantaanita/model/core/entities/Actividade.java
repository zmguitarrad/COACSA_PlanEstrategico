package coacsantaanita.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the actividades database table.
 * 
 */
@Entity
@Table(name="actividades")
@NamedQuery(name="Actividade.findAll", query="SELECT a FROM Actividade a")
public class Actividade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer secuencial;

	@Column(name="nombre_actividad")
	private String nombreActividad;

	@Column(name="personal_apoyo")
	private String personalApoyo;

	//bi-directional many-to-one association to Indicadore
	@ManyToOne
	@JoinColumn(name="secuencial_indicadores")
	private Indicadore indicadore;

	//bi-directional many-to-one association to ObjetivoPerspectiva
	@ManyToOne
	@JoinColumn(name="secuencial_objetivo")
	private ObjetivoPerspectiva objetivoPerspectiva;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario_usuario")
	private Usuario usuario;

	//bi-directional many-to-one association to PoaMaestro
	@OneToMany(mappedBy="actividade")
	private List<PoaMaestro> poaMaestros;

	public Actividade() {
	}

	public Integer getSecuencial() {
		return this.secuencial;
	}

	public void setSecuencial(Integer secuencial) {
		this.secuencial = secuencial;
	}

	public String getNombreActividad() {
		return this.nombreActividad;
	}

	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}

	public String getPersonalApoyo() {
		return this.personalApoyo;
	}

	public void setPersonalApoyo(String personalApoyo) {
		this.personalApoyo = personalApoyo;
	}

	public Indicadore getIndicadore() {
		return this.indicadore;
	}

	public void setIndicadore(Indicadore indicadore) {
		this.indicadore = indicadore;
	}

	public ObjetivoPerspectiva getObjetivoPerspectiva() {
		return this.objetivoPerspectiva;
	}

	public void setObjetivoPerspectiva(ObjetivoPerspectiva objetivoPerspectiva) {
		this.objetivoPerspectiva = objetivoPerspectiva;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<PoaMaestro> getPoaMaestros() {
		return this.poaMaestros;
	}

	public void setPoaMaestros(List<PoaMaestro> poaMaestros) {
		this.poaMaestros = poaMaestros;
	}

	public PoaMaestro addPoaMaestro(PoaMaestro poaMaestro) {
		getPoaMaestros().add(poaMaestro);
		poaMaestro.setActividade(this);

		return poaMaestro;
	}

	public PoaMaestro removePoaMaestro(PoaMaestro poaMaestro) {
		getPoaMaestros().remove(poaMaestro);
		poaMaestro.setActividade(null);

		return poaMaestro;
	}

}