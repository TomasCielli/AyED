package tp3.ejercicio9;

import java.util.Iterator;

import tp3.ejercicio1.GeneralTree;

public class ParcialArboles {

	public static boolean esDeSeleccion(GeneralTree<Integer> arbol) {
		boolean es_de_seleccion = false;
		if (arbol!= null && !arbol.isEmpty()) {
			es_de_seleccion = esDeSeleccionRecursivo(arbol);
		}
		return es_de_seleccion;
	}

	private static boolean esDeSeleccionRecursivo(GeneralTree<Integer> arbol) {
		boolean es_de_seleccion = true;
		if (!arbol.isLeaf()) {
			int minimo = Integer.MAX_VALUE;
			Iterator<GeneralTree<Integer>> it = arbol.getChildren().iterator();
			while (it.hasNext() && es_de_seleccion) {
				GeneralTree<Integer> hijo = it.next();
				es_de_seleccion = esDeSeleccionRecursivo(hijo);
				minimo = hijo.getData() < minimo ? hijo.getData() : minimo;
			}
			if (es_de_seleccion) es_de_seleccion = minimo == arbol.getData();
		}
		return es_de_seleccion;
	}
}
