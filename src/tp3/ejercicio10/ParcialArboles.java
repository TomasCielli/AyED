package tp3.ejercicio10;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp3.ejercicio1.GeneralTree;

public class ParcialArboles {

	public static List<Integer> resolver(GeneralTree<Integer> arbol) {
		List<Integer> camino_maximo = new LinkedList<Integer>();
		if (!arbol.isEmpty()) {
			List<Integer> camino_actual = new LinkedList<Integer>();
			int[] maximo = {Integer.MIN_VALUE};
			resolver(arbol, camino_actual, camino_maximo, maximo, 0, 0);
		}
		return camino_maximo;
	}

	private static int resolver(GeneralTree<Integer> nodo, List<Integer> camino_actual, List<Integer> camino_maximo, int[] maximo, int nivel, int valor_acumulado) {
		if (nodo.getData() != 0) {
			camino_actual.add(nodo.getData());
			valor_acumulado += nivel;
		}
		if (!nodo.isLeaf()) {
			nivel++;
			Iterator<GeneralTree<Integer>> it = nodo.getChildren().iterator();
			while (it.hasNext()) {
				maximo[0] = resolver(it.next(), camino_actual, camino_maximo, maximo, nivel, valor_acumulado);
			}
		} else {
			if (valor_acumulado > maximo[0]) {
				maximo[0] = valor_acumulado;
				camino_maximo.clear();
				camino_maximo.addAll(camino_actual);
			}
		}
		if (nodo.getData() != 0) {
			camino_actual.removeLast();
		}
		return maximo[0];
	}
}
