import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un presupuesto para alicatado.
 * 
 * @author Daniel Val
 */

public class Presupuesto {
	private String cliente;
	private Double superficie;
	private List<Baldosa> ofertas;

	/**
	 * Constructor de la clase Presupuesto.
	 * 
	 * @param cliente    El cliente al que se le realiza el presupuesto.
	 * @param superficie La superficie a alicatar.
	 * @throws ObjetoErroneo Si el cliente es nulo o la superficie es negativa.
	 */

	public Presupuesto(String cliente, double superficie) throws ObjetoErroneo {
		setCliente(cliente);
		setSuperficie(superficie);
		ofertas = new ArrayList<>();
		if (this.cliente == null || this.superficie == null) {
			throw new ObjetoErroneo();
		}
	}

	/**
	 * Obtiene el cliente del presupuesto.
	 * 
	 * @return El cliente del presupuesto.
	 */

	public String getCliente() {
		return cliente;
	}

	/**
	 * Establece el cliente del presupuesto.
	 * 
	 * @param cliente El cliente del presupuesto.
	 */

	public void setCliente(String cliente) {
		if (cliente != null && cliente.trim().length() > 0) {
			this.cliente = cliente;
		}
	}

	/**
	 * Obtiene la superficie a alicatar del presupuesto.
	 * 
	 * @return La superficie a alicatar del presupuesto.
	 */

	public Double getSuperficie() {
		return superficie;
	}

	/**
	 * Establece la superficie a alicatar del presupuesto.
	 * 
	 * @param superficie La superficie a alicatar del presupuesto.
	 */

	public void setSuperficie(double superficie) {
		if (superficie > 0.0) {
			this.superficie = superficie;
		}
	}

	/**
	 * Obtiene las ofertas de baldosas del presupuesto.
	 * 
	 * @return Las ofertas de baldosas del presupuesto.
	 */

	public List<Baldosa> getOfertas() {
		return ofertas;
	}

	/**
	 * Añade una oferta de baldosa al presupuesto.
	 * 
	 * @param bal La baldosa a añadir.
	 * @return true si se añadió correctamente, false en caso contrario.
	 */

	public boolean anadeOfertas(Baldosa bal) {
		if (bal != null && ofertas.size() < 3 && !ofertas.contains(bal)) {
			ofertas.add(bal);
			return true;
		}
		return false;
	}

	/**
	 * Compara este presupuesto con el objeto especificado para igualdad.
	 * 
	 * Se comparan varios aspectos del presupuesto:
	 * 
	 * 1. Primero, se verifica si el objeto proporcionado es una referencia a este
	 * mismo presupuesto.
	 * 2. Luego, se verifica si el objeto es una instancia de la clase Presupuesto.
	 * 3. Después, se compara el cliente de este presupuesto con el cliente del
	 * otro.
	 * 4. A continuación, se compara la superficie a alicatar de este presupuesto
	 * con la del otro.
	 *
	 * @param obj El objeto a comparar.
	 * @return true si los objetos son iguales, false en caso contrario.
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Presupuesto)) {
			return false;
		}
		Presupuesto other = (Presupuesto) obj;
		if (cliente == null) {
			if (other.cliente != null) {
				return false;
			}
		} else if (!cliente.equals(other.cliente)) {
			return false;
		}
		if (superficie == null) {
			if (other.superficie != null) {
				return false;
			}
		} else if (!superficie.equals(other.superficie)) {
			return false;
		}
		return true;
	}

	/**
	 * @return Devuelve los parametros de Triangulo
	 */

	@Override
	public String toString() {
		String texto = "";
		int nbal;
		for (Baldosa baldosa : ofertas) {
			nbal = (int) (Math.round((Math.round(superficie / baldosa.getForma().superficie() + 0.5)) * 1.03 + 0.5));
			texto += "\n\t" + baldosa.toString() + "\n\t N�mero de baldosas: " + nbal + " Precio total "
					+ String.format(" %7.2f", nbal * baldosa.getPrecio());
		}
		return "Presupuesto  cliente=" + cliente + ", superficie a alicatar =" + superficie + "\n ofertas:" + texto;
	}
	/**
	 * Autores de la documentación del proyecto:
	 * @author Milad Al Chihabi
	 * @author Derek Casa
	 */
}
