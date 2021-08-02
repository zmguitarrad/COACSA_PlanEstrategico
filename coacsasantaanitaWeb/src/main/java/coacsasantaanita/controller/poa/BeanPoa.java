package coacsasantaanita.controller.poa;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import coacsantaanita.model.actividades.manager.ManagerActividades;
import coacsantaanita.model.core.entities.Actividade;
import coacsantaanita.model.core.entities.Calendario;
import coacsantaanita.model.core.entities.Estado;
import coacsantaanita.model.core.entities.Indicadore;
import coacsantaanita.model.core.entities.ObjetivoPerspectiva;
import coacsantaanita.model.core.entities.Perspectiva;
import coacsantaanita.model.core.entities.PlanEstrategico;
import coacsantaanita.model.core.entities.PoaMaestro;
import coacsantaanita.model.poa.manager.ManagerPoa;

@Named
@SessionScoped
public class BeanPoa implements Serializable {
	@EJB
	private ManagerPoa mPoa;
	private List<Actividade> listaActividades;
	private List<Estado>listaEstado;
	private List<PlanEstrategico> listaPlan;
	private List<Calendario> listaCalendario;
	private List<PoaMaestro> listaPoa;

	public BeanPoa() {
	
	}
	@PostConstruct
	public void inicializacion() {
		listaActividades= mPoa.findAllActividades();
		listaEstado=mPoa.findAllEstado();
		listaCalendario=mPoa.findAllCalendario();
		listaPlan=mPoa.finAllPlan();
		listaPoa=mPoa.findAllPoa();
		
		
	}
	public String actionCargarPoa() {
		listaActividades= mPoa.findAllActividades();
		listaEstado=mPoa.findAllEstado();
		listaCalendario=mPoa.findAllCalendario();
		listaPlan=mPoa.finAllPlan();
		listaPoa=mPoa.findAllPoa();
		return "actividades?faces-redirect=true";
	}
	public List<Actividade> getListaActividades() {
		return listaActividades;
	}
	public void setListaActividades(List<Actividade> listaActividades) {
		this.listaActividades = listaActividades;
	}
	public List<Estado> getListaEstado() {
		return listaEstado;
	}
	public void setListaEstado(List<Estado> listaEstado) {
		this.listaEstado = listaEstado;
	}
	public List<PlanEstrategico> getListaPlan() {
		return listaPlan;
	}
	public void setListaPlan(List<PlanEstrategico> listaPlan) {
		this.listaPlan = listaPlan;
	}
	public List<Calendario> getListaCalendario() {
		return listaCalendario;
	}
	public void setListaCalendario(List<Calendario> listaCalendario) {
		this.listaCalendario = listaCalendario;
	}
	public List<PoaMaestro> getListaPoa() {
		return listaPoa;
	}
	public void setListaPoa(List<PoaMaestro> listaPoa) {
		this.listaPoa = listaPoa;
	}
	

}
