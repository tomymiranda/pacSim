package Compuestos;

import Componentes.Casillero;

public class Salida implements Casillero {

	@Override
	public boolean getSePuedeAvanzar() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean esSalida() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean esEntrada() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String toString() {
		return "S";
	}

	@Override
	public boolean estaLibre() {
		// TODO Auto-generated method stub
		return true;
	}

}
