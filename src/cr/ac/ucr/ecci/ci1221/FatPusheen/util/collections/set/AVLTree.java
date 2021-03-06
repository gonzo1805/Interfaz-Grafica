package cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.set;

import javax.swing.JOptionPane;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Iterator;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.stack.Stack;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.stack.StackArray;

public class AVLTree<T extends Comparable> implements Conjunto<T> {

	/**
	 * Atributo donde estara guardado la raiz del arbol binario de busqueda
	 */
	Nodo<T> raiz;

	/**
	 * Contructor del arbol binario de busqueda
	 * 
	 * @param raiz
	 *            lo que sera la raiz del nuevo arbol
	 */
	public AVLTree(T raiz) {
		this.raiz = new Nodo<T>(raiz);
		this.raiz.padre = null;
		this.raiz.altura = 1;
	}

	/**
	 * Une todos los datos no repetidos de los conjuntos A y B y lo retorna en
	 * uno tercero
	 * 
	 * @param A
	 *            conjunto a unir
	 * @param B
	 *            conjunto a unir
	 * @return el conjunto con la union de todos los datos no repetidos de los
	 *         conjuntos A y B
	 */
	@Override
	public Conjunto<T> union(Conjunto<T> A, Conjunto<T> B) {
		if (A.isEmpty() == true && B.isEmpty() == true) {// Si alguno o ambos
			// conjuntos estan vacios, devuelve el que no o un error,
			// respectivamente
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("Ambas listas estan vacias");
			throw f;
		} else if (A.isEmpty() == true) {
			return B;
		} else if (B.isEmpty() == true) {
			return A;
		}

		Iterator<T> itA = A.iterator();// Iterador de A
		Conjunto<T> resultado = new BinarySearchTree<T>(itA.next());// Nuevo
																	// arbol

		while (itA.hasNext()) {// A�ade todo A al nuevo arbol
			resultado.add(itA.next());
		}

		Iterator<T> itB = B.iterator();// Iterador de B

		while (itB.hasNext()) {// Busca los datos en B que no estan en resultado
								// y los inserta
			T dato = itB.next();
			if (!resultado.contains(dato)) {
				resultado.add(dato);
			}
		}
		return resultado;// Retorna el nuevo arbol
	}

	/**
	 * Interseca los datos de los conjuntos A y B y los retorna en un tercer
	 * conjunto, la interseccion son los datos que estan en el cconjunto A y al
	 * mismo tiempo en el B
	 * 
	 * @param A
	 *            conjunto a intersecar
	 * @param B
	 *            conjunto a intersecar
	 * @return el conjunto con la interseccion de los datos de los conjuntos A y
	 *         B
	 */
	@Override
	public Conjunto<T> intersection(Conjunto<T> A, Conjunto<T> B) {
		if (A.isEmpty() == true && B.isEmpty() == true) {// Comprobacion vacios
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("Ambas listas estan vacias");
			throw f;
		} else if (A.isEmpty() == true) {
			return B;
		} else if (B.isEmpty() == true) {
			return A;
		}
		Iterator<T> itA = A.iterator();// Iterador A
		Conjunto<T> resultado = new BinarySearchTree<T>(itA.next());// Nuevo
																	// arbol

		while (itA.hasNext()) {// Iteramos por todo A
			resultado.add(itA.next());// Insertamos en resultado
		}
		Iterator<T> itB = B.iterator();// Iterador de B

		while (itB.hasNext()) {// Iteramos por todo B
			T dato = itB.next();
			if (!A.contains(dato)) {// Si el dato no esta en A
				resultado.remove(dato);// Lo quitamos de resultado
			}
		}
		return resultado;// Retorna el nuevo arbol
	}

	/**
	 * Hace una diferencia entre los datos del conjunto A a los del conjunto B y
	 * los retorna en uno tercero, la diferencia son todos los datos que estan
	 * en el conjunto A y que no estan en B
	 * 
	 * @param A
	 *            elemento base para la diferencia
	 * @param B
	 *            elemento que "resta" en la diferencia
	 * @return datos resultantes de la diferencia de A con B
	 */
	@Override
	public Conjunto<T> difference(Conjunto<T> A, Conjunto<T> B) {
		if (A.isEmpty() == true && B.isEmpty() == true) {// Comprobacion de
															// vacios
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("Ambas listas estan vacias");
			throw f;
		} else if (A.isEmpty() == true) {
			return B;
		} else if (B.isEmpty() == true) {
			return A;
		}
		Iterator<T> itA = A.iterator();// Iterador de A
		Conjunto<T> resultado = new BinarySearchTree<T>(itA.next());// Nuevo
																	// arbol

		while (itA.hasNext()) {// Iteramos todo A
			resultado.add(itA.next());// Insertamos en resultado lo de A
		}
		itA = A.iterator();// Reiniciamos el iterador de A

		while (itA.hasNext()) {// Iteramos todo A
			T dato = itA.next();
			if (B.contains(dato)) {// Si B contiene un dato que esta en A
				resultado.remove(dato);// Lo remueve de resultado
			}
		}
		return resultado;// Retorna el nuevo arbol
	}

	/**
	 * Retorna un boolean que dice si el elemento esta en el conjunto o no
	 * 
	 * @param dato
	 *            lo que se quiere buscar en el conjunto
	 * @return un boolean que dice si el elemento esta en el conjunto o no
	 */
	@Override
	public boolean contains(T dato) {
		return contains(raiz, dato);// Auxiliar
	}

	/**
	 * Auxiliar para el contains
	 * 
	 * @param nodo
	 *            por donde va la recursividad
	 * @param dato
	 *            el dato que se quiere encontrar en el arbol
	 * @return un boolean si el dato esta o no en la lista
	 */
	private boolean contains(Nodo<T> nodo, T dato) {
		if (nodo == null) {
			return false;
		}

		if (nodo.dato.equals(dato)) {// Si lo encontro
			return true;// Retorna true
		} else {
			if (nodo.dato.compareTo(dato) > 0) {// Si nodo es mayor que dato
				return contains(nodo.hijoIzquierdo, dato);// Recursividad por
															// ahi
			} else if (nodo.dato.compareTo(dato) < 0) {// Si nodo es menor
				return contains(nodo.hijoDerecho, dato);// Recursividad por ahi
			}
		}
		return false;// No lo encontro
	}

	/**
	 * Limpia la lista a dejarla sin datos
	 */
	@Override
	public void clear() {
		raiz = null;// Borra todo
	}

	/**
	 * Rotacion a la izquierda del arbol
	 * 
	 * @param bal
	 *            el nodo donde esta el desbalanceo
	 */
	private void rotacionRR(Nodo<T> bal) {
		// Si el dato desbalanceado es la raiz
		if (bal.dato == raiz.dato) {
			Nodo<T> aux;// Auxiliar
			bal.hijoDerecho.padre = null;// Le quitamos el padre al hijo derecho
											// de la raiz
			raiz = bal.hijoDerecho;// La nueva raiz es el hijo derecho
			bal.padre = bal.hijoDerecho;// El padre de la vieja raiz es la nueva
										// raiz
			aux = bal.hijoDerecho.hijoIzquierdo;// Auxiliar de los hijos
												// izquierdos de la nueva raiz
			bal.hijoDerecho.hijoIzquierdo = bal;// Asignamos la vieja raiz como
												// hijo izquierdo de la nueva
			bal.hijoDerecho = aux;// Insertamos los hijos de la nueva raiz como
									// hijos de la vieja
			aux.padre = bal;// Otro puntero
		} else {
			Nodo<T> aux;// Auxiliar
			bal.hijoDerecho.padre = bal.padre;// Asignamos como padre del hijo
												// derecho al padre del
												// desbalanceado
			bal.padre.hijoDerecho = bal.hijoDerecho;// Lo mismo que el anterior
													// pero con el otro puntero
			bal.padre = bal.hijoDerecho;// Asignamos como padre del
										// desbalanceado a si hijo derecho
			aux = bal.hijoDerecho.hijoIzquierdo;// Auxiliar de los hijos del
												// hijo del desbalanceado
			bal.hijoDerecho.hijoIzquierdo = bal;// Insertamos el desbalanceado
												// como hijo de su nuevo padre
			bal.hijoDerecho = aux;// Insertamos los hijos
			aux.padre = bal;// Otro puntero
		}
	}

	/**
	 * Rotacion derecha del arbol
	 * 
	 * @param bal
	 *            nodo desbalanceado
	 */
	private void rotacionLL(Nodo<T> bal) {
		// Si el nodo es la raiz
		if (bal.dato == raiz.dato) {
			Nodo<T> aux;// Auxiliar
			bal.hijoIzquierdo.padre = null;// Quitamos el padre del hijo
											// izquierdo de la raiz
			raiz = bal.hijoIzquierdo;// La nueva raiz es el hijo izquierdo
			bal.padre = bal.hijoIzquierdo;// La antigua raiz pasa como hijo
											// izquierdo de la nueva
			aux = bal.hijoIzquierdo.hijoDerecho;// Auxiliar de los hijos de la
												// nueva raiz
			bal.hijoIzquierdo.hijoDerecho = bal;// Insertamos el segundo puntero
												// de la antigua raiz
			bal.hijoIzquierdo = aux;// Insertamos los hijos
			aux.padre = bal;// Otro puntero
		} else {
			Nodo<T> aux;// Auxiliar
			bal.hijoIzquierdo.padre = bal.padre;// Cambiamos el padre del hijo
												// izquierdo del desbalanceado
												// como el padre del
												// desbalanceado
			bal.padre.hijoIzquierdo = bal.hijoIzquierdo;// Cambio de punteros de
														// lo anterior
			bal.padre = bal.hijoIzquierdo;// El padre del desbalanceado es su
											// hijo izquierdo
			aux = bal.hijoIzquierdo.hijoDerecho;// Auxiliar de los hijos
			bal.hijoIzquierdo.hijoDerecho = bal;// Insertamos el desbalanceado
			bal.hijoIzquierdo = aux;// Insetamos los hijos
			aux.padre = bal;// Otro puntero
		}
	}

	/**
	 * Rotacion doble del arbol derecha izquierda
	 * 
	 * @param bal
	 *            nodo desbalanceado
	 */
	private void rotacionRL(Nodo<T> bal) {
		rotacionLL(bal);// Una rotacion derecho
		rotacionRR(bal);// Una rotacion izquierda
	}

	/**
	 * Rotacion doble del arbol izquierda derecha
	 * 
	 * @param bal
	 *            nodo desbalanceado
	 */
	private void rotacionLR(Nodo<T> bal) {
		rotacionRR(bal);// Una rotacion izquierda
		rotacionLL(bal);// Una rotacion derecha
	}

	/**
	 * Metodo que realiza el balanceo del arbol
	 * 
	 * @param bal
	 *            nodo a balancear
	 * @param factor
	 *            factor de balanceo del nodo desbalanceado
	 * @param dato
	 *            si es una rotacion doble o simple
	 */
	private void balanceo(Nodo<T> bal, int factor, int dato) {
		if (factor == -2) {// Si es balanceo izquierdo
			if (dato == 1) {// Simple
				rotacionRR(bal);
			} else if (dato == 0) {// Doble
				rotacionLR(bal);
			}
		} else if (factor == 2) {// Si es balanceo derecho
			if (dato == 0) {// Simple
				rotacionLL(bal);
			} else if (dato == 1) {// Doble
				rotacionRL(bal);
			}
		}
	}

	/**
	 * Metodo que dice que nodo esta desbalanceado empezando la busqueda desde
	 * un nodo en especial moviendose por sus padres que son los unicos
	 * candidatos a estar desbalanceados. Metodo recursivo
	 * 
	 * @param nodo
	 *            nodo que se inserto previamente a este metodo
	 * @return El nodo desbalanceado
	 */
	private Nodo<T> necesitaBal(Nodo<T> nodo) {
		int factor = 0;// Inicializacion del factor y valor que toma factor si
						// ambos hijos son null
		// Si hijo derecho es null e izquierdo no
		if (nodo.hijoDerecho == null && nodo.hijoIzquierdo != null) {
			// Factor es altura de izquierda menos 0
			factor = (sacaAltura(nodo.hijoIzquierdo) - 0);
		}
		// Si hijo derecho no es null pero izquierdo si
		else if (nodo.hijoDerecho != null && nodo.hijoIzquierdo == null) {
			// Factor es 0 menos altura del derecho
			factor = (0 - sacaAltura(nodo.hijoDerecho));
		}
		// Si ninguno null
		else if (nodo.hijoDerecho != null && nodo.hijoIzquierdo != null) {
			// Factor es altura izquierdo menos altura derecho
			factor = sacaAltura(nodo.hijoIzquierdo) - sacaAltura(nodo.hijoDerecho);
		}
		// Si estamos en la raiz y no se encontro un desbalanceo
		if (nodo.padre == null && (factor == 1 || factor == 0 || factor == -1)) {
			return null;// Retorna null
		} else if (factor > 1 || factor < -1) {
			return nodo;// Si no retorna el nodo desbalanceado
		}
		// Si ninguna de las anteriores entonces retorna el mismo con el padre
		// del nodo revisado
		return necesitaBal(nodo.padre);
	}

	/**
	 * Metodo que saca el factor de balanceo del nodo enviado por parametro
	 * 
	 * @param nodo
	 *            El nodo que se quiere saber el factor de balanceo
	 * @return El factor de balanceo
	 */
	private int factor(Nodo<T> nodo) {
		int factor = 0;// Inicializacion del factor y valor que toma si ambos
						// hijos son null
		// Si hijo derecho es null e izquierdo no
		if (nodo.hijoDerecho == null && nodo.hijoIzquierdo != null) {
			// Factor es altura de izquierda menos 0
			factor = (sacaAltura(nodo.hijoIzquierdo) - 0);
		}
		// Si hijo derecho no es null pero izquierdo si
		else if (nodo.hijoDerecho != null && nodo.hijoIzquierdo == null) {
			// Factor es 0 menos altura del derecho
			factor = (0 - sacaAltura(nodo.hijoDerecho));
		}
		// Si ninguno null
		else if (nodo.hijoDerecho != null && nodo.hijoIzquierdo != null) {
			// Factor es altura izquierdo menos altura derecho
			factor = sacaAltura(nodo.hijoIzquierdo) - sacaAltura(nodo.hijoDerecho);
		}
		return factor;// Retorna el factor
	}

	/**
	 * Saca la altura del nodo dado
	 * 
	 * @param sacar
	 *            el nodo a saber su altura
	 * @return la altura del nodo dado
	 */
	private int sacaAltura(Nodo<T> sacar) {
		return sacaAltura(sacar, 1, 1);
	}

	/**
	 * Saca la altura del nodo dado
	 * 
	 * @param sacar
	 *            el nodo a saber la altura
	 * @param altura
	 *            la altura actual en la recursividad
	 * @param maxima
	 *            la altura maxima encontrada
	 * @return
	 */
	private int sacaAltura(Nodo<T> sacar, int altura, int maxima) {

		// Si la altura que tenemos es mayor a la maxima
		if (altura > maxima) {
			// Sustituimos la maxima
			maxima = altura;
		}

		// Si no tiene hijos
		if (sacar.hijoDerecho == null && sacar.hijoIzquierdo == null) {
			return maxima;// Retorna la maxima
		}

		// Si tiene hijo izquierdo
		if (sacar.hijoIzquierdo != null) {
			altura++;// Aumenta altura
			// La maxima sera lo que sustituya la recursividad
			maxima = sacaAltura(sacar.hijoIzquierdo, altura, maxima);
			altura--;// Reduce la altura
		}
		// Si tiene hijo derecho
		if (sacar.hijoDerecho != null) {
			altura++;// Aumenta altura
			// La maxima sero lo que sustituya la recursividad
			maxima = sacaAltura(sacar.hijoDerecho, altura, maxima);
			altura--;// Reduce la altura
		}

		return maxima;// Retorna la maxima
	}

	/**
	 * A�ade un dato al conjunto asignado al this
	 * 
	 * @param dato
	 *            el elemento que se quiere agregar al conjunto
	 */
	@Override
	public void add(T dato) {
		if (this.contains(dato)) {// Si el dato ya esta en el conjunto
			System.out.println("El elemento ya esta en el arbol, no se insertara");
			return;// Solo avisa y sale del metodo
		}
		if (raiz == null) {// Si el arbol esta vacio
			this.raiz = new Nodo<T>(dato);// Sera la nueva raiz
			raiz.padre = null;
		} else {
			inserteOrdenado(raiz, new Nodo<T>(dato), false);// Auxiliar
		}
	}

	/**
	 * Auxiliar para el add, inserta ordenadamente dentro del arbol mas no
	 * reacomoda datos del mismo
	 * 
	 * @param este
	 *            por donde va la recursividad
	 * @param dato
	 *            el nodo que se quiere insertar en el arbol
	 * @param insercion
	 *            si ya se inserto entonces cambia a true
	 */
	private void inserteOrdenado(Nodo<T> este, Nodo<T> dato, boolean insercion) {
		if (insercion == true) {// Si ya esta insertado

			return;// Sale
		} else {
			if (este.dato.compareTo(dato.dato) < 0) {// Si donde esta es menor
														// que el dato
				if (este.hijoDerecho == null) {// Y no tiene hijo derecho
					este.hijoDerecho = dato;// Inserta
					dato.padre = este;
					insercion = true;// Insercion se hizo
					boolean comp = true;// Boolean para el balanceo
					while (comp) {// Mientras no este balanceado
						Nodo<T> bal = necesitaBal(dato);// Vemos si necesita
														// balanceo

						if (bal != null) {// Si lo necesita
							// Balancea
							balanceo(bal, factor(bal), 1);
							dato = bal;// Repetimos pero esta vez escalando en
										// el arbol
						} else if (bal == null) {// Si no necesita
							comp = false;// Sale del while
						}
					}

				} else {
					inserteOrdenado(este.hijoDerecho, dato, insercion);// Si no
																		// inserta,
																		// recursividad
				}
			}
			if (este.dato.compareTo(dato.dato) >= 0) {// Si donde esta es mayor
														// que el dato
				if (este.hijoIzquierdo == null) {// Y no tiene hijo izquierdo
					este.hijoIzquierdo = dato;// Inserta
					dato.padre = este;
					insercion = true;// Se hizo insercion
					boolean comp = true;// Boolean para el balanceo
					while (comp) {// Mientras este desbalanceado
						// Vemos si necesita balanceo
						Nodo<T> bal = necesitaBal(dato);

						if (bal != null) {// Si necesita
							// Balancea
							balanceo(bal, factor(bal), 0);
							// Repetimos
							dato = bal;
						} else if (bal == null) {// Si no necesita
							comp = false;// Termina el while
						}
					}

				} else {
					inserteOrdenado(este.hijoIzquierdo, dato, insercion);// Recursividad
																			// de
																			// caso
																			// contrario
				}
			}
		}
	}

	/**
	 * Elimina un dato al conjunto asignado al this
	 * 
	 * @param dato
	 *            el elemento que se quiere eliminar del conjunto
	 */
	@Override
	public void remove(T dato) {
		Nodo<T> nodo = null;// Una copia del nodo que tiene el dato
		if (!this.contains(dato) || this.isEmpty()) {// Si vacia o no la
														// contiene
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException(
					"La lista esta vacia o el elemento no esta en la lista");
			throw f;// Se cae
		}

		nodo = localizaNodo(dato, raiz, nodo);// Localiza el nodo

		Nodo<T> padreNodo = nodo.padre;

		// Caso sin hijos
		if (nodo.hijoDerecho == null && nodo.hijoIzquierdo == null) {// Si hoja
			nodo = null;// Borra
			int posicion = 0;
			if (padreNodo != null) {
				if (padreNodo.hijoDerecho.equals(nodo)) {
					padreNodo.hijoDerecho = null;
					posicion = 0;
				} else {
					padreNodo.hijoIzquierdo = null;
					posicion = 1;
				}
			}

			// Balanceo
			boolean comp = true;
			while (comp) {
				Nodo<T> bal;
				if (padreNodo == null) {
					bal = null;
				} else {
					bal = necesitaBal(padreNodo);
				}
				if (bal != null) {
					balanceo(bal, factor(bal), posicion);
					padreNodo = bal;
				} else if (bal == null) {
					comp = false;
				}
			}

		}
		// Caso solo hijo izquierdo existe
		else if (nodo.hijoDerecho == null && nodo.hijoIzquierdo != null) {// Si
																			// hijo
																			// izquierdo
			nodo.hijoIzquierdo.padre = nodo.padre;
			nodo.padre.hijoIzquierdo = nodo.hijoIzquierdo;// Borra

			// Balanceo
			boolean comp = true;
			while (comp) {

				Nodo<T> bal;
				if (padreNodo == null) {
					bal = null;
				} else {
					bal = necesitaBal(padreNodo);
				}
				if (bal != null) {
					balanceo(bal, factor(bal), 0);
					padreNodo = bal;
				} else if (bal == null) {
					comp = false;
				}
			}

		}
		// Caso solo hijo derecho existe
		else if (nodo.hijoDerecho != null && nodo.hijoIzquierdo == null) {// Si
																			// hijo
																			// derecho
			nodo.hijoDerecho.padre = nodo.padre;
			nodo.padre.hijoDerecho = nodo.hijoDerecho;// Borra

			// Blanaceo
			boolean comp = true;
			while (comp) {
				Nodo<T> bal;
				if (padreNodo == null) {
					bal = null;
				} else {
					bal = necesitaBal(padreNodo);
				}

				if (bal != null) {
					balanceo(bal, factor(bal), 0);
					padreNodo = bal;
				} else if (bal == null) {
					comp = false;
				}
			}

		}
		// Caso ambos hijos existen
		else if (nodo.hijoDerecho != null && nodo.hijoIzquierdo != null) {// Si
																			// ambos
																			// hijos
			Nodo<T> camino = nodo.hijoDerecho;// Nodo auxiliar
			Nodo<T> padre = nodo;// Nodo padre al auxiliar
			while (camino.hijoIzquierdo != null) {// Busca el nodo mas izquierdo
													// de los derecho del nodo a
													// borrar
				padre = camino;// Mueve el padre
				camino = camino.hijoIzquierdo;// Mueve el auxiliar
			} // Cuando estan en posicion
			nodo.dato = camino.dato;// Borra el dato a borrar por el mas
									// izquierdo de sus hijos derechos
			padre.setHijoIzquierdo(camino.hijoDerecho);// Reasigna los hijos del
														// auxiliar
														// padre del auxiliar
			padre.hijoIzquierdo.padre = padre;

			// Balanceo
			boolean comp = true;
			while (comp) {
				Nodo<T> bal;
				if (padreNodo == null) {
					bal = null;
				} else {
					bal = necesitaBal(padreNodo);
				}

				if (bal != null) {
					balanceo(bal, factor(bal), 0);
					padreNodo = bal;
				} else if (bal == null) {
					comp = false;
				}
			}
		}

	}

	/**
	 * Metodo que localiza el nodo a borrar en el arbol, es un auxiliar para el
	 * remove del arbol
	 * 
	 * @param dato
	 *            el dato que se busca en el arbol
	 * @param raiz
	 *            la raiz del arbol en el que se quiere buscar
	 * @param nodo
	 *            el nodo due�o del dato que se quiere encontrar
	 * @return el nodo due�o del dato que se quiere encontrar
	 */
	private Nodo<T> localizaNodo(T dato, Nodo<T> raiz, Nodo<T> nodo) {
		if (raiz.dato.equals(dato)) {// Si lo encuentra
			nodo = raiz; // Lo asigna a nodo
			return nodo; // Lo retorna
		}
		if (raiz.dato.compareTo(dato) > 0) {// Va para la izquierda
			return localizaNodo(dato, raiz.hijoIzquierdo, nodo);
		}
		if (raiz.dato.compareTo(dato) < 0) {// Luego derecha
			return localizaNodo(dato, raiz.hijoDerecho, nodo);
		}
		return nodo;// Retorna nodo
	}

	/**
	 * Retorna un boolean que dice si el conjunto asignado al this es igual en
	 * todos sus elementos al conjunto A
	 * 
	 * @param A
	 *            el conjunto que se compara con el asignado en this
	 * @return boolean que dice si el conjunto asignado al this es igual en
	 *         todos sus elementos al conjunto A
	 */
	@Override
	public boolean Equals(Conjunto<T> A) {
		Iterator<T> itThis = this.iterator();// Iterador this
		Iterator<T> itA = A.iterator();// Iterador A

		while (itThis.hasNext()) {// Si lo que esta en this esta en A
			if (!A.contains(itThis.next())) {// Si no
				return false;// Retorna falso
			}
		}

		while (itA.hasNext()) {// Si lo que esta en A esta en this
			if (!this.contains(itA.next())) {// Si no
				return false;// Retorna falso
			}
		}
		return true;// Si lo que esta en A esta en this y vice, entonces son
					// iguales
	}

	/**
	 * Retorna un boolean si el conjunto asignado al this esta vacio
	 * 
	 * @return un boolean si el conjunto asignado al this esta vacio
	 */
	@Override
	public boolean isEmpty() {
		return raiz == null;
	}

	/**
	 * Retorna el tama�o del conjunto
	 * 
	 * @return el tama�o del conjunto
	 */
	@Override
	public int size() {
		Iterator<T> it = iterator();
		int i = 0;
		while (it.hasNext()) {
			i++;
			it.next();
		}
		return i;
	}

	/**
	 * Clase nodo para el arbol binario de busqueda
	 * 
	 * @author Gonzalo
	 *
	 * @param <T>
	 */
	private class Nodo<T> {

		T dato;
		Nodo<T> padre;
		Nodo<T> hijoDerecho;
		Nodo<T> hijoIzquierdo;
		int altura;

		public Nodo(T dato) {
			altura = 1;
			hijoIzquierdo = null;
			hijoDerecho = null;
			this.dato = dato;
			this.padre = null;
		}

		public Nodo(T dato, Nodo<T> padre) {
			hijoIzquierdo = null;
			hijoDerecho = null;
			this.dato = dato;
			this.padre = padre;
		}

		public void setPadre(Nodo<T> padre) {
			this.padre = padre;
		}

		public Nodo<T> getPadre(Nodo<T> padre) {
			return this.padre;
		}

		public T getDato() {
			return this.dato;
		}

		public Nodo<T> getHijoIzquierdo() {
			return this.hijoIzquierdo;
		}

		public Nodo<T> getHijoDerecho() {
			return this.hijoDerecho;
		}

		public void setDato(T dato) {
			this.dato = dato;
		}

		public void setHijoDerecho(Nodo<T> hijo) {
			this.hijoDerecho = hijo;
		}

		public void setHijoIzquierdo(Nodo<T> hijo) {
			this.hijoIzquierdo = hijo;
		}
	}

	/**
	 * Clase iterador del arbol binario de busqueda
	 * 
	 * @author Gonzalo
	 *
	 * @param <E>
	 */
	private class It<E> implements Iterator<E> {

		Stack<Nodo<T>> stack;

		/**
		 * Crea el stack con los datos del arbol
		 */
		public It() {
			stack = new StackArray<Nodo<T>>();
			inserciones(raiz);
		}

		/**
		 * Itera todo el arbol y guarda los datos en el stack
		 * 
		 * @param raiz
		 *            la raiz del arbol a iterar
		 */
		private void inserciones(Nodo<T> raiz) {
			if (raiz.dato != null) {
				stack.push(raiz);
			}
			if (raiz.hijoIzquierdo != null) {
				inserciones(raiz.hijoIzquierdo);
			}
			if (raiz.hijoDerecho != null) {
				inserciones(raiz.hijoDerecho);
			}
		}

		@Override
		public boolean hasNext() {
			return (!stack.isEmpty());
		}

		@Override
		public E next() {
			return (E) stack.pop().dato;
		}
	}

	/**
	 * Instanciador del iterador
	 * 
	 * @return una instancia del iterador
	 */
	@Override
	public Iterator<T> iterator() {
		return new It<T>();
	}

}
