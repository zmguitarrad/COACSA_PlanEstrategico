package coacsantaanita.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the auditoria_bitacora database table.
 * 
 */
@Entity
@Table(name="auditoria_bitacora")
@NamedQuery(name="AuditoriaBitacora.findAll", query="SELECT a FROM AuditoriaBitacora a")
public class AuditoriaBitacora implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer secuencial;

	@Column(name="descripcion_evento")
	private String descripcionEvento;

	@Column(name="direccion_ip")
	private String direccionIp;

	@Column(name="fecha_evento")
	private Timestamp fechaEvento;

	@Column(name="id_usuario")
	private String idUsuario;

	@Column(name="nombre_clase")
	private String nombreClase;

	@Column(name="nombre_metodo")
	private String nombreMetodo;

	public AuditoriaBitacora() {
	}

	public Integer getSecuencial() {
		return this.secuencial;
	}

	public void setSecuencial(Integer secuencial) {
		this.secuencial = secuencial;
	}

	public String getDescripcionEvento() {
		return this.descripcionEvento;
	}

	public void setDescripcionEvento(String descripcionEvento) {
		this.descripcionEvento = descripcionEvento;
	}

	public String getDireccionIp() {
		return this.direccionIp;
	}

	public void setDireccionIp(String direccionIp) {
		this.direccionIp = direccionIp;
	}

	public Timestamp getFechaEvento() {
		return this.fechaEvento;
	}

	public void setFechaEvento(Timestamp fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	public String getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreClase() {
		return this.nombreClase;
	}

	public void setNombreClase(String nombreClase) {
		this.nombreClase = nombreClase;
	}

	public String getNombreMetodo() {
		return this.nombreMetodo;
	}

	public void setNombreMetodo(String nombreMetodo) {
		this.nombreMetodo = nombreMetodo;
	}

}