package tp1.ejercicio8;

public class CircularQueue <T> extends Queue<T>{

	public T shift() {
		T primero = this.dequeue();
		this.enqueue(primero);
		return primero;
	}
}
