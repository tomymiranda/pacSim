package Utilidad;

import java.io.File;

public class PathGenerator {
	private String getRoot() {
		String ruta = "";
		File directorio = new File(".");
		try {
			ruta = directorio.getCanonicalPath();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ruta;
	}
	
	public String getFilePath(String fileName) {
		return getRoot()+"/src/Archivos/"+fileName.toLowerCase()+".txt";
	}
}
