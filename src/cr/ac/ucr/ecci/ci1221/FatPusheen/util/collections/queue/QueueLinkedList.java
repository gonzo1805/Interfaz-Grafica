package cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.queue;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Iterator;

/**
 * Implementation of a queue using a linked list.
 *
 * @author Rodrigo A. Bartels
 */
public class QueueLinkedList<E> implements Queue<E> {

	private int cantidadDatos = 0;
	Nodo cabeza;

	@Override
	public void enqueue(E element) {
		if (cantidadDatos == 0) {
			cabeza = new Nodo(element);
			cantidadDatos++;
		} else {
			Nodo nodo = new Nodo(element);
			nodo.setSiguiente(cabeza);
			cabeza = nodo;
			cantidadDatos++;
		}
	}

	@Override
	public E dequeue() {
		if (cantidadDatos == 0) {
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("La lista esta vacia");
			throw f;
		}
		if (cantidadDatos == 1) {
			Nodo aux = cabeza;
			cabeza = null;
			cantidadDatos--;
			return aux.getDato();
		}
		Nodo aux = cabeza;
		Nodo aux_anterior = cabeza;
		for (int i = 0; i < cantidadDatos - 1; i++) {
			aux_anterior = aux;
			aux = aux.siguiente;
		}
		E retorno = aux.getDato();
		aux_anterior.setSiguiente(null);
		cantidadDatos--;
		return retorno;
	}

	@Override
	public E top() {
		if (cantidadDatos == 0) {
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("La lista esta vacia");
			throw f;
		}
		Nodo aux = cabeza;
		for (int i = 0; i < cantidadDatos - 1; i++) {
			aux = aux.siguiente;
		}
		return aux.getDato();
	}

	@Override
	public void add(E element) {
		enqueue(element);
	}

	@Override
	public E remove(E element) {
		if (cantidadDatos == 0) {
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("La lista esta vacia");
			throw f;
		}
		if (cantidadDatos == 1) {
			return dequeue();
		}
		Nodo aux = cabeza;
		Nodo aux_anterior = cabeza;
		for (int i = 0; i < cantidadDatos; i++) {
			if (i == cantidadDatos - 1 && element.equals(aux.getDato())) {
				E retorno = aux.getDato();
				aux_anterior.setSiguiente(null);
				cantidadDatos--;
				return retorno;
			}
			if (element.equals(aux.getDato())) {
				if (aux.equals(cabeza)){
					E retorno = aux.getDato();
					cabeza = aux.siguiente;
					cantidadDatos--;
					return retorno;
				}
				E retorno = aux.getDato();
				aux_anterior.setSiguiente(aux.getSiguiente());
				cantidadDatos--;
				return retorno;
			}
			aux_anterior = aux;
			aux = aux.siguiente;
		}
		System.out.println("El elemento no esta en la lista");
		return null;
	}

	@Override
	public boolean contains(E element) {
		if (cantidadDatos == 0) {
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("La lista esta vacia");
			throw f;
		}
		Nodo aux = cabeza;

		for (int i = 0; i < cantidadDatos; i++) {
			if (element.equals(aux.getDato())) {
				return true;
			}
			aux = aux.siguiente;
		}
		return false;
	}

	@Override
	public int size() {
		return cantidadDatos;
	}

	@Override
	public boolean isEmpty() {
		return cantidadDatos == 0;
	}

	@Override
	public void clear() {
		cabeza = null;
		cantidadDatos = 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new It<E>();
	}

	private class Nodo {

		E dato;
		Nodo siguiente;

		public Nodo() {
		}

		public Nodo(E element) {
			this.dato = element;
		}

		public void setDato(E element) {
			this.dato = element;
		}

		public E getDato() {
			return this.dato;
		}

		public void setSiguiente(Nodo siguiente) {
			this.siguiente = siguiente;
		}

		public Nodo getSiguiente() {
			return this.siguiente;
		}

	}

	private class It<E> implements Iterator<E> {

		Nodo actual = cabeza;

		public It() {
		}

		@Override
		public boolean hasNext() {
			return (!(actual == null));
		}

		@Override
		public E next() {
			E dato = (E) actual.dato;
			if (actual.siguiente == null) {
				actual = null;
				return dato;
			}
			actual = actual.siguiente;
			return dato;
		}
	}
}
