package coacasantaanita.model.seguridades.dtos;

import java.util.ArrayList;
import java.util.List;

import coacsantaanita.model.core.entities.SeguridadesRole;

public class LoginDTO {
	private String idUsuario;
	private String correo;
	private String direccionIP;
	private List<SeguridadesRole> listaroles;

	
	public LoginDTO() {
		listaroles=new ArrayList<SeguridadesRole>();
		
	}


	public String getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getDireccionIP() {
		return direccionIP;
	}


	public void setDireccionIP(String direccionIP) {
		this.direccionIP = direccionIP;
	}


	public List<SeguridadesRole> getListaroles() {
		return listaroles;
	}


	public void setListaroles(List<SeguridadesRole> listaroles) {
		this.listaroles = listaroles;
	}
	
	
	
}

