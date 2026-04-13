package tp2.ejercicio1;

import tp1.ejercicio8.Queue;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}	
		
    
    public BinaryTree<T> espejo(){
    	BinaryTree<T> invertido = new BinaryTree<T>();
    	invertido.setData(this.getData());
    	if (!this.isLeaf()) {
	    	BinaryTree<T> derecho = null, izquierdo = null;
	    	if (this.hasLeftChild()) {
	    		izquierdo = this.getLeftChild().espejo();
	    	}
	    	
	    	if (this.hasRightChild()) {
	    		derecho = this.getRightChild().espejo();
	    	}
	    	
	    	
	    	invertido.leftChild = derecho;
	    	invertido.rightChild = izquierdo;
    	}
    	return invertido;
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m){
		
		BinaryTree<T> ab = null;
		Queue <BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
		int contador_nivel = 0;
		
		cola.enqueue(this);
		cola.enqueue(null);
		
		while(!cola.isEmpty()) {
			ab = cola.dequeue();
			if (ab != null) {
				if ((contador_nivel >= n) && (contador_nivel <= m)) {
					System.out.print(ab.getData());
				}
				if (ab.hasLeftChild()) cola.enqueue(ab.getLeftChild());
				if (ab.hasRightChild()) cola.enqueue(ab.getRightChild());
			} else if (!cola.isEmpty()) {
				contador_nivel++;
				cola.enqueue(null);
			}
		}
   }
	
	public int contarHojas() {
		int cont = this.isLeaf()? 1: 0;
		if (this.hasLeftChild()) cont += this.getLeftChild().contarHojas();
		if (this.hasRightChild()) cont += this.getRightChild().contarHojas();
		
		return cont;
	}
		
}

