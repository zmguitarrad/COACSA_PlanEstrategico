package coacsantaanita.model.actividades.manager;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import coacsantaanita.model.auditoria.managers.ManagerAuditoria;
import coacsantaanita.model.core.entities.ProcesoActividad;
import coacsantaanita.model.core.entities.IndicadoresIndicadore;
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
    

    public MandoIntegralPlanEstrategico insertarPlan(MandoIntegralPlanEstrategico nuevoPlan) throws Exception {
    	MandoIntegralPlanEstrategico plan=new MandoIntegralPlanEstrategico();
    	plan.setMandoIntegralDetallePlan(nuevoPlan.getMandoIntegralDetallePlan());
    	plan.setGeneralesAnio(nuevoPlan.getGeneralesAnio());
    	mDAO.insertar(plan);
    	return plan;
    }
    
    
    public void eliminarPaln(int secuencial) throws Exception {
    	mDAO.eliminar(MandoIntegralPlanEstrategico.class, secuencial);
    }
    
    public void actualizarPlan(MandoIntegralPlanEstrategico edicionPlan) throws Exception {
    	MandoIntegralPlanEstrategico plan=(MandoIntegralPlanEstrategico) mDAO.findById(MandoIntegralPlanEstrategico.class, edicionPlan.getSecuencial());
    	plan.setMandoIntegralDetallePlan(edicionPlan.getMandoIntegralDetallePlan());
    	plan.setGeneralesAnio(edicionPlan.getGeneralesAnio());
    	mDAO.actualizar(plan);
    }
    
    public ProcesoActividad findPoaByActividad(int secuencial) {
    	return em.find(ProcesoActividad.class, secuencial);
    }
    
    public void actualizarActividad(ProcesoActividad actividade) throws Exception{
    	ProcesoActividad a =findPoaByActividad(actividade.getSecuencial());
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
    public List<ProcesoActividad> findAllActividades(){
    	return mDAO.findAll(ProcesoActividad.class);
    }
    public List<ProcesoPerspectiva> findAllPerspectiva(){
    	return mDAO.findAll(ProcesoPerspectiva.class);
    }
    public List<ProcesoObjetivoPerspectiva> findAllObjetivo(){
    	return mDAO.findAll(ProcesoObjetivoPerspectiva.class);
    }
    public List<IndicadoresIndicadore> findAllIndicadores(){
    	return mDAO.findAll(IndicadoresIndicadore.class);
    }
    
}
