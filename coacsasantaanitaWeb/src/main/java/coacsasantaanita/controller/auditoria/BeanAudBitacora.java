package coacsasantaanita.controller.auditoria;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import coacsantaanita.model.auditoria.managers.ManagerAuditoria;
import coacsantaanita.model.core.entities.AuditoriaBitacora;
import coacsasantaanita.controller.JSFUtil;
import coacsasantaanita.model.core.utils.ModelUtil;

@Named
@SessionScoped
public class BeanAudBitacora implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerAuditoria managerAuditoria;
	private List<AuditoriaBitacora> listaBitacora;
	private Date fechaInicio;
	private Date fechaFin;

	public BeanAudBitacora() {
		// TODO Auto-generated constructor stub
	}
	@PostConstruct
	public void inicializacion() {

	}

	public String actionCargarMenuBitacora() {
		// obtener la fecha de ayer:
		fechaInicio = ModelUtil.addDays(new Date(), -1);
		// obtener la fecha de hoy:
		fechaFin = new Date();
		listaBitacora = managerAuditoria.findBitacoraByFecha(fechaInicio, fechaFin);
		JSFUtil.crearMensajeINFO("Registros encontrados: " + listaBitacora.size());
		return "bitacora";
	}

	public void actionListenerConsultarBitacora() {
		listaBitacora = managerAuditoria.findBitacoraByFecha(fechaInicio, fechaFin);
		JSFUtil.crearMensajeINFO("Registros encontrados: " + listaBitacora.size());
	}

	public List<AuditoriaBitacora> getListaBitacora() {
		return listaBitacora;
	}

	public void setListaBitacora(List<AuditoriaBitacora> listaBitacora) {
		this.listaBitacora = listaBitacora;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

}

