package coacsasantaanita.controller.actividades;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import coacsantaanita.model.actividades.manager.ManagerActividades;
import coacsantaanita.model.core.entities.IndicadoresIndicador;
import coacsantaanita.model.core.entities.ProcesoActividade;
import coacsantaanita.model.core.entities.ProcesoObjetivoPerspectiva;
import coacsantaanita.model.core.entities.ProcesoPerspectiva;

@Named
@SessionScoped
public class BeanActividades implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerActividades mActividaes;
	private List<ProcesoActividade> listaActividades;
	private List<ProcesoPerspectiva>listaPerspectiva;
	private List<ProcesoObjetivoPerspectiva> listaObjetivo;
	private List<IndicadoresIndicador> listaIndicadores;
	private ProcesoActividade actividadSeleccionado;

	public BeanActividades() {
	}
	@PostConstruct
	public void inicializacion() {
		listaActividades= mActividaes.findAllActividades();
		listaIndicadores= mActividaes.findAllIndicadores();
		listaObjetivo=mActividaes.findAllObjetivo();
		listaPerspectiva=mActividaes.findAllPerspectiva();
	}
	
	public String actionCargarActividades() {
		listaActividades= mActividaes.findAllActividades();
		listaIndicadores= mActividaes.findAllIndicadores();
		listaObjetivo=mActividaes.findAllObjetivo();
		listaPerspectiva=mActividaes.findAllPerspectiva();
		return "actividades?faces-redirect=true";
	}
	public void actionListenerSeleccionarActividad(ProcesoActividade actividade) {
		actividadSeleccionado=actividade;
		
	}
	public List<ProcesoActividade> getListaActividades() {
		return listaActividades;
	}
	public void setListaActividades(List<ProcesoActividade> listaActividades) {
		this.listaActividades = listaActividades;
	}
	public List<ProcesoPerspectiva> getListaPerspectiva() {
		return listaPerspectiva;
	}
	public void setListaPerspectiva(List<ProcesoPerspectiva> listaPerspectiva) {
		this.listaPerspectiva = listaPerspectiva;
	}
	public List<ProcesoObjetivoPerspectiva> getListaObjetivo() {
		return listaObjetivo;
	}
	public void setListaObjetivo(List<ProcesoObjetivoPerspectiva> listaObjetivo) {
		this.listaObjetivo = listaObjetivo;
	}
	public List<IndicadoresIndicador> getListaIndicadores() {
		return listaIndicadores;
	}
	public void setListaIndicadores(List<IndicadoresIndicador> listaIndicadores) {
		this.listaIndicadores = listaIndicadores;
	}
	public ProcesoActividade getActividadSeleccionado() {
		return actividadSeleccionado;
	}
	public void setActividadSeleccionado(ProcesoActividade actividadSeleccionado) {
		this.actividadSeleccionado = actividadSeleccionado;
	}
		
	
	}



