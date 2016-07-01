package cr.ac.ucr.ecci.ci1221.FatPusheen.ui;



import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Iterator;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.ArrayList;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.LinkedList;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.List;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.sorting.InsertionSort;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.sorting.MergeSort;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.sorting.SelectionSort;

public class mainsort {

	public static void main(String args[]) {
		/*MergeSort sort = new MergeSort();
		int[] lista = { 1, 5, 7, 2, 4, 6, 8, 0, 10, 9 };
		lista = sort.mergeSortTopBottom(lista);
		for (int i = 0; i < lista.length; i++) {
			System.out.print(lista[i] + " ");
		}*/
		
		System.out.println("\n");
		MergeSort<Integer> sort4 = new MergeSort<Integer>();
		List<Integer> lista4 = new ArrayList<Integer>();
		lista4.add(8);
		lista4.add(7);
		lista4.add(3);
		lista4.add(2);
		lista4.add(5);
		lista4.add(7);
		lista4.add(11);
		lista4.add(1);
		lista4.add(12);
		lista4.add(6);
		lista4.add(4);
		sort4.mergeSortBottomTop(lista4);
		Iterator<Integer> it = lista4.iterator();
		while (it.hasNext()){
			System.out.print(it.next() + " ");
		}
		
		/*System.out.println("\n");
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
		}*/
	}
}