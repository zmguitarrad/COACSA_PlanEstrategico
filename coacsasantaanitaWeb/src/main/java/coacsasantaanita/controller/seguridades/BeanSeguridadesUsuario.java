package coacsasantaanita.controller.seguridades;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import coacsantaanita.model.core.entities.SeguridadesRole;
import coacsantaanita.model.core.entities.SeguridadesUsuario;
import coacsantaanita.model.core.entities.SeguridadesUsuarioRole;
import coacsantaanita.model.seguridades.manager.ManagerSeguridades;
import coacsasantaanita.controller.JSFUtil;

@Named
@SessionScoped
public class BeanSeguridadesUsuario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EJB
	private ManagerSeguridades managerSeguridades;
	
	private List<SeguridadesUsuario> listaUsuarios;
	private SeguridadesUsuario nuevoUsuario;
	private SeguridadesUsuario edicionUsuario;
	
	@Inject
	private BeanSeguridadesLogin beanSegLogin;

	

	public BeanSeguridadesUsuario() {
		// TODO Auto-generated constructor stub
	}
	public String actionMenuUsuarios() {
		listaUsuarios=managerSeguridades.findAllUsuarios();
		return "usuarios";
	}
	
	public void actionListenerActivarDesactivarUsuario(String idSegUsuario) {
		try {
			managerSeguridades.activarDesactivarUsuario(idSegUsuario);
			listaUsuarios=managerSeguridades.findAllUsuarios();
			JSFUtil.crearMensajeINFO("Usuario activado/desactivado");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public String actionMenuNuevoUsuario() {
		nuevoUsuario=new SeguridadesUsuario();
		nuevoUsuario.setActivo(true);
		return "usuarios_nuevo";
	}
	
	public void actionListenerInsertarNuevoUsuario() {
		try {
			managerSeguridades.insertarUsuario(nuevoUsuario);
			listaUsuarios=managerSeguridades.findAllUsuarios();
			nuevoUsuario=new SeguridadesUsuario();
			nuevoUsuario.setActivo(true);
			JSFUtil.crearMensajeINFO("Usuario insertado.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public String actionSeleccionarEdicionUsuario(SeguridadesUsuario usuario) {
		edicionUsuario=usuario;
		return "usuarios_edicion";
	}
	
	public void actionListenerActualizarEdicionUsuario() {
		try {
			managerSeguridades.actualizarUsuario(beanSegLogin.getLoginDTO(),edicionUsuario);
			listaUsuarios=managerSeguridades.findAllUsuarios();
			JSFUtil.crearMensajeINFO("Usuario actualizado.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void actionListenerEliminarUsuario(String idSegUsuario) {
		try {
			managerSeguridades.eliminarUsuario(idSegUsuario);
			listaUsuarios=managerSeguridades.findAllUsuarios();
			JSFUtil.crearMensajeINFO("Usuario eliminado.");
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
	public SeguridadesUsuario getNuevoUsuario() {
		return nuevoUsuario;
	}
	public void setNuevoUsuario(SeguridadesUsuario nuevoUsuario) {
		this.nuevoUsuario = nuevoUsuario;
	}
	public SeguridadesUsuario getEdicionUsuario() {
		return edicionUsuario;
	}
	public void setEdicionUsuario(SeguridadesUsuario edicionUsuario) {
		this.edicionUsuario = edicionUsuario;
	}
	public BeanSeguridadesLogin getBeanSegLogin() {
		return beanSegLogin;
	}
	public void setBeanSegLogin(BeanSeguridadesLogin beanSegLogin) {
		this.beanSegLogin = beanSegLogin;
	}
	
	

	
	
}