package Compuestos;

import Componentes.Casillero;
import Componentes.Jugador;

public class Componente implements Casillero{
	
	private int cantidad;
	private boolean esSalida;
	private boolean mina ;
	private boolean provision;
	private boolean esEntrada;
	
	public Componente(boolean esSalida, boolean esEntrada, boolean mina, boolean provision, int cantidad) {
		this.esSalida = esSalida;
		this.esEntrada = esEntrada;
		this.mina = mina;
		this.provision = provision;
		this.cantidad = cantidad;
		
	}
	
	@Override
	public boolean getSePuedeAvanzar() {
		return true;
	}
	
	@Override
	public boolean esSalida() {
		return esSalida;
	}
	
	@Override
	public boolean esEntrada() {
		return esEntrada;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidadDeComponente) {
		this.cantidad = cantidadDeComponente;
	}
	
	public void actualizarJugador(Jugador jugador){
		
	}
	
	public boolean esMina() {
		return mina;
	}
	
	public boolean esProvision() {
		return provision;
	}

	@Override
	public boolean estaLibre() {
		return false;
	}
}