package Componentes;

public class Jugador {

	private int vida = 100;
	private int escudo = 0;
	private int posicionX;
	private int posicionY;

	public Jugador() {

	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vidas) {
		this.vida = vidas;
	}

	public int getEscudo() {
		return escudo;
	}

	public void setEscudo(int escudo) {
		this.escudo = escudo;
	}

	public int getPosicionX() {
		return posicionX;
	}

	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}

	public int getPosicionY() {
		return posicionY;
	}

	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}

	public void moverALaDerecha() {
		this.posicionY = posicionY + 1;
	}

	public void moverALaIzquierda() {
		this.posicionY = posicionY - 1;
	}

	public void moverAAbajo() {
		this.posicionX = posicionX + 1;
	}

	public void moverAArriba() {
		this.posicionX = posicionX - 1;
	}

	public int calcularPuntaje() {
		return vida;
	}
	
	public String toString() {
		return "J";
	}
	
	public String getEstado() {
		return "Vida: " + vida + " | Escudo: " + escudo;
	}
}
