package cr.ac.ucr.ecci.ci1221.FatPusheen.util.sorting;

public class SelectionSort {

	public void selectionSort(int[] lista){
		for (int i=0; i<lista.length; i++){
			int minimo = i;
			
			for (int x=i+1; x<lista.length; x++){
				if (lista[x] < lista[minimo]){
					minimo = x;
				}
			}
			if (i != minimo){
				swap(lista, i, minimo);
			}
		}
	}
	
	private void swap(int[] lista, int i, int minimo){
		int aux = lista[i];
		lista[i] = lista[minimo];
		lista[minimo] = aux;
	}
	
	
}
