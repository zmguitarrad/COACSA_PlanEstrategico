package coacsantaanita.model.seguridades.manager;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import coacasantaanita.model.seguridades.dtos.LoginDTO;
import coacsantaanita.model.auditoria.managers.ManagerAuditoria;
import coacsantaanita.model.core.entities.SeguridadesRole;
import coacsantaanita.model.core.entities.SeguridadesUsuario;
import coacsantaanita.model.core.entities.SeguridadesUsuarioRole;
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
     * Funcion de inicializacion de datos de usuarios.
     */
    public void inicializarDemo() throws Exception {
    	mAuditoria.mostrarLog(getClass(), "inicializando", "Inicializacion de bdd demo.");
    	List<SeguridadesUsuario> listaUsuarios=mDAO.findAll(SeguridadesUsuario.class);
    	String idSegUsuarioAdmin=null;
    	
    	boolean existeAdministrador=false;
    	for(SeguridadesUsuario u:listaUsuarios) {
    		mAuditoria.mostrarLog(getClass(), "inicializando", "Info de usuario "+u.getCorreo()+" "+u.getApellidos()+""+u.getNombres());
    		//Se considera al usuario 1 como administrador: 
    	}
    	
    }
    
    /**
     * Funcion de autenticacion mediante el uso de credenciales.
     * @param idSegUsuario El codigo del usuario que desea autenticarse.
     * @param clave La contrasenia.
     * @param direccionIP La dirección IP V4 del cliente web.
     * @return La ruta de acceso al sistema.
     * @throws Exception
     */
    public LoginDTO login(String idSegUsuario,String clave,String direccionIP) throws Exception{
    	//crear DTO:
		LoginDTO loginDTO=new LoginDTO();
		loginDTO.setIdUsuario(idSegUsuario);
		loginDTO.setDireccionIP(direccionIP);
		
    	if(ModelUtil.isEmpty(clave)) {
    		mAuditoria.mostrarLog(getClass(), "login", "Debe indicar una clave y usuario "+idSegUsuario);
    		throw new Exception("Debe indicar una clave");
    	}
    	SeguridadesUsuario usuario=(SeguridadesUsuario) mDAO.findById(SeguridadesUsuario.class, idSegUsuario);
    	if(usuario==null) {
    		mAuditoria.mostrarLog(getClass(), "login", "No existe usuario "+idSegUsuario);
    		throw new Exception("Error en credenciales.");
    	}
    		
    	if(usuario.getClave().equals(clave)) {
    		if(usuario.getActivo()==false) {
        		mAuditoria.mostrarLog(getClass(), "login", "Intento de login usuario desactivado "+idSegUsuario);
        		throw new Exception("El usuario esta desactivado.");
        	}
    		mAuditoria.mostrarLog(loginDTO, getClass(), "login", "Login exitoso "+idSegUsuario);
    		
    		loginDTO.setCorreo(usuario.getCorreo());
    		//aqui puede realizarse el envio de correo de notificacion.
    		
    		//obtener la lista de modulos a los que tiene acceso:
    		/*
    		List<SeguridadesUsuarioRole> listaAsignaciones=findAsignacionByUsuario(usuario.getIdUsuario());
    		for(SeguridadesUsuarioRole asig:listaAsignaciones) {
    			SeguridadesRole modulo=asig.getSeguridadesRoles();
    			loginDTO.getListaroles().add(modulo);
    		}
    		*/
    		return loginDTO;
    	}
    	mAuditoria.mostrarLog(getClass(), "login", "No coincide la clave "+idSegUsuario);
    	throw new Exception("Error en credenciales");
    }
    
    public void cerrarSesion(String idSegUsuario) {
    	mAuditoria.mostrarLog(getClass(), "cerrarSesion", "Cerrar sesión usuario: "+idSegUsuario);
    }
    
    public void accesoNoPermitido(String idSegUsuario,String ruta) {
    	mAuditoria.mostrarLog(getClass(), "accesoNoPermitido", "Usuario "+idSegUsuario+" intento no autorizado a "+ruta);
    }
    
    public List<SeguridadesUsuario> findAllUsuarios(){
    	return mDAO.findAll(SeguridadesUsuario.class, "apellidos");
    }
    
    public SeguridadesUsuario findByIdSegUsuario(String idSegUsuario) throws Exception {
    	return (SeguridadesUsuario) mDAO.findById(SeguridadesUsuario.class, idSegUsuario);
    }
    
    public SeguridadesUsuario insertarUsuario(SeguridadesUsuario nuevoUsuario) throws Exception {
    	SeguridadesUsuario usuario=new SeguridadesUsuario();
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

    
    public void actualizarUsuario(LoginDTO loginDTO,SeguridadesUsuario edicionUsuario) throws Exception {
    	SeguridadesUsuario usuario=(SeguridadesUsuario) mDAO.findById(SeguridadesUsuario.class, edicionUsuario.getIdUsuario());
    	usuario.setApellidos(edicionUsuario.getApellidos());
    	usuario.setClave(edicionUsuario.getClave());
    	usuario.setCorreo(edicionUsuario.getCorreo());
    	usuario.setNombres(edicionUsuario.getNombres());
    	mDAO.actualizar(usuario);
    	mAuditoria.mostrarLog(loginDTO, getClass(), "actualizarUsuario", "se actualizó al usuario "+usuario.getApellidos());
    }
    
    public void activarDesactivarUsuario(String idSegUsuario) throws Exception {
    	SeguridadesUsuario usuario=(SeguridadesUsuario) mDAO.findById(SeguridadesUsuario.class, idSegUsuario);
    	if(idSegUsuario=="Admin")
    		throw new Exception("No se puede desactivar al usuario administrador.");
    	usuario.setActivo(!usuario.getActivo());
    	System.out.println("activar/desactivar "+usuario.getActivo());
    	mDAO.actualizar(usuario);
    }
    
    public void eliminarUsuario(String idSegUsuario) throws Exception {
    	SeguridadesUsuario usuario=(SeguridadesUsuario) mDAO.findById(SeguridadesUsuario.class, idSegUsuario);
    	if(usuario.getIdUsuario()=="Admin")
    		throw new Exception("No se puede eliminar el usuario administrador.");
    	if(usuario.getSeguridadesUsuarioRoles().size()>0)
    		throw new Exception("No se puede elimininar el usuario porque tiene asignaciones de módulos.");
    	mDAO.eliminar(SeguridadesUsuario.class, usuario.getIdUsuario());
    }
    
    public List<SeguridadesRole> findAllRoles(){
    	return mDAO.findAll(SeguridadesRole.class, "nombreRole");
    }
    
    public SeguridadesRole insertarRole(SeguridadesRole nuevoRol) throws Exception {
    	SeguridadesRole rol=new SeguridadesRole();
    	rol.setNombreRol(nuevoRol.getNombreRol());
    	rol.setRutaAcceso(nuevoRol.getRutaAcceso());
    	mDAO.insertar(rol);
    	return rol;
    
    }
    public void eliminarRol(int idSegRol) throws Exception {
    	mDAO.eliminar(SeguridadesRole.class, idSegRol);
    }
    
    public void actualizarRol(SeguridadesRole edicionRol) throws Exception {
    	SeguridadesRole rol=(SeguridadesRole) mDAO.findById(SeguridadesRole.class, edicionRol.getSecuencial());
    	rol.setNombreRol(edicionRol.getNombreRol());
    	rol.setRutaAcceso(edicionRol.getRutaAcceso());
    	mDAO.actualizar(rol);
    }
    /*
    public List<SeguridadesUsuarioRole> findAsignacionByUsuario(String idSegUsuario){
    	String consulta="o.seguridadesUsuario.idUsuario="+idSegUsuario;
		List<SeguridadesUsuarioRole> listaAsignaciones=mDAO.findWhere(SeguridadesUsuarioRole.class, consulta, null);
		return listaAsignaciones;
    }
    
    /**
     * Permite asignar el acceso a un modulo del inventario de sistemas.
     * @param idSegUsuario El codigo del usuario.
     * @param idSegModulo El codigo del modulo que se va a asignar.
     * @throws Exception
     */
    public void asignarRoles(String idSegUsuario,int idSegRol) throws Exception{
    	//Buscar los objetos primarios:
    	SeguridadesUsuario usuario=(SeguridadesUsuario)mDAO.findById(SeguridadesUsuario.class, idSegUsuario);
    	SeguridadesRole rol=(SeguridadesRole)mDAO.findById(SeguridadesRole.class, idSegRol);
    	//crear la relacion:
    	SeguridadesUsuarioRole asignacion=new SeguridadesUsuarioRole();
    	asignacion.setSeguridadesRole(rol);
    	asignacion.setSeguridadesUsuario(usuario);
    	//guardar la asignacion:
    	mDAO.insertar(asignacion);
    	
    	mAuditoria.mostrarLog(getClass(), "asignarModulo", "Modulo "+idSegRol+" asigando a usuario "+idSegUsuario);
    }
    
    public void eliminarAsignacion(int idSegAsignacion) throws Exception {
    	mDAO.eliminar(SeguridadesUsuarioRole.class, idSegAsignacion);
    }

}

   