package tp1.ejercicio2;

import java.util.Scanner;

public class Metodos {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		
		System.out.print("Escriba un numero: ");
		int n = s.nextInt();
		System.out.println("");
		
		System.out.print("| ");
		for (int dato : Metodos.devolverArreglo(n)) System.out.print(dato + " | ");
	}
	
	public static int[] devolverArreglo(int n) {
		int[] arreglo = new int[n]; //creo un arreglo con "n" lugares
		
		for (int i = 0; i < n; i++) {
			arreglo[i] = n * (i + 1); 
		}
		
		return arreglo;
	}

}
