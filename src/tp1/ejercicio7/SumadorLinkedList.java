package tp1.ejercicio7;

import java.util.LinkedList;

public class SumadorLinkedList {

	public int sumarLinkedList(LinkedList<Integer> lista) {
		
		Integer total = 0;
		return this.metodoRecursivo(lista, 0);
	}
	
	private int metodoRecursivo(LinkedList<Integer> lista, int i) {
		
		if (i < lista.size()) {
			return this.metodoRecursivo(lista, i + 1) + lista.get(i);
		}
		return 0;
	}
}
