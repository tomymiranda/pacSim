package Compuestos;

import Componentes.Casillero;

public class Libre implements Casillero{

	@Override
	public boolean getSePuedeAvanzar() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean esSalida() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean esEntrada() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estaLibre() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public String toString() {
		return " ";
	}

}
