package Utilidad;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class LectorDeArchivos {
	
	BufferedReader bufferReader = null;
	String linea = "";
	BufferedReaderUtil buffReader = new BufferedReaderUtil();
	List<String> datos = new ArrayList<String>();
	
	public List<String> leerArchivo() throws Exception {
		bufferReader = buffReader.getBufferReader("tablero");

			while ((linea = bufferReader.readLine()) != null) {
				datos.add(linea);
			}
			
		return datos;
	}
	
	public int getIndiceCategoria(int categoria, List<String> lista) {
		int indice = -1;
		String item;
		Iterator iter = lista.listIterator(categoria);
		
		while(iter.hasNext() && indice == -1) {
			item = iter.next().toString();
			if(item.startsWith("[") && !item.equals(lista.get(categoria))) {
				indice = lista.indexOf(item);
			}
		}
		
		if(indice == -1) {
			indice = lista.size();
		}
		
		return indice;
	}
	
	public List<String> getDatosEntreDosCategorias(int cat1, int cat2, List<String> lista) {
		List<String> listaValores = new ArrayList<String>();
		
		for(int i = cat1+1; i < cat2; i++) {
			listaValores.add(lista.get(i));
		}
		
		return listaValores;
	}
	
	
}
