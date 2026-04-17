package tp2.ejercicio7;
import tp2.ejercicio1.BinaryTree;

public class ParcialArboles {
	
	private BinaryTree<Integer> arbol;
	
	public ParcialArboles(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	private class Resultado{
		int cantidad_izquierda = 0;
		int cantidad_derecha = 0;
		boolean encontro = false;
		
		
		public Resultado(int cantidad_izquierda, int cantidad_derecha, boolean encontro) {
			super();
			this.cantidad_izquierda = cantidad_izquierda;
			this.cantidad_derecha = cantidad_derecha;
			this.encontro = encontro;
		}
		
		public int getCantidad_izquierda() {
			return cantidad_izquierda;
		}
		public void setCantidad_izquierda(int cantidad_izquierda) {
			this.cantidad_izquierda = cantidad_izquierda;
		}
		public int getCantidad_derecha() {
			return cantidad_derecha;
		}
		public void setCantidad_derecha(int cantidad_derecha) {
			this.cantidad_derecha = cantidad_derecha;
		}
		public boolean getEncontro() {
			return this.encontro;
		}
		public void setEncontro(boolean encontro) {
			this.encontro = encontro;
		}
		
		
	}
	
	public boolean isLeftTree(int num) {
		
		Resultado resultado = this.isLeftTreeRecursivo(num, this.arbol);
		
		return (resultado.getEncontro() && (resultado.getCantidad_izquierda() > resultado.getCantidad_derecha()));
	}
	
	private Resultado isLeftTreeRecursivo(int num, BinaryTree<Integer> arbol) {
		Resultado resultado = new Resultado(0, 0, false);
		
		//caso limite 1
		if (arbol.isEmpty()) {
			resultado.setEncontro(false);
		} else if (arbol.isLeaf()) {
			if (arbol.getData() == num) {
				resultado.setEncontro(true);
				resultado.setCantidad_izquierda(-1);
				resultado.setCantidad_derecha(-1);
			}
		}
		else {
			if (arbol.getData() != num) {
				Resultado izquierda = arbol.hasLeftChild()? this.isLeftTreeRecursivo(num, arbol.getLeftChild()) : new Resultado(0, 0, false);
				Resultado derecha = arbol.hasRightChild()? this.isLeftTreeRecursivo(num, arbol.getRightChild()) : new Resultado(0, 0, false);
				
				if (izquierda.getEncontro()) {
					resultado = izquierda;
				}
				else if (derecha.getEncontro()) {
					resultado = derecha;
				}
			}
			else {
				int cant_izquierda = arbol.hasLeftChild()? this.contarRecursivo(arbol.getLeftChild()) : -1;
				int cant_derecha = arbol.hasRightChild()? this.contarRecursivo(arbol.getRightChild()) : -1;
				resultado.setEncontro(true);
				resultado.setCantidad_izquierda(cant_izquierda);
				resultado.setCantidad_derecha(cant_derecha);
			}
		}
		
		return resultado;
	}
	
	private int contarRecursivo(BinaryTree<Integer> arbol) {
		
		int cant = 0;
		if (!(arbol.isEmpty() | arbol.isLeaf())) {
			if ((arbol.hasLeftChild() && !arbol.hasRightChild()) || (!arbol.hasLeftChild() && arbol.hasRightChild())) {
				cant = 1;
			}
			
			if (arbol.hasLeftChild()) cant += this.contarRecursivo(arbol.getLeftChild());
			if (arbol.hasRightChild()) cant += this.contarRecursivo(arbol.getRightChild());
		}
		
		return cant;
	}
	
	

	
	
}