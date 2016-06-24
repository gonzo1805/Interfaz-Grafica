package cr.ac.ucr.ecci.ci1221.FatPusheen.util.sorting;

public class QuickSort {

	public void quickSort(int[] lista, int inicio, int ultimo) {
		if (inicio < ultimo) {
			int p = partidor(lista, inicio, ultimo);
			quickSort(lista, inicio, p-1);
			quickSort(lista, p+1, ultimo);
		}
	}
	/**
	 * Los diferentes casos del pivote estaran comentados dentro mismo codigo, 
	 * nombrando el caso con documentacion y luego el codigo en forma de comentario
	 */
	public int partidor(int[] lista, int inicio, int ultimo) {

		int posPiv = 0;
		/** Caso pivote al medio de la lista (default)
		 * Ultimo - inicio / 2 nos da la mitad entre esos dos numeros
		 * Al sumarle inicio lo reacomodamos en el ambito que ocupamos
		 */
		posPiv = ((ultimo - inicio)) / 2 + inicio;
		/**
		 * Caso pivote al final de la lista
		 */
		//posPiv = ultimo; 
		/**
		 * Caso pivote al inicio de la lista
		 */
		//posPiv = inicio;
		/**
		 * Caso pivote random dentro del rango de la lista, la funcion usada da un numero al azar en el rango dado por los 
		 * parametros de inicio y ultimo
		 */
		//posPiv = ThreadLocalRandom.current().nextInt(inicio, ultimo);
		
		int pivote = lista[posPiv];
		int pi = inicio;
		int pd = ultimo;
		
		while (pi < pd) {
			
			while (lista[pi] < pivote) {
				pi++;
			}
			
			while (lista[pd] > pivote) {
				pd--;
			}
			
			if (pd == pi)
				break;
			
			if (lista[pi] == lista[pd]){
				pi++;
				pd--;
			}
			
			if (pi < pd) {
				cambiaNumeros(lista, pi, pd);
			}
		}
		
		lista[pi] = pivote;
		return pi;
	}

	private void cambiaNumeros(int[] lista, int i, int d) {
		int temp = lista[i];
		lista[i] = lista[d];
		lista[d] = temp;
	}
	
	public boolean comprobador(int[] lista){
		for (int i=0; i<lista.length-1; i++){
			if (i == lista.length) break;
			if (lista[i] > lista[i+1]){
				return false;
			}	
		}
		return true;
	}

}
