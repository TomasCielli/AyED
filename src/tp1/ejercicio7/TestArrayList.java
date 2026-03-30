package tp1.ejercicio7;

import java.util.ArrayList;
import java.util.LinkedList;
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
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		EjercicioSucesion calculadora = new EjercicioSucesion();
		List<Integer> sucesion = calculadora.calcularSucesion(15);
		
		ArrayList<Integer> sucesion_array = new ArrayList<>();
		System.out.println(" Sucesion normal: ");
		for (int numero : sucesion) {
			System.out.print(numero + " | ");
			sucesion_array.add(numero);
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println(" Sucesion invertida: ");
		InversorArray inversor = new InversorArray();
		inversor.invertirArrayList(sucesion_array);
		for (int numero : sucesion_array) {
			System.out.print(numero + " | ");
		}
		
		LinkedList<Integer> lista_sumatoria = new LinkedList<>();
		for (int i = 0; i < 11; i++) {
			lista_sumatoria.add(i);
		}
		
		SumadorLinkedList sumador = new SumadorLinkedList();
		
		System.out.println("");
		System.out.println("");
		System.out.println("La suma es: " + sumador.sumarLinkedList(lista_sumatoria));
		
		
		
		ArrayList<Integer> lista1 = new ArrayList<>();
		lista1.add(1); lista1.add(5); lista1.add(6); lista1.add(11); lista1.add(12); lista1.add(13); lista1.add(20);
		System.out.println("");
		System.out.println("");
		System.out.print("Lista 1: ");
		for (int numero : lista1) {
			System.out.print(numero + " | ");
		}
		
		
		
		ArrayList<Integer> lista2 = new ArrayList<>();
		lista2.add(2); lista2.add(4); lista2.add(5); lista2.add(8); lista2.add(9);
		System.out.println("");
		System.out.println("");
		System.out.print("Lista 2: ");
		for (int numero : lista2) {
			System.out.print(numero + " | ");
		}
		
		CombinadorDeListas combinador = new CombinadorDeListas();
		
		ArrayList<Integer> lista_combinada = new ArrayList<>();
		lista_combinada = combinador.combinarOrdenado(lista1, lista2);
		
		System.out.println("");
		System.out.println("");
		System.out.print("Lista combinada: ");
		for (int numero : lista_combinada) {
			System.out.print(numero + " | ");
		}
		System.out.println("");
		
	}

}
