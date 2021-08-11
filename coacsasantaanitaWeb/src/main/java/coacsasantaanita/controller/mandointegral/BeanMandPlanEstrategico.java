package coacsasantaanita.controller.mandointegral;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import coacsantaanita.model.core.entities.MandoIntegralPlanEstrategico;
import coacsantaanita.model.core.entities.MandoIntegralPoaMaestro;
import coacsantaanita.model.core.entities.ProcesoActividade;
import coacsantaanita.model.core.entities.ProcesoPerspectiva;
import coacsantaanita.model.mandointegral.manager.ManagerPlanEstrategico;



@Named
@SessionScoped
public class BeanMandPlanEstrategico implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerPlanEstrategico mPlanEstrategico;
	private List<MandoIntegralPlanEstrategico>listaPlanEstrategico;
	private List<MandoIntegralPoaMaestro>listaPOA;
	private List<ProcesoPerspectiva>listaperspectiva;
	private int secuencialplanestrategico;
	private int secuencialpoa;

	public BeanMandPlanEstrategico() {
		
	}
	@PostConstruct
	public void inicializacion() {
		listaPlanEstrategico= mPlanEstrategico.findAllPlanEstrategico();
		listaPOA =mPlanEstrategico.findAllPoaMaestro();
	

	}
	//cargar plan estrategico
	public String actionCargarPlanEstrategico() {
		listaPlanEstrategico=mPlanEstrategico.findAllPlanEstrategico();
		listaPOA =mPlanEstrategico.findAllPoaMaestro();
		return "POA?faces-redirect=true";
	}
	
	
	public List<MandoIntegralPlanEstrategico> getListaPlanEstrategico() {
		return listaPlanEstrategico;
	}
	public void setListaPlanEstrategico(List<MandoIntegralPlanEstrategico> listaPlanEstrategico) {
		this.listaPlanEstrategico = listaPlanEstrategico;
	}
	public List<MandoIntegralPoaMaestro> getListaPOA() {
		return listaPOA;
	}
	public void setListaPOA(List<MandoIntegralPoaMaestro> listaPOA) {
		this.listaPOA = listaPOA;
	}
	public int getSecuencialplanestrategico() {
		return secuencialplanestrategico;
	}
	public void setSecuencialplanestrategico(int secuencialplanestrategico) {
		this.secuencialplanestrategico = secuencialplanestrategico;
	}
	public int getSecuencialpoa() {
		return secuencialpoa;
	}
	public void setSecuencialpoa(int secuencialpoa) {
		this.secuencialpoa = secuencialpoa;
	}
	
	
	
}
