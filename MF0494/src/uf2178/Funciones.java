package uf2178;

import java.util.Scanner;

public class Funciones {
	
	/** 
	 * Método de la clase que pide un vector por teclado
	 * @param v int[] el vector a introducir por teclado
	 */
	public static void  pedir_vector(int v[]) {
		Scanner entrada = new Scanner(System.in);
		
		for (int i = 0; i < v.length; i++) {
			System.out.printf("Introduce el elemento %d: ", i);
			v[i] = entrada.nextInt();
		}
		
		
	}
	
	

	/**
	 * Método para mostrar por pantalla el vector pasado como parámetro
	 * @param v int [] el vector a mostrar en pantalla
	 */
	public static void  mostrar_vector(int v[]) {
		for (int i = 0; i < v.length; i++) {
			System.out.printf("%3d ", v[i]);
		}
		System.out.println();
	}
	
	public static void calculaSancion(double tasa) {
		String mensaje;
		if (tasa<0.25)
			mensaje = "Sin sanción";
		else if (tasa>=0.25 && tasa<0.50)
			mensaje = "500€ y pérdida de 4 puntos";
		else if (tasa>=0.50 && tasa<0.60)
			mensaje = "1000€ y pérdida de 6 puntos";
		else
			mensaje = "Retirada del carnet y de 3 a 6 meses de cárcel";
		
		System.out.println("El conductor con tasa de alcoholemia "+tasa+" tiene la "
				+ "sanción "+mensaje);
		
		
	}
	
	
	public static void restaPuntos(int v1[], int v2[]) {
		
		for (int i = 0; i < v1.length; i++) {
			v1[i]-=v2[i];
			if (v1[i] < 0)
				v1[i] = 0;
			
		}
			
		
	} 
	
	
	// Escribe las sentencias de los apartados 1 y 2

}
