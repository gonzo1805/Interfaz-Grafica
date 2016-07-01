package cr.ac.ucr.ecci.ci1221.FatPusheen.ui;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.set.AVLTree;

public class MainArbol {

	
	public static void main(String args[]){
		AVLTree<Integer> arbol = new AVLTree<Integer>(1);
		arbol.add(3);
		arbol.add(0);
		arbol.add(5);
		arbol.add(-1);
		arbol.add(2);
		arbol.add(6);
		arbol.add(7);
		
	}
}
