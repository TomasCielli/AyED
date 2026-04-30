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
	
	public List<Integer> caminoAHojaMasLejanaBien(){
		List<Integer> camino_maximo = new LinkedList<Integer>(), camino_actual = new LinkedList<Integer>();
		if (!this.recorridos.isEmpty()) {
			camino_maximo = this.caminoAHojaMasLejanaBien(this.recorridos, camino_maximo, camino_actual);
		}
		return camino_maximo;
	}
	
	private List<Integer> caminoAHojaMasLejanaBien(GeneralTree<Integer> nodo, List<Integer> camino_maximo, List<Integer> camino_actual){
		camino_actual.add(nodo.getData());
		if (nodo.isLeaf()) camino_maximo = camino_actual.size() > camino_maximo.size()? new LinkedList<Integer>(camino_actual) : camino_maximo;
		else {
			Iterator<GeneralTree<Integer>> it = nodo.getChildren().iterator();
			while (it.hasNext()) {
				camino_maximo = this.caminoAHojaMasLejanaBien(it.next(), camino_maximo, camino_actual);
			}
		}
		camino_actual.remove(0);
		return camino_maximo;
	}
	
	
}
