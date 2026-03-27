package tp1.ejercicio7;

import java.util.LinkedList;
import java.util.List;

public class EjercicioSucesion {
	
	
	
	public List<Integer> calcularSucesion (int n) {
		List<Integer> sucesion = new LinkedList<>();
		
		this.calcularRecursion(sucesion, n);
		
		return sucesion;
	}
	
	private void calcularRecursion(List<Integer> sucesion, int n) {
		if (n == 1) {
			sucesion.add(n);
		}
		else {
			sucesion.add(n);
			if (this.esPar(n)) calcularRecursion(sucesion, this.siEsPar(n));
			else this.calcularRecursion(sucesion, this.siEsImpar(n));
		}
	}
	
	private boolean esPar(int n) {
		return (n % 2 == 0);
	}
	
	private int siEsPar(int n) {
		return n/2;
	}
	
	private int siEsImpar(int n) {
		return  3*n + 1;
	}
}
