package lineals;

public class Node<E> {
	public E data;
	public Node<E> next;
	public Node<E> prev;
	
	public Node(E data) {
		this.data = data;
		next = null;
		prev = null;
	}
	
	public Node(E data, Node<E> next) {
		this.data = data;
		this.next = next;
		this.prev = null;
	}
	
	public Node(E data, Node<E> prev, Node<E> next) {
		this.data = data;
		this.prev = prev;
		this.next = next;
	}
	
	public String toString() {
		return data.toString();
	}
}
