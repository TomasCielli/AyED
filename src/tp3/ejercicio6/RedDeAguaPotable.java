package tp3.ejercicio6;

import java.util.Iterator;
import java.util.List;

import tp3.ejercicio1.GeneralTree;

public class RedDeAguaPotable {
	
	private GeneralTree<Character> red;

	public RedDeAguaPotable(GeneralTree<Character> red) {
		this.red = red;
	}

	public double minimoCaudal(double caudal) {
		double minimo = 0;
		if (!this.red.isEmpty()) {
			minimo = minimoCaudal(caudal, this.red);
		}
		return minimo;
	}
	
	private double minimoCaudal(double caudal, GeneralTree<Character> arbol) {
		double minimo = Double.MAX_VALUE;
		if (!arbol.isLeaf()) {
			List<GeneralTree<Character>> children = arbol.getChildren();
			int cant = children.size(); 
			double caudal_hijo;
			
			Iterator<GeneralTree<Character>> it = children.iterator();
			while (it.hasNext()) {
				caudal_hijo = this.minimoCaudal(caudal/cant, it.next());
				minimo = (caudal_hijo < minimo)? caudal_hijo : minimo;
			}
		} else minimo = caudal;
		
		return minimo;
	}
}
