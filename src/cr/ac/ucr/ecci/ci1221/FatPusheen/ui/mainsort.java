package cr.ac.ucr.ecci.ci1221.FatPusheen.ui;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.sorting.InsertionSort;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.sorting.MergeSort;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.sorting.SelectionSort;

public class mainsort {

	public static void main(String args[]) {
		MergeSort sort = new MergeSort();
		int[] lista = { 1, 5, 7, 2, 4, 6, 8, 0, 10, 9 };
		lista = sort.mergeSortTopBottom(lista);
		for (int i = 0; i < lista.length; i++) {
			System.out.print(lista[i] + " ");
		}
		System.out.println("\n");
		InsertionSort sort2 = new InsertionSort();
		int[] lista2 = { 1, 5, 7, 2, 4, 6, 8, 0, 10, 9 };
		sort2.insertionSort(lista2);
		for (int i = 0; i < lista2.length; i++) {
			System.out.print(lista2[i] + " ");
		}
		System.out.println("\n");
		SelectionSort sort3 = new SelectionSort();
		int[] lista3 = { 1, 5, 7, 2, 4, 6, 8, 0, 10, 9 };
		sort3.selectionSort(lista3);
		for (int i = 0; i < lista3.length; i++) {
			System.out.print(lista3[i] + " ");
		}
	}
}