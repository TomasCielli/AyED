package tp1.ejercicio7;

import java.util.ArrayList;

public class CapicuaCheker {
	
	public static boolean esCapicua(ArrayList<Integer> lista) {
		int primero = 0, ultimo = lista.size()-1;
		while (primero != ultimo) {
			if (lista.get(primero) != lista.get(ultimo)) return false;
			primero++;
			ultimo--;
		}
		return true;
	}

}
