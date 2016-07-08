package cr.ac.ucr.ecci.ci1221.FatPusheen.util.sorting;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.List;

public class InsertionSort<T extends Comparable<T>> {

	/**
	 * Metodo que inicia el sort bajo el enfoque de Insertion Sort
	 * 
	 * @param lista
	 *            la lista que queremos ordenar
	 */
	public void insertionSort(List<T> lista) {
		int x;// Se usa este int para hacer las comparaciones para atras en la
				// lista
		for (int i = 1; i <= lista.size(); i++) {// Recorrido de la lista
			x = i;// Donde empezaremos a movernos
			int cambio = i;// Dato que se moveria si se hace swap
			while (x != 0) {// Para atras en la lista
				if (lista.get(x).compareTo(lista.get(cambio)) > 0) {// Si x es
																	// mayor a
																	// cambio
					swap(lista, cambio, x);// Swap
					cambio = x;// Ahora movemos desde x;
				}
				x--;// Movemos el contador para atras
			}
		}
	}

	/**
	 * Swap para la el sort
	 * 
	 * @param lista la lista donde se realiza el swap
	 * @param i valor a cambiar con minimo
	 * @param minimo valor a cambiar con i
	 */
	private void swap(List<T> lista, int i, int minimo) {
		T aux = lista.get(i);// Auxiliar de i
		lista.set(i, lista.get(minimo));// Cambio
		lista.set(minimo, aux);// Cambio
	}
}
