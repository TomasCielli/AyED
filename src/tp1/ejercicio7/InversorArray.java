package tp1.ejercicio7;

import java.util.ArrayList;
import java.util.List;

public class InversorArray {

	/* public void invertirArrayList(List<Integer> lista) {
		
		if (lista.size() > 1) {
			int temp, ultimo = lista.size() - 1;
			for (int primero = 0; primero < ultimo; primero++) {
				temp = lista.get(ultimo);
				lista.set(ultimo, lista.get(primero));
				lista.set(primero, temp);
				ultimo--;
			}
		}
	}
	*/
	
	public void invertirArrayList(ArrayList<Integer> lista) {
	
		this.metodoRecursivo(lista, 0);
	}
	
	private void metodoRecursivo (ArrayList<Integer> lista, int i) {
		
		if (i < lista.size()) {
			int valor = lista.get(i);
			this.metodoRecursivo(lista, i+1);
			lista.set((lista.size() - 1) - i, valor);
		}
	}
	
}
