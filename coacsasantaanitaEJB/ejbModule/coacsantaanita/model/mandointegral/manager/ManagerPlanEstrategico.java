package coacsantaanita.model.mandointegral.manager;

import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import coacsantaanita.model.auditoria.managers.ManagerAuditoria;
import coacsantaanita.model.core.entities.GeneralesAnio;
import coacsantaanita.model.core.entities.MandoIntegralPlanEstrategico;
import coacsantaanita.model.core.entities.MandoIntegralPoaMaestro;
import coacsantaanita.model.core.entities.ProcesoActividade;
import coacsantaanita.model.core.entities.ProcesoPerspectiva;
import coacsasantaanita.model.core.managers.ManagerDAO;

/**
 * Session Bean implementation class ManagerPlanEstrategico
 */
@Stateless
@LocalBean
public class ManagerPlanEstrategico {
	
	@PersistenceContext
	private EntityManager em;
	@EJB
	private ManagerDAO mDAO;
	@EJB
	private ManagerAuditoria mAuditoria;
	


	
    /**
     * Default constructor. 
     */
    public ManagerPlanEstrategico() {
       
    }
    //listar PlanEstrategico
    public List<MandoIntegralPlanEstrategico> findAllPlanEstrategico(){
    	return mDAO.findAll(MandoIntegralPlanEstrategico.class);
    }
		//listar por id plan estrategico
    public MandoIntegralPlanEstrategico findByIdPlanEstrategico(int secuencial) throws Exception {
    	return (MandoIntegralPlanEstrategico) mDAO.findById(MandoIntegralPlanEstrategico.class, secuencial);
    }
	//listar por id perspectiva
    public ProcesoPerspectiva findByPerspectiva(int secuencialplanesrategico) throws Exception {
    	return (ProcesoPerspectiva) mDAO.findById(ProcesoPerspectiva.class, secuencialplanesrategico);
    }
    //listar anios
    public List<GeneralesAnio> findAllAnio(){
    	return mDAO.findAll(GeneralesAnio.class);
    }
	//listar por id anio
    public GeneralesAnio findByIdAnio(int secuencial) throws Exception {
    	return (GeneralesAnio) mDAO.findById(GeneralesAnio.class, secuencial);
    }
    ///poa maestro
    
    public List<MandoIntegralPoaMaestro> findAllPoaMaestro(){
    	return mDAO.findAll(MandoIntegralPoaMaestro.class);
    }
    public MandoIntegralPoaMaestro findBySecuencialPOA(int secuencial) throws Exception {
    	return(MandoIntegralPoaMaestro) mDAO.findById(MandoIntegralPoaMaestro.class, secuencial);
    	
    }
    
   	//crear plan estrategico
    public MandoIntegralPlanEstrategico insertarPlanEstrategico(MandoIntegralPlanEstrategico nuevoplanestrategico) throws Exception {
    	
    	MandoIntegralPlanEstrategico planestrategico=new MandoIntegralPlanEstrategico();
    	planestrategico.setNombrePlanEstrategico(nuevoplanestrategico.getNombrePlanEstrategico());
    	planestrategico.setAnioInicio(nuevoplanestrategico.getAnioInicio());
    	planestrategico.setAnioFin(nuevoplanestrategico.getAnioFin());
    	
    	mAuditoria.mostrarLog(getClass(), "inicializar Plan Operativo Anual", "Inicializaciando.....");
    	mDAO.insertar(planestrategico);
    	
    	 //inicializando poa maestro
    	for (int i = nuevoplanestrategico.getAnioInicio(); i < nuevoplanestrategico.getAnioFin(); i++) {
    		MandoIntegralPoaMaestro poa=new MandoIntegralPoaMaestro();
        	GeneralesAnio anio=new GeneralesAnio();
        	poa.setGeneralesAnio(poa.getGeneralesAnio());
        	poa.setMandoIntegralPlanEstrategico(poa.getMandoIntegralPlanEstrategico());
        	poa.setNombrePoaMaestro("POA"+poa.getGeneralesAnio());
        	poa.setActivo(true);
        	mDAO.insertar(poa);
		}

    	return planestrategico;
    }
    /*
    public ProcesoActividade ingresarActividades(ProcesoPerspectiva perspectiva,MandoIntegralPoaMaestro poa) throws Exception {
    	ProcesoActividade actividad=new ProcesoActividade();
    	if(perspectiva.getMandoIntegralPlanEstrategico().equals(poa.getMandoIntegralPlanEstrategico())) {
    		mAuditoria.mostrarLog(getClass(), "inGRESO A ACTIVIDADES","DEACUERDO AL PLANESTRATEGICO");
    	}
    	return actividad;
    }
    */
    /*
    public void asignarActividades(int secuencialplanestrategico,int indicador) throws Exception{
    	//Buscar los objetos primarios:
    	MandoIntegralPlanEstrategico plan=(MandoIntegralPlanEstrategico)mDAO.findById(getClass(), em)
    	SegUsuario usuario=(SegUsuario)mDAO.findById(SegUsuario.class, idSegUsuario);
    	SegModulo modulo=(SegModulo)mDAO.findById(SegModulo.class, idSegModulo);
    	//crear la relacion:
    	SegAsignacion asignacion=new SegAsignacion();
    	asignacion.setSegModulo(modulo);
    	asignacion.setSegUsuario(usuario);
    	//guardar la asignacion:
    	mDAO.insertar(asignacion);
    	mAuditoria.mostrarLog(getClass(), "asignarModulo", "Modulo "+idSegModulo+" asigando a usuario "+idSegUsuario);
    }
    */
    
   


}
