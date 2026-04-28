package tp3.ejercicio1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp1.ejercicio8.Queue;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int altura() {	 
		int altura = 0;
		if (!this.isEmpty()) altura = this.altura_priv();
		return altura;
	}
	
	private int altura_priv() {
		int altura = 0, altura_max = -1;
		if (!this.isLeaf()) {
			List<GeneralTree<T>> children = this.getChildren();
			Iterator<GeneralTree<T>> it = children.iterator();
			
			while (it.hasNext()) {
				int altura_hijo = it.next().altura_priv();
				if (altura_hijo > altura_max) altura_max = altura_hijo;
			}
			altura= altura_max + 1;
		}
		return altura;
	}
	
	public int nivel(T dato){
		int nivel = -1;
		if (!this.isEmpty()) {
			ResultadoNivel resultado = nivel_recursivo(dato);
			if (resultado.isEncontrado()) {
				nivel = resultado.getNivel();
			}
		}
		return nivel;
	}
	
	private ResultadoNivel nivel_recursivo(T dato) {
		ResultadoNivel resultado = new ResultadoNivel(false, -1);
		if (!this.getData().equals(dato)) {
			if (this.hasChildren()) {
				Iterator<GeneralTree<T>> it = this.getChildren().iterator();
				while (it.hasNext() && (!resultado.isEncontrado())) {
					resultado = it.next().nivel_recursivo(dato);
				}
				if (resultado.isEncontrado()) {
					resultado.setNivel(resultado.getNivel()+ 1);
				}
			}
		} else {
			resultado.setEncontrado(true);
			resultado.setNivel(0);
		}
		return resultado;
	}
	
	private class ResultadoNivel {
		boolean encontrado;
		int nivel;
		
		private ResultadoNivel(boolean encontrado, int nivel){
			this.encontrado = encontrado;
			this.nivel = nivel;
		}

		public boolean isEncontrado() {
			return encontrado;
		}

		public void setEncontrado(boolean encontrado) {
			this.encontrado = encontrado;
		}

		public int getNivel() {
			return nivel;
		}

		public void setNivel(int nivel) {
			this.nivel = nivel;
		}
		
		
	}

	public int ancho(){
		int max = 0;
		if (!this.isEmpty()) {
			Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
			cola.enqueue(this);	cola.enqueue(null);
			int cant = 0;
			while (!cola.isEmpty()) {
				GeneralTree<T> arbol = cola.dequeue();
				if (arbol != null) {
					cant++;
					if (arbol.hasChildren()) {
						List<GeneralTree<T>> children = arbol.getChildren();
						for (GeneralTree<T> child : children) {
							cola.enqueue(child);
						}
					}
				} else {
					if (!cola.isEmpty()) cola.enqueue(null);
					max = cant > max? cant : max;
					cant = 0;
				}
				
			}
		}
		return max;
	}
	
	public boolean esAncestro(T a, T b) {
		boolean es_ancestro = false;
		if (!this.isEmpty()) es_ancestro = this.buscarA(a, b);
		return es_ancestro;
	}
	
	private boolean buscarA(T a, T b) {
		boolean es_ancestro = false;
		if (this.getData().equals(a)) {
			if (this.hasChildren()) {
				Iterator<GeneralTree<T>> it = this.getChildren().iterator();
				while (it.hasNext() && !es_ancestro) {
					es_ancestro = it.next().buscarB(b);
				}
			}
		} if (!es_ancestro && this.hasChildren()) {
			Iterator<GeneralTree<T>> it = this.getChildren().iterator();
			while (it.hasNext() && !es_ancestro) {
				es_ancestro = it.next().buscarA(a, b);
			}
		}
		return es_ancestro;
	}
	
	private boolean buscarB(T b) {
		boolean encontre_b = false;
		if (this.getData().equals(b)) {
			encontre_b = true;
		} else {
			if (this.hasChildren()) {
				Iterator<GeneralTree<T>> it = this.getChildren().iterator();
				while (it.hasNext() && !encontre_b) {
					encontre_b = it.next().buscarB(b);
				}
			}
		}
		return encontre_b;
	}
	
}