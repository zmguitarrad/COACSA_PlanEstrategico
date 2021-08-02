package coacsantaanita.model.actividades.manager;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import coacsantaanita.model.auditoria.managers.ManagerAuditoria;
import coacsantaanita.model.core.entities.Actividade;
import coacsantaanita.model.core.entities.Indicadore;
import coacsantaanita.model.core.entities.ObjetivoPerspectiva;
import coacsantaanita.model.core.entities.Perspectiva;
import coacsantaanita.model.core.entities.PlanEstrategico;
import coacsasantaanita.model.core.managers.ManagerDAO;

/**
 * Session Bean implementation class ManagerActividades
 */
@Stateless
@LocalBean
public class ManagerActividades {
	@EJB
	private ManagerDAO mDAO;
	@EJB
	private ManagerAuditoria mAuditoria;

    /**
     * Default constructor. 
     */
    public ManagerActividades() {
    }
    public List<PlanEstrategico> findAllModulos(){
    	return mDAO.findAll(PlanEstrategico.class, "nombre");
    }
    

    public PlanEstrategico insertarPlan(PlanEstrategico nuevoPlan) throws Exception {
    	PlanEstrategico plan=new PlanEstrategico();
    	plan.setNombre(nuevoPlan.getNombre());
    	plan.setAnioFin(nuevoPlan.getAnioFin());
    	plan.setAnioInicio(nuevoPlan.getAnioInicio());
    	mDAO.insertar(plan);
    	return plan;
    }
    
    
    public void eliminarPaln(int secuencial) throws Exception {
    	mDAO.eliminar(PlanEstrategico.class, secuencial);
    }
    
    public void actualizarPlan(PlanEstrategico edicionPlan) throws Exception {
    	PlanEstrategico plan=(PlanEstrategico) mDAO.findById(PlanEstrategico.class, edicionPlan.getSecuencial());
    	plan.setNombre(edicionPlan.getNombre());
    	plan.setAnioInicio(edicionPlan.getAnioInicio());
    	plan.setAnioFin(edicionPlan.getAnioFin());
    	mDAO.actualizar(plan);
    }
    
    //Actividades
    public List<Actividade> findAllActividades(){
    	return mDAO.findAll(Actividade.class);
    }
    public List<Perspectiva> findAllPerspectiva(){
    	return mDAO.findAll(Perspectiva.class);
    }
    public List<ObjetivoPerspectiva> findAllObjetivo(){
    	return mDAO.findAll(ObjetivoPerspectiva.class);
    }
    public List<Indicadore> findAllIndicadores(){
    	return mDAO.findAll(Indicadore.class);
    }
    
    
    
    

}
