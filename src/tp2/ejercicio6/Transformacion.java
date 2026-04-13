package tp2.ejercicio6;

import tp2.ejercicio1.BinaryTree;

public class Transformacion {

	BinaryTree<Integer> arbol;
	
	private class Resultado {
		BinaryTree<Integer> arbol_transformado;
		int suma_original;
		
		Resultado(BinaryTree<Integer> arbol, int suma){
			this.arbol_transformado = arbol;
			this.suma_original = suma;
		}

		protected BinaryTree<Integer> getArbol_transformado() {
			return arbol_transformado;
		}

		protected int getSuma_original() {
			return suma_original;
		}
		
		
	}
	
	public Transformacion(BinaryTree<Integer> arbol) {
		this.setArbol(arbol);
	}
	
	public BinaryTree<Integer> getArbol() {
		return arbol;
	}

	public void setArbol(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}

	public BinaryTree<Integer> suma(){
	    if (this.getArbol().isEmpty()) throw new IllegalStateException("El arbol binario no tiene nodos");
	    return suma_private(this.getArbol()).getArbol_transformado();
	}
	
	private Resultado suma_private(BinaryTree<Integer> ab){
		BinaryTree<Integer> nodo = new BinaryTree<Integer>(0);
		if (ab.isLeaf()) {
			return new Resultado(nodo, ab.getData());
		}
		else {
			Resultado res_izq = ab.hasLeftChild()? suma_private(ab.getLeftChild()) : null;
			Resultado res_der = ab.hasRightChild()? suma_private(ab.getRightChild()) : null;
			
			int valor_izq = (res_izq != null)? res_izq.getSuma_original() : 0;
			int valor_der = (res_der != null)? res_der.getSuma_original() : 0;
			
			BinaryTree<Integer> hijo_izq = (res_izq != null)? res_izq.getArbol_transformado() : null;
			BinaryTree<Integer> hijo_der = (res_der != null)? res_der.getArbol_transformado() : null;
			
			nodo.setData(valor_izq + valor_der); 
			if (hijo_izq != null) nodo.addLeftChild(hijo_izq); 
			if (hijo_der != null) nodo.addRightChild(hijo_der);
			return new Resultado(nodo, valor_izq + valor_der + ab.getData());
		}
	}
}
