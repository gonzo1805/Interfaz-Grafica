package cr.ac.ucr.ecci.ci1221.FatPusheen.ui;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.sorting.InsertionSort;

public class mainsort {

	
	public static void main (String args[]){
		InsertionSort sort = new InsertionSort();
		int[] lista = {1,43,34,75,23,86,97,43,67};
		sort.insertionSort(lista);
		for (int i=0; i<lista.length; i++){
			System.out.print(lista[i] + " ");
		}
	}
}