package Componentes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import Componentes.Casillero;
import Compuestos.Escudo;
import Compuestos.Provision;
import Compuestos.Vitamina;
import Utilidad.LectorDeArchivos;
import Utilidad.Utils;

public class Tablero {

	private LectorDeArchivos lector;
	private Utilidad.Utils utils;
	private int ancho;
	private int alto;
	private int entrada;
	private int salida;
	private Casillero[] paredes;
	private String[] minas;
	private Casillero[] tablero;
	private List<Provision> listaProvisiones;

	public Tablero() throws Exception {
		lector = new LectorDeArchivos();
		utils = new Utils();
		listaProvisiones = new ArrayList<Provision>();
		List<String> datosArchivo = lector.leerArchivo();
		cargarDatosTablero(datosArchivo);
		tablero = new Casillero[alto * ancho];
		cargarDatosMinas(datosArchivo);
		cargarDatosAlTablero();
		crearProvisiones(datosArchivo);
		cargarPosicionesProvisiones(datosArchivo);
	}

	private void cargarDatosTablero(List<String> lista) {
		// Obtener datos del tablero
		List<String> listadoTablero = utils.obtenerValoresDeCategoria(lista, "[TABLERO]");
		for (String item : listadoTablero) {

			switch (item.substring(0, 1)) {
			case "M":
				this.ancho = utils.parseDataToInt(item);
				break;
			case "N":
				this.alto = utils.parseDataToInt(item);
				break;
			case "S":
				this.salida = utils.parseDataToInt(item);
				break;
			case "E":
				this.entrada = utils.parseDataToInt(item);
				break;
			default:

				char[] charParedes = (item.split("=", 0)[1]).toCharArray();
				this.paredes = new Casillero[charParedes.length];

				for (int i = 0; i < this.paredes.length; i++) {
					this.paredes[i] = Character.getNumericValue(charParedes[i]) == 1 ? new Compuestos.Pared()
							: new Compuestos.Libre();
				}
				break;
			}
		}

	}

	private void cargarDatosMinas(List<String> lista) {
		List<String> listado = utils.obtenerValoresDeCategoria(lista, "[MINAS]");
		minas = listado.get(0).split("=", 0)[1].split(",", 0);
	}
	
	public void crearProvisiones(List<String> lista) {
		// Obtener iDs de las provisiones
		List<String> listadoProvisiones = utils.obtenerValoresDeCategoria(lista, "[PROVISIONES]");
		for (String item : listadoProvisiones) {
			//iDs = item.split("=", 0)[1].split(",", 0);
			Provision aux = new Provision();
			aux.setID(item.split("=", 0)[0]);
			
			for(String prov : item.split("=", 0)[1].split(",",0)) {
				if(prov.startsWith("P")) {
					for(Provision p : this.listaProvisiones) {
						if(p.getID() == prov) {
							aux.addProvision(p);
						}
					}
				} else if(prov.equals("E")) {
					aux.addProvision(new Escudo(50));
				} else if(prov.equals("V")){
					aux.addProvision(new Vitamina(20));
				}
				
				
			}
			
			this.listaProvisiones.add(aux);
			
		}
	}
	
	private void cargarPosicionesProvisiones(List<String> lista) {
		List<String> listado = utils.obtenerValoresDeCategoria(lista, "[UBICACION_PROVISIONES]");

		for (String item : listado) {
			String[] items = item.split("=", 0);
			
			if (!items[1].contains(",") && !(tablero[Integer.parseInt(items[1]) - 1] instanceof Compuestos.Pared)) {
				for(Provision prov : this.listaProvisiones) {
					if(prov.getID().equals(items[0])) {
						
						tablero[Integer.parseInt(items[1])-1] = prov;
					}
				}
				
			} else {
				for (String p : items[1].split(",", 0)) {
					if (!(tablero[Integer.parseInt(p) - 1] instanceof Compuestos.Pared)) {
						for(Provision prov : this.listaProvisiones) {
							if(prov.getID().equals(items[0])) {
								tablero[Integer.parseInt(p)-1] = prov;
							}
						}
						;
					}
				}
			}
		}

	}

	private void cargarDatosAlTablero() {

		for (int i = 0; i < tablero.length; i++) {
			tablero[i] = paredes[i];
		}

		tablero[entrada] = new Compuestos.Entrada();
		tablero[salida] = new Compuestos.Salida();

		for (String mina : minas) {
			if (!(tablero[Integer.parseInt(mina) - 1] instanceof Compuestos.Pared)) {
				tablero[Integer.parseInt(mina) - 1] = new Compuestos.Mina(ThreadLocalRandom.current().nextInt(1, 50));
			}

		}

	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

	public int getEntrada() {
		return entrada;
	}

	public int getSalida() {
		return salida;
	}

	public Casillero[] getTablero() {
		return this.tablero;
	}
}
