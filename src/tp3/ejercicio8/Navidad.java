package tp3.ejercicio8;

import java.util.Iterator;

import tp3.ejercicio1.GeneralTree;

public class Navidad {

	GeneralTree<Integer> abeto;
	
	public Navidad(GeneralTree<Integer> abeto) {
		this.abeto = abeto;
	}
	
	public String esAbetoNavidenio() {
		String respuesta = "No";
		if (!this.abeto.isEmpty()) {
			if (this.esAbetoNavidenio(abeto)) respuesta = "Yes";
		}
		return respuesta;
	}
	
	private boolean esAbetoNavidenio(GeneralTree<Integer> nodo) {
		boolean es_abeto = true;
		int cant_hojas = 0;
		if (nodo.hasChildren()) {
			Iterator<GeneralTree<Integer>> it = nodo.getChildren().iterator();
			while (es_abeto && it.hasNext()) {
				GeneralTree<Integer> hijo = it.next();
				if (hijo.isLeaf()) cant_hojas++;
				else es_abeto = this.esAbetoNavidenio(hijo);
			}
		}
		return es_abeto && cant_hojas >= 3;
	}
}
