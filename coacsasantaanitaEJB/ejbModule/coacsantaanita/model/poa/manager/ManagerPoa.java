package coacsantaanita.model.poa.manager;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import coacsantaanita.model.auditoria.managers.ManagerAuditoria;
import coacsantaanita.model.core.entities.Actividade;
import coacsantaanita.model.core.entities.Calendario;
import coacsantaanita.model.core.entities.Estado;
import coacsantaanita.model.core.entities.Indicadore;
import coacsantaanita.model.core.entities.ObjetivoPerspectiva;
import coacsantaanita.model.core.entities.Perspectiva;
import coacsantaanita.model.core.entities.PlanEstrategico;
import coacsantaanita.model.core.entities.PoaMaestro;
import coacsasantaanita.model.core.managers.ManagerDAO;

/**
 * Session Bean implementation class ManagerPoa
 */
@Stateless
@LocalBean
public class ManagerPoa {
	@EJB
	private ManagerDAO mDAO;
	@EJB
	private ManagerAuditoria mAuditoria;

    /**
     * Default constructor. 
     */
    public ManagerPoa() {
       
    }
    public List<PlanEstrategico> finAllPlan(){
    	return mDAO.findAll(PlanEstrategico.class);
    }
    
    public List<Actividade> findAllActividades(){
    	return mDAO.findAll(Actividade.class);
    }
 
    public List<Calendario> findAllCalendario(){
    	return mDAO.findAll(Calendario.class);
    }
    public List<Estado> findAllEstado(){
    	return mDAO.findAll(Estado.class);
    }
    public List<PoaMaestro> findAllPoa(){
    	return mDAO.findAll(PoaMaestro.class);
    }

}
