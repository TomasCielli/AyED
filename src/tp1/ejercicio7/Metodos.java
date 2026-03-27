package tp1.ejercicio7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import tp1.ejercicio3.Estudiante;

public class Metodos {

	public static void main(String[] args) {
		Metodos.puntoD();
	}
	
	public static void puntoD() {
		
		List<Estudiante> estudiantes = new LinkedList<>();
		
		estudiantes.add(new Estudiante("Tomas", "Cielli Moro", "tomas@gmail.com", "1", "C 73"));
		estudiantes.add(new Estudiante("Juan", "Cielli", "juan@gmail.com", "2", "C 74"));
		estudiantes.add(new Estudiante("Pedro", "Cielli", "pedro@gmail.com", "3", "C 75"));
		
		List<Estudiante> estudiantes_copia = new LinkedList<>();
		
		for (Estudiante estudiante : estudiantes) estudiantes_copia.add(estudiante);
		
		System.out.println("----- Original -----");
		Metodos.imprimirContenidoListaEstudiante(estudiantes);
		System.out.println("");
		
		System.out.println("----- Copia -----");
		Metodos.imprimirContenidoListaEstudiante(estudiantes_copia); //siempre iguales xq apunta a los mismos estudiantes
		
		Estudiante estudiante_para_agregar = new Estudiante("Maria", "Moro", "maria@gmail.com", "4", "C 76");
		if (Metodos.agregarSeguro(estudiante_para_agregar, estudiantes_copia)) System.out.println("Estudiante cargado.");
		
		Estudiante estudiante_agregado = estudiante_para_agregar;
		if (!Metodos.agregarSeguro(estudiante_agregado, estudiantes_copia)) System.out.println("No se cargo al estudiante.");
		
		ArrayList<Integer> numero_capicua = new ArrayList<>();
		numero_capicua.add(1); numero_capicua.add(3); numero_capicua.add(5); numero_capicua.add(3); numero_capicua.add(1); 
		if (CapicuaCheker.esCapicua(numero_capicua)) System.out.println("Es capicua!");
		
		ArrayList<Integer> numero_no_capicua = new ArrayList<>();
		numero_no_capicua.add(1); numero_no_capicua.add(2); numero_no_capicua.add(5); numero_no_capicua.add(3); numero_no_capicua.add(1); 
		if (!CapicuaCheker.esCapicua(numero_no_capicua)) System.out.println("No e.s capicua!");
	}
	
	public static void imprimirContenidoListaEstudiante(List<Estudiante> lista) {
		for (Estudiante estudiante : lista) System.out.println(estudiante.tusDatos());
	}
	
	public static boolean agregarSeguro(Estudiante estudiante, List<Estudiante> lista) {
		if (lista.contains(estudiante)) return false;
		else {
			lista.add(estudiante);
			return true;
		}
	}

}
