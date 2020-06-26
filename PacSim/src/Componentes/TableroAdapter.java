package Componentes;

import java.util.Arrays;

public class TableroAdapter implements TableroJuego {

	private Casillero[][] tableroDondeSeMueveElJugador;

	@Override
	public Casillero[][] Dimensionar(Tablero tableroViejo) {
		int alto = tableroViejo.getAlto();
		int ancho = tableroViejo.getAncho();
		tableroDondeSeMueveElJugador = new Casillero[alto][ancho];
		for (int i = 0; i < alto ; i++) {
			tableroDondeSeMueveElJugador[i] = Arrays.copyOfRange(tableroViejo.getTablero(), i*ancho, (i*ancho)+ancho);
		}
		
		return tableroDondeSeMueveElJugador;
	}

}
