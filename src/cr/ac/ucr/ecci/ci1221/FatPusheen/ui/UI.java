package cr.ac.ucr.ecci.ci1221.FatPusheen.ui;

import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

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
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.stack.Stack;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.stack.StackArray;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.stack.StackLinkedList;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.stack.StackSpecialArray;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.tree.Node;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.tree.NodeImpl;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.tree.Tree;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.tree.TreeImpl;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.sorting.InsertionSort;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.sorting.QuickSort;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.sorting.SelectionSort;

public class UI {

	public static void main(String args[]) {
		UI esto = new UI();
		esto.casosModelos();
	}

	public void casosModelos() {
		String input = "0";

		while (Integer.parseInt(input) < 1 || Integer.parseInt(input) > 7) {
			input = JOptionPane.showInputDialog(null, "Elija una de las siguiente opciones:\n" + "1. List\n"
					+ "2. Stack\n" + "3. Queue\n" + "4. Map\n" + "5. Tree\n" + "6. Set\n" + "7. Cerrar\n", "TDA`s", 3);
		}

		switch (Integer.parseInt(input)) {
		case 1:
			casosList();
			break;
		case 2:
			casosStack();
			break;
		case 3:
			casosQueue();
			break;
		case 4:
			casosMap();
			break;
		case 5:
			casosTree();
			break;
		case 6:
			casosSet();
			break;
		case 7:
			JOptionPane.showMessageDialog(null, "GRACIAS!", "EXIT", 1);
			break;
		}
	}

	public void casosList() {
		String inputList;
		inputList = JOptionPane.showInputDialog(null,
				"Elija una de las siguientes estructuras:\n" + "1. LinkedList\n" + "2. ArrayList\n" + "3. Regresar\n",
				"List", 3);
		switch (Integer.parseInt(inputList)) {

		case 1:
			JOptionPane.showMessageDialog(null, "Eligio una LinkedList");
			List<Integer> lista = new LinkedList<Integer>();
			list(lista);
			break;
		case 2:
			JOptionPane.showMessageDialog(null, "Eligio un ArrayList");
			List<Integer> lista2 = new ArrayList<Integer>();
			list(lista2);
			break;
		case 3:
			casosModelos();
			break;
		}
	}// Fin casosList

	public void casosStack() {
		String inputStack;
		inputStack = JOptionPane.showInputDialog(null, "Elija una de las siguiente estructuras:\n"
				+ "1. StackLinkedList\n" + "2. StackArray\n" + "3. StackSpecialArray\n" + "4. Regresar\n", "Stack", 3);

		switch (Integer.parseInt(inputStack)) {
		case 1:
			JOptionPane.showMessageDialog(null, "Eligio StackLinkedList");
			Stack<Integer> stack = new StackLinkedList<Integer>();
			stack(stack);
			break;
		case 2:
			JOptionPane.showMessageDialog(null, "Eligio StackArray");
			Stack<Integer> stack2 = new StackArray<Integer>();
			stack(stack2);
			break;
		case 3:
			JOptionPane.showMessageDialog(null, "Eligio StackSpecialArray");
			Stack<Integer> stack3 = new StackSpecialArray<Integer>();
			stack(stack3);
			break;
		case 4:
			casosModelos();
			break;
		}
	}// Fin casosStack

	public void casosQueue() {
		String inputQueue;
		inputQueue = JOptionPane.showInputDialog(null, "Elija una de las siguiente estructuras:\n"
				+ "1. QueueLinkedList\n" + "2. QueueArray\n" + "3. QueueCircularArray\n" + "4. Regresar\n", "Queue", 3);

		switch (Integer.parseInt(inputQueue)) {

		case 1:
			JOptionPane.showMessageDialog(null, "Eligio QueueLinkedList");
			Queue<Integer> queue = new QueueLinkedList<Integer>();
			queue(queue);
			break;
		case 2:
			JOptionPane.showMessageDialog(null, "Eligio QueueArray");
			Queue<Integer> queue2 = new QueueArray<Integer>();
			queue(queue2);
			break;
		case 3:
			JOptionPane.showMessageDialog(null, "Eligio QueueCircularArray");
			Queue<Integer> queue3 = new QueueCircularArray<Integer>();
			queue(queue3);
			break;
		case 4:
			casosModelos();
			break;
		}
	}// Fin casosQueue

	public void casosMap() {
		String inputMap;
		inputMap = JOptionPane.showInputDialog(null,
				"Elija una de las siguiente estructuras:\n" + "1. LinkedMap\n" + "2. Regresar\n", "Map", 3);

		switch (Integer.parseInt(inputMap)) {
		case 1:
			JOptionPane.showMessageDialog(null, "Eligio LinkedMap");
			Map<Integer, String> map = new LinkedMap<Integer, String>();
			map(map);
			break;
		case 2:
			casosModelos();
			break;
		}
	}// Fin casosMap

	public void casosTree() {
		String inputTree;
		inputTree = JOptionPane.showInputDialog(null,
				"Elija una de las siguiente estructuras:\n" + "1. NodeTree\n" + "2. Regresar\n", "Tree", 3);

		switch (Integer.parseInt(inputTree)) {
		case 1:
			JOptionPane.showMessageDialog(null, "Eligio NodeTree");
			Tree<Integer> tree = null;
			tree(tree);
			break;
		case 2:
			casosModelos();
			break;
		}
	}// Fin casosTree

	public void casosSet() {
		String inputSet;
		inputSet = JOptionPane.showInputDialog(null, "Elija una de las siguiente estructuras:\n" + "1. BitSet\n"
				+ "2. LinkedListSet\n" + "3. HashTable\n" + "4. BinarySearchTree\n" + "5. Regresar\n", "Set", 3);
		switch (Integer.parseInt(inputSet)) {
		case 1:
			JOptionPane.showMessageDialog(null, "Eligio BitSet");
			break;
		case 2:
			JOptionPane.showMessageDialog(null, "Eligio LinkedListSet");
			break;
		case 3:
			JOptionPane.showMessageDialog(null, "Eligio HashTable");
			break;
		case 4:
			JOptionPane.showMessageDialog(null, "Eligio BinarySearchTree");
			break;
		case 5:
			casosModelos();
			break;
		}
	}// Fin casosSet

	public void list(List<Integer> lista) {
		String input;
		input = JOptionPane.showInputDialog(null,
				"Elija una operacion:\n" + "1. Agregar\n" + "2. Agregar posicionado\n"
						+ "3. Agregar multiples elementos\n" + "4. Eliminar\n" + "5. Buscar\n" + "6. Vacia?\n"
						+ "7. Tamaño de la coleccion\n" + "8. Limpiar coleccion\n" + "9. Imprimir la coleccion\n"
						+ "10. Ordenar coleccion\n" + "11. Regresar\n");

		switch (Integer.parseInt(input)) {

		case 1:
			lista.add(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a ingresar", "Dato", 1)));
			list(lista);
			break;

		case 2:
			int dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a ingresar", "Dato", 1));
			int posicion = Integer
					.parseInt(JOptionPane.showInputDialog(null, "Ingrese la posicion del dato", "Posicion", 1));
			lista.add(dato, posicion);
			list(lista);
			break;

		case 3:
			String dato2 = JOptionPane.showInputDialog(null, "Ingrese los datos a ingresar serparados por una ,",
					"Lista", 1);
			StringTokenizer datos = new StringTokenizer(dato2, ",");
			while (datos.hasMoreTokens()) {
				lista.add(Integer.parseInt(datos.nextToken()));
			}
			list(lista);
			break;

		case 4:
			Integer aBorrar = Integer
					.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a eliminar", "Dato", 1));
			lista.remove(aBorrar);
			list(lista);
			break;

		case 5:
			boolean esta = lista.contains(Integer
					.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a buscar en la lista", "Dato", 1)));
			if (esta) {
				JOptionPane.showMessageDialog(null, "El elemento esta en la lista", "Esta?", 1);
			} else {
				JOptionPane.showMessageDialog(null, "El elemento no esta en la lista", "Esta?", 2);
			}
			list(lista);
			break;

		case 6:
			boolean vacia = lista.isEmpty();
			if (vacia) {
				JOptionPane.showMessageDialog(null, "La lista esta vacia", "Vacia?", 0);
			} else {
				JOptionPane.showMessageDialog(null, "La lista no esta vacia", "Vacia?", 2);
			}
			list(lista);
			break;

		case 7:
			JOptionPane.showMessageDialog(null, "El tamaño de la lista es " + lista.size(), "Tamaño", 1);
			list(lista);
			break;

		case 8:
			lista.clear();
			JOptionPane.showMessageDialog(null, "La coleccion ha sido borrada", "Borrado", 2);
			list(lista);
			break;

		case 9:
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

		case 10:
			int eleccion = Integer
					.parseInt(
							JOptionPane
									.showInputDialog(null,
											"Ingrese el tipo algoritmo de ordenamiento\n" + "1. Insertion Sort\n"
													+ "2. Selection Sort\n" + "3. Quicksort\n" + "4. Resgresar\n",
											"Dato", 1));
			switch (eleccion) {

			case 1:
				if (lista.size() == 0) {
					JOptionPane.showMessageDialog(null, "La lista esta vacia", "VACIA!", 0);
					list(lista);
				} else {
					InsertionSort isort = new InsertionSort();
					Iterator<Integer> iti = lista.iterator();
					int[] numerosi = new int[lista.size()];
					int x = 0;
					while (iti.hasNext()) {
						numerosi[x] = iti.next();
						x++;
					}
					isort.insertionSort(numerosi);
					lista.clear();
					x = 0;
					while (x != numerosi.length - 1) {
						lista.add(numerosi[x]);
						x++;
					}
					list(lista);
				}
				break;

			case 2:
				if (lista.size() == 0) {
					JOptionPane.showMessageDialog(null, "La lista esta vacia", "VACIA!", 0);
					list(lista);
				} else {
					SelectionSort ssort = new SelectionSort();
					Iterator<Integer> its = lista.iterator();
					int[] numeross = new int[lista.size()];
					int x = 0;
					while (its.hasNext()) {
						numeross[x] = its.next();
						x++;
					}
					ssort.selectionSort(numeross);
					lista.clear();
					x = 0;
					while (x != numeross.length - 1) {
						lista.add(numeross[x]);
						x++;
					}
					list(lista);
				}
				break;

			case 3:
				if (lista.size() == 0) {
					JOptionPane.showMessageDialog(null, "La lista esta vacia", "VACIA!", 0);
					list(lista);
				} else {
					QuickSort qsort = new QuickSort();
					Iterator<Integer> itq = lista.iterator();
					int[] numerosq = new int[lista.size()];
					int i = 0;
					while (itq.hasNext()) {
						numerosq[i] = (itq.next());
						i++;
					}
					qsort.quickSort(numerosq, 0, lista.size() - 1);
					lista.clear();
					i = 0;
					while (i != numerosq.length - 1) {
						lista.add(numerosq[i]);
						i++;
					}
					list(lista);
				}
				break;

			case 4:
				list(lista);
				break;

			}
			break;

		case 11:
			casosList();
			break;
		}
	}// Fin List

	public void queue(Queue<Integer> queue) {
		String input;
		input = JOptionPane.showInputDialog(null,
				"Elija una operacion:\n" + "1. Agregar\n" + "2. Agregar multiples elementos\n" + "3. Eliminar\n"
						+ "4. Buscar\n" + "5. Vacia?\n" + "6. Tamaño de la coleccion\n" + "7. Limpiar coleccion\n"
						+ "8. Imprimir la coleccion\n" + "9. Regresar\n");
		switch (Integer.parseInt(input)) {

		case 1:
			queue.add(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a ingresar", "Dato", 1)));
			queue(queue);
			break;

		case 2:
			String dato2 = JOptionPane.showInputDialog(null, "Ingrese los datos a ingresar serparados por una ,",
					"Cola", 1);
			StringTokenizer datos = new StringTokenizer(dato2, ",");
			while (datos.hasMoreTokens()) {
				queue.add(Integer.parseInt(datos.nextToken()));
			}
			queue(queue);
			break;

		case 3:
			Integer aBorrar = Integer
					.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a eliminar", "Dato", 1));
			queue.remove(aBorrar);
			queue(queue);
			break;

		case 4:
			boolean esta = queue.contains(Integer
					.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a buscar en la cola", "Dato", 1)));
			if (esta) {
				JOptionPane.showMessageDialog(null, "El elemento esta en la cola", "Esta?", 1);
			} else {
				JOptionPane.showMessageDialog(null, "El elemento no esta en la cola", "Esta?", 2);
			}
			queue(queue);
			break;

		case 5:
			boolean vacia = queue.isEmpty();
			if (vacia) {
				JOptionPane.showMessageDialog(null, "La cola esta vacia", "Vacia?", 0);
			} else {
				JOptionPane.showMessageDialog(null, "La cola no esta vacia", "Vacia?", 2);
			}
			queue(queue);
			break;

		case 6:
			JOptionPane.showMessageDialog(null, "El tamaño de la cola es " + queue.size(), "Tamaño", 1);
			queue(queue);
			break;

		case 7:
			queue.clear();
			JOptionPane.showMessageDialog(null, "La coleccion ha sido borrada", "Borrado", 2);
			queue(queue);
			break;

		case 8:
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

		case 9:
			casosQueue();
			break;

		}
	}// Fin queue

	public void stack(Stack<Integer> stack) {
		String input;
		input = JOptionPane.showInputDialog(null,
				"Elija una operacion:\n" + "1. Agregar\n" + "2. Agregar multiples elementos\n" + "3. Eliminar\n"
						+ "4. Buscar\n" + "5. Vacia?\n" + "6. Tamaño de la coleccion\n" + "7. Limpiar coleccion\n"
						+ "8. Imprimir la coleccion\n" + "9. Regresar\n");
		switch (Integer.parseInt(input)) {

		case 1:
			stack.add(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a ingresar", "Dato", 1)));
			stack(stack);
			break;

		case 2:
			String dato2 = JOptionPane.showInputDialog(null, "Ingrese los datos a ingresar serparados por una ,",
					"Pila", 1);
			StringTokenizer datos = new StringTokenizer(dato2, ",");
			while (datos.hasMoreTokens()) {
				stack.add(Integer.parseInt(datos.nextToken()));
			}
			stack(stack);
			break;

		case 3:
			Integer aBorrar = Integer
					.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a eliminar", "Dato", 1));
			stack.remove(aBorrar);
			stack(stack);
			break;

		case 4:
			boolean esta = stack.contains(Integer
					.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a buscar en la pila", "Dato", 1)));
			if (esta) {
				JOptionPane.showMessageDialog(null, "El elemento esta en la pila", "Esta?", 1);
			} else {
				JOptionPane.showMessageDialog(null, "El elemento no esta en la pila", "Esta?", 2);
			}
			stack(stack);
			break;

		case 5:
			boolean vacia = stack.isEmpty();
			if (vacia) {
				JOptionPane.showMessageDialog(null, "La pila esta vacia", "Vacia?", 0);
			} else {
				JOptionPane.showMessageDialog(null, "La pila no esta vacia", "Vacia?", 2);
			}
			stack(stack);
			break;

		case 6:
			JOptionPane.showMessageDialog(null, "El tamaño de la pila es " + stack.size(), "Tamaño", 1);
			stack(stack);
			break;

		case 7:
			stack.clear();
			JOptionPane.showMessageDialog(null, "La coleccion ha sido borrada", "Borrado", 2);
			stack(stack);
			break;

		case 8:
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

		case 9:
			casosStack();
			break;

		}
	}// Fin stack

	public void map(Map<Integer, String> map) {
		String input;
		input = JOptionPane.showInputDialog(null,
				"Elija una operacion:\n" + "1. Agregar\n" + "2. Agregar multiples elementos\n" + "3. Eliminar\n"
						+ "4. Buscar\n" + "5. Vacia?\n" + "6. Tamaño de la coleccion\n" + "7. Limpiar coleccion\n"
						+ "8. Imprimir la coleccion\n" + "9. Regresar\n");
		switch (Integer.parseInt(input)) {

		case 1:
			String dato = JOptionPane.showInputDialog(null,
					"Inserte el par a ingresar con el siguiente formato (Numero - String)", "Par", 1);
			StringTokenizer datos = new StringTokenizer(dato, "-");
			map.put(Integer.parseInt(datos.nextToken()), datos.nextToken());
			map(map);
			break;

		case 2:
			String dato2 = JOptionPane.showInputDialog(null,
					"Inserte los pares a ingresar con el siguiente formato ((Numero - String) , (Numero - Guion))",
					"Pares", 1);
			StringTokenizer datos2 = new StringTokenizer(dato2, ",");
			while (datos2.hasMoreTokens()) {
				String aIngresar = datos2.nextToken();
				StringTokenizer datosIngresar = new StringTokenizer(aIngresar, "-");
				map.put(Integer.parseInt(datosIngresar.nextToken()), datosIngresar.nextToken());
			}
			map(map);
			break;

		case 3:
			map.remove(Integer
					.parseInt(JOptionPane.showInputDialog(null, "Inserte el numero que desea eliminar", "Dato", 3)));
			map(map);
			break;

		case 4:
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

		case 5:
			boolean vacia = map.isEmpty();
			if (vacia) {
				JOptionPane.showMessageDialog(null, "El mapa esta vacio", "Vacio?", 0);
			} else {
				JOptionPane.showMessageDialog(null, "El mapa no esta vacio", "Vacio?", 2);
			}
			map(map);
			break;

		case 6:
			JOptionPane.showMessageDialog(null, "El tamaño del mapa es " + map.size(), "Tamaño", 1);
			map(map);
			break;

		case 7:
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

		case 8:
			Iterator<Integer> itMap = map.iterator();
			String impresion = "";
			while (itMap.hasNext()) {
				int data = itMap.next();
				impresion += Integer.toString(data) + "-" + map.get(data) + ",\n";
			}
			JOptionPane.showMessageDialog(null, "El mapa completo es\n" + impresion, "Mapa", 3);
			map(map);
			break;

		case 9:
			casosMap();
			break;

		}
	}// Fin map

	public void tree(Tree<Integer> tree) {
		if (tree == null) {
			tree = new TreeImpl<Integer>(Integer.parseInt(JOptionPane.showInputDialog(null,
					"Por favor inserte la raiz del arbol para su creacion", "Raiz", 3)));
		}
		String input;
		input = JOptionPane.showInputDialog(null,
				"Elija una operacion:\n" + "1. Agregar\n" + "2. Agregar multiples elementos\n" + "3. Eliminar\n"
						+ "4. Buscar\n" + "5. Vacia?\n" + "6. Tamaño de la coleccion\n" + "7. Limpiar coleccion\n"
						+ "8. Imprimir la coleccion\n" + "9. Regresar\n");
		switch (Integer.parseInt(input)) {
		case 1:
			List<Node<Integer>> lista = new LinkedList<Node<Integer>>();
			lista = tree.getPreOrderTraversal();
			Iterator<Node<Integer>> it = lista.iterator();
			int[] numeros = new int[lista.size()];
			int i = 0;
			while (it.hasNext()) {
				numeros[i] = (it.next().getData());
				i++;
			}
			int input2 = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Elija el nodo al cual le quiere agregar un hijo:\n" + Arrays.toString(numeros), "Hijos", 1));
			Node<Integer> padre = new NodeImpl<Integer>(input2, null);
			padre = lista.get(lista.find(padre));
			int aInsertar = Integer
					.parseInt(JOptionPane.showInputDialog(null, "Inserte el dato que desea insertar", "Dato", 3));
			padre.addChild(new NodeImpl<Integer>(aInsertar, (NodeImpl<Integer>) padre));
			break;
		case 8:
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

		}// Fin tree
	}
}
