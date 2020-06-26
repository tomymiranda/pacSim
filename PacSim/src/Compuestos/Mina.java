package Compuestos;

import Componentes.Jugador;

public class Mina extends Componente {

	public Mina(int poder) {
		super(false, false, true, false, poder);
	}

	@Override
	public void actualizarJugador(Jugador jugadorActual) {
		
		if(jugadorActual.getEscudo() > 0) {
			jugadorActual.setEscudo(jugadorActual.getEscudo() - super.getCantidad());
			if(jugadorActual.getEscudo() < 0) {
				jugadorActual.setVida(jugadorActual.getVida() + jugadorActual.getEscudo());
				jugadorActual.setEscudo(0);
			}
		} else {
			jugadorActual.setVida(jugadorActual.getVida() - super.getCantidad());
		}
		if (jugadorActual.getVida() < 0) {
			jugadorActual.setVida(0);
		}
	}

	public String toString() {
		return "M";
	}
}
