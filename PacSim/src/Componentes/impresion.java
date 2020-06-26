package Componentes;

public class impresion {

	
	public static void main(String[] arg) {

		imprimir();
		
	}

	private static void imprimir(){
		int matriz[][] = new int[2][2]; 
		matriz[0][0] = 1;
		matriz[0][1] = 2;
		matriz[1][0] = 3;
		matriz[1][1] = 4;
		
		for(int i = 0; i < matriz.length; i++){
			for(int j = 0; j< matriz.length; j++){
				System.out.print(matriz[i][j] + "\t");
				
			}
			System.out.print("\n");
		}
		
	}
	
	
}
