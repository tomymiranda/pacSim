package Utilidad;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import Utilidad.PathGenerator;

public class BufferedReaderUtil {
	private PathGenerator pathGen = new PathGenerator();
	
	public BufferedReader getBufferReader(String nombreArchivo) throws Exception {
		
		String ruta = pathGen.getFilePath(nombreArchivo);
				
		try {
			File archivo = new File (ruta);
			FileReader fileReader = new FileReader (archivo);
			return new BufferedReader(fileReader);
		}
		catch(Exception e){
			throw new Error(nombreArchivo);
		}
		
	}
/*
	private void cerrarBufferedReader(BufferedReader buffered, String archivo) throws Exception{
		try {
			if (bufferReader != null)
				bufferReader.close();
		} catch (IOException e) {
			throw new CerrarReaderException(archivo);
		}
	
	}
*/
}
