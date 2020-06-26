package Test;

import org.junit.Assert;
import org.junit.Test;

import Componentes.Jugador;
import Compuestos.Escudo;
import Compuestos.Mina;
import Compuestos.Pared;
import Compuestos.Provision;

public class CompuestosTest {

	@Test(expected = Error.class)
	public void laVidaYaNoEs100() {
		Jugador pacman = new Jugador();

		Mina mina = new Mina(20);
		mina.actualizarJugador(pacman);
		int actual = pacman.getVida();
		Assert.assertEquals(100, actual);

	}

	@Test
	public void laParedNuncaVaAEstarLibre() throws Exception {
		Pared pared = new Pared();
		boolean loEs = pared.estaLibre();

		Assert.assertEquals(false, loEs);

	}

	@Test
	public void laParedNoVaASerEntrada() {
		Pared pared = new Pared();
		boolean loEs = pared.esEntrada();

		Assert.assertEquals(false, loEs);
	}

	@Test
	public void laParedNoVaASerSalida() {
		Pared pared = new Pared();
		boolean loEs = pared.esSalida();

		Assert.assertEquals(false, loEs);
	}

	@Test
	public void seIdentificaParedComoP() {
		Pared pared = new Pared();
		String id = pared.toString();

		Assert.assertEquals("X", id);
	}

	@Test
	public void seIdentificaMinaComoM() {

		Mina mina = new Mina(20);

		String id = mina.toString();

		Assert.assertEquals("M", id);
	}

	@Test
	public void seIdentificaProvisionComoB() {
		Provision pro = new Provision();

		String id = pro.toString();
		Assert.assertEquals("B", id);

	}

}
