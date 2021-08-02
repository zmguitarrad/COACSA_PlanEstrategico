package coacsasantaanita.controller.seguridades;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import coacasantaanita.model.seguridades.dtos.LoginDTO;
import coacsantaanita.model.seguridades.manager.ManagerSeguridades;
import coacsasantaanita.controller.JSFUtil;

@Named
@SessionScoped
public class BeanLogin implements Serializable {
	private static final long serialVersionUID = 1L;
	private String idUsuario;
	private String clave;
	private LoginDTO loginDTO;
	private String direccionIP;
	
	@EJB
	private ManagerSeguridades mSeguridades;

	public BeanLogin() {

	}
	@PostConstruct
	public void inicializar() {
		HttpServletRequest req=(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String agente=req.getHeader("user-agent");
		String ipAddress = req.getHeader("X-FORWARDED-FOR");
		if(ipAddress==null) {
			ipAddress=req.getRemoteAddr();
		}
		direccionIP=ipAddress;
	}
	
	public String actionLogin() {
		try {
			loginDTO=mSeguridades.login(idUsuario, clave, direccionIP);
			//loginDTO.setDireccionIP(direccionIP);
			return "menu";
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
		return "";
	}
	
	public String actionMenu(String ruta) {
		return ruta+"?faces-redirect=true";
	}
	
	public String actionCerrarSesion(){
		mSeguridades.cerrarSesion(loginDTO.getIdUsuario());
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}
	
	public void actionVerificarLogin() {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		String requestPath=ec.getRequestPathInfo();
		
		//primero validamos si loginDTO aun no se ha inicializado es porque
		//el usuario aun no ha pasado por la pantalla de login:
		if(loginDTO==null || loginDTO.getIdUsuario()==null)
		{
			try {
				mSeguridades.accesoNoPermitido(null, requestPath);
				ec.redirect(ec.getRequestContextPath()+"/faces/login.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		
	}
	
	

	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public LoginDTO getLoginDTO() {
		return loginDTO;
	}

	public void setLoginDTO(LoginDTO loginDTO) {
		this.loginDTO = loginDTO;
	}

	public String getDireccionIP() {
		return direccionIP;
	}

	public void setDireccionIP(String direccionIP) {
		this.direccionIP = direccionIP;
	}

}

