package Tarea1;

import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Translator {
	public static void main(String[] args) throws Exception {
		try {
			String num;
			int numeros;
			String decimal = "", letra = "", lineaBraile = "", linea = "", lineaUnica = "", traduccionABraille = "", traduccionADecimal = "";
			// Inicialización de la fila y del archivo resultante
			File archivo = new File(
					"C:\\Users\\Factor-Gx\\workspace\\Base de Datos\\src\\Tarea1\\braille.in");
			FileReader archNumeros = new FileReader(archivo);
			PrintStream archResultados = new PrintStream(
					"C:\\Users\\Factor-Gx\\workspace\\Base de Datos\\src\\Tarea1\\resultado.txt");
			// Inicialización del Scanner
			Scanner scanArchivo = new Scanner(archNumeros);
			StringTokenizer stk;
			// La lectura se terminará cuando encuentre un 0 en la siguiente
			// línea
			while (!scanArchivo.hasNext("0")) {
				num = scanArchivo.nextLine();
				numeros = Integer.parseInt(num);
				letra = scanArchivo.nextLine();
				// Si la letra es igual a S hará lo siguiente
				if (letra.equals("S")) {
					decimal = scanArchivo.nextLine();
					traduccionABraille = BrailleSystem
							.translateDecimaltoBraille(decimal, numeros);
					stk = new StringTokenizer(traduccionABraille, " ");
					/*
					 * Matriz: la matriz tendrá filas igual al número del
					 * archivo y tendrá 3 columnas, debido a que el lenguaje
					 * braille posee 3 filas siempre, el objetivo de esta matriz
					 * es dejar al braille escrito en una sola línea
					 */
					String[][] brailleOrdenado = new String[numeros][3];
					for (int i = 0; i < numeros; i++) {
						for (int j = 0; j < 3; j++) {
							brailleOrdenado[i][j] = stk.nextToken();
						}
					}
					// Iteración para imprimir el braille en el archivo
					// resultante
					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < numeros; j++) {
							archResultados.print(brailleOrdenado[j][i] + " ");
						}
						archResultados.println();
					}
					// Si la letra que recibe es B hará lo siguiente:
				} else if (letra.equals("B")) {
					/*
					 * La matriz tendrá filas igual a el número recibido y una
					 * sola columna el objetivo de esta matriz es el de dejar el
					 * braille escrito en una sola línea
					 */
					String[][] braille = new String[numeros][1];
					// Iteración que deja el braille escrito en una sola línea
					for (int i = 0; i < 3; i++) {
						lineaBraile = scanArchivo.nextLine();
						// StringTokenizer para separar los espacios que posee
						// la línea leída
						stk = new StringTokenizer(lineaBraile, " ");
						for (int j = 0; j < numeros; j++) {
							linea = stk.nextToken();
							braille[j][0] += linea;
						}
					}
					// Iteración para escribir todo el braille en una sola línea
					// para luego proceder a traducirla
					for (int i = 0; i < numeros; i++) {
						lineaUnica += braille[i][0] + " ";
					}
					traduccionADecimal = BrailleSystem
							.translateBrailletoDecimal(lineaUnica);
					archResultados.println(traduccionADecimal);
					// Limpiar la variable lineaUnica para ser reutilizada
					// despúes en la iteración
					lineaUnica = "";
				}
			}
		} catch (Exception e) {
			System.err.println("Archivo no encontrado");
		}
	}
}
