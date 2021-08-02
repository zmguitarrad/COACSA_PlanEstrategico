package coacsasantaanita.controller.actividades;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import coacsantaanita.model.actividades.manager.ManagerActividades;
import coacsantaanita.model.core.entities.Actividade;
import coacsantaanita.model.core.entities.Indicadore;
import coacsantaanita.model.core.entities.ObjetivoPerspectiva;
import coacsantaanita.model.core.entities.Perspectiva;

@Named
@SessionScoped
public class BeanActividades implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerActividades mActividaes;
	private List<Actividade> listaActividades;
	private List<Perspectiva>listaPerspectiva;
	private List<ObjetivoPerspectiva> listaObjetivo;
	private List<Indicadore> listaIndicadores;

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
	public List<Actividade> getListaActividades() {
		return listaActividades;
	}
	public void setListaActividades(List<Actividade> listaActividades) {
		this.listaActividades = listaActividades;
	}
	public List<Perspectiva> getListaPerspectiva() {
		return listaPerspectiva;
	}
	public void setListaPerspectiva(List<Perspectiva> listaPerspectiva) {
		this.listaPerspectiva = listaPerspectiva;
	}
	public List<ObjetivoPerspectiva> getListaObjetivo() {
		return listaObjetivo;
	}
	public void setListaObjetivo(List<ObjetivoPerspectiva> listaObjetivo) {
		this.listaObjetivo = listaObjetivo;
	}
	public List<Indicadore> getListaIndicadores() {
		return listaIndicadores;
	}
	public void setListaIndicadores(List<Indicadore> listaIndicadores) {
		this.listaIndicadores = listaIndicadores;
	}
	
	
	
	
	
	}



