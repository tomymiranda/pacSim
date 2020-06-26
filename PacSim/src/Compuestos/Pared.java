package Compuestos;
import Componentes.Casillero;

public class Pared implements Casillero {

	@Override
	public boolean getSePuedeAvanzar() {
		return false;
	}

	@Override
	public boolean esSalida() {
		return false;
	}
	
	@Override
	public String toString() {
		return "X";
	}

	@Override
	public boolean esEntrada() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estaLibre() {
		// TODO Auto-generated method stub
		return false;
	}

}
