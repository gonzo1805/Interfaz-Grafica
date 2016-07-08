package cr.ac.ucr.ecci.ci1221.FatPusheen.util.sorting;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.List;

public class MergeSort<T extends Comparable<T>> {

	/**
	 * Array auxiliar para el sort
	 */
	private T[] auxT;

	/**
	 * Llamado al sort con enfoque TopBottom
	 * 
	 * @param lista
	 *            la lista a ordenar
	 */
	@SuppressWarnings("unchecked")
	public void mergeSortTopBottom(List<T> lista) {
		auxT = (T[]) new Comparable[lista.size()];// Inicializaciamos la lista
		separador(lista, 1, lista.size());// Llamado a separador
	}

	/**
	 * El "separador" in-place para el top down
	 * 
	 * @param lista
	 *            la lista a separar y ordenar
	 * @param inicio
	 *            por donde inicia la separacion
	 * @param ultimo
	 *            por donde termina la separacion
	 */
	private void separador(List<T> lista, int inicio, int ultimo) {

		// Condicion de parada, si queremos acomodar listas con solo 1 dato
		if (ultimo <= inicio) {
			return;
		}
		// Mitad de la lista
		int mitad = (ultimo - inicio) / 2 + inicio;
		// Separa mitad izquierda
		separador(lista, inicio, mitad);
		// Separa mitad derecha
		separador(lista, mitad + 1, ultimo);
		// Las une
		merge(lista, inicio, mitad, ultimo);

	}

	/**
	 * Combinador de las lista para ambos enfoques del merge
	 * 
	 * @param lista
	 *            la lista donde juntaremos ambas listas
	 * @param inicio
	 *            donde inicia la lista
	 * @param mitad
	 *            la mitad de la lista
	 * @param ultimo
	 *            el final de la lista
	 */
	private void merge(List<T> lista, int inicio, int mitad, int ultimo) {
		// Puntero de la primera lista
		int i = inicio;
		// Puntero de la segunda lista
		int b = mitad + 1;

		// Llenamos la auxiliar con los dato actuales de la lista
		for (int x = inicio; x <= lista.size(); x++) {
			auxT[x - 1] = lista.get(x);
		}
		// Recorremos la lista
		for (int y = inicio; y <= ultimo; y++) {
			if (i > mitad) {// Si la recorrimos toda la lista inicial
				lista.set(y, auxT[b++ - 1]);
			} else if (b > ultimo) {// Si ya recorrimos toda la segunda lista
				lista.set(y, auxT[i++ - 1]);
			} else if (auxT[b - 1].compareTo(auxT[i - 1]) < 0) {// Si un dato de
																// derecha es
																// menor que uno
																// de la
																// izquierda
				lista.set(y, auxT[b++ - 1]);
			} else {// Si uno de la izquierda es menor que uno de la derecha
				lista.set(y, auxT[i++ - 1]);
			}
		}
	}

	/**
	 * Enfoque bottom up del merge sort
	 * 
	 * @param lista
	 *            la lista a ordenar
	 */
	@SuppressWarnings("unchecked")
	public void mergeSortBottomTop(List<T> lista) {
		// Tamaño de la lista
		int tamano = lista.size();
		// Inicializacion de auxiliar
		auxT = (T[]) new Comparable[tamano];
		// Recorre la lista
		for (int i = 1; i < tamano; i = i + i) {
			// La divide por bloques de 2^n dependiendo de la iteracion del for
			// anterior
			for (int z = 0; z < tamano - i; z += i + i) {
				// Llamado a merge para unirlas
				merge(lista, z + 1, z + i, Math.min(z + i + i, tamano));
			}
		}
	}
}
