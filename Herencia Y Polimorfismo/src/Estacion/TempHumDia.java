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
	 * M�todo que recibe los par�metros de la clase TempDia y a�ade humedad m�xima y humedad m�nima.
	 * @param a�o
	 * @param mes
	 * @param dia
	 * @param tempmax
	 * @param tempmin
	 * @param humMax
	 * @param humMin
	 */
	
	public TempHumDia(int a�o, int mes, int dia, int tempmax, int tempmin, int humMax, int humMin) {
		super(a�o, mes, dia, tempmax, tempmin);
		this.humMax=humMax;
		this.humMin=humMin;
					
	}

	/**
	 * M�todo que devuelve los valores que hay introducidos en la tabla.
	 * @return devuelve los valores que hay introducidos en la tabla.
	 */
	
	@Override
	public String toString() {
		return "TempHumDia [humMax=" + humMax + ", humMin=" + humMin + ", a�o=" + a�o + ", mes=" + mes + ", dia=" + dia
				+ ", tempMax=" + tempMax + ", tempMin=" + tempMin + "]";
	}
}
