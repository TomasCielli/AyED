package tp1.ejercicio7;

import java.util.ArrayList;
import java.util.List;

public class TestArrayList {

	public static void main(String[] args) {
		
		List<Integer> array_list = new ArrayList<>();
		for (String arg : args) {
			array_list.add(Integer.parseInt(arg));
		}
		
		for (int i = 0; i < array_list.size(); i++) {
			System.out.print(array_list.get(i) + " | ");
		}
		
		EjercicioSucesion calculadora = new EjercicioSucesion();
		List<Integer> sucesion = calculadora.calcularSucesion(15);
		for (int numero : sucesion) {
			System.out.print(numero + " | ");
		}
	}

}
