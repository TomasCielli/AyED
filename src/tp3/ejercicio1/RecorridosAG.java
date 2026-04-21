package tp3.ejercicio1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RecorridosAG {

	public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a, Integer n){
		List<Integer> l = new LinkedList<Integer>();
		this.numerosImparesMayoresQuePreOrdenRecursivo(a, n, l);
		
		return l;
	}
	
	private void numerosImparesMayoresQuePreOrdenRecursivo(GeneralTree<Integer> a, Integer n, List<Integer> l) {
		if (a.isEmpty()) {
			int valor = a.getData();
			if ((this.esPar(valor)) && (valor > n)) l.add(valor);
			if (a.hasChildren()) {
				List<GeneralTree<Integer>> children = a.getChildren();
				for (GeneralTree<Integer> child: children) {
					this.numerosImparesMayoresQuePreOrdenRecursivo(child, n, l);
				}
			}
		}
	}
	
	private boolean esPar(int x) {
		return (x%2 == 0);
	}
}
