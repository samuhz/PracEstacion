package Estacion;

/**
 * Clase TempDia.
 * @author Samuel
 * @author Andrés
 */

public class TempDia {
	protected int año;
	protected int mes;
	protected int dia;
	protected int tempMax;
	protected int tempMin;
	
	/**
	 * Constructor que inicializa la temperatura maxima y minima
	 */
	
	public TempDia(){
		this.tempMax = 0;
		this.tempMin = 0;
	}
	
	/**
	 * Segundo constructor que coge el valor que el usuario le de.
	 * @param año - representa el año
	 * @param mes - representa el mes
	 * @param dia - representa el día
	 * @param tempMax - representa la temperatura máxima
	 * @param tempMin - representa la temperatura mínima
	 */
	
	public TempDia(int año, int mes, int dia, int tempMax, int tempMin) {
		this.año = año;
		this.mes = mes;
		this.dia = dia;
		this.tempMax = tempMax;
		this.tempMin = tempMin;
	}
	
	/**
	 * Método que recibe el año
	 * @return devuelve el año
	 */
	
	public int getAño() {
		return año;
	}
	
	/**
	 * Método que recibe el día
	 * @return devuelve el día
	 */
	
	public int getDia() {
		return dia;
	}
	
	/**
	 * Método que devuelve los valores que hay introducidos en la tabla.
	 * @return devuelve los valores que hay introducidos en la tabla.
	 */
	
	@Override
	public String toString() {
		return "TempDia [año=" + año + ", mes=" + mes + ", dia=" + dia + ", tempMax=" + tempMax + ", tempMin=" + tempMin
				+ "]";
	}
	

}
