package tp2.ejercicio5;

import tp1.ejercicio8.Queue;
import tp2.ejercicio1.BinaryTree;

public class ProfundidadDeArbolBinario {

	private BinaryTree<Integer> arbol;
	
	public BinaryTree<Integer> getArbol() {
		return arbol;
	}

	public void setArbol(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}

	public int sumaElementosProfundidad(int p) {
		int suma = 0;
		if (!this.getArbol().isEmpty()) {
			int nivel = 0;
			boolean terminoNivel = false;
			Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
			BinaryTree<Integer> ab = this.getArbol();
			
			cola.enqueue(ab); cola.enqueue(null);
			
			while (!cola.isEmpty() && !terminoNivel) {
				ab = cola.dequeue();
				if (ab != null) {
					if (nivel == p) suma += ab.getData();
					if ((ab.hasLeftChild() && (nivel + 1 <= p))) cola.enqueue(ab.getLeftChild());
					if ((ab.hasRightChild() && (nivel + 1 <= p))) cola.enqueue(ab.getRightChild());
				} else if (!cola.isEmpty()) {
					cola.enqueue(null);
					nivel++;
					terminoNivel = nivel > p;
				}
			}
		}
		return suma;
	}
}
