package cr.ac.ucr.ecci.ci1221.FatPusheen.ui;

import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import cr.ac.ucr.ecci.ci1221.FatPusheen.model.Estudiante;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Iterator;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.ArrayList;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.LinkedList;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.List;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.map.LinkedMap;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.map.Map;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.queue.Queue;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.queue.QueueArray;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.queue.QueueCircularArray;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.queue.QueueLinkedList;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.set.AVLTree;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.set.BinarySearchTree;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.set.BitsVectorSetImpl;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.set.Conjunto;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.set.ConjuntoNumerable;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.set.HashTableSetImpl;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.set.LinkedListSetImpl;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.stack.Stack;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.stack.StackArray;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.stack.StackLinkedList;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.stack.StackSpecialArray;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.tree.Node;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.tree.NodeImpl;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.tree.Tree;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.tree.TreeImpl;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.sorting.InsertionSort;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.sorting.MergeSort;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.sorting.QuickSort;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.sorting.SelectionSort;

public class UI {

	/**
	 * Main de toda la interfaz grafica
	 * 
	 * @param args
	 *            los argumentos que recibe en el main
	 * @throws IOException
	 *             Tira una excepcion si se sale en algun paso
	 */
	public static void main(String args[]) throws IOException {
		try {
			UI esto = new UI();
			esto.casosModelos();
		} catch (IOException ex) {
		}
	}

	/**
	 * Excepcion cuando alguien cancela la ejecucion del programa
	 * 
	 * @throws IOException
	 */
	private void cancelado() throws IOException {
		ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("Se cancelo la ejecucion del programa");
		throw f;
	}

	/**
	 * El caso principal de la clase que deja elegir el TDA
	 * 
	 * @throws IOException
	 *             si cancelan la ejecucion
	 */
	public void casosModelos() throws IOException {
		String input = "0";

		// Elija un TDA
		while (Integer.parseInt(input) < 1 || Integer.parseInt(input) > 7) {
			input = JOptionPane.showInputDialog(null, "Elija una de las siguiente opciones:\n" + "1. List\n"
					+ "2. Stack\n" + "3. Queue\n" + "4. Map\n" + "5. Tree\n" + "6. Set\n" + "7. Cerrar\n", "TDA`s", 3);
			if (input == null) {// Si se sale
				cancelado();// Excepcion
			}
			// Elija una opcion correcta
			if (Integer.parseInt(input) < 1 || Integer.parseInt(input) > 7) {
				JOptionPane.showMessageDialog(null, "Por favor elija una de las opciones", "Opcion no valida", 1);
			}
		}

		switch (Integer.parseInt(input)) {// Casos

		case 1:// List
			casosList();
			break;
		case 2:// Stack
			casosStack();
			break;
		case 3:// Queue
			casosQueue();
			break;
		case 4:// Map
			casosMap();
			break;
		case 5:// Tree
			casosTree();
			break;
		case 6:// Set
			casosSet();
			break;
		case 7:// Out
			JOptionPane.showMessageDialog(null, "GRACIAS!", "EXIT", 1);
			break;
		}

	}

	/**
	 * El caso para todas las estructuras de la lista
	 * 
	 * @throws IOException
	 */
	public void casosList() throws IOException {
		String inputList;

		// Elija el tipo de estructura
		inputList = JOptionPane.showInputDialog(null,
				"Elija una de las siguientes estructuras:\n" + "1. LinkedList\n" + "2. ArrayList\n" + "3. Regresar\n",
				"List", 3);
		if (inputList == null) {// Si lo cancela
			cancelado();// Sale
		}
		switch (Integer.parseInt(inputList)) {// Casos

		case 1:// LinkedList
			JOptionPane.showMessageDialog(null, "Eligio una LinkedList");
			List<Integer> lista = new LinkedList<Integer>();
			list(lista);
			break;
		case 2:// ArrayList
			JOptionPane.showMessageDialog(null, "Eligio un ArrayList");
			List<Integer> lista2 = new ArrayList<Integer>();
			list(lista2);
			break;
		case 3:// Regresa
			casosModelos();
			break;
		}
	}// Fin casosList

	/**
	 * El caso para todas las estructuras del stack
	 * 
	 * @throws IOException
	 */
	public void casosStack() throws IOException {
		String inputStack;
		// Elija una estructura
		inputStack = JOptionPane.showInputDialog(null, "Elija una de las siguiente estructuras:\n"
				+ "1. StackLinkedList\n" + "2. StackArray\n" + "3. StackSpecialArray\n" + "4. Regresar\n", "Stack", 3);
		if (inputStack == null) {// Si cancela
			cancelado();// Sale
		}
		switch (Integer.parseInt(inputStack)) {// Casos

		case 1:// StackLinkedList
			JOptionPane.showMessageDialog(null, "Eligio StackLinkedList");
			Stack<Integer> stack = new StackLinkedList<Integer>();
			stack(stack);
			break;
		case 2:// StackArray
			JOptionPane.showMessageDialog(null, "Eligio StackArray");
			Stack<Integer> stack2 = new StackArray<Integer>();
			stack(stack2);
			break;
		case 3:// SpecialStackArray
			JOptionPane.showMessageDialog(null, "Eligio StackSpecialArray");
			Stack<Integer> stack3 = new StackSpecialArray<Integer>();
			stack(stack3);
			break;
		case 4:// Regresa
			casosModelos();
			break;
		}
	}// Fin casosStack

	/**
	 * El caso para todas las estructuras del queue
	 * 
	 * @throws IOException
	 */
	public void casosQueue() throws IOException {
		String inputQueue;
		// Elija una estructuras
		inputQueue = JOptionPane.showInputDialog(null, "Elija una de las siguiente estructuras:\n"
				+ "1. QueueLinkedList\n" + "2. QueueArray\n" + "3. QueueCircularArray\n" + "4. Regresar\n", "Queue", 3);
		if (inputQueue == null) {// Si cancela
			cancelado();// Sale
		}
		switch (Integer.parseInt(inputQueue)) {// Casos

		case 1:// QueueLinkedList
			JOptionPane.showMessageDialog(null, "Eligio QueueLinkedList");
			Queue<Integer> queue = new QueueLinkedList<Integer>();
			queue(queue);
			break;
		case 2:// QueueArray
			JOptionPane.showMessageDialog(null, "Eligio QueueArray");
			Queue<Integer> queue2 = new QueueArray<Integer>();
			queue(queue2);
			break;
		case 3:// QueueCircularArray
			JOptionPane.showMessageDialog(null, "Eligio QueueCircularArray");
			Queue<Integer> queue3 = new QueueCircularArray<Integer>();
			queue(queue3);
			break;
		case 4:// Regresa
			casosModelos();
			break;
		}
	}// Fin casosQueue

	/**
	 * El caso para todas las estructuras del map
	 * 
	 * @throws IOException
	 */
	public void casosMap() throws IOException {
		String inputMap;
		// Elija una estructura
		inputMap = JOptionPane.showInputDialog(null,
				"Elija una de las siguiente estructuras:\n" + "1. LinkedMap\n" + "2. Regresar\n", "Map", 3);
		if (inputMap == null) {// Si cancela
			cancelado();// Sale
		}
		switch (Integer.parseInt(inputMap)) {// Casos
		case 1:// LinkedMap
			JOptionPane.showMessageDialog(null, "Eligio LinkedMap");
			Map<Integer, String> map = new LinkedMap<Integer, String>();
			map(map);
			break;
		case 2:// Regresa
			casosModelos();
			break;
		}
	}// Fin casosMap

	/**
	 * El caso para todas las estructuras del tree
	 * 
	 * @throws IOException
	 */
	public void casosTree() throws IOException {
		String inputTree;
		// Elija una estructura
		inputTree = JOptionPane.showInputDialog(null,
				"Elija una de las siguiente estructuras:\n" + "1. NodeTree\n" + "2. Regresar\n", "Tree", 3);
		if (inputTree == null) {// Si cancela
			cancelado();// Sale
		}
		switch (Integer.parseInt(inputTree)) {// Sale
		case 1:// NodeTree
			JOptionPane.showMessageDialog(null, "Eligio NodeTree");
			Tree<Integer> tree = null;
			tree(tree);
			break;
		case 2:// Regresa
			casosModelos();
			break;
		}
	}// Fin casosTree

	/**
	 * El caso para todas las estrcuturas del set
	 * 
	 * @throws IOException
	 */
	public void casosSet() throws IOException {
		String inputSet;
		// Elija una estructura
		inputSet = JOptionPane
				.showInputDialog(null,
						"Elija una de las siguiente estructuras:\n" + "1. BitSet\n" + "2. LinkedListSet\n"
								+ "3. HashTable\n" + "4. BinarySearchTree\n" + "5. Arbol AVL\n" + "6. Regresar\n",
						"Set", 3);
		if (inputSet == null) {// Si cancela
			cancelado();// Sale
		}
		switch (Integer.parseInt(inputSet)) {// Casos
		case 1:// BitSet
			JOptionPane.showMessageDialog(null, "Eligio BitSet");
			ConjuntoNumerable<Estudiante> bits = new BitsVectorSetImpl<Estudiante>();
			setNumerable(bits);
			break;
		case 2:// LinkedListSet
			JOptionPane.showMessageDialog(null, "Eligio LinkedListSet");
			Conjunto<Integer> set2 = new LinkedListSetImpl<Integer>();
			set(set2);
			break;
		case 3:// HashTable
			JOptionPane.showMessageDialog(null, "Eligio HashTable");
			Conjunto<Integer> set3 = new HashTableSetImpl<Integer>();
			set(set3);
			break;
		case 4:// BinarySearchTree
			JOptionPane.showMessageDialog(null, "Eligio BinarySearchTree");
			String dato = JOptionPane.showInputDialog(null,
					"Por favor ingrese el primer dato para la creacion del arbol", "Dato", 1);
			Conjunto<Integer> set4 = new BinarySearchTree<Integer>(Integer.parseInt(dato));
			set(set4);
			break;

		case 5:// ArbolAVL
			JOptionPane.showMessageDialog(null, "Eligio ArbolAVL");
			String dato2 = JOptionPane.showInputDialog(null,
					"Por favor ingrese el primer dato para la creacion del arbol", "Dato", 1);
			Conjunto<Integer> set5 = new AVLTree<Integer>(Integer.parseInt(dato2));
			set(set5);
			break;

		case 6:// Regresa
			casosModelos();
			break;
		}
	}// Fin casosSet

	/**
	 * Interfaz para las listas
	 * 
	 * @param lista
	 *            la lista creada en el casosLista, trae el tipo de lista que se
	 *            eligio
	 * @throws IOException
	 */
	public void list(List<Integer> lista) throws IOException {
		String input;
		// Elija una accion
		input = JOptionPane.showInputDialog(null,
				"Elija una operacion:\n" + "1. Agregar\n" + "2. Agregar posicionado\n"
						+ "3. Agregar multiples elementos\n" + "4. Eliminar\n" + "5. Buscar\n" + "6. Vacia?\n"
						+ "7. Tamaño de la coleccion\n" + "8. Limpiar coleccion\n" + "9. Imprimir la coleccion\n"
						+ "10. Ordenar coleccion\n" + "11. Regresar\n");
		if (input == null) {// Si cancela
			cancelado();// Sale
		}
		switch (Integer.parseInt(input)) {// Casos

		case 1:// Ingrese 1 dato
			lista.add(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a ingresar", "Dato", 1)));
			list(lista);
			break;

		case 2:// Ingrese 1 dato con posicion
			int dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a ingresar", "Dato", 1));
			int posicion = Integer
					.parseInt(JOptionPane.showInputDialog(null, "Ingrese la posicion del dato", "Posicion", 1));
			lista.add(dato, posicion);
			list(lista);
			break;

		case 3:// Ingrese varios datos
			String dato2 = JOptionPane.showInputDialog(null, "Ingrese los datos a ingresar serparados por una ,",
					"Lista", 1);
			StringTokenizer datos = new StringTokenizer(dato2, ",");
			while (datos.hasMoreTokens()) {
				lista.add(Integer.parseInt(datos.nextToken()));
			}
			list(lista);
			break;

		case 4:// Borre 1 dato
			Integer aBorrar = Integer
					.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a eliminar", "Dato", 1));
			lista.remove(aBorrar);
			list(lista);
			break;

		case 5:// Encuentre 1 dato
			boolean esta = lista.contains(Integer
					.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a buscar en la lista", "Dato", 1)));
			if (esta) {
				JOptionPane.showMessageDialog(null, "El elemento esta en la lista", "Esta?", 1);
			} else {
				JOptionPane.showMessageDialog(null, "El elemento no esta en la lista", "Esta?", 2);
			}
			list(lista);
			break;

		case 6:// Coleccion vacia?
			boolean vacia = lista.isEmpty();
			if (vacia) {
				JOptionPane.showMessageDialog(null, "La lista esta vacia", "Vacia?", 0);
			} else {
				JOptionPane.showMessageDialog(null, "La lista no esta vacia", "Vacia?", 2);
			}
			list(lista);
			break;

		case 7:// Tamaño lista
			JOptionPane.showMessageDialog(null, "El tamaño de la lista es " + lista.size(), "Tamaño", 1);
			list(lista);
			break;

		case 8:// Limpia la lista
			lista.clear();
			JOptionPane.showMessageDialog(null, "La coleccion ha sido borrada", "Borrado", 2);
			list(lista);
			break;

		case 9:// Imprime
			if (lista.size() == 0) {
				JOptionPane.showMessageDialog(null, "La lista esta vacia", "VACIA!", 0);
				list(lista);
			} else {
				Iterator<Integer> it = lista.iterator();
				int[] numeros = new int[lista.size()];
				int i = 0;
				while (it.hasNext()) {
					numeros[i] = (it.next());
					i++;
				}
				JOptionPane.showMessageDialog(null, "La lista es la siguiente:\n" + Arrays.toString(numeros),
						"Impresion Lista", 1);
				list(lista);
			}
			break;

		case 10:// Sort
			int eleccion = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Ingrese el tipo algoritmo de ordenamiento\n" + "1. Insertion Sort\n" + "2. Selection Sort\n"
							+ "3. Quicksort\n" + "4. MergeSort enfoque TopBottom\n" + "5. MergeSort enfoque BottomTop\n"
							+ "6. Resgresar\n",
					"Dato", 1));
			if (input == null) {// Si cancela
				cancelado();// Sale
			}
			switch (eleccion) {

			case 1:// Insertion
				if (lista.size() == 0) {
					JOptionPane.showMessageDialog(null, "La lista esta vacia", "VACIA!", 0);
					list(lista);
				} else {
					InsertionSort<Integer> isort = new InsertionSort<Integer>();
					isort.insertionSort(lista);
					list(lista);
				}
				break;

			case 2:// Selection
				if (lista.size() == 0) {
					JOptionPane.showMessageDialog(null, "La lista esta vacia", "VACIA!", 0);
					list(lista);
				} else {
					SelectionSort<Integer> ssort = new SelectionSort<Integer>();
					ssort.selectionSort(lista);
					list(lista);
				}
				break;

			case 3:// QuickSort
				if (lista.size() == 0) {
					JOptionPane.showMessageDialog(null, "La lista esta vacia", "VACIA!", 0);
					list(lista);
				} else {
					QuickSort<Integer> qsort = new QuickSort<Integer>();
					qsort.quickSort(lista, 1, lista.size());
					list(lista);
				}
				break;

			case 4:// Merge TopDown
				if (lista.size() == 0) {
					JOptionPane.showMessageDialog(null, "La lista esta vacia", "VACIA!", 0);
					list(lista);
				} else {
					MergeSort<Integer> msort = new MergeSort<Integer>();
					msort.mergeSortTopBottom(lista);
					list(lista);
				}
				break;

			case 5:// Merge BottomUp
				if (lista.size() == 0) {
					JOptionPane.showMessageDialog(null, "La lista esta vacia", "VACIA!", 0);
				} else {
					MergeSort<Integer> msort = new MergeSort<Integer>();
					msort.mergeSortBottomTop(lista);
					list(lista);
				}
				break;

			case 6:// Regresa
				list(lista);
				break;

			}
			break;

		case 11:// Regresa
			casosList();
			break;
		}

	}// Fin List

	/**
	 * Interfaz para los queue
	 * 
	 * @param queue
	 *            El queue creado en el casosQueue, trae el tipo de queue que se
	 *            eligio
	 * @throws IOException
	 */
	public void queue(Queue<Integer> queue) throws IOException {
		String input;
		// Elija una accion
		input = JOptionPane.showInputDialog(null,
				"Elija una operacion:\n" + "1. Agregar\n" + "2. Agregar multiples elementos\n" + "3. Eliminar\n"
						+ "4. Buscar\n" + "5. Vacia?\n" + "6. Tamaño de la coleccion\n" + "7. Limpiar coleccion\n"
						+ "8. Imprimir la coleccion\n" + "9. Regresar\n");
		if (input == null) {// Si cancela
			cancelado();// Sale
		}
		switch (Integer.parseInt(input)) {// Casos

		case 1:// Ingresa 1 dato
			queue.add(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a ingresar", "Dato", 1)));
			queue(queue);
			break;

		case 2:// Ingresa varios datos
			String dato2 = JOptionPane.showInputDialog(null, "Ingrese los datos a ingresar serparados por una ,",
					"Cola", 1);
			StringTokenizer datos = new StringTokenizer(dato2, ",");
			while (datos.hasMoreTokens()) {
				queue.add(Integer.parseInt(datos.nextToken()));
			}
			queue(queue);
			break;

		case 3:// Elimina 1 dato
			Integer aBorrar = Integer
					.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a eliminar", "Dato", 1));
			queue.remove(aBorrar);
			queue(queue);
			break;

		case 4:// Contiene un dato
			boolean esta = queue.contains(Integer
					.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a buscar en la cola", "Dato", 1)));
			if (esta) {
				JOptionPane.showMessageDialog(null, "El elemento esta en la cola", "Esta?", 1);
			} else {
				JOptionPane.showMessageDialog(null, "El elemento no esta en la cola", "Esta?", 2);
			}
			queue(queue);
			break;

		case 5:// Coleccion vacia?
			boolean vacia = queue.isEmpty();
			if (vacia) {
				JOptionPane.showMessageDialog(null, "La cola esta vacia", "Vacia?", 0);
			} else {
				JOptionPane.showMessageDialog(null, "La cola no esta vacia", "Vacia?", 2);
			}
			queue(queue);
			break;

		case 6:// Tamaño de la coleccion
			JOptionPane.showMessageDialog(null, "El tamaño de la cola es " + queue.size(), "Tamaño", 1);
			queue(queue);
			break;

		case 7:// Limpia la cola
			queue.clear();
			JOptionPane.showMessageDialog(null, "La coleccion ha sido borrada", "Borrado", 2);
			queue(queue);
			break;

		case 8:// Imprime
			if (queue.size() == 0) {
				JOptionPane.showMessageDialog(null, "La cola esta vacia", "VACIA!", 0);
				queue(queue);
			} else {
				Iterator<Integer> it = queue.iterator();
				int[] numeros = new int[queue.size()];
				int i = 0;
				while (it.hasNext()) {
					numeros[i] = (it.next());
					i++;
				}
				JOptionPane.showMessageDialog(null, "La cola es la siguiente:\n" + Arrays.toString(numeros),
						"Impresion Cola", 1);
				queue(queue);
			}
			break;

		case 9:// Regresa
			casosQueue();
			break;
		}
	}// Fin queue

	/**
	 * Interfaz para las stack
	 * 
	 * @param stack
	 *            La stack que se creo en casosStack, trae el tipo de stack que
	 *            se eligio
	 * @throws IOException
	 */
	public void stack(Stack<Integer> stack) throws IOException {
		String input;
		// Elija una accion
		input = JOptionPane.showInputDialog(null,
				"Elija una operacion:\n" + "1. Agregar\n" + "2. Agregar multiples elementos\n" + "3. Eliminar\n"
						+ "4. Buscar\n" + "5. Vacia?\n" + "6. Tamaño de la coleccion\n" + "7. Limpiar coleccion\n"
						+ "8. Imprimir la coleccion\n" + "9. Regresar\n");
		if (input == null) {// Si cancela
			cancelado();// Sale
		}
		switch (Integer.parseInt(input)) {// Casos

		case 1:// Ingrese 1 dato
			stack.add(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a ingresar", "Dato", 1)));
			stack(stack);
			break;

		case 2:// Ingrese varios datos
			String dato2 = JOptionPane.showInputDialog(null, "Ingrese los datos a ingresar serparados por una ,",
					"Pila", 1);
			StringTokenizer datos = new StringTokenizer(dato2, ",");
			while (datos.hasMoreTokens()) {
				stack.add(Integer.parseInt(datos.nextToken()));
			}
			stack(stack);
			break;

		case 3:// Borre 1 dato
			Integer aBorrar = Integer
					.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a eliminar", "Dato", 1));
			stack.remove(aBorrar);
			stack(stack);
			break;

		case 4:// Contiene 1 dato
			boolean esta = stack.contains(Integer
					.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a buscar en la pila", "Dato", 1)));
			if (esta) {
				JOptionPane.showMessageDialog(null, "El elemento esta en la pila", "Esta?", 1);
			} else {
				JOptionPane.showMessageDialog(null, "El elemento no esta en la pila", "Esta?", 2);
			}
			stack(stack);
			break;

		case 5:// Coleccion vacia?
			boolean vacia = stack.isEmpty();
			if (vacia) {
				JOptionPane.showMessageDialog(null, "La pila esta vacia", "Vacia?", 0);
			} else {
				JOptionPane.showMessageDialog(null, "La pila no esta vacia", "Vacia?", 2);
			}
			stack(stack);
			break;

		case 6:// Tamaño de la coleccion
			JOptionPane.showMessageDialog(null, "El tamaño de la pila es " + stack.size(), "Tamaño", 1);
			stack(stack);
			break;

		case 7:// Limpia la stack
			stack.clear();
			JOptionPane.showMessageDialog(null, "La coleccion ha sido borrada", "Borrado", 2);
			stack(stack);
			break;

		case 8:// Imprime
			if (stack.size() == 0) {
				JOptionPane.showMessageDialog(null, "La pila esta vacia", "VACIA!", 0);
				stack(stack);
			} else {
				Iterator<Integer> it = stack.iterator();
				int[] numeros = new int[stack.size()];
				int i = 0;
				while (it.hasNext()) {
					numeros[i] = (it.next());
					i++;
				}
				JOptionPane.showMessageDialog(null, "La pila es la siguiente:\n" + Arrays.toString(numeros),
						"Impresion pila", 1);
				stack(stack);
			}
			break;

		case 9:// Regresa
			casosStack();
			break;

		}
	}// Fin stack

	/**
	 * Interfaz para el map
	 * 
	 * @param map
	 *            El map creado en casosMap, es un linkedMap
	 * @throws IOException
	 */
	public void map(Map<Integer, String> map) throws IOException {
		String input;
		// Elija una accion
		input = JOptionPane.showInputDialog(null,
				"Elija una operacion:\n" + "1. Agregar\n" + "2. Agregar multiples elementos\n" + "3. Eliminar\n"
						+ "4. Buscar\n" + "5. Vacia?\n" + "6. Tamaño de la coleccion\n" + "7. Limpiar coleccion\n"
						+ "8. Imprimir la coleccion\n" + "9. Regresar\n");
		if (input == null) {// Si cancela
			cancelado();// Sale
		}
		switch (Integer.parseInt(input)) {// Sale

		case 1:// Ingresa 1 dato
			String dato = JOptionPane.showInputDialog(null,
					"Inserte el par a ingresar con el siguiente formato (Numero - String)", "Par", 1);
			StringTokenizer datos = new StringTokenizer(dato, "-");
			map.put(Integer.parseInt(datos.nextToken()), datos.nextToken());
			map(map);
			break;

		case 2:// Ingresa varios datos
			String dato2 = JOptionPane.showInputDialog(null,
					"Inserte los pares a ingresar con el siguiente formato ((Numero - String) con el guion y cada pareja de datos separados por una coma)",
					"Pares", 1);
			StringTokenizer datos2 = new StringTokenizer(dato2, ",");
			while (datos2.hasMoreTokens()) {
				String aIngresar = datos2.nextToken();
				StringTokenizer datosIngresar = new StringTokenizer(aIngresar, "-");
				map.put(Integer.parseInt(datosIngresar.nextToken()), datosIngresar.nextToken());
			}
			map(map);
			break;

		case 3:// Elimina 1 dato
			map.remove(Integer
					.parseInt(JOptionPane.showInputDialog(null, "Inserte el numero que desea eliminar", "Dato", 3)));
			map(map);
			break;

		case 4:// Contiene un dato
			String[] opciones = { "Numeros", "Letras" };
			int dato3 = JOptionPane.showOptionDialog(null, "Elija el tipo de dato que desea buscar", "Datos",
					JOptionPane.YES_NO_OPTION, 3, null, opciones, null);

			if (dato3 == 0) {
				if (map.containsKey(Integer.parseInt(
						JOptionPane.showInputDialog(null, "Elija el numero que desea buscar", "Numero", 3)))) {
					JOptionPane.showMessageDialog(null, "El elemento esta en el mapa", "Esta", 1);
				} else {
					JOptionPane.showMessageDialog(null, "El elemento no esta en el mapa", "No esta", 0);
				}
			} else if (dato3 == 1) {
				if (map.containsValue(
						JOptionPane.showInputDialog(null, "Ingrese la o las letras que desea buscar", "Letras", 3))) {
					JOptionPane.showMessageDialog(null, "El elemento esta en el mapa", "Esta", 1);
				} else {
					JOptionPane.showMessageDialog(null, "El elemento no esta en el mapa", "No esta", 0);
				}
			}
			map(map);
			break;

		case 5:// Coleccion vacia?
			boolean vacia = map.isEmpty();
			if (vacia) {
				JOptionPane.showMessageDialog(null, "El mapa esta vacio", "Vacio?", 0);
			} else {
				JOptionPane.showMessageDialog(null, "El mapa no esta vacio", "Vacio?", 2);
			}
			map(map);
			break;

		case 6:// Tamaño de la coleccion
			JOptionPane.showMessageDialog(null, "El tamaño del mapa es " + map.size(), "Tamaño", 1);
			map(map);
			break;

		case 7:// Limpia el mapap
			if (map.size() == 0) {
				JOptionPane.showMessageDialog(null, "La coleccion ya estaba vacia", "Borrado", 2);
				map(map);
				break;
			} else {
				map.clear();
				JOptionPane.showMessageDialog(null, "La coleccion ha sido borrada", "Borrado", 2);
				map(map);
				break;
			}

		case 8:// Imprime
			Iterator<Integer> itMap = map.iterator();
			String impresion = "";
			while (itMap.hasNext()) {
				int data = itMap.next();
				impresion += Integer.toString(data) + "-" + map.get(data) + ",\n";
			}
			JOptionPane.showMessageDialog(null, "El mapa completo es\n" + impresion, "Mapa", 3);
			map(map);
			break;

		case 9:// Regresa
			casosMap();
			break;

		}
	}// Fin map

	/**
	 * Auxiliar para la insercion del NodeTree
	 * 
	 * @param raiz
	 *            la raiz del arbol
	 * @param aInsertar
	 *            el nodo a insertar
	 * @param padre
	 *            el nodo al cual queremos insertar el nodo a insertar
	 */
	private void insercion(Node<Integer> raiz, Node<Integer> aInsertar, Integer padre) {
		if (raiz.getData().equals(padre)) {// Si encontramos el nodo donde se
											// quiere insertar
			raiz.addChild(aInsertar);// Se inserta
			aInsertar.setParent(raiz);// Asigna padre
		} else {
			if (raiz.getChildren() != null) {// Si no es donde se quiere
												// insertar
				List<Node<Integer>> lista = raiz.getChildren();// Busca en los
																// hijos
				for (int i = 1; i <= lista.size(); i++) {
					insercion(lista.get(i), aInsertar, padre);
				}
			}
		}
	}

	/**
	 * Auxiliar para el borrado del NodeTree
	 * 
	 * @param raiz
	 *            la raiz del arbol
	 * @param aBorrar
	 *            el nodo que se quiere borrar
	 * @param padre
	 *            el nodo padre del nodo a borrar
	 * @param posicion
	 *            la posicion entre los hijos del nodo a borrar
	 */
	private void borrado(Node<Integer> raiz, Integer aBorrar, Node<Integer> padre, int posicion) {
		if (raiz.getData().equals(aBorrar)) {// Si encontramos el nodo que
												// queremos borrar
			padre.removeChildAt(posicion);// Lo borra con la posicion
		} else {
			if (raiz.getChildren() != null) {// Si no es el nodo
				List<Node<Integer>> lista = raiz.getChildren();// Recorremos los
																// hijos en
																// busca de el
				for (int i = 1; i <= lista.size(); i++) {
					borrado(lista.get(i), aBorrar, raiz, i);// Guardando la
															// posicion por
															// donde va la
															// busqueda
				}
			}
		}
	}

	/**
	 * Interfa para el tree
	 * 
	 * @param tree
	 *            El arbol creado en casosTree, es un nodeTree
	 * @throws IOException
	 */
	public void tree(Tree<Integer> tree) throws IOException {
		if (tree == null) {// Crea la raiz del arbol ya que el arbol no acepta
							// estar vacio del todo
			tree = new TreeImpl<Integer>(Integer.parseInt(JOptionPane.showInputDialog(null,
					"Por favor inserte la raiz del arbol para su creacion", "Raiz", 3)));
		}
		String input;
		// Elija una accion
		input = JOptionPane.showInputDialog(null,
				"Elija una operacion:\n" + "1. Agregar\n" + "2. Agregar multiples elementos\n" + "3. Eliminar\n"
						+ "4. Buscar\n" + "5. Vacia?\n" + "6. Tamaño de la coleccion\n" + "7. Limpiar coleccion\n"
						+ "8. Imprimir la coleccion\n" + "9. Regresar\n");
		if (input == null) {// Si cancela
			cancelado();// Sale
		}
		switch (Integer.parseInt(input)) {// Casos

		case 1:// Inserta 1 elemento
			Integer insercion = Integer
					.parseInt(JOptionPane.showInputDialog(null, "Escriba el elemento que desea insertar", "Dato", 3));
			Integer posicion = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Escriba el elemento al cual le desea insertar el nuevo elemento", "Dato", 3));
			Node<Integer> nodo = new NodeImpl<Integer>(insercion, null);
			insercion(tree.getRoot(), nodo, posicion);
			tree(tree);
			break;

		case 2:// Inserta varios elementos
			String dato2 = JOptionPane.showInputDialog(null,
					"Inserte los datos a insertar con el siguiente formato ((Dato a insertar-Padre) con el guion)",
					"Nodos", 1);
			StringTokenizer datos2 = new StringTokenizer(dato2, ",");
			while (datos2.hasMoreTokens()) {
				String aIngresar = datos2.nextToken();
				StringTokenizer datosIngresar = new StringTokenizer(aIngresar, "-");
				Node<Integer> nodo2 = new NodeImpl<Integer>(Integer.parseInt(datosIngresar.nextToken()), null);
				insercion(tree.getRoot(), nodo2, Integer.parseInt(datosIngresar.nextToken()));
			}
			tree(tree);
			break;

		case 3:// Elimina 1 elemento
			Integer borrar = Integer
					.parseInt(JOptionPane.showInputDialog(null, "Escriba el elemento que desea borrar", "Dato", 3));
			borrado(tree.getRoot(), borrar, tree.getRoot(), 0);
			tree(tree);
			break;

		case 4:// Contiene un elemento
			boolean si = tree.exists(
					Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato que desea buscar", "Dato", 3)));
			if (si) {
				JOptionPane.showMessageDialog(null, "El elemento si esta en el arbol", "Esta", 1);
			} else {
				JOptionPane.showMessageDialog(null, "El elemento no esta en el arbol", "Esta", 0);
			}
			tree(tree);
			break;

		case 5:// Coleccion vacia?
			if (tree.getNumberOfNodes() == 0) {
				JOptionPane.showMessageDialog(null, "La coleccion esta vacia", "Vacia", 0);
			} else {
				JOptionPane.showMessageDialog(null, "La coleccion no esta vacia", "Vacia", 1);
			}
			tree(tree);
			break;

		case 6:// Tamaño del arbol
			JOptionPane.showMessageDialog(null, "La cantidad de elementos en el arbol es: " + tree.getNumberOfNodes(),
					"Cantidad de nodos", 1);
			tree(tree);
			break;

		case 7:// Imprime
			List<Node<Integer>> lista2 = new LinkedList<Node<Integer>>();
			lista2 = tree.getPreOrderTraversal();
			Iterator<Node<Integer>> it2 = lista2.iterator();
			int[] numeros2 = new int[lista2.size()];
			int x = 0;
			while (it2.hasNext()) {
				numeros2[x] = (it2.next().getData());
				x++;
			}
			JOptionPane.showMessageDialog(null, "El arbol es el siguiente:\n" + Arrays.toString(numeros2),
					"Impresion Arbol", 1);
			tree(tree);
			break;

		case 8:// Limpia el arbol
			Node<Integer> nod = tree.getRoot();
			nod.setData(null);
			while (nod.getChildren() != null) {
				nod.removeChildren();
			}
			tree(tree);
			break;

		case 9:// Regresa
			casosTree();
			break;

		}// Fin tree
	}

	/**
	 * Interfaz para el set
	 * 
	 * @param set
	 *            El set creado en casosSet, trae el tipo de set que se eligio
	 *            menos el de ConjuntoNumerable
	 * @throws IOException
	 */
	public void set(Conjunto<Integer> set) throws IOException {
		String input;
		// Elija una opcion
		input = JOptionPane.showInputDialog(null,
				"Elija una operacion:\n" + "1. Agregar\n" + "2. Agregar multiples elementos\n" + "3. Union\n"
						+ "4. Diferencia\n" + "5. Interseccion\n" + "6. Eliminar\n" + "7. Buscar\n" + "8. Vacia?\n"
						+ "9. Tamaño de la coleccion\n" + "10. Limpiar coleccion\n" + "11. Imprimir la coleccion\n"
						+ "12. Regresar\n");
		if (input == null) {// Si cancela
			cancelado();// Sale
		}
		switch (Integer.parseInt(input)) {// Casos

		case 1:// Inserta 1 dato
			int dato = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Escriba el elemento que desea insertar en el conjunto", "Dato", 3));
			set.add(dato);
			set(set);
			break;

		case 2:// Inserta varios datos
			String dato2 = JOptionPane.showInputDialog(null, "Ingrese los datos a ingresar serparados por una ,",
					"Pila", 1);
			StringTokenizer datos = new StringTokenizer(dato2, ",");
			while (datos.hasMoreTokens()) {
				set.add(Integer.parseInt(datos.nextToken()));
			}
			set(set);
			break;

		case 3:// Union
			Conjunto<Integer> con = new LinkedListSetImpl<Integer>();
			String dato3 = JOptionPane.showInputDialog(null, "Ingrese los datos a ingresar serparados por una ,",
					"Conjunto", 1);
			StringTokenizer datos3 = new StringTokenizer(dato3, ",");
			while (datos3.hasMoreTokens()) {
				con.add(Integer.parseInt(datos3.nextToken()));
			}
			con = con.union(set, con);
			Iterator<Integer> it1 = con.iterator();
			String numeros = "";
			while (it1.hasNext()) {
				if (numeros == "") {
					numeros += (it1.next());
				} else {
					numeros += ", ";
					numeros += (it1.next());
				}
			}
			JOptionPane.showMessageDialog(null, "El conjunto es el siguiente:\n" + numeros, "Impresion conjunto", 1);
			set(set);
			break;

		case 4:// Diferencia
			Conjunto<Integer> con2 = new LinkedListSetImpl<Integer>();
			String dato4 = JOptionPane.showInputDialog(null, "Ingrese los datos a ingresar serparados por una ,",
					"Conjunto", 1);
			StringTokenizer datos4 = new StringTokenizer(dato4, ",");
			while (datos4.hasMoreTokens()) {
				con2.add(Integer.parseInt(datos4.nextToken()));
			}
			con2 = con2.difference(set, con2);
			Iterator<Integer> it2 = con2.iterator();
			String numeros2 = "";
			while (it2.hasNext()) {
				if (numeros2 == "") {
					numeros2 += (it2.next());
				} else {
					numeros2 += ", ";
					numeros2 += (it2.next());
				}
			}
			JOptionPane.showMessageDialog(null, "El conjunto es el siguiente:\n" + numeros2, "Impresion conjunto", 1);
			set(set);
			break;

		case 5:// Interseccion
			Conjunto<Integer> con3 = new LinkedListSetImpl<Integer>();
			String dato5 = JOptionPane.showInputDialog(null, "Ingrese los datos a ingresar serparados por una ,",
					"Conjunto", 1);
			StringTokenizer datos5 = new StringTokenizer(dato5, ",");
			while (datos5.hasMoreTokens()) {
				con3.add(Integer.parseInt(datos5.nextToken()));
			}
			con3 = con3.intersection(set, con3);
			Iterator<Integer> it3 = con3.iterator();
			String numeros3 = "";
			while (it3.hasNext()) {
				if (numeros3 == "") {
					numeros3 += (it3.next());
				} else {
					numeros3 += ", ";
					numeros3 += (it3.next());
				}
			}
			JOptionPane.showMessageDialog(null, "El conjunto es el siguiente:\n" + numeros3, "Impresion conjunto", 1);
			set(set);
			break;

		case 6:// Elimina 1 dato
			Integer aBorrar = Integer
					.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a eliminar", "Dato", 1));
			set.remove(aBorrar);
			set(set);
			break;

		case 7:// Contiene un elemento
			boolean esta = set.contains(Integer
					.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a buscar en el conjunto", "Dato", 1)));
			if (esta) {
				JOptionPane.showMessageDialog(null, "El elemento esta en el conjunto", "Esta?", 1);
			} else {
				JOptionPane.showMessageDialog(null, "El elemento no esta en el conjunto", "Esta?", 2);
			}
			set(set);
			break;

		case 8:// Coleccion vacia?
			boolean vacia = set.isEmpty();
			if (vacia) {
				JOptionPane.showMessageDialog(null, "El conjunto esta vacio", "Vacia?", 0);
			} else {
				JOptionPane.showMessageDialog(null, "El conjunto no esta vacio", "Vacia?", 2);
			}
			set(set);
			break;

		case 9:// Tamaño del conjunto
			JOptionPane.showMessageDialog(null, "El tamaño del conjunto es " + "Tamaño" + set.size(), "Tamaño", 1);
			set(set);
			break;

		case 10:// Limpia el conjunto
			set.clear();
			JOptionPane.showMessageDialog(null, "La coleccion ha sido borrada", "Borrado", 2);
			set(set);
			break;

		case 11:// Imprime el conjunto
			Iterator<Integer> it = set.iterator();
			String numeros6 = "";
			while (it.hasNext()) {
				if (numeros6 == "") {
					numeros6 += (it.next());
				} else {
					numeros6 += ", ";
					numeros6 += (it.next());
				}
			}
			JOptionPane.showMessageDialog(null, "El conjunto es el siguiente:\n" + numeros6, "Impresion conjunto", 1);
			set(set);
			// }
			break;

		case 12:// Regresa
			casosSet();
			break;

		}
	}// Fin set no numerable

	/**
	 * Interfaz para el set numerable
	 * 
	 * @param set
	 *            El set numerable creado en casosSet, tiene un BitVectorSet
	 * @throws IOException
	 */
	public void setNumerable(ConjuntoNumerable<Estudiante> set) throws IOException {
		String input;
		// Elija una accion
		input = JOptionPane.showInputDialog(null,
				"Elija una operacion:\n" + "1. Agregar\n" + "2. Agregar multiples elementos\n" + "3. Union\n"
						+ "4. Diferencia\n" + "5. Interseccion\n" + "6. Eliminar\n" + "7. Buscar\n" + "8. Vacia?\n"
						+ "9. Tamaño de la coleccion\n" + "10. Limpiar coleccion\n" + "11. Imprimir la coleccion\n"
						+ "12. Regresar\n");
		if (input == null) {// Si cancela
			cancelado();// Sale
		}
		switch (Integer.parseInt(input)) {// Casos

		case 1:// Ingrese 1 dato
			String nombre = JOptionPane.showInputDialog(null, "Por favor inserte el nombre del estudiante", "Nombre",
					3);
			int dato = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Escriba el index o posicion en la lista de clase del estudiante", "Index", 3));

			set.add(new Estudiante(nombre, dato));
			setNumerable(set);
			break;

		case 2:// Ingrese varios datos
			String dato2 = JOptionPane.showInputDialog(null,
					"Inserte los Estudiante a ingresar con el siguiente formato ((Nombre - Index) con el guion y cada pareja de datos separados por una coma",
					"Estudiantes", 1);
			StringTokenizer datos2 = new StringTokenizer(dato2, ",");
			while (datos2.hasMoreTokens()) {
				String aIngresar = datos2.nextToken();
				StringTokenizer datosIngresar = new StringTokenizer(aIngresar, "-");
				set.add(new Estudiante(datosIngresar.nextToken(), Integer.parseInt(datosIngresar.nextToken())));
			}
			setNumerable(set);
			break;

		case 3:// Union
			ConjuntoNumerable<Estudiante> con = new BitsVectorSetImpl<Estudiante>();
			String dato3 = JOptionPane.showInputDialog(null,
					"Inserte los Estudiante a ingresar con el siguiente formato ((Nombre - Index) con el guion y cada pareja de datos separados por una coma",
					"Estudiantes", 1);
			StringTokenizer datos3 = new StringTokenizer(dato3, ",");
			while (datos3.hasMoreTokens()) {
				String aIngresar = datos3.nextToken();
				StringTokenizer datosIngresar = new StringTokenizer(aIngresar, "-");
				con.add(new Estudiante(datosIngresar.nextToken(), Integer.parseInt(datosIngresar.nextToken())));
			}
			con = con.union(set, con);
			Iterator<Estudiante> it1 = con.iterator();
			String numeros = "";
			while (it1.hasNext()) {
				if (numeros == "") {
					Estudiante es = it1.next();
					numeros += es.getIndex();
					numeros += "-";
					numeros += es.getNombre();
				} else {
					numeros += ", ";
					Estudiante es = it1.next();
					numeros += es.getIndex();
					numeros += "-";
					numeros += es.getNombre();
				}
			}
			JOptionPane.showMessageDialog(null, "El conjunto es el siguiente:\n" + numeros, "Impresion conjunto", 1);
			setNumerable(set);
			break;

		case 4:// Diferencia
			ConjuntoNumerable<Estudiante> con2 = new BitsVectorSetImpl<Estudiante>();
			String dato4 = JOptionPane.showInputDialog(null,
					"Inserte los Estudiante a ingresar con el siguiente formato ((Nombre - Index) con el guion y cada pareja de datos separados por una coma",
					"Estudiantes", 1);
			StringTokenizer datos4 = new StringTokenizer(dato4, ",");
			while (datos4.hasMoreTokens()) {
				String aIngresar = datos4.nextToken();
				StringTokenizer datosIngresar = new StringTokenizer(aIngresar, "-");
				con2.add(new Estudiante(datosIngresar.nextToken(), Integer.parseInt(datosIngresar.nextToken())));
			}
			con2 = con2.difference(set, con2);
			Iterator<Estudiante> it2 = con2.iterator();
			String numeros2 = "";
			while (it2.hasNext()) {
				if (numeros2 == "") {
					Estudiante es = it2.next();
					numeros2 += es.getIndex();
					numeros2 += "-";
					numeros2 += es.getNombre();
				} else {
					numeros2 += ", ";
					Estudiante es = it2.next();
					numeros2 += es.getIndex();
					numeros2 += "-";
					numeros2 += es.getNombre();
				}
			}
			JOptionPane.showMessageDialog(null, "El conjunto es el siguiente:\n" + numeros2, "Impresion conjunto", 1);
			setNumerable(set);
			break;

		case 5:// Interseccion
			ConjuntoNumerable<Estudiante> con3 = new BitsVectorSetImpl<Estudiante>();
			String dato5 = JOptionPane.showInputDialog(null,
					"Inserte los Estudiante a ingresar con el siguiente formato ((Nombre - Index) con el guion y cada pareja de datos separados por una coma",
					"Estudiantes", 1);
			StringTokenizer datos5 = new StringTokenizer(dato5, ",");
			while (datos5.hasMoreTokens()) {
				String aIngresar = datos5.nextToken();
				StringTokenizer datosIngresar = new StringTokenizer(aIngresar, "-");
				con3.add(new Estudiante(datosIngresar.nextToken(), Integer.parseInt(datosIngresar.nextToken())));
			}
			con3 = con3.intersection(set, con3);
			Iterator<Estudiante> it3 = con3.iterator();
			String numeros3 = "";
			while (it3.hasNext()) {
				if (numeros3 == "") {
					Estudiante es = it3.next();
					numeros3 += es.getIndex();
					numeros3 += "-";
					numeros3 += es.getNombre();
				} else {
					numeros3 += ", ";
					Estudiante es = it3.next();
					numeros3 += es.getIndex();
					numeros3 += "-";
					numeros3 += es.getNombre();
				}
			}
			JOptionPane.showMessageDialog(null, "El conjunto es el siguiente:\n" + numeros3, "Impresion conjunto", 1);
			setNumerable(set);
			break;

		case 6:// Borre un elemento
			Integer aBorrar = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Ingrese el index en la lista del estudiante que desea elimiar", "Index", 1));
			set.remove(new Estudiante(null, aBorrar));
			setNumerable(set);
			break;

		case 7:// Contiene un elemento
			boolean esta = set.contains(new Estudiante(null, Integer.parseInt(JOptionPane.showInputDialog(null,
					"Ingrese index del estudiante que desea buscar en la coleccion", "Dato", 1))));
			if (esta) {
				JOptionPane.showMessageDialog(null, "El elemento esta en el conjunto", "Esta?", 1);
			} else {
				JOptionPane.showMessageDialog(null, "El elemento no esta en el conjunto", "Esta?", 2);
			}
			setNumerable(set);
			break;

		case 8:// Conjunto vacio?
			boolean vacia = set.isEmpty();
			if (vacia) {
				JOptionPane.showMessageDialog(null, "El conjunto esta vacio", "Vacia?", 0);
			} else {
				JOptionPane.showMessageDialog(null, "El conjunto no esta vacio", "Vacia?", 2);
			}
			setNumerable(set);
			break;

		case 9:// Tamaño del conjunto
			JOptionPane.showMessageDialog(null, "El tamaño del conjunto es " + "Tamaño" + set.size(), "Tamaño", 1);
			setNumerable(set);
			break;

		case 10:// Limpia la coleccion
			set.clear();
			JOptionPane.showMessageDialog(null, "La coleccion ha sido borrada", "Borrado", 2);
			setNumerable(set);
			break;

		case 11:// Imprime
			Iterator<Estudiante> it = set.iterator();
			String numeros6 = "";
			while (it.hasNext()) {
				if (numeros6 == "") {
					Estudiante es = it.next();
					numeros6 += es.getIndex();
					numeros6 += "-";
					numeros6 += es.getNombre();
				} else {
					numeros6 += ", ";
					Estudiante es = it.next();
					numeros6 += es.getIndex();
					numeros6 += "-";
					numeros6 += es.getNombre();
				}
			}
			JOptionPane.showMessageDialog(null, "El conjunto es el siguiente:\n" + numeros6, "Impresion conjunto", 1);
			setNumerable(set);
			break;

		case 12:// Regresa
			casosSet();
			break;

		}
	}// Fin set Numerable
}// Fin UI
