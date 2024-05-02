/**
 * Interfaz que define comportamiento para objetos dimensionables.
 * 
 * @author Daniel Val
 */

public interface Dimensionable {
	/**
	 * Calcula la superficie del objeto dimensionable.
	 * 
	 * @return La superficie del objeto dimensionable.
	 */
	public default Double superficie() {
		return null;
	}

	/**
	 * Calcula la longitud del objeto dimensionable.
	 * 
	 * @return La longitud del objeto dimensionable.
	 */
	public default Double longitud() {
		return null;
	};

	/**
	 * Autores de la documentación del proyecto:
	 * @author Milad Al Chihabi
	 * @author Derek Casa
	 */
}
