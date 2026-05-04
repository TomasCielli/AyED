package tp3.ejercicio11;

import java.util.Iterator;

import tp1.ejercicio8.Queue;
import tp3.ejercicio1.GeneralTree;

public class ParcialArboles {

	public static boolean resolver(GeneralTree<Integer> arbol) {
		boolean es_creciente;
		if (!arbol.isEmpty()) {
			es_creciente = true;
			Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
			cola.enqueue(arbol);
			cola.enqueue(null);
			int nivel = 0, cant = 0;
			while (es_creciente && !cola.isEmpty()) {
				GeneralTree<Integer> nodo = cola.dequeue();
				if (nodo != null) {
					cant++;
					if (nodo.hasChildren()) {
						Iterator<GeneralTree<Integer>> it = nodo.getChildren().iterator();
						while (es_creciente && it.hasNext()) {
							cola.enqueue(it.next());
						}
					}
					es_creciente = cant <= (nivel + 1);
				} else {
					es_creciente = cant == (nivel + 1);
					if (es_creciente && !cola.isEmpty()) {
						cola.enqueue(null);
						cant = 0;
						nivel++;
					}
				}
			}
		} else es_creciente = false;
		return es_creciente;
	}
}
