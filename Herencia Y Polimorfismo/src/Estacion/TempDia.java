package Estacion;

/**
 * Clase TempDia.
 * @author Samuel
 * @author Andr�s
 */

public class TempDia {
	protected int a�o;
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
	 * @param a�o - representa el a�o
	 * @param mes - representa el mes
	 * @param dia - representa el d�a
	 * @param tempMax - representa la temperatura m�xima
	 * @param tempMin - representa la temperatura m�nima
	 */
	
	public TempDia(int a�o, int mes, int dia, int tempMax, int tempMin) {
		this.a�o = a�o;
		this.mes = mes;
		this.dia = dia;
		this.tempMax = tempMax;
		this.tempMin = tempMin;
	}
	
	/**
	 * M�todo que recibe el a�o
	 * @return devuelve el a�o
	 */
	
	public int getA�o() {
		return a�o;
	}
	
	/**
	 * M�todo que recibe el d�a
	 * @return devuelve el d�a
	 */
	
	public int getDia() {
		return dia;
	}
	
	/**
	 * M�todo que devuelve los valores que hay introducidos en la tabla.
	 * @return devuelve los valores que hay introducidos en la tabla.
	 */
	
	@Override
	public String toString() {
		return "TempDia [a�o=" + a�o + ", mes=" + mes + ", dia=" + dia + ", tempMax=" + tempMax + ", tempMin=" + tempMin
				+ "]";
	}
	

}
