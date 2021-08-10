package coacsantaanita.model.actividades.manager;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import coacsantaanita.model.auditoria.managers.ManagerAuditoria;
import coacsantaanita.model.core.entities.ProcesoActividade;
import coacsantaanita.model.core.entities.IndicadoresIndicador;
import coacsantaanita.model.core.entities.ProcesoObjetivoPerspectiva;
import coacsantaanita.model.core.entities.ProcesoPerspectiva;
import coacsantaanita.model.core.entities.MandoIntegralPlanEstrategico;
import coacsasantaanita.model.core.managers.ManagerDAO;

/**
 * Session Bean implementation class ManagerActividades
 */
@Stateless
@LocalBean
public class ManagerActividades {
	@PersistenceContext
	private EntityManager em;
	@EJB
	private ManagerDAO mDAO;
	@EJB
	private ManagerAuditoria mAuditoria;

    /**
     * Default constructor. 
     */
    public ManagerActividades() {
    }
    public List<MandoIntegralPlanEstrategico> findAllModulos(){
    	return mDAO.findAll(MandoIntegralPlanEstrategico.class, "nombre");
    }
    
    
    public void eliminarPaln(int secuencial) throws Exception {
    	mDAO.eliminar(MandoIntegralPlanEstrategico.class, secuencial);
    }
    
 
    
    public ProcesoActividade findPoaByActividad(int secuencial) {
    	return em.find(ProcesoActividade.class, secuencial);
    }
    
    public void actualizarActividad(ProcesoActividade actividade) throws Exception{
    	ProcesoActividade a =findPoaByActividad(actividade.getSecuencial());
    	if(a==null)
    		throw new Exception("No existe");
    	//p.setCalendario(poaMaestro.getCalendario());
    	//a.setObjetivoPerspectiva(actividade.getObjetivoPerspectiva());
    	a.setNombreActividad(actividade.getNombreActividad());
    	//a.setIndicadore(actividade.getIndicadore());
    	//a.setIndicadore(actividade.getIndicadore());
    	em.merge(a);   	
    	
    }
    
    //Actividades
    public List<ProcesoActividade> findAllActividades(){
    	return mDAO.findAll(ProcesoActividade.class);
    }
    public List<ProcesoPerspectiva> findAllPerspectiva(){
    	return mDAO.findAll(ProcesoPerspectiva.class);
    }
    public List<ProcesoObjetivoPerspectiva> findAllObjetivo(){
    	return mDAO.findAll(ProcesoObjetivoPerspectiva.class);
    }
    public List<IndicadoresIndicador> findAllIndicadores(){
    	return mDAO.findAll(IndicadoresIndicador.class);
    }
    
}
