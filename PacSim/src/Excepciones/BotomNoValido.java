package Excepciones;

public class BotomNoValido extends Exception {
	public BotomNoValido() {
		super("el boton ingresado no es valido");
	}
}
