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
		
		int i = 0;
		this.metodoRecursivo(lista, i);
		
		
	}
	
	private void metodoRecursivo(ArrayList<Integer> lista, int i) {
		if (!(i >= lista.size()/2)) {
			this.reemplazar(lista, i);
			this.metodoRecursivo(lista, i + 1);
		}
	}
	
	private void reemplazar(ArrayList<Integer> lista, int i) {
		int temp = lista.get(lista.size() - i - 1);
		lista.set(lista.size() - i - 1, lista.get(i));
		lista.set(i, temp);
	}
	
	
}
