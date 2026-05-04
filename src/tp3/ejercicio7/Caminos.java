package tp3.ejercicio7;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp3.ejercicio1.GeneralTree;

public class Caminos {

	private GeneralTree<Integer> recorridos;
	
	
	
	public Caminos(GeneralTree<Integer> recorridos) {
		this.recorridos = recorridos;
	}



	public List<Integer> caminoAHojaMasLejana (){
		List<Integer> camino_maximo = new LinkedList<Integer>();
		if (!this.recorridos.isEmpty()) {
			camino_maximo = caminoAHojaMasLejana(this.recorridos);
		}
		return camino_maximo;
	}
	
	private List<Integer> caminoAHojaMasLejana(GeneralTree<Integer> arbol){
		List<Integer> camino_max = new LinkedList<Integer>();
		if (!arbol.isLeaf()) {
			Iterator<GeneralTree<Integer>> it = arbol.getChildren().iterator();
			while (it.hasNext()) {
				List<Integer> camino_hijo = this.caminoAHojaMasLejana(it.next());
				if (camino_hijo.size() > camino_max.size()) {
					camino_max = camino_hijo;
				}
			}
		}
		camino_max.addFirst(arbol.getData());
		return camino_max;
		
	}
	
	
}
