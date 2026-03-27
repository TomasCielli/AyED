package tp1.ejercicio5;

public class Metodos {
	
	public static int[] calcularValoresReturn(int[] valores) {
		
		if (valores == null || valores.length == 0) {
		    throw new IllegalArgumentException("El arreglo no puede estar vacío");
		}
		
		int total = 0, 
			mayor = valores[0], menor = valores[0], promedio = 0; 
		
		for (int valor : valores) {
			total += valor;
			mayor = (valor > mayor) ? valor : mayor;
			menor = (valor < menor) ? valor : menor;
		}
		
		promedio = total / valores.length;
		
		return new int[] {mayor, menor, promedio};
	}
	
	public static class Valores {
		private int mayor;
		private int menor;
		private int promedio;
		
		public int getMayor() {
			return mayor;
		}
		public void setMayor(int mayor) {
			this.mayor = mayor;
		}
		public int getMenor() {
			return menor;
		}
		public void setMenor(int menor) {
			this.menor = menor;
		}
		public int getPromedio() {
			return promedio;
		}
		public void setPromedio(int promedio) {
			this.promedio = promedio;
		}
		
		
	}
	
	public static void calcularValoresObjeto(int[] valores, Valores resultado) {
		
		int[] resultados = Metodos.calcularValoresReturn(valores);
		
		resultado.setMayor(resultados[0]);
		resultado.setMenor(resultados[1]);
		resultado.setPromedio(resultados[2]);
	}
	
	static int mayor;
	static int menor;
	static int promedio;
	
	public static void calcularValoresStatic(int[] valores) {
		int[] resultados = Metodos.calcularValoresReturn(valores);
		
		Metodos.mayor = resultados[0];
		Metodos.menor = resultados[1];
		Metodos.promedio = resultados[2];
	}
	
	public static void main(String[] args) {
		
		int[] valores = new int[] {2,10, 25, 4, 1, 32, 23};
		
		Metodos.calcularValoresStatic(valores);
		
		System.out.print("Mayor: " + Metodos.mayor + "| Menor:" + Metodos.menor + "| Promedio: " + Metodos.promedio);
	}
	
	
}
