/**
 * Clase abstracta que representa una figura geométrica de las tres
 * empleadas:
 * hexágono, triángulo y cuadrado y que implementa la interfaz
 * Dimensionable.
 * 
 * @author Daniel Val
 */
public abstract class Figura implements Dimensionable {
	/**
	 * El tamaño del lado de la figura.
	 */
	private Double lado;

	/**
	 * Constructor que inicializa la figura con un lado dado.
	 * 
	 * @param lado El tamaño del lado de la figura.
	 * @throws ObjetoErroneo Si el lado es nulo.
	 */
	public Figura(double lado) throws ObjetoErroneo {
		setLado(lado);
		if (this.lado == null) {
			throw new ObjetoErroneo();
		}
	}

	/**
	 * Obtiene el lado de la figura.
	 * 
	 * @return El tamaño del lado de la figura.
	 */
	public double getLado() {
		return lado;
	}

	/**
	 * Establece el tamaño del lado de la figura.
	 * 
	 * @param lado El lado de la figura.
	 */
	public void setLado(double lado) {
		if (lado > 0.0) {
			this.lado = lado;
		}
	}

	/**
	 * Devuelve una representación de la figura, indicando el tamaño de su lado con
	 * dos decimales de precisión.
	 * 
	 * @return Representación en cadena de la figura.
	 */
	@Override
	public String toString() {
		return "lado=" + String.format(" %5.2f", lado);
	}

	/**
	 * Calcula el código hash de la figura.
	 * 
	 * @return Código hash de la figura.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lado == null) ? 0 : lado.hashCode());
		return result;
	}

	/**
	 * Comprueba si esta figura es igual a otro objeto dado comprobando si es
	 * instancia de figura o no, si es otro tipo de objeto equivalente a ella o no.
	 * 
	 * @param obj Objeto con el que comparar.
	 * @return true si los objetos son iguales, false en caso contrario.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Figura)) {
			return false;
		}
		Figura other = (Figura) obj;
		if (lado == null) {
			if (other.lado != null) {
				return false;
			}
		} else if (!lado.equals(other.lado)) {
			return false;
		}
		if (!getClass().equals(obj.getClass())) {
			return false;
		}
		return true;
	}
	/**
	 * Autores de la documentación del proyecto:
	 * @author Milad Al Chihabi
	 * @author Derek Casa
	 */
}
