/**
 * Clase que representa un hexágono regular.
 * 
 * @author Daniel Val
 */

public class Hexagono extends Figura implements Dimensionable {

	/**
	 * Constructor de la clase Hexagono.
	 * 
	 * @param lado El lado del hexágono regular.
	 * @throws ObjetoErroneo Si el lado es nulo o negativo.
	 */

	public Hexagono(double lado) throws ObjetoErroneo {
		super(lado);
	}

	/**
	 * Calcula la superficie del hexágono regular.
	 * 
	 * @return La superficie del hexágono regular.
	 */

	@Override
	public Double superficie() {
		// TODO Auto-generated method stub
		return super.getLado() * super.getLado() * Math.sqrt(3) * 3 / 2;
	}

	/**
	 * Calcula la longitud del hexágono regular.
	 * 
	 * @return La longitud del hexágono regular.
	 */

	@Override
	public Double longitud() {
		// TODO Auto-generated method stub
		return super.getLado() * 6;
	}

	/**
	 * @return Devuelve los parametros de Hexagono
	 */

	@Override
	public String toString() {
		return "Hex�gono " + super.toString();
	}

	/**
	 * Autores de la documentación del proyecto:
	 * @author Milad Al Chihabi
	 * @author Derek Casa
	 */
}
