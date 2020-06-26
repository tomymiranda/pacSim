package Compuestos;

import Componentes.Jugador;

public class Vitamina extends Provision {

	public Vitamina(int cantidad) {
		super.setCantidad(cantidad);
	}

	
	public void actualizarJugador(Jugador jugadorActual) {
		System.out.println("Vita");
		jugadorActual.setVida(jugadorActual.getVida() + super.getCantidad());
	}
}
