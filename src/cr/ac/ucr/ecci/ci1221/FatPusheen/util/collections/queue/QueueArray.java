package cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.queue;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Iterator;

/**
 * Implementation of a Queue using an array.
 *
 * @author Rodrigo A. Bartels
 */
public class QueueArray<E> implements Queue<E> {

	private E[] elements;
	private int cantidadDatos;

	public QueueArray() {
		elements = (E[]) new Object[1000];
		cantidadDatos = 0;
	}

	public QueueArray(int tamano) {
		elements = (E[]) new Object[tamano];
		cantidadDatos = 0;
	}

	@Override
	public void enqueue(E element) {
		if (elements[0] == null) {
			elements[0] = element;
			cantidadDatos++;
		} else if (cantidadDatos + 1 >= elements.length) {
			E[] sustituto = (E[]) new Object[elements.length * 2];
			for (int i = 0; i < cantidadDatos; i++) {
				sustituto[i] = elements[i];
			}
			sustituto[cantidadDatos] = element;
			elements = sustituto;
			cantidadDatos++;
		} else {
			elements[cantidadDatos] = element;
			cantidadDatos++;
		}
	}

	@Override
	public E dequeue() {
		if (cantidadDatos == 0) {
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException(
					"La posicion que se quiere borrar no existe");
			throw f;
		}
		E retorno = elements[0];
		for (int i = 0; i < cantidadDatos; i++) {
			elements[i] = elements[i + 1];
		}
		cantidadDatos--;
		return retorno;
	}

	@Override
	public E top() {
		if (cantidadDatos == 0) {
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("La lista esta vacia");
			throw f;
		}
		return elements[cantidadDatos - 1];
	}

	@Override
	public void add(E element) {
		enqueue(element);
	}

	@Override
	public E remove(E element) {
		if (this.contains(element) == false) {
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("El elemento no esta en la lista");
			throw f;
		}
		if (element.equals(elements[0])) {
			return dequeue();
		} else {
			boolean comprobacion = false;
			for (int i = 0; i < cantidadDatos; i++) {
				if (elements[i].equals(element)) {
					comprobacion = true;
				}
				if (comprobacion == true) {
					if (elements[i + 1] != null) {
						elements[i] = elements[i + 1];
					}
				}
			}
			elements[cantidadDatos] = null;
			cantidadDatos--;
			return element;
		}
	}

	@Override
	public boolean contains(E element) {
		for (int i = 0; i < cantidadDatos; i++) {
			if (elements[i].equals(element))
				return true;
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
		elements = (E[]) new Object[1000];
		cantidadDatos = 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new It<E>();
	}

	private class It<E> implements Iterator<E> {

		int actual = 0;

		public It() {
		}

		@Override
		public boolean hasNext() {
			return actual < cantidadDatos;
		}

		@Override
		public E next() {
			if (actual >= cantidadDatos) {
				System.out.println("No hay mas elementos");
				return null;
			} else {
				E retorno = (E) elements[actual];
				actual++;
				return retorno;
			}
		}
	}
}
