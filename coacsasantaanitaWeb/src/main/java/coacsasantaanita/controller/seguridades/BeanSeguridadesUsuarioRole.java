package coacsasantaanita.controller.seguridades;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import coacsantaanita.model.core.entities.SeguridadesRole;
import coacsantaanita.model.core.entities.SeguridadesUsuario;
import coacsantaanita.model.core.entities.SeguridadesUsuarioRole;
import coacsantaanita.model.seguridades.manager.ManagerSeguridades;
import coacsasantaanita.controller.JSFUtil;

@Named
@RequestScoped
public class BeanSeguridadesUsuarioRole implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private ManagerSeguridades managerSeguridades;
	
	private List<SeguridadesUsuario> listaUsuarios;
	private List<SeguridadesRole> listaroles;
	private String idSegUsuarioSeleccionado;
	private List<SeguridadesUsuarioRole> listaAsignaciones;
	
	
	public BeanSeguridadesUsuarioRole() {
		// TODO Auto-generated constructor stub
	}
	public String actionMenuAsignaciones() {
		listaUsuarios=managerSeguridades.findAllUsuarios();
		listaroles=managerSeguridades.findAllRoles();
		return "asignaciones";
	}
	
	public void actionListenerSeleccionarUsuario() {
		//listaAsignaciones=managerSeguridades.findAsignacionByUsuario(idSegUsuarioSeleccionado);
	}
	
	public void actionListenerAsignarRoles(int idSegRoles) {
		try {
			managerSeguridades.asignarRoles(idSegUsuarioSeleccionado, idSegRoles);
			//listaAsignaciones=managerSeguridades.findAsignacionByUsuario(idSegUsuarioSeleccionado);
			JSFUtil.crearMensajeINFO("Rol asignado.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void actionListenerEliminarAsignacionRol(int idSeUsuarioRoles) {
		try {
			managerSeguridades.eliminarAsignacion(idSeUsuarioRoles);
			//listaAsignaciones=managerSeguridades.findAsignacionByUsuario(idSegUsuarioSeleccionado);
			JSFUtil.crearMensajeINFO("Asignación eliminada.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
		
	}
	public List<SeguridadesUsuario> getListaUsuarios() {
		return listaUsuarios;
	}
	public void setListaUsuarios(List<SeguridadesUsuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	public List<SeguridadesRole> getListaroles() {
		return listaroles;
	}
	public void setListaroles(List<SeguridadesRole> listaroles) {
		this.listaroles = listaroles;
	}
	public String getIdSegUsuarioSeleccionado() {
		return idSegUsuarioSeleccionado;
	}
	public void setIdSegUsuarioSeleccionado(String idSegUsuarioSeleccionado) {
		this.idSegUsuarioSeleccionado = idSegUsuarioSeleccionado;
	}
	public List<SeguridadesUsuarioRole> getListaAsignaciones() {
		return listaAsignaciones;
	}
	public void setListaAsignaciones(List<SeguridadesUsuarioRole> listaAsignaciones) {
		this.listaAsignaciones = listaAsignaciones;
	}

}

