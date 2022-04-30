package JuegoVidaFinal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Juego {

	/**
	 * @author Shova Shrestha
	 */
	/**
	 * Este metodo lo usaremos para pasar la matriz tablaEnElFichero, a una más
	 * grande a la matriz matrizGrande Lo usaremos para centrar la matriz en el
	 *
	 * 
	 * @param matrizGrande
	 * @param tablaEnElFichero
	 */
	public static void introducirMatriz(int[][] matrizGrande, int[][] tablaEnElFichero) {
	
		//con ayuda de Carlos

		for (int i = 0; i < tablaEnElFichero.length; i++)
			for (int j = 0; j < tablaEnElFichero[0].length; j++)
				matrizGrande[i + ((matrizGrande.length - tablaEnElFichero.length) / 2)][j
						+ ((matrizGrande[0].length - tablaEnElFichero[0].length) / 2)] = tablaEnElFichero[i][j];

	}

	/**
	 * Este metodo la usaremos para el leer la matriz inicial y final
	 * 
	 * @param matriz
	 * @return
	 */
	public static int[][] leerMatriz(int[][] matriz) {
		for (int[] elem : matriz) {
			for (int u : elem) {
				if (u == 0)
					System.out.print(" ");
				else if (u == 1)
					System.out.print("*");
				else
					System.out.print(u);

				// System.out.print(" ");

			}
			System.out.println();
		}
		return matriz;

	}

	/**
	 * copiado de
	 * https://github.com/egibide-ciberseguridad/juego-de-la-vida/blob/main/Conway/src/main/java/com/jaureguialzo/Main.java
	 * 
	 * @return
	 */
	// inicio
	/**
	 * 
	 * @return
	 */

	public static int numCiclos() {

		// usaremos la clase BufferReader para leer el numero de ciclos que el usuario
		// quiere realizar
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Numero de ciclos: ");

		int numero = 2000;
		try {
			numero = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return numero;
	}
	// fin

	/**
	 * Metodo para comprobar los valores alrededor de un valor en concreto,
	 *  primero el de los valores centrales, porteriormente de los bordes y extremidades,
	 * puesto que estas no cumplen con las mismas normas que las centales, estas son
	 * especiales porque se salen de la longitud de la matriz
	 * 
	 * También haremos las comprobaciones de las reglas del juego
	 * Este metodo puede ser dividido en otros dos metodos, para que esté más 
	 * ordenado, en mi caso no lo he hecho.
	 * 
	 * @param matriz
	 * @param futuraGeneracion
	 */
	public static void futuraGeneracion(int[][] matriz, int[][] futuraGeneracion) {

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {

				int cont = 0;

				// comprobar cuantos valores tienen alrederor
				try {
					if (i > 0 && j > 0 && j < matriz.length - 1 && i < matriz.length - 1) {

						// estos son para comprobar con cont++(para usar más adelante)
						// cuantos valores tienen alredor de los valores centrales
						if (matriz[i][j + 1] == 1) {
							cont++;
						}
						if (matriz[i][j - 1] == 1) {
							cont++;
						}
						if (matriz[i + 1][j] == 1) {
							cont++;
						}
						if (matriz[i - 1][j] == 1) {
							cont++;
						}
						if (matriz[i - 1][j - 1] == 1) {
							cont++;
						}

						if (matriz[i - 1][j + 1] == 1) {
							cont++;
						}
						if (matriz[i + 1][j - 1] == 1) {
							cont++;
						}
						if (matriz[i + 1][j + 1] == 1) {
							cont++;
						}

						// System.out.println("libre " + cont);

					}

					// esquina superior inzquierda
					else if ((i - 1) == -1 && (j - 1) == -1) {
						if (matriz[i][j + 1] == 1) { // 1,2 derecha
							cont++;
						}

						if (matriz[i + 1][j + 1] == 1) { // 2,2 Inferior Derecho
							cont++;
						}
						if (matriz[i + 1][j] == 1) {// 0,1 arriba
							cont++;
						}
						// System.out.println("esq sup iz " + cont);
					}

					// esquina superior derecha

					else if ((i - 1) == -1 && (j + 1) == matriz.length) {

						if (matriz[i][j - 1] == 1) {// 1,0 izquierda
							cont++;
						}
						if (matriz[i + 1][j - 1] == 1) {// 2,0 Inferior izquierda
							cont++;
						}
						if (matriz[i + 1][j] == 1) {// 0,1 arriba
							cont++;
						}
						// System.out.println("esq sup derc " + cont);
					}

					// esquina inferior izquierdo
					else if ((i + 1) == matriz.length && (j - 1) == -1) {
						if (matriz[i - 1][j] == 1) {// 2,1 abajo
							cont++;
						}
						if (matriz[i - 1][j + 1] == 1) {// 0,0 Superior derecha
							cont++;
						}
						if (matriz[i][j + 1] == 1) { // 1,2 derecha
							cont++;
						}
						// System.out.println("esq inf izq " + cont);
					}
					// esquina inferior derecha
					else if ((i + 1) == matriz.length && (j + 1) == matriz.length) {
						if (matriz[i - 1][j] == 1) {// 2,1 abajo
							cont++;
						}
						if (matriz[i - 1][j - 1] == 1) {// 0,0 superior izquierda
							cont++;
						}
						if (matriz[i][j - 1] == 1) {// 1,0 izquierda
							cont++;
						}
						// System.out.println("esq inf derc " + cont);
					}
					// borde superior
					else if ((i - 1) == -1) {

						if (matriz[i][j - 1] == 1) {// 1,0 izquierda
							cont++;
						}
						if (matriz[i][j + 1] == 1) { // 1,2 derecha
							cont++;
						}
						if (matriz[i + 1][j - 1] == 1) {// 2,0 Inferior izquierda
							cont++;
						}
						if (matriz[i + 1][j] == 1) {// 0,1 arriba
							cont++;
						}
						if (matriz[i + 1][j + 1] == 1) { // 2,2 Inferior Derecho
							cont++;
						}
						// System.out.println("borde sup " + cont);
					}

					// borde inferior
					else if (i + 1 == matriz.length) {
						if (matriz[i][j + 1] == 1) { // 1,2 derecha
							cont++;
						}
						if (matriz[i][j - 1] == 1) {// 1,0 izquierda
							cont++;
						}
						if (matriz[i - 1][j + 1] == 1) {// 0,0 Superior derecha
							cont++;
						}
						if (matriz[i - 1][j] == 1) {// 2,1 abajo
							cont++;
						}
						if (matriz[i - 1][j - 1] == 1) {// 0,0 superior izquierda
							cont++;
						}
						// System.out.println("borde inf " + cont);
					}

					// borde derecho
					else if (j + 1 == matriz.length) {

						if (matriz[i - 1][j] == 1) {// 2,1 abajo
							cont++;
						}
						if (matriz[i - 1][j - 1] == 1) {// 0,0 superior izquierda
							cont++;
						}
						if (matriz[i][j - 1] == 1) {// 1,0 izquierda
							cont++;
						}
						if (matriz[i + 1][j - 1] == 1) {// 2,0 Inferior izquierda
							cont++;
						}
						if (matriz[i + 1][j] == 1) {// 2,0 Inferior izquierda
							cont++;
						}
						// System.out.println("borde dch " + cont);
					}
					// borde izquierdo
					else if (j - 1 == -1) {
						if (matriz[i - 1][j] == 1) {// 2,1 abajo
							cont++;
						}
						if (matriz[i - 1][j + 1] == 1) {// 2,1 abajo
							cont++;
						}
						if (matriz[i][j + 1] == 1) {// 2,1 abajo
							cont++;
						}
						if (matriz[i + 1][j + 1] == 1) {// 2,1 abajo
							cont++;
						}
						if (matriz[i + 1][j] == 1) {// 2,1 abajo
							cont++;
						}
						// System.out.println("borde izq " + cont);
					}

					// reglas del juego en el que usaremos la variable cont

					
					/**
					 * Cualquier célula con menos de 2 vecinos muere en la siguiente generación por
					 * soledad. 
					 * • Cualquier célula que tenga 2 ó 3 vecinos sobrevive en la siguiente
					 * generación. 
					 * • Cualquier célula con más de 3 vecinos muere en la siguiente
					 * generación por sobrepoblación. 
					 * 
					 * • En cualquier celda vacía que esté rodeada
					 * exactamente de 3 células, nace por “generación espontánea” una nueva célula
					 * en la generación siguiente
					 */
					if (matriz[i][j] == 1) {
						if (cont == 2 || cont == 3) {
							futuraGeneracion[i][j] = 1;
						} else {
							futuraGeneracion[i][j] = 0;
						}
					} else if (matriz[i][j] == 0) {
						if (cont == 3) {
							futuraGeneracion[i][j] = 1;
						} else {
							futuraGeneracion[i][j] = 0;
						}
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					throw e;
				}
				/*
				 * System.out.print("["+i+"]["+j+"]"+futuraGeneracion[i][j]+","+cont+" "); if
				 * (j==9)System.out.println();
				 */

			} // fin for
		} // fin for

		// pasamos a la siguiente generacion, la matriz pasará a ser la de la siguiente
		// generación
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {

				matriz[i][j] = futuraGeneracion[i][j];
			}

		}
	

	}

}
