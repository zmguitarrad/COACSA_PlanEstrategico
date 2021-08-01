package coacasantaanita.model.seguridades.dtos;


public class LoginDTO {
	private String idUsuario;
	private String correo;
	private String direccionIP;

	
	public LoginDTO() {
		
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
	
	
	
}

