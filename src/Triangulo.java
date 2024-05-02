/**
 * Clase que representa un triángulo equilátero.
 * 
 * @author Daniel Val
 */
public class Triangulo extends Figura implements Dimensionable {

	/**
	 * Constructor de la clase Triangulo.
	 * 
	 * @param lado El lado del triángulo equilátero.
	 * @throws ObjetoErroneo Si el lado es nulo o negativo.
	 */

	public Triangulo(double lado) throws ObjetoErroneo {
		super(lado);
	}

	/**
	 * Calcula la superficie del triángulo equilátero.
	 * 
	 * @return La superficie del triángulo equilátero.
	 */

	@Override
	public Double superficie() {
		// TODO Auto-generated method stub
		return super.getLado() * super.getLado() * Math.sqrt(3) / 4;
	}

	/**
	 * Calcula la longitud del triángulo equilátero.
	 * 
	 * @return La longitud del triángulo equilátero.
	 */
	@Override
	public Double longitud() {
		// TODO Auto-generated method stub
		return super.getLado() * 3;
	}

	/**
	 * @return Devuelve los parametros de Triangulo
	 */

	@Override
	public String toString() {
		return "Tri�ngulo " + super.toString();
	}
	/**
	* Autores de la documentación del proyecto:
	* @author Milad Al Chihabi
	* @author Derek Casa
	*/
}
