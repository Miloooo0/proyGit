/**
 * Clase baldosa, que contiene la información para crear objetos
 * baldosa, modificar sus atributos, comparar objetos de la misma clase
 * y mostrarlos mediante un método toString
 * 
 * @author Daniel Val
 * 
 * Modificación para practica 0002
 */

public class Baldosa implements Cloneable {
	private String modelo;
	private Figura forma;
	private String color;
	private Double precio;

	/**
	 * Constructor de la clase Baldosa.
	 * 
	 * @param modelo Hace referencia al modelo.
	 * @param forma  Forma que hace referencia a la clase figura.
	 * @param color  Color de la baldosa.
	 * @param precio Precio de la baldosa.
	 * @throws ObjetoErroneo Si el modelo, la forma o el precio son nulos.
	 */

	public Baldosa(String modelo, Figura forma, String color, double precio) throws ObjetoErroneo {
		setModelo(modelo);
		setForma(forma);
		this.color = color;
		setPrecio(precio);
		if (this.modelo == null || this.forma == null || this.precio == null) {
			throw new ObjetoErroneo();
		}
	}

	/**
	 * Obtiene el modelo de la baldosa.
	 * 
	 * @return El modelo de la baldosa.
	 */

	public String getModelo() {
		return modelo;
	}

	/**
	 * Establece el modelo de la baldosa.
	 * 
	 * @param modelo El modelo de la baldosa.
	 */

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * Obtiene la forma de la baldosa.
	 * 
	 * @return La forma de la baldosa.
	 */

	public Figura getForma() {
		return forma;
	}

	/**
	 * Establece la forma de la baldosa.
	 * 
	 * @param forma La forma de la baldosa.
	 */

	public void setForma(Figura forma) {
		if (forma != null) {
			this.forma = forma;
		}
	}

	/**
	 * Obtiene el color de la baldosa.
	 * 
	 * @return El color de la baldosa.
	 */

	public String getColor() {
		return color;
	}

	/**
	 * Establece el color de la baldosa.
	 * 
	 * @param color El color de la baldosa.
	 */

	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Obtiene el precio de la baldosa.
	 * 
	 * @return El precio de la baldosa.
	 */

	public Double getPrecio() {
		return precio;
	}

	/**
	 * Establece el precio de la baldosa.
	 * 
	 * @param precio El precio de la baldosa.
	 */

	public void setPrecio(Double precio) {
		if (precio != null && precio > 0.0) {
			this.precio = precio;
		}
	}

	/**
	 * @return Devuelve los parametros de Baldosa
	 */

	@Override
	public String toString() {
		return "Modelo de baldosa=" + modelo + ", forma=" + forma + ", color=" + color + ", superficie="
				+ String.format("%7.2f", forma.superficie()) + ", precio=" + String.format("%7.2f", precio);
	}

	/**
	 * Compara esta baldosa con un objeto.
	 * Se comparan varias condiciones;
	 * 1. Primero, se verifica si el objeto proporcionado es una referencia a esta
	 * misma baldosa.
	 * 2. Luego, se verifica si el objeto es una instancia de la clase Baldosa.
	 * 3. Después, se compara el color de esta baldosa con el color de la otra
	 * 4. A continuación, se compara la forma de esta baldosa con la forma de la
	 * otra baldosa.
	 * 5. Por último, se compara el modelo de esta baldosa con el modelo de la otra
	 *
	 * 
	 * @param obj El objeto a comparar.
	 * @return true si los objetos son iguales, false en caso contrario.
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Baldosa)) {
			return false;
		}
		Baldosa other = (Baldosa) obj;
		if (color == null) {
			if (other.color != null) {
				return false;
			}
		} else if (!color.equals(other.color)) {
			return false;
		}
		if (forma == null) {
			if (other.forma != null) {
				return false;
			}
		} else if (!forma.equals(other.forma)) {
			return false;
		}
		if (modelo == null) {
			if (other.modelo != null) {
				return false;
			}
		} else if (!modelo.equals(other.modelo)) {
			return false;
		}

		return true;
	}

	/**
	 * Crea y devuelve una copia exacta de esta baldosa.
	 * 
	 * @return Copia esta baldosa.
	 * @throws CloneNotSupportedException Si la clonación sufre un fallo.
	 */

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Baldosa nueva = null;
		try {
			nueva = new Baldosa(this.modelo, this.forma, this.color, this.precio);
		} catch (ObjetoErroneo e) {
			// Como la baldosa existe la clonar� y este error no se dar�
			System.out.println("Error imposible al clonar");
		}
		return nueva;
	}
	/**
	 * Autores de la documentación del proyecto:
	 * @author Milad Al Chihabi
	 * @author Derek Casa
	 */
}
