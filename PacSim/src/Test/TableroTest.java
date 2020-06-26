package Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Componentes.Jugador;
import Componentes.Tablero;
import Compuestos.Escudo;
import Compuestos.Pared;
import Compuestos.Provision;
import Compuestos.Vitamina;

public class TableroTest {

	@Test
	public void seCreaTablero() throws Exception {

		Tablero tablero = new Tablero();
		Assert.assertNotNull(tablero);

	}

	@Test
	public void seObtieneLasColumnas() throws Exception {
		Tablero tablero = new Tablero();
		int columnas = tablero.getAncho();

		Assert.assertEquals(7, columnas);

	}

	@Test
	public void seObtieneLasFilas() throws Exception {
		Tablero tablero = new Tablero();
		int filas = tablero.getAlto();

		Assert.assertEquals(10, filas);
	}

	@Test
	public void seObtieneElCasilleroDeEntrada() throws Exception {

		Tablero tablero = new Tablero();

		int casillero = tablero.getEntrada();

		Assert.assertEquals(64, casillero);
	}

	@Test
	public void seObtieneElCasilleroDeSalida() throws Exception {

		Tablero tablero = new Tablero();

		int casillero = tablero.getSalida();

		Assert.assertEquals(13, casillero);
	}


}
