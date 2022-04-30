package JuegoVidaFinal;

import java.util.Scanner;

public class ProbarJuevoVida {

	public class ProbarJuegoVida {

		private static final int longitud = 10;
		static Scanner leer = new Scanner(System.in);

		public static void main(String[] args) {
			String RUTA = " ";
			final String RUTAFutura = "/home/sofia/Escritorio/juegovifa/matrizFinal.csv";

			//insertar por consola la ruta del fichero
			System.out.println("Inserte la ruta del fichero que quiere abrir");
			RUTA = leer.nextLine();
			
			//matrices a usar para los metodos
			int[][] matriz = documentoCsv.leerDeFichero(RUTA);
			int[][] matrizMasGrande = new int[longitud][longitud];
			int[][] futuraGeneracion = new int[longitud][longitud];
			
			//pasar la matriz de longitud 3 a una de 10 y poner la matriz en el centro de la matrizMasGrande
			Juego.introducirMatriz(matrizMasGrande, matriz);

			// Mostrar LA MATRIZ
			System.out.println("Estado inicial: ");
			//Juego.leerMatriz(matriz);
			Juego.leerMatriz(matrizMasGrande);
			
			// Pedir al usuario el numero de ciclos a repetir
			int ciclos = Juego.numCiclos();
			System.out.println();

		
			// Actualizar LA MATRIZ
			try {
				for (int i = 0; i < ciclos; i++) {
					System.out.format("Ciclo: %d%n", i + 1);
					
					Juego.futuraGeneracion(matrizMasGrande, futuraGeneracion);
					Juego.leerMatriz(matrizMasGrande);
				

				}
			} catch (java.lang.ArrayIndexOutOfBoundsException e) {
				throw e;
			}

			//guardaremos la futurageneracion en un fichero
			documentoCsv.escribirAFichero(futuraGeneracion, RUTAFutura);
			leer.close();//cerramos el scanner
///home/sofia/Escritorio/juegovifa/matrizLeer.csv
		}
	}
}
