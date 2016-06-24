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

		return merge(izquierda, derecha);
	}

	private int[] merge(int[] lista, int[] lista2) {

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

}
