import java.util.ArrayList;
import java.util.List;

/**
 * Clase Pepe Gotera, en la que se podrán realizar diferentes
 * operaciones para para presupuestar los proyectos de alicatado que se
 * soliciten.
 * 
 * @author Daniel Val
 */

public class PepeGotera {

	/**
	 * @param args No empleado
	 */

	public static void main(String[] args) {
		List<Baldosa> catalogo = new ArrayList<>(); // Lista del catálogo de baldosas
		List<Presupuesto> pedidos = new ArrayList<>(); // Lista de pedidos
		/**
		 * Menu que contiene las operaciones que se pueden realizar
		 * Salir: Sale del programa
		 * Alta Baldosa: Añadir un tipo de baldosa nuevo
		 * Baja Baldosa: Eliminar un tipo de baldosa existente
		 * Modificacion Baldosa: Permite modificar parámetros de las baldosas
		 * existentes, como su color, forma o tramaño
		 * Listado de Baldosas: Muestra un listado de las baldosas existentes
		 * Crea presupuesto: Crea un presupuesto tras la elección de las baldosas
		 * Añade baldosa a presupuesto: Permite añadir más baldosas al presupuesto ya
		 * existente
		 * Lista presupuestos: Muestra los presupuestos ofrecidos
		 * Explicación a detalle de cada una de las opciones en sus métodos
		 * correspondientes.
		 */
		final String[] MENU = { "Salir", "Alta baldosa", "Baja baldosa", "Modificaci�n baldosas", "Listado de baldosas",
				"Crea presupuesto", "A�ade baldosa a presupuesto", "Lista presupuestos" };
		/**
		 * Array que contiene los diferentes tipos de posibles figuras para las baldosas
		 * o la opción de Salir.
		 */
		final String[] FIGURA = { "Salir", "Tri�ngulo", "Cuadrado", "Hex�gono" };
		int opcion = -1, pos;
		String cliente;
		double superficie;
		Baldosa b = null;
		Presupuesto p = null;
		while (opcion != 0) {
			switch (opcion) {
				case 1:
					creaBaldosa(catalogo, FIGURA);
					break;
				case 2:
					pos = selecciona(catalogo, " a borrar");
					b = catalogo.remove(pos);
					System.out.println("Baldosa borrada " + b);
					break;
				case 3:
					modificaBaldosa(catalogo, FIGURA);
					break;
				case 4:
					imprimeBaldosas(catalogo);
					break;
				case 5:
					cliente = Leer.cadena("Nombre del cliente");
					superficie = Leer.doble("Superficie a alicatar");
					try {
						p = new Presupuesto(cliente, superficie);
						pedidos.add(p);
					} catch (ObjetoErroneo e) {
						System.out.println("Datos err�neos para elaborar un presupuesto");
					}
					break;
				case 6:
					pos = seleccionaPre(pedidos, " a a�adir baldosas");
					p = pedidos.get(pos);
					System.out.println(p);
					pos = selecciona(catalogo, " a a�adir");
					b = catalogo.get(pos);
					if (p.anadeOfertas(b)) {
						System.out.println("Baldosa a�adida correctamente");
					} else {
						System.out.println("No se puede a�adir la baldosa");
					}
					break;
				case 7:
					for (Presupuesto pre : pedidos) {
						System.out.println(pre + "\n-------");
					}
					break;
			}
			opcion = Leer.menu(MENU);
		}
		System.out.println("FIN DE PROGRAMA");
	}

	public static int selecciona(List<Baldosa> cat, String texto) {
		int pos = -1;
		imprimeBaldosas(cat);
		while (pos < 0 || pos > cat.size() - 1) {
			pos = Leer.entero("Selecciona la baldosa" + texto);
		}
		return pos;
	}

	/**
	 * Método para imprimir la lista de baldosas.
	 * 
	 * @param cat Lista de baldosas.
	 */
	private static void imprimeBaldosas(List<Baldosa> cat) {
		for (int i = 0; i < cat.size(); i++) {
			System.out.println(i + " " + cat.get(i).toString());
		}
	}

	/**
	 * Método para seleccionar un presupuesto de una lista de presupuestos.
	 * 
	 * @param pre   Lista de presupuestos.
	 * @param texto Texto que se mostrará al solicitar la selección del presupuesto.
	 * @return La posición del presupuesto seleccionado en la lista.
	 */
	public static int seleccionaPre(List<Presupuesto> pre, String texto) {
		int pos = -1;
		for (int i = 0; i < pre.size(); i++) {
			System.out.println(i + " " + pre.get(i).getCliente() + " superficie "
					+ String.format(" %7.2f", pre.get(i).getSuperficie()));
		}
		while (pos < 0 || pos > pre.size() - 1) {
			pos = Leer.entero("Selecciona el presupuesto" + texto);
		}
		return pos;
	}

	/**
	 * Método para crear una nueva baldosa y añadirla al catálogo.
	 * 
	 * @param catalogo Lista con el catálogo de las baldosas existentes.
	 * @param FIGURA   Lista con los tipos de figura disponibles para las baldosas
	 *                 (cuadrada, hexagonal o triangular).
	 */
	public static void creaBaldosa(List<Baldosa> catalogo, String[] FIGURA) {
		int opcion = -1;
		String modelo, color;
		double precio, lado;
		Baldosa b = null;
		Figura forma = null;

		// Se solicitan los datos necesarios para crear la baldosa
		modelo = Leer.cadena("Modelo de la baldosa");
		color = Leer.cadena("Color de la baldosa");
		precio = Leer.doble("Precio de la baldosa");
		lado = Leer.doble("Longitud del lado");
		opcion = -1;

		// Se solicita al usuario que seleccione el tipo de figura de la baldosa
		while (opcion < 0 || opcion > 3) {
			opcion = Leer.menu(FIGURA);
		}
		try {
			switch (opcion) {
				case 1:
					forma = new Triangulo(lado);
					break;
				case 2:
					forma = new Cuadrado(lado);
					break;
				case 3:
					forma = new Hexagono(lado);
					break;
			}
			b = new Baldosa(modelo, forma, color, precio);
			if (catalogo.contains(b)) {
				System.out.println("La baldosa ya existe");
			} else {
				catalogo.add(b);
			}
		} catch (ObjetoErroneo e) {
			System.out.println("Hay errores en la forma de la baldosa");
		}
	}

	/**
	 * Este método permite al usuario modificar los atributos de una baldosa
	 * existente en el catálogo, incluyendo su forma, modelo, color y precio.
	 * 
	 * Se utiliza el método selecciona para solicitar al usuario que seleccione la
	 * baldosa que desea modificar, se clona la baldosa seleccionada para trabajar
	 * con una copia y así no modificar directamente la baldosa original.
	 * 
	 * Se muestra la información de la baldosa y se solicita al usuario que
	 * introduzca los nuevos datos. Si el usuario presiona Enter sin ingresar nada,
	 * se mantiene el valor existente.
	 * 
	 * @param catalogo Lista con el catalogo de las baldosas existentes
	 * @param FIGURA   Lista con el tipo de figura, cuadrada, hexagonal o triangular
	 */
	public static void modificaBaldosa(List<Baldosa> catalogo, String[] FIGURA) {
		/**
		 * Opcion: Variable entera utilizada para almacenar la opción seleccionada por
		 * el usuario
		 * Pos: Variable entera que almacena la posición de la baldosa que se va a
		 * modificar en el catálogo
		 * Modelo, color, precio, lado: Variables que almacenan los datos modificados de
		 * la baldosa
		 * b: Una instancia de Baldosa que representa la baldosa que se va a modificar
		 * Forma: Una instancia de Figura que representa la forma de la baldosa.
		 */

		int opcion = -1, pos;
		String modelo, color;
		double precio, lado;
		Baldosa b = null;
		Figura forma = null;

		pos = selecciona(catalogo, " a modificar");
		try {
			b = (Baldosa) catalogo.get(pos).clone();
			System.out.println(b + "\n Con Intro se valida el valor existente");
			modelo = Leer.cadena("Modelo de la baldosa");
			if (!modelo.equals("")) {
				b.setModelo(modelo);
			}
			color = Leer.cadena("Color de la baldosa");
			if (!modelo.equals("")) {
				b.setColor(color);
			}
			precio = Leer.doble("Precio de la baldosa");
			if (precio > 0.0) {
				b.setPrecio(precio);
			}
			lado = Leer.doble("Longitud del lado");
			if (lado == 0.0) {
				lado = b.getForma().getLado();
			}
			opcion = -1;
			while (opcion < 0 || opcion > 3) {
				opcion = Leer.menu(FIGURA);
			}
			try {
				switch (opcion) {
					case 0:
						forma = b.getForma();
						forma.setLado(lado);
					case 1:
						forma = new Triangulo(lado);
						break;
					case 2:
						forma = new Cuadrado(lado);
						break;
					case 3:
						forma = new Hexagono(lado);
						break;
				}
				b.setForma(forma);
				if (catalogo.indexOf(b) == pos || catalogo.indexOf(b) == -1) {
					catalogo.set(pos, b);
				} else {
					System.out.println("La baldosa ya existe");
				}
			} catch (ObjetoErroneo e) {
				System.out.println("Hay errores en la forma de la baldosa");
			}
		} catch (CloneNotSupportedException e) {
			System.out.println("Error al clonar");
		}
	}
	/**
	 * Autores de la documentación del proyecto:
	 * @author Milad Al Chihabi
	 * @author Derek Casa
	 */
}
