package cr.ac.ucr.ecci.ci1221.FatPusheen.util.sorting;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.List;

public class SelectionSort<T extends Comparable<T>> {

	/**
	 * Sort por el metodo de selection Sort
	 * 
	 * @param lista
	 *            la lista a ordenar
	 */
	public void selectionSort(List<T> lista) {
		// Recorremos la lista
		for (int i = 1; i <= lista.size(); i++) {
			// Asignamos el punto donde estamos como minimo de la lista
			int minimo = i;

			// La recorremos denuevo desde el punto donde se inicio la iteracion
			// del for de afuera
			for (int x = i + 1; x <= lista.size(); x++) {
				// Si hay un nuevo valor minimo
				if (lista.get(x).compareTo(lista.get(minimo)) < 0) {
					minimo = x;// Lo guardamos
				}
			}
			// Si el minimo cambio
			if (i != minimo) {
				// Cambiamos los datos
				swap(lista, i, minimo);
			}
		}
	}

	/**
	 * Swap para el selection sort
	 * 
	 * @param lista
	 *            la lista a ordenar
	 * @param i
	 *            el dato a cambiar por minimo
	 * @param minimo
	 *            el dato a cambiar por i
	 */
	private void swap(List<T> lista, int i, int minimo) {
		T aux = lista.get(i);
		lista.set(i, lista.get(minimo));
		lista.set(minimo, aux);
	}

}
