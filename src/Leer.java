import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

/**
 * Clase para leer diferentes tipos de datos desde la entrada estándar,
 * sustituyendo a la clase Scanner.
 * 
 * @author Daniel Val
 */

public class Leer {

	/**
	 * Lee un entero desde la entrada estándar.
	 * 
	 * @param texto El texto que se mostrará al solicitar la entrada.
	 * @return El entero leído desde la entrada de la cadena.
	 */

	public static int entero(String texto) {
		int valor;
		String var;
		while (true) {
			var = cadena(texto);
			try {
				valor = Integer.parseInt(var);
				return valor;
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("Error de datos");
			}
		}
	}

	/**
	 * Lee una cadena de texto desde la entrada estándar.
	 * 
	 * @param texto El texto que se mostrará al solicitar la entrada.
	 * @return La cadena de texto leída desde la entrada estándar.
	 */

	public static String cadena(String texto) {
		Scanner teclado = new Scanner(System.in);
		String valor;
		System.out.println(texto);
		valor = teclado.nextLine();
		return valor;
	}

	/**
	 * Lee una cadena de texto desde la entrada estándar que coincida con una
	 * expresión regular dada.
	 * 
	 * @param regex La expresión regular con la que debe coincidir el texto de
	 *              entrada.
	 * @param texto El texto que se mostrará al solicitar la entrada.
	 * @return La cadena de texto leída desde la entrada estándar que coincide con
	 *         la expresión regular.
	 */

	public static String cadena(String regex, String texto) {
		Scanner teclado = new Scanner(System.in);
		String valor;
		System.out.println(texto);
		valor = teclado.nextLine();
		try {
			while (!valor.matches(regex)) {
				System.out.println(texto);
				valor = teclado.nextLine();
			}
		} catch (PatternSyntaxException e) {
			// TODO Auto-generated catch block
			System.out.println(regex + " No es una expresi�n regular");
			return null;
		}
		return valor;
	}

	/**
	 * Lee un número real desde la entrada estándar.
	 * 
	 * @param texto El texto que se mostrará al solicitar la entrada.
	 * @return El real leído desde la entrada de la cadena.
	 */

	public static float real(String texto) {
		float valor;
		String var;
		while (true) {
			var = cadena(texto);
			try {
				valor = Float.parseFloat(var);
				return valor;
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("Error de datos reales");
			}
		}

	}

	/**
	 * Lee un número de punto flotante de doble precisión desde la entrada estándar.
	 * 
	 * @param texto El texto que se mostrará al solicitar la entrada.
	 * @return El número de punto flotante de doble precisión leído desde la entrada
	 *         estándar.
	 */

	public static double doble(String texto) {
		double valor;
		String var;
		while (true) {
			var = cadena(texto);
			try {
				valor = Double.parseDouble(var);
				return valor;
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("Error en los datos tecleados");
			}
		}
	}

	/**
	 * Muestra un menú y lee la opción seleccionada desde la entrada estándar.
	 * 
	 * @param menu El array que contiene las opciones del menú.
	 * @return La opción seleccionada del menú en el rango de 0 a n (opciones del
	 *         menú).
	 */

	public static int menu(String[] menu) {
		int opcion = -1;
		for (int i = 1; i < menu.length; i++) {
			System.out.println(i + ".-" + menu[i]);
		}
		System.out.println("0.-" + menu[0]);
		while (opcion < 0 || opcion >= menu.length) {
			opcion = entero("Elije opci�n");
		}
		return opcion;
	}
	/**
	 * Autores de la documentación del proyecto:
	 * @author Milad Al Chihabi
	 * @author Derek Casa
	 */
}
