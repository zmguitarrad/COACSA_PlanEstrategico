package coacsantaanita.model.seguridades.manager;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import coacasantaanita.model.seguridades.dtos.LoginDTO;
import coacsantaanita.model.auditoria.managers.ManagerAuditoria;
import coacsantaanita.model.core.entities.Usuario;
import coacsasantaanita.model.core.managers.ManagerDAO;
import coacsasantaanita.model.core.utils.ModelUtil;


/**
 * Implementa la logica de manejo de usuarios y autenticacion.
 * Funcionalidades principales:
 * <ul>
 * 	<li>Verificacion de credenciales de usuario.</li>
 *  <li>Asignacion de modulos a un usuario.</li>
 * </ul>
 * @author
 */
@Stateless
@LocalBean
public class ManagerSeguridades {
	@EJB
	private ManagerDAO mDAO;
	@EJB
	private ManagerAuditoria mAuditoria;
    /**
     * Default constructor. 
     */
    public ManagerSeguridades() {
        
    }
    /**
     * Funcion de autenticacion mediante el uso de credenciales.
     * @param idSegUsuario El codigo del usuario que desea autenticarse.
     * @param clave La contrasenia.
     * @param direccionIP La dirección IP V4 del cliente web.
     * @return La ruta de acceso al sistema.
     * @throws Exception
     */
    public LoginDTO login(String idUsuario,String clave,String direccionIP) throws Exception{
    	//crear DTO:
		LoginDTO loginDTO=new LoginDTO();
		loginDTO.setIdUsuario(idUsuario);
		loginDTO.setDireccionIP(direccionIP);
		
    	if(ModelUtil.isEmpty(clave)) {
    		mAuditoria.mostrarLog(getClass(), "login", "Debe indicar una clave "+idUsuario);
    		throw new Exception("Debe indicar una clave");
    	}
    	Usuario usuario=(Usuario) mDAO.findById(Usuario.class, idUsuario);
    	if(usuario==null) {
    		mAuditoria.mostrarLog(getClass(), "login", "No existe usuario "+idUsuario);
    		throw new Exception("Error en credenciales.");
    	}
    		
    	if(usuario.getClave().equals(clave)) {
    		if(usuario.getActivo()==false) {
        		mAuditoria.mostrarLog(getClass(), "login", "Intento de login usuario desactivado "+idUsuario);
        		throw new Exception("El usuario esta desactivado.");
        	}
    		mAuditoria.mostrarLog(loginDTO, getClass(), "login", "Login exitoso "+idUsuario);
    		
    		loginDTO.setCorreo(usuario.getCorreo());
    	
    		return loginDTO;
    	}
    	mAuditoria.mostrarLog(getClass(), "login", "No coincide la clave "+idUsuario);
    	throw new Exception("Error en credenciales");
    }
    
    public void cerrarSesion(String idUsuario) {
    	mAuditoria.mostrarLog(getClass(), "cerrarSesion", "Cerrar sesión usuario: "+idUsuario);
    }
    
    public void accesoNoPermitido(String idUsuario,String ruta) {
    	mAuditoria.mostrarLog(getClass(), "accesoNoPermitido", "Usuario "+idUsuario+" intento no autorizado a "+ruta);
    }
    
    public List<Usuario> findAllUsuarios(){
    	return mDAO.findAll(Usuario.class, "apellidos");
    }
    
    public Usuario findByIdSegUsuario(String idUsuario) throws Exception {
    	return (Usuario) mDAO.findById(Usuario.class, "idUsuario");
    }
    
    
    public Usuario insertarUsuario(Usuario nuevoUsuario) throws Exception {
    	Usuario usuario=new Usuario();
    	usuario.setIdUsuario(nuevoUsuario.getIdUsuario());
    	usuario.setCedula(nuevoUsuario.getCedula());
    	usuario.setApellidos(nuevoUsuario.getApellidos());
    	usuario.setNombres(nuevoUsuario.getNombres());
    	usuario.setCorreo(nuevoUsuario.getCorreo());
    	usuario.setClave(nuevoUsuario.getClave());
    	usuario.setActivo(true);
    	mDAO.insertar(usuario);
    	return usuario;
    }
    
    public void actualizarUsuario(LoginDTO loginDTO,Usuario edicionUsuario) throws Exception {
    	Usuario usuario=(Usuario) mDAO.findById(Usuario.class, edicionUsuario.getIdUsuario());
    	usuario.setApellidos(edicionUsuario.getApellidos());
    	usuario.setClave(edicionUsuario.getClave());
    	usuario.setCorreo(edicionUsuario.getCorreo());
    	usuario.setCedula(edicionUsuario.getCedula());
    	usuario.setNombres(edicionUsuario.getNombres());
    	mDAO.actualizar(usuario);
    	mAuditoria.mostrarLog(loginDTO, getClass(), "actualizarUsuario", "se actualizó al usuario "+usuario.getApellidos());
    }
    
    public void activarDesactivarUsuario(String idUsuario) throws Exception {
    	Usuario usuario=(Usuario) mDAO.findById(Usuario.class, idUsuario);
    	if(idUsuario=="Z_Guitarra")
    		throw new Exception("No se puede desactivar al usuario administrador.");
    	usuario.setActivo(!usuario.getActivo());
    	System.out.println("activar/desactivar "+usuario.getActivo());
    	mDAO.actualizar(usuario);
    }

    
    public void eliminarUsuario(String idUsuario) throws Exception {
    	Usuario usuario=(Usuario) mDAO.findById(Usuario.class, idUsuario);
    	if(usuario.getIdUsuario()=="Z_Guitarra")
    		throw new Exception("No se puede eliminar el usuario administrador.");
   
    	mDAO.eliminar(Usuario.class, usuario.getIdUsuario());
    }
  
}
