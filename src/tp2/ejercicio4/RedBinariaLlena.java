package tp2.ejercicio4;

import tp2.ejercicio1.BinaryTree;

public class RedBinariaLlena {

	private BinaryTree<Integer> retardos;
	
	
	public BinaryTree<Integer> getRetardos() {
		return retardos;
	}

	public void setRetardos(BinaryTree<Integer> retardos) {
		this.retardos = retardos;
	}




	public int retardoReenvio() {
	    if (this.getRetardos().isEmpty()) {
	        throw new IllegalStateException("La red binaria no tiene nodos");
	    }
	    return retardoReenvio_private(this.getRetardos(), 0);
	}
	
	private int retardoReenvio_private(BinaryTree<Integer> nodo, int sumaAcumulada) {
		int resultado = sumaAcumulada;
		if (!nodo.isEmpty()) {
			resultado += nodo.getData();
			
			if (!nodo.isLeaf()) {
				int retardoIzq = 0, retardoDer = 0;
			
				if (nodo.hasLeftChild()) retardoIzq = this.retardoReenvio_private(nodo.getLeftChild(), resultado);
				if (nodo.hasRightChild()) retardoDer = this.retardoReenvio_private(nodo.getRightChild(), resultado);
				
				resultado = retardoIzq > retardoDer? retardoIzq : retardoDer;
			}
		}
		return resultado;
	}
}
