package Principal;

import Componentes.*;
import Utilidad.Utils;

public class Juego {

	private Jugador jugador;
	private Casillero[][] tablero;
	private Utils utils = new Utils();
	private boolean finJuego = false;

	public Juego() throws Exception {
		tablero = new TableroAdapter().Dimensionar(new Tablero());
		jugador = new Jugador();
		setInicioJugador();
	}

	public void jugar() throws Exception {
		while (!finJuego) {
			System.out.flush();
			System.out.println(jugador.getEstado());
			utils.mostrarTablero(tablero, jugador);

			movimientoJugador(utils.getConsoleInput());

			verificarCasillero(jugador.getPosicionX(), jugador.getPosicionY());

			

		}
		if (jugador.getVida() > 0) {
			System.out.println("Muy bien! Llegaste a la salida! Tu puntaje es de " + jugador.calcularPuntaje());
		} else {
			System.out.println("Perdiste! No tenes mas vida...");
		}
	}

	public void setInicioJugador() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (tablero[i][j].esEntrada()) {
					jugador.setPosicionX(i);
					jugador.setPosicionY(j);
				}
			}
		}
	}

	public void movimientoJugador(String tecla) {
		switch (tecla) {
		case "w":
			if (jugador.getPosicionX() - 1 >= 0
					&& tablero[jugador.getPosicionX() - 1][jugador.getPosicionY()].getSePuedeAvanzar()) {
				jugador.moverAArriba();
			} else {
				System.out.println("No se puede mover\n");
			}

			break;

		case "s":
			if (jugador.getPosicionX() + 1 < tablero.length
					&& tablero[jugador.getPosicionX() + 1][jugador.getPosicionY()].getSePuedeAvanzar()) {
				jugador.moverAAbajo();
			} else {
				System.out.println("No se puede mover\n");
			}

			break;

		case "a":
			if (jugador.getPosicionY() - 1 >= 0
					&& tablero[jugador.getPosicionX()][jugador.getPosicionY() - 1].getSePuedeAvanzar()) {
				jugador.moverALaIzquierda();
			} else {
				System.out.println("No se puede mover\n");
			}

			break;
		case "d":
			if (jugador.getPosicionY() + 1 < tablero[jugador.getPosicionX()].length
					&& tablero[jugador.getPosicionX()][jugador.getPosicionY() + 1].getSePuedeAvanzar()) {
				jugador.moverALaDerecha();
			} else {
				System.out.println("No se puede mover\n");
			}

			break;
		default:
			System.out.println("No se puede mover\n");
		}
			
	}

	private void verificarCasillero(int x, int y) {
		Casillero casillero = tablero[x][y];
		if (casillero.esSalida()) {
			finJuego = true;
		} else if (casillero instanceof Compuestos.Mina) {
			((Compuestos.Mina) casillero).actualizarJugador(jugador);
			tablero[x][y] = new Compuestos.Libre();
			if (jugador.getVida() <= 0) {
				finJuego = true;
			}
		}

		else if (casillero instanceof Compuestos.Provision) {
			
			
			
			for(Compuestos.Provision prov : ((Compuestos.Provision) casillero).getProvisiones()) {
				System.out.println("Provision" + prov.getCantidad());
				prov.actualizarJugador(jugador);
			}
			tablero[x][y] = new Compuestos.Libre();
		}

	}
}
