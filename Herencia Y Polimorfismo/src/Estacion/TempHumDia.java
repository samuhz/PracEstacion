package Estacion;

/**
 * Clase TempHumDia que extiende a TempDia
 * @author Samuel
 * @author Andres
 */

public class TempHumDia extends TempDia {
	private int humMax;
	private int humMin;

	/**
	 * Método que recibe los parámetros de la clase TempDia y añade humedad máxima y humedad mínima.
	 * @param año
	 * @param mes
	 * @param dia
	 * @param tempmax
	 * @param tempmin
	 * @param humMax
	 * @param humMin
	 */
	
	public TempHumDia(int año, int mes, int dia, int tempmax, int tempmin, int humMax, int humMin) {
		super(año, mes, dia, tempmax, tempmin);
		this.humMax=humMax;
		this.humMin=humMin;
					
	}

	/**
	 * Método que devuelve los valores que hay introducidos en la tabla.
	 * @return devuelve los valores que hay introducidos en la tabla.
	 */
	
	@Override
	public String toString() {
		return "TempHumDia [humMax=" + humMax + ", humMin=" + humMin + ", año=" + año + ", mes=" + mes + ", dia=" + dia
				+ ", tempMax=" + tempMax + ", tempMin=" + tempMin + "]";
	}
}
