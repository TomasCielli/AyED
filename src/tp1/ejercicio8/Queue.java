package tp1.ejercicio8;
import java.util.LinkedList;
import java.util.*;

public class Queue <T> {

	private List<T> data;
	
	public Queue() {
		this.data = new LinkedList<T>();
	}
	
	public void enqueue(T dato) {
		this.data.addLast(dato);
	}
	
	public T dequeue() {
		if (this.data.isEmpty()) {
			System.out.println("ERROR: Cola vacia.");
			return null;
		}
		else return this.data.removeFirst();
	}
	
	public T head() {
		if (this.data.isEmpty()) {
			System.out.println("ERROR: Cola vacia.");
			return null;
		}
		else return this.data.getFirst();
	}
	
	public boolean isEmpty() {
		return this.data.isEmpty();
	}
	
	public int size() {
		return this.data.size();
	}
	
	public String toString() {
		String str = "[";
		for (T dato : this.data) {
			str += dato.toString() + ", ";
		}
		str = str.substring(0, str.length()-2)+"]"; //borra el ultimo ", " y pone un "]"
		
		return str;
	}
	
	protected List<T> getData() {
		return this.data;
	}
	
}
