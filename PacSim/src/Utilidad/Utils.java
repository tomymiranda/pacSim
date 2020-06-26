package Utilidad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import Componentes.Casillero;
import Componentes.Jugador;

public class Utils {
	LectorDeArchivos lector = new LectorDeArchivos();
			
	public List<String> obtenerValoresDeCategoria(List<String> lista, String categoria) {
		int indiceCatTablero = lista.indexOf(categoria);
		int indiceCatSigTablero = lector.getIndiceCategoria(indiceCatTablero, lista);
		return lector.getDatosEntreDosCategorias(indiceCatTablero, indiceCatSigTablero, lista);
		
	}
	
	public int parseDataToInt(String item) {
		return Integer.parseInt(item.split("=",0)[1]);
	}
	
	public void mostrarTablero(Casillero[][] tablero, Jugador jug) {
		for(int i=0; i< tablero.length; i++) {
			for(int j=0; j < tablero[i].length; j++) {
				if(jug.getPosicionX() == i && jug.getPosicionY() == j) {
					System.out.print(jug.toString());
				} else {
					System.out.print(tablero[i][j]);					
				}
			}
			System.out.print("\n");
		}
	}
	
	public String getConsoleInput() {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        
        try {
			return reader.readLine().toLowerCase();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new Error("Tecla incorrecta");
		}
        
	}
	
}
