package tp1.ejercicio9;

import tp1.ejercicio8.*;

public class TestBalanceo {

	public boolean estaBalanceado(String str) {
		if (str.isBlank()) return true;
		else {
			Stack<Character> pila = new Stack<Character>();
			
			char[] caracteres = str.toCharArray();
			
			for (char caracter : caracteres) {
				if (this.abre(caracter)) {
					pila.push(caracter);
				}
				else if (pila.isEmpty() || (this.cierra(caracter) && (!(this.esSuPar(pila.pop(), caracter))))) return false;
			}
			if (!pila.isEmpty()) return false;
			return true;
		}
	}
	
	private boolean abre(char x) {
		return ((x == '(') | (x == '{') | (x == '['));
	}
	
	private boolean cierra(char x) {
		return ((x == ')') | (x == '}') | (x == ']'));
	}
	
	private boolean esSuPar(char x, char y) {
		if (x == '(') return (y == ')');
		else if (x == '{') return (y == '}');
		else if (x == '[') return (y == ']');
		else return false;
	}
}
