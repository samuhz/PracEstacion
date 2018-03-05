package Estacion;
import java.util.Scanner;

/**
 * Clase de prueba.
 * @author Samuel
 * @author Andr�s 
 */

public class EstacionClimatica {

	private String nombre;
	private int a�o;
	private TempHumDia mediciones[]; //Tabla de mediciones
	private int nummediciones; // N�mero de mediciones almacenadas

	/**
	 * Constructor para objetos de la clase EstacionClimatica
	 */
	
	public EstacionClimatica() {
		this.nombre = "";
		this.a�o = 2000;
		mediciones = new TempHumDia[366]; // Por si el a�o es bisiesto.
		nummediciones = 0;
	}

	/**
	 * Constructor que inicializa el nombre y el a�o y llama al constructor por defecto
	 * @param nombre - representa el nombre de la estacion
	 * @param a�o - representa el a�o de la estacion
	 */
	
	public EstacionClimatica(String nombre, int a�o) {
		this(); 
		this.nombre = nombre;
		this.a�o = a�o;
	}

	/**
	 * M�todo AddDia, que recibe una fecha, una temperatura m�xima y otra
	 * m�nima, humedad m�xima, humedad m�nima y que, si el a�o de la fecha
	 * corresponde con el a�o de la estaci�n, introduce el nuevo objeto en
	 * el vector. Si el a�o no corresponde con el de la estaci�n dar un
	 * mensaje de
	 * error.
	 * @param media - representa una fecha, temperatura m�xima y m�nima, humedad m�xima y m�nima.
	 * @return devuelve verdadero si el numero es igual al a�o o error si no.
	 */
	
	public boolean addDia(TempHumDia media) {
		if (this.a�o == media.getA�o()) {
			mediciones[nummediciones] = media;
			nummediciones++;
			return true;
		} else {
			System.out.println("ERROR. EL A�O NO CORRRESPONDE CON EL DE LA ESTACION");
			return false;
		}
	}

	/**
	 * M�todo DelDia, que recibe una fecha y borra ese d�a si existen datos
	 * @param media - representa una fecha, temperatura m�xima y m�nima, humedad m�xima y m�nima.
	 * @return devuelve verdadero si se cumple la condicion.
	 */
	
	public boolean delDia(TempHumDia media) {
		for (int a = 0;a<this.mediciones.length;a++) {
			if(this.mediciones[a] != null) {
				
				if (this.mediciones[a].getDia() == media.getDia()) {
					this.mediciones[a] = null;
					nummediciones--;
					return true;
				}
			}
		}
	return false;
	}

	/**
	 * Metodo ListarDias, que te muestra en pantalla los datos de los d�as
	 * que hemos introducido: fecha, temperatura maxima, minima y media,
	 * humedad maxima, minima y media.
	 */
	
	public void listarDias() {
		for(int a = 0;a<this.mediciones.length;a++){
			if (this.mediciones[a] != null) {
				System.out.println(this.mediciones[a].toString());
			}
		}
    
	}

	/**
	 * M�todo auxiliar que indica si una fecha es correcta.
	 * @param dia - representa el n�mero de d�a
	 * @param mes - representa el n�mero de mes
	 * @param a�o - representa el n�mero de a�o
	 * @return devuelve verdadero si la fecha es correcta.
	 */

	static boolean fechaOK(int dia, int mes, int a�o) {
		return dia > 0 && dia <= 31 && mes > 0 && mes <= 12 && a�o > 1999 && a�o <= 2018;
	}
	
	/**
	 * M�todo que lee la medida del teclado.
	 * @return devuelve la medida.
	 */
	
	static TempHumDia leerMedida() {
		Scanner leer = new Scanner(System.in);
		int dia, mes, a�o, tempmax, tempmin, hummax, hummin;
		TempHumDia medicion = null;

		boolean error = true;
		do {
			System.out.println("D�a:");
			dia = leer.nextInt();
			System.out.println("Mes:");
			mes = leer.nextInt();
			System.out.println("A�o:");
			a�o = leer.nextInt();

			if (fechaOK(dia, mes, a�o)) {
				System.out.println(" T� M�xima:");
				tempmax = leer.nextInt();
				System.out.println(" T� M�nima:");
				tempmin = leer.nextInt();
				System.out.println(" H� M�xima:");
				hummax = leer.nextInt();
				System.out.println(" H� M�nima:");
				hummin = leer.nextInt();
				medicion = new TempHumDia(dia, mes, a�o, tempmax, tempmin, hummax, hummin);
				error = false;
			} else {
				System.out.println(" Fecha �rronea");
			}

		} while (error);
		return medicion;
	}

	/**
	 * Programa principal de pruebas en el que se crea una estaci�n, introduce cinco d�as
	 * pedidos por teclado (si la fecha no es correcta te la tiene que volver a pedir) y
	 * lista esos d�as. Luego borra dos (pedido por teclado y validandolo de nuevo) y los
	 * vuelve a listar.
	 */
	
	public static void main(String[] argv) {

		EstacionClimatica estaci�n = new EstacionClimatica("Burgos", 2017);

		System.out.println(" Introducir 5 medidas :");

		for (int i = 0; i < 5; i++) {
			TempHumDia medicion = leerMedida();
			estaci�n.addDia(medicion);
		}

		estaci�n.listarDias();

		System.out.println("Introduca 2 medidas a Borrar:");
		TempHumDia medida1 = leerMedida();
		TempHumDia medida2 = leerMedida();

		estaci�n.delDia(medida1);
		estaci�n.delDia(medida2);

		estaci�n.listarDias();

	}

}