package tp3.ejercicio2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp1.ejercicio8.Queue;
import tp3.ejercicio1.GeneralTree;

public class RecorridosAG {
	
	public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a, Integer n){
		List<Integer> lista_impares = new LinkedList<Integer>();
		if (!a.isEmpty()) this.numerosImparesMayoresQuePreOrden(a, n, lista_impares);
		
		return lista_impares;
	}
	
	private void numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a, Integer n, List<Integer> l) {
		int dato = a.getData();
		if (this.cumpleCondicion(dato, n)) {
			l.add(dato);
		}
		if (a.hasChildren()) {
			List<GeneralTree<Integer>> children = a.getChildren();
			Iterator<GeneralTree<Integer>> it = children.iterator();
			
			while (it.hasNext()) {
				this.numerosImparesMayoresQuePreOrden(it.next(), n, l);
			}
		}
	}
	
	public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n){
		List<Integer> lista_impares = new LinkedList<Integer>();
		if (!a.isEmpty()) this.numerosImparesMayoresQuePostOrden(a, n, lista_impares);
		
		return lista_impares;
	}
	
	private void numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n, List<Integer> l){
		if (a.hasChildren()) {
			List<GeneralTree<Integer>> children = a.getChildren();
			Iterator<GeneralTree<Integer>> it = children.iterator();
			
			while (it.hasNext()) {
				this.numerosImparesMayoresQuePostOrden(it.next(), n, l);
			}
		}
		int dato = a.getData();
		if (this.cumpleCondicion(dato, n)) {
			l.add(dato);
		}
	}
	
	
	public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n) {
		List<Integer> lista_impares = new LinkedList<Integer>();
		if (!a.isEmpty()) this.numerosImparesMayoresQueInOrden(a, n, lista_impares);
		
		return lista_impares;
	}
	
	private void numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n, List<Integer> l) {
		int dato = a.getData();
		if (a.hasChildren()) {
			List<GeneralTree<Integer>> children = a.getChildren();
			Iterator<GeneralTree<Integer>> it = children.iterator();
			
			this.numerosImparesMayoresQueInOrden(it.next(), n, l);
			if (this.cumpleCondicion(dato, n)) {
				l.add(dato);
			}
			while (it.hasNext()) {
				this.numerosImparesMayoresQueInOrden(it.next(), n, l);
			}
		}
		else {
			if (this.cumpleCondicion(dato, n)) {
				l.add(dato);
			}
		}
	}
	
	
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a, Integer n){
		List<Integer> lista_impares = new LinkedList<Integer>();
		if (!a.isEmpty()) {
			Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
			GeneralTree<Integer> desencolado;
			cola.enqueue(a);
			while (!cola.isEmpty()) {
				desencolado = cola.dequeue();
				int dato = desencolado.getData();
				if (this.cumpleCondicion(dato, n)) lista_impares.add(dato);
				if (desencolado.hasChildren()) {
					List<GeneralTree<Integer>> children = desencolado.getChildren();
					Iterator<GeneralTree<Integer>> it = children.iterator();
					while (it.hasNext()) {
						cola.enqueue(it.next());
					}
				}
			}
		}
		return lista_impares;
	}
	
	
	
	
	
	public boolean cumpleCondicion (int dato, int n) {
		return ((dato % 2 != 0) && (dato > n));
	}
}
