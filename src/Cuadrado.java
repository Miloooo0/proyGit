/**
 * Clase hija de figura que hace referencia a un cuadrado.
 * 
 * @author Daniel Val
 */
public class Cuadrado extends Figura implements Dimensionable {
	/**
	 * Constructor de la clase Cuadrado.
	 * 
	 * @param lado El lado del cuadrado.
	 * @throws ObjetoErroneo Si el lado es nulo o negativo.
	 */

	public Cuadrado(double lado) throws ObjetoErroneo {
		super(lado);
	}

	/**
	 * Calcula la superficie del cuadrado.
	 * 
	 * @return La superficie del cuadrado.
	 */

	@Override
	public Double superficie() {
		// TODO Auto-generated method stub
		return super.getLado() * super.getLado();
	}

	/**
	 * Calcula la longitud del cuadrado.
	 * 
	 * @return La longitud del cuadrado.
	 */
	@Override
	public Double longitud() {
		// TODO Auto-generated method stub
		return super.getLado() * 4;
	}

	/**
	 * @return Devuelve los parametros de cuadrado llamando al método toString de la
	 *         clase padre
	 */

	@Override
	public String toString() {
		return "Cuadrado " + super.toString();
	}
	
	/**
	 * Autores de la documentación del proyecto:
	 * @author Milad Al Chihabi
	 * @author Derek Casa
	 */
}
