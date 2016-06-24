package cr.ac.ucr.ecci.ci1221.FatPusheen.util.sorting;

public class MergeSort {

	public void mergeSort(int[] lista) {
		int[] lista2 = new int[lista.length];
		separador(lista, 0, lista.length, lista2);
	}

	public void separador(int[] lista, int bajo, int alto, int[] lista2) {
		if ((alto - bajo) / 2 <= 1) {
			return;
		} else {
			int mitad = (bajo + alto) / 2;
			int[] izquierda = new int[mitad];
			int[] derecha = new int[alto-mitad];
			
			int indiceIz = 0;
			int indiceDe = 0;
			
			for (int i=0; i<lista.length; i++){
				if (i<mitad){
					izquierda[indiceIz] = lista[i];
					indiceIz++;
				}
				else {
					derecha[indiceDe] = lista[i];
					indiceDe++;
				}
			}
			separador(lista, 0, mitad, lista2);
			separador(lista, mitad + 1, alto, lista2);
		}
	}

	public void merge(int[] lista, int bajo, int mitad, int alto, int[] lista2) {
		
	}

}
