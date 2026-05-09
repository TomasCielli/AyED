package parciales;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tp2.ejercicio1.BinaryTree;
import tp3.ejercicio1.GeneralTree;



public class Parcial {

	private BinaryTree<Integer> arbol;
	
	public BinaryTree<Integer> nuevoTree(){
		BinaryTree<Integer> arbol = new BinaryTree<Integer>();
		if (this.arbol != null && !this.arbol.isEmpty()) {
			arbol = this.nuevoTree(this.arbol, arbol, 0);
		}
		return arbol;
	}

	private BinaryTree<Integer> nuevoTree(BinaryTree<Integer> arbol, BinaryTree<Integer> nuevo, int papi) {
		BinaryTree<Integer> nuevoNodardo= new GeneralTree<Integer>();
		nuevoNodardo.setData(papi + arbol.getData());
		
		if (arbol.hasLeftChild()) {
			BinaryTree<Integer> nodoIzq = this.nuevoTree(arbol.getLeftChild(), nuevo, arbol.getData());
			nuevoNodardo.addLeftChild(nodoIzq);
		}
		
		if (arbol.hasRightChild()) {
			BinaryTree<Integer> nodo = this.nuevoTree(arbol.getLeftChild(), nuevo, arbol.getData());
			nuevoNodardo.addLeftChild(nodoIzq);
		}
	}
}
