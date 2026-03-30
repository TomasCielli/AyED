package tp1.ejercicio7;

import java.util.ArrayList;

public class CombinadorDeListas {

	public ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1, ArrayList<Integer> lista2) {
	
		ArrayList<Integer> lista_final = new ArrayList<>();
		
		int min, cont1 = 0, cont2 = 0;
		
		while ((cont1 < lista1.size()) & (cont2 < lista2.size())) {
			if (lista1.get(cont1) < lista2.get(cont2)) {
				min = lista1.get(cont1);
				cont1++;
			}
			else {
				min = lista2.get(cont2);
				cont2++;
			}
			lista_final.add(min);
		}
		if (cont1 < lista1.size()) {
			while (cont1 < lista1.size()) {
				lista_final.add(lista1.get(cont1));
				cont1++;
			}
		}
		else {
			while (cont2 < lista2.size()) {
				lista_final.add(lista2.get(cont2));
				cont2++;
			}
		}
		return lista_final;
	}
	
}
