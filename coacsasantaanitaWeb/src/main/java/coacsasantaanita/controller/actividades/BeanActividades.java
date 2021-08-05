package coacsasantaanita.controller.actividades;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import coacsantaanita.model.actividades.manager.ManagerActividades;
import coacsantaanita.model.core.entities.IndicadoresIndicadore;
import coacsantaanita.model.core.entities.ProcesoActividad;
import coacsantaanita.model.core.entities.ProcesoObjetivoPerspectiva;
import coacsantaanita.model.core.entities.ProcesoPerspectiva;

@Named
@SessionScoped
public class BeanActividades implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerActividades mActividaes;
	private List<ProcesoActividad> listaActividades;
	private List<ProcesoPerspectiva>listaPerspectiva;
	private List<ProcesoObjetivoPerspectiva> listaObjetivo;
	private List<IndicadoresIndicadore> listaIndicadores;
	private ProcesoActividad actividadSeleccionado;

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
	public void actionListenerSeleccionarActividad(ProcesoActividad actividade) {
		actividadSeleccionado=actividade;
		
	}
	public List<ProcesoActividad> getListaActividades() {
		return listaActividades;
	}
	public void setListaActividades(List<ProcesoActividad> listaActividades) {
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
	public List<IndicadoresIndicadore> getListaIndicadores() {
		return listaIndicadores;
	}
	public void setListaIndicadores(List<IndicadoresIndicadore> listaIndicadores) {
		this.listaIndicadores = listaIndicadores;
	}
	public ProcesoActividad getActividadSeleccionado() {
		return actividadSeleccionado;
	}
	public void setActividadSeleccionado(ProcesoActividad actividadSeleccionado) {
		this.actividadSeleccionado = actividadSeleccionado;
	}
		
	
	}



