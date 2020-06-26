package Test;

import org.junit.*;

import Componentes.Jugador;
import Compuestos.Escudo;
import Compuestos.Mina;
import Compuestos.Provision;

public class JugadorTest {

	@Test
	public void seCreaUsuario() {

		Jugador pacman = new Jugador();
		Assert.assertNotNull(pacman);

	}

	@Test
	public void seObtieneVidas() {
		Jugador pacman = new Jugador();

		int vidaJugador = pacman.getVida();

		Assert.assertEquals(100, vidaJugador);
	}

	@Test
	public void seObtieneEscudo() {
		Jugador pacman = new Jugador();

		int escudo = pacman.getEscudo();

		Assert.assertEquals(0, escudo);

	}

	@Test
	public void seRealizanLosCambiosEnLaPosicionY() {
		Jugador pacman = new Jugador();

		pacman.moverALaDerecha();
		pacman.moverALaDerecha();
		pacman.moverALaDerecha();
		pacman.moverALaIzquierda();

		int posicionYActual = pacman.getPosicionY();

		Assert.assertEquals(2, posicionYActual);
	}

	@Test
	public void seRealizanLosCambiosEnLaPosicionX() {
		Jugador pacman = new Jugador();

		pacman.moverAAbajo();
		pacman.moverAAbajo();
		pacman.moverAAbajo();
		pacman.moverAArriba();

		int posicionXActual = pacman.getPosicionX();

		Assert.assertEquals(2, posicionXActual);
	}

	@Test
	public void seObtieneElPuntajeTotalDeAcuerdoAlasVidas() {

		Jugador pacman = new Jugador();

		int puntaje = pacman.calcularPuntaje();

		Assert.assertEquals(100, puntaje);

	}
	@Test(expected = Error.class)
	public void elPuntajeEsMenorA100PorqueSeComioUnaMina() {
		Jugador pacman = new Jugador();

		Mina mina = new Mina(20);
		mina.actualizarJugador(pacman);

		int puntaje = pacman.calcularPuntaje();

		Assert.assertEquals(100, puntaje);
	}

}