/**
 * 
 */
package uf2178;

import java.util.Scanner;

/**
 * @author 
 *
 */
public class Ppal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Funciones f = new Funciones();
		
		// Escribe aquí las sentencias del apartado 3
		Scanner teclado = new Scanner(System.in);
		double tasa;
		int puntos[] = new int [6];
		int sanciones[] = new int [6];
		System.out.println("Introduce la tasa de alcoholemia de un conductor: ");
		tasa = teclado.nextDouble();
		f.calculaSancion(tasa);
		
		System.out.println("\n**************INTRODUCE VALORES**************\n");
		System.out.println("*******PUNTOS*******");
		f.pedir_vector(puntos);
		
		
		System.out.println("\n*******SANCIONES*******");
		f.pedir_vector(sanciones);
		
		
		System.out.println("\n**************MOSTRANDO VALORES**************\n");
		System.out.println("*******PUNTOS*******");
		f.mostrar_vector(puntos);
		System.out.println("\n*******SANCIONES*******");
		f.mostrar_vector(sanciones);
		
		System.out.println("\n*******PUNTOS RESTADOS*******");
		f.restaPuntos(puntos,sanciones);
		f.mostrar_vector(puntos);
		
		
	}

}
