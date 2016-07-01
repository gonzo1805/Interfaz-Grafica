package cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.queue;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Iterator;

/**
 * Implementation of a queue using a circular array.
 *
 * @author Rodrigo A. Bartels
 */
public class QueueCircularArray<E> implements Queue<E> {

	private E[] elements;
	private int write;
	private int read;
	private int cantidadDatos;

	public QueueCircularArray() {
		elements = (E[]) new Object[50];
		write = 0;
		read = 0;
		cantidadDatos = 0;
	}

	public QueueCircularArray(int tamano) {
		elements = (E[]) new Object[tamano];
		write = 0;
		read = 0;
		cantidadDatos = 0;
	}

	@Override
	public void enqueue(E element) {
		if (cantidadDatos + 1 > elements.length) {
			E[] auxiliar = (E[]) new Object[cantidadDatos * 2];
			for (int i = 0; i < cantidadDatos; i++) {
				auxiliar[i] = elements[read];
				read = (read + 1) % elements.length;
			}
			read = 0;
			write = cantidadDatos;
			elements = auxiliar;
		}
		elements[write] = element;
		write = (write + 1) % elements.length;
		cantidadDatos++;

	}

	@Override
	public E dequeue() {
		if (cantidadDatos == 0) {
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("La cola esta vacia");
			throw f;
		} else {
			E aux = elements[read];
			elements[read] = null;
			read = (read + 1) % write;
			cantidadDatos--;
			if (cantidadDatos == 0)
				read = write;
			return aux;
		}
	}

	@Override
	public E top() {
		if (cantidadDatos == 0) {
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("La cola esta vacia");
			throw f;
		}
		return elements[read];
	}

	@Override
	public void add(E element) {
		enqueue(element);
	}

	@Override
	public E remove(E element) {
		if (element.equals(elements[read])) {
			return dequeue();
		} else if (element.equals(elements[write])) {
			E aux = elements[write];
			elements[write] = null;
			write--;
			cantidadDatos--;
			return aux;
		} else {
			boolean comprobante = false;
			int i = 0;
			int aux = read;
			while (i != cantidadDatos) {
				if (elements[aux].equals(element)) {
					comprobante = true;
				}
				if (comprobante == true) {
					elements[aux] = elements[(aux + 1) % cantidadDatos];
				}
				i++;
				aux = (aux + 1) % cantidadDatos;
			}
			cantidadDatos--;
			write = aux;

			return element;
		}
	}

	@Override
	public boolean contains(E element) {
		if (cantidadDatos == 0) {
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("Lista Vacia");
			throw f;
		}
		int aux = read;
		boolean comprobante = false;
		while (!comprobante) {
			if (elements[aux].equals(element)) {
				return true;
			}
			if (aux == write) {
				comprobante = true;
			}
			aux = (aux + 1) % write;
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
		elements = (E[]) new Object[50];
		cantidadDatos = 0;
		write = 0;
		read = 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new It<E>();
	}

	private class It<E> implements Iterator<E> {

		int actual = read;
		int comprobador = actual;
		int test = write;
		int test2 = write % cantidadDatos;

		public It() {
		}

		@Override
		public boolean hasNext() {
			return (actual < write);
		}

		@Override
		public E next() {
			E aux = (E) elements[actual];
			if (actual + 1 == comprobador){
				actual = write;
				return aux;
			}
			actual = (actual + 1) % elements.length;
			return aux;
		}
	}
}
