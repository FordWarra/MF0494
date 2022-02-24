/**
 * 
 */
package uf2181;

/**
 * @author David
 *
 */
public class FuncionesDGT {

	/**
	 * Función que recibe un array de [x] tamaño y devuelve la media de los números que
	 * contiene este vector. Si el tamaño del vector es 0, salta una excepción.
	 * 
	 * @param puntos int [] Vector que recibe la función y contiene los valores a los que se hará la media
	 * @return suma double Devuelve la media de los puntos 
	 * @throws ArrayIndexOutOfBoundsException Excepción que salta cuando el vector introducido
	 * tiene tamaño de 0.
	 */
	public double mediaPuntos(int puntos[]) {
		double suma = 0;
		
		for (int i = 0; i < puntos.length; i++) {
			suma = suma +puntos[i];
		}
		if (puntos.length==0) throw new ArrayIndexOutOfBoundsException();
		return suma/puntos.length;
	}
	
	/**
	 * Función que devuelve la tasa máxima permitida según el tipo
	 * de conductor (General o Novel). Además el valor de la tasa máxima
	 * dependera de si la tasa calculada es en aire aspirado (True) o en sangre (False).
	 * 
	 * @param tipoConductor String Tipo de conductor (General o Novel)
	 * @param aire boolean Tipo de prueba (Aire aspirado -> True o Sangre -> False)
	 * @return tasa double Devuelve valor de la tasa máxima permitida según tipo de conductor y prueba utilizada para calcularla
	 */
	public double maximaTasaPermitida(String tipoConductor, boolean aire) {
		double tasa=0.25;
		if (tipoConductor.equalsIgnoreCase("General")) {
			if (aire) {
				tasa=0.25;
			} else {
				tasa=0.5;
			}
		} else {
			// profesionales y noveles
			if (aire) {
				tasa=0.15;
			} else {
				tasa=0.3;
			}
		}
		return tasa;
	}

	
}
