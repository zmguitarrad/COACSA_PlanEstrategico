package coacsasantaanita.controller.seguridades;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import coacsantaanita.model.core.entities.SeguridadesRole;
import coacsantaanita.model.seguridades.manager.ManagerSeguridades;
import coacsasantaanita.controller.JSFUtil;

@Named
@SessionScoped
public class BeanSeguridadesRoles implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerSeguridades mSeguridades;
	private List<SeguridadesRole> listaRoles;
	private SeguridadesRole nuevoRol;
	private SeguridadesRole edicionRol;

	public BeanSeguridadesRoles() {
		// TODO Auto-generated constructor stub
	}
	@PostConstruct
	public void inicializacion() {
		System.out.println("BeanSegRoles inicializado...");
		nuevoRol=new SeguridadesRole();
	}
	
	public String actionCargarMenuRoles() {
		listaRoles=mSeguridades.findAllRoles();
		return "modulos?faces-redirect=true";
	}
	
	public void actionListenerInsertarModulo() {
		try {
			mSeguridades.insertarRole(nuevoRol);
			listaRoles=mSeguridades.findAllRoles();
			JSFUtil.crearMensajeINFO("Rol creado.");
			nuevoRol=new SeguridadesRole();
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void actionListenerCargarModulo(SeguridadesRole modulo) {
		edicionRol=modulo;
	}
	
	public void actionListenerGuardarEdicionModulo() {
		try {
			mSeguridades.actualizarRol(edicionRol);
			JSFUtil.crearMensajeINFO("Rol editado.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public void actionListenerEliminarRol(int idSegModulo) {
		try {
			mSeguridades.eliminarRol(idSegModulo);
			listaRoles=mSeguridades.findAllRoles();
			JSFUtil.crearMensajeINFO("Rol eliminado");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	public ManagerSeguridades getmSeguridades() {
		return mSeguridades;
	}
	public void setmSeguridades(ManagerSeguridades mSeguridades) {
		this.mSeguridades = mSeguridades;
	}
	public List<SeguridadesRole> getListaRoles() {
		return listaRoles;
	}
	public void setListaRoles(List<SeguridadesRole> listaRoles) {
		this.listaRoles = listaRoles;
	}
	public SeguridadesRole getNuevoRol() {
		return nuevoRol;
	}
	public void setNuevoRol(SeguridadesRole nuevoRol) {
		this.nuevoRol = nuevoRol;
	}
	public SeguridadesRole getEdicionRol() {
		return edicionRol;
	}
	public void setEdicionRol(SeguridadesRole edicionRol) {
		this.edicionRol = edicionRol;
	}
	

}
