package Test;

import org.junit.*;

import Componentes.Jugador;
import Compuestos.Escudo;
import Compuestos.Mina;
import Compuestos.Provision;
import Principal.Juego;

public class JuegoTest {

	@Test
	public void seCreaElJuego() throws Exception {

		Juego juego = new Juego();

		Assert.assertNotNull(juego);

	}

	@Test
	public void elJugadorSeSeteaEnLaPosicionDeEntrada() {

	
	}

}
