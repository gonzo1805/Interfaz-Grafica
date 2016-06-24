package cr.ac.ucr.ecci.ci1221.FatPusheen.util.sorting;

public class MergeSort {

	public int[] mergeSortTopBottom(int[] lista) {
		return separador(lista);
	}

	private int[] separador(int[] lista) {
		if (lista.length / 2 < 1) {
			return lista;
		}

		int mitad = lista.length / 2;
		int[] izquierda = new int[mitad];
		int[] derecha = new int[lista.length - mitad];

		int indiceIz = 0;
		int indiceDe = 0;

		for (int i = 0; i < lista.length; i++) {
			if (i < mitad) {
				izquierda[indiceIz] = lista[i];
				indiceIz++;
			} else {
				derecha[indiceDe] = lista[i];
				indiceDe++;
			}
		}

		izquierda = separador(izquierda);
		derecha = separador(derecha);

		return mergeTB(izquierda, derecha);
	}

	private int[] mergeTB(int[] lista, int[] lista2) {

		SelectionSort sort = new SelectionSort();
		int[] listaRet = new int[lista.length + lista2.length];

		int tamano1 = 0;
		int tamano2 = 0;

		int x = 0;

		while (tamano1 != lista.length) {
			listaRet[x] = lista[tamano1];
			x++;
			tamano1++;
		}
		while (tamano2 != lista2.length) {
			listaRet[x] = lista2[tamano2];
			x++;
			tamano2++;
		}

		sort.selectionSort(listaRet);
		return listaRet;

	}

	public int[] mergeSortBottomTop(int[] lista) {
		int tamano = lista.length;
		for (int x = 2; x < lista.length; x = x * 2) {
			int posicionI = 0;
			tamano = tamano / 2;
			for (int i = 0; i <= tamano; i++) {

				lista = mergeBT(lista, posicionI, posicionI + x - 1);
				// i = i + x;
				posicionI = posicionI + x;

			}
		}
		lista = mergeBT(lista, 0, lista.length);
		return lista;
	}

	private int[] mergeBT(int[] lista, int min, int max) {
		if (max - min < 1) {
			return lista;
		}
		if (max > lista.length) {
			max = lista.length - 1;
		}
		int x;
		for (int i = min; i <= max; i++) {
			if (lista.length == i) {
				break;
			}
			x = i;
			int cambio = i;
			while (x != min - 1) {
				if (lista[x] > lista[cambio]) {
					swap(lista, cambio, x);
					cambio = x;
				}
				x--;
			}
		}
		return lista;
	}

	private void swap(int[] lista, int i, int minimo) {
		int aux = lista[i];
		lista[i] = lista[minimo];
		lista[minimo] = aux;
	}

}
