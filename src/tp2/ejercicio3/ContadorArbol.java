package tp2.ejercicio3;

import java.util.LinkedList;
import java.util.List;

import tp2.ejercicio1.BinaryTree;

public class ContadorArbol {

	private BinaryTree<Integer> arbol;
	
	
	public ContadorArbol(BinaryTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}


	public BinaryTree<Integer> getArbol() {
		return arbol;
	}


	public void setArbol(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}


	public List<Integer> numerosParesIO() {
		List<Integer> pares = new LinkedList<Integer>();
		
		return this.numeroParesIO_private(pares, this.getArbol());
	}
	
	private List<Integer> numeroParesIO_private(List<Integer> lista, BinaryTree<Integer> ab) {
		if (!ab.isEmpty()) {
			if (ab.hasLeftChild()) this.numeroParesIO_private(lista, ab.getLeftChild());
			if (ab.getData() % 2 == 0) lista.add(ab.getData());
			if (ab.hasRightChild()) this.numeroParesIO_private(lista, ab.getRightChild());
		}
		
		return lista;
	}
	
	public List<Integer> numerosParesPO() {
		List<Integer> pares = new LinkedList<Integer>();
		
		return this.numeroParesPO_private(pares, this.getArbol());
	}
	
	private List<Integer> numeroParesPO_private(List<Integer> lista, BinaryTree<Integer> ab) {
		if (!ab.isEmpty()) {
			if (ab.hasLeftChild()) this.numeroParesPO_private(lista, ab.getLeftChild());
			if (ab.hasRightChild()) this.numeroParesPO_private(lista, ab.getRightChild());
			if (ab.getData() % 2 == 0) lista.add(ab.getData());
		}
		
		return lista;
	}
}
