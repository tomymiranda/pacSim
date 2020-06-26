package Compuestos;

import Componentes.Jugador;

public class Escudo extends Provision {

	private int cantidad = 0;

	public Escudo(int cantidad) {
		super.setCantidad(cantidad);
	}

	public void actualizarJugador(Jugador jugadorActual) {
		System.out.println("ESCUDO");
		jugadorActual.setEscudo(jugadorActual.getEscudo()  + super.getCantidad());
	}

}
