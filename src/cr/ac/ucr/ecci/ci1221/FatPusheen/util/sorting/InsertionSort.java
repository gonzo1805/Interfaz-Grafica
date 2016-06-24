package cr.ac.ucr.ecci.ci1221.FatPusheen.util.sorting;

public class InsertionSort {

	public void insertionSort(int[] lista) {
		int x;
		for (int i = 0; i < lista.length; i++) {
			x = i;
			int cambio = i;
			while (x != -1) {
				if (lista[x] > lista[cambio]) {
					swap(lista, cambio, x);
					cambio = x;
				}
				x--;
			}
		}
	}

	private void swap(int[] lista, int i, int minimo) {
		int aux = lista[i];
		lista[i] = lista[minimo];
		lista[minimo] = aux;
	}
}
