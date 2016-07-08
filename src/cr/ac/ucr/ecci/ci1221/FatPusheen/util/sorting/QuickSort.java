package cr.ac.ucr.ecci.ci1221.FatPusheen.util.sorting;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.List;

public class QuickSort<T extends Comparable<T>> {

	/**
	 * Llamado al quickSort todo hecho in place por eso se espicifica el inicio
	 * y final de la lista
	 * 
	 * @param lista
	 *            la lista a ordenar
	 * @param inicio
	 *            el inicio de la lista
	 * @param ultimo
	 *            el final de la lista
	 */
	public void quickSort(List<T> lista, int inicio, int ultimo) {
		// Si ya recorrimos toda la lista acaba
		if (inicio < ultimo) {
			// Llama al que parte la lista
			int p = partidor(lista, inicio, ultimo);
			// Ordena mitad izquierda
			quickSort(lista, inicio, p - 1);
			// Ordena mitad derecha
			quickSort(lista, p + 1, ultimo);
		}
	}

	/**
	 * Metodo que divide la lista a la mitad
	 * 
	 * @param lista
	 *            la lista a dividir
	 * @param inicio
	 *            el inicio de la lista
	 * @param ultimo
	 *            el final de la lista
	 * @return
	 */
	public int partidor(List<T> lista, int inicio, int ultimo) {

		// Int de la posicion del pivote en la lista
		int posPiv = 0;

		// El pivote
		posPiv = ((ultimo - inicio)) / 2 + inicio;

		// El valor de la posicion del pivote en la lista
		T pivote = lista.get(posPiv);
		// Puntero izquierdo
		int pi = inicio;
		// Puntero derecho
		int pd = ultimo;

		// Mientras que los dos punteros no se encuentren
		while (pi < pd) {

			// Encontramos un valor izquierdo mayor al pivote
			while (lista.get(pi).compareTo(pivote) < 0) {
				pi++;
			}

			// Encontramos un valor derecho menor al pivote
			while (lista.get(pd).compareTo(pivote) > 0) {
				pd--;
			}

			// Si ambos se encuentran sale
			if (pd == pi)
				break;

			// Si ambos punteros tienen el mismo valor en la lista, se sigue
			if (lista.get(pi).compareTo(lista.get(pd)) == 0) {
				pi++;
				pd--;
			}

			// Swap
			if (pi < pd) {
				cambiaNumeros(lista, pi, pd);
			}
		}

		// Añade el pivote denuevo a la lista
		lista.set(pi, pivote);
		return pi;
	}

	/**
	 * Swap para el quicksort
	 * @param lista la lista donde se hace el swap
	 * @param i dato a cambiar con d
	 * @param d dato a cambiar con i
	 */
	private void cambiaNumeros(List<T> lista, int i, int d) {
		T aux = lista.get(i);
		lista.set(i, lista.get(d));
		lista.set(d, aux);
	}
}
