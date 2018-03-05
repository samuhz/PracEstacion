package Estacion;
import java.util.Scanner;

/**
 * Clase de prueba.
 * @author Samuel
 * @author Andrés 
 */

public class EstacionClimatica {

	private String nombre;
	private int año;
	private TempHumDia mediciones[]; //Tabla de mediciones
	private int nummediciones; // Número de mediciones almacenadas

	/**
	 * Constructor para objetos de la clase EstacionClimatica
	 */
	
	public EstacionClimatica() {
		this.nombre = "";
		this.año = 2000;
		mediciones = new TempHumDia[366]; // Por si el año es bisiesto.
		nummediciones = 0;
	}

	/**
	 * Constructor que inicializa el nombre y el año y llama al constructor por defecto
	 * @param nombre - representa el nombre de la estacion
	 * @param año - representa el año de la estacion
	 */
	
	public EstacionClimatica(String nombre, int año) {
		this(); 
		this.nombre = nombre;
		this.año = año;
	}

	/**
	 * Método AddDia, que recibe una fecha, una temperatura máxima y otra
	 * mínima, humedad máxima, humedad mínima y que, si el año de la fecha
	 * corresponde con el año de la estación, introduce el nuevo objeto en
	 * el vector. Si el año no corresponde con el de la estación dar un
	 * mensaje de
	 * error.
	 * @param media - representa una fecha, temperatura máxima y mínima, humedad máxima y mínima.
	 * @return devuelve verdadero si el numero es igual al año o error si no.
	 */
	
	public boolean addDia(TempHumDia media) {
		if (this.año == media.getAño()) {
			mediciones[nummediciones] = media;
			nummediciones++;
			return true;
		} else {
			System.out.println("ERROR. EL AÑO NO CORRRESPONDE CON EL DE LA ESTACION");
			return false;
		}
	}

	/**
	 * Método DelDia, que recibe una fecha y borra ese día si existen datos
	 * @param media - representa una fecha, temperatura máxima y mínima, humedad máxima y mínima.
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
	 * Metodo ListarDias, que te muestra en pantalla los datos de los días
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
	 * Método auxiliar que indica si una fecha es correcta.
	 * @param dia - representa el número de día
	 * @param mes - representa el número de mes
	 * @param año - representa el número de año
	 * @return devuelve verdadero si la fecha es correcta.
	 */

	static boolean fechaOK(int dia, int mes, int año) {
		return dia > 0 && dia <= 31 && mes > 0 && mes <= 12 && año > 1999 && año <= 2018;
	}
	
	/**
	 * Método que lee la medida del teclado.
	 * @return devuelve la medida.
	 */
	
	static TempHumDia leerMedida() {
		Scanner leer = new Scanner(System.in);
		int dia, mes, año, tempmax, tempmin, hummax, hummin;
		TempHumDia medicion = null;

		boolean error = true;
		do {
			System.out.println("Día:");
			dia = leer.nextInt();
			System.out.println("Mes:");
			mes = leer.nextInt();
			System.out.println("Año:");
			año = leer.nextInt();

			if (fechaOK(dia, mes, año)) {
				System.out.println(" Tº Máxima:");
				tempmax = leer.nextInt();
				System.out.println(" Tº Mínima:");
				tempmin = leer.nextInt();
				System.out.println(" Hº Máxima:");
				hummax = leer.nextInt();
				System.out.println(" Hº Mínima:");
				hummin = leer.nextInt();
				medicion = new TempHumDia(dia, mes, año, tempmax, tempmin, hummax, hummin);
				error = false;
			} else {
				System.out.println(" Fecha érronea");
			}

		} while (error);
		return medicion;
	}

	/**
	 * Programa principal de pruebas en el que se crea una estación, introduce cinco días
	 * pedidos por teclado (si la fecha no es correcta te la tiene que volver a pedir) y
	 * lista esos días. Luego borra dos (pedido por teclado y validandolo de nuevo) y los
	 * vuelve a listar.
	 */
	
	public static void main(String[] argv) {

		EstacionClimatica estación = new EstacionClimatica("Burgos", 2017);

		System.out.println(" Introducir 5 medidas :");

		for (int i = 0; i < 5; i++) {
			TempHumDia medicion = leerMedida();
			estación.addDia(medicion);
		}

		estación.listarDias();

		System.out.println("Introduca 2 medidas a Borrar:");
		TempHumDia medida1 = leerMedida();
		TempHumDia medida2 = leerMedida();

		estación.delDia(medida1);
		estación.delDia(medida2);

		estación.listarDias();

	}

}