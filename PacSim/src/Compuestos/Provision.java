package Compuestos;

import java.util.*;

import Componentes.Jugador;

public class Provision extends Componente {

	private Utilidad.Utils utils;
	private String[] iDs;
	private List<Provision> listaDeProvisiones;
	private String id;
	private int cantidad;

	public Provision() {
		super(false, false, false, true, 0);
		listaDeProvisiones = new ArrayList<Provision>();
	}

	

	public void addProvision(Provision prov) {
		if (prov != this) {
			listaDeProvisiones.add(prov);
			super.setCantidad(super.getCantidad() + prov.getCantidad());
		}
	}

	public List<Provision> getProvisiones() {
		return listaDeProvisiones;
	}

	public String toString() {
		return "B";
	}

	
	public String getID() {
		return id;
	}
	
	public void setID(String id) {
		this.id = id;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
