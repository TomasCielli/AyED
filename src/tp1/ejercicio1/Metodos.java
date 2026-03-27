package tp1.ejercicio1;

public class Metodos {
	
	public static void main(String[] args) {
		System.out.println("Metodo For:");
		Metodos.imprimirFor(1, 10);
		System.out.println("-----------");
		System.out.println("");
		
		System.out.println("Metodo While:");
		Metodos.imprimirWhile(1, 10);
		System.out.println("-----------");
		System.out.println("");
		
		System.out.println("Metodo Sin");
		Metodos.imprimirSin(1, 10);
		System.out.println("-----------");
		
	}
	
	public static void imprimirFor(int a, int b) {
		int mayor = (a > b) ? a : b;
		int menor = (a > b) ? b : a;
		
		for (int i = menor; i <= mayor; i++) {
			System.out.println(i);
		}
	}
	
	public static void imprimirWhile(int a, int b) {
		int mayor = (a > b) ? a : b;
		int menor = (a > b) ? b : a;
		
		while (menor <= mayor) {
			System.out.println(menor);
			menor++;
		}
	}
	
	public static void imprimirSin(int a, int b) {
		int mayor = (a > b) ? a : b;
		int menor = (a > b) ? b : a;
		
		if (menor != mayor) {
			System.out.println(menor);
			Metodos.imprimirSin(menor + 1, mayor);
		}
		else {
			System.out.println(menor);
		}
	}
}
