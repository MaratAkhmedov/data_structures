package lineals;

import models.List;
import models.Queue;

/**
 * Linked List implements Queue becouse the model queue can be implemented by linked list
 * @param <E>
 */

public class LinkedList<E> implements List<E>, Queue<E> {
	public int size;
	public Node<E> first;

	// en Java List tmbn tiene Last por lo que accede al ultimo en tiempo constante


	public LinkedList() {
		size = 0;
		this.first = null;
	}


	@Override
	public int size() {
		return size;
	}


	/**
	 * inserta un elemento al final de la lista, coste lineal O(n) donde n es el numero de elementos
	 * 
	 */
	@Override
	public void add(E data) {
		add(data, this.size);
	}


	/**
	 * Method of the Queue interface
	 * remove the head of the queue
	 * @return the removed element
	 */
	@Override
	public E remove() {
		E res = null;
		if(first != null) {
			size--;
			res = first.data;
			first = first.next;
			if(first != null) { first.prev = null;}
		}
		return res;
	}


	/**
	 * Method of the Queue interface
	 * get the element in the head
	 * @return the data of the element searched
	 */
	@Override
	public E get() {
		E res = null;
		if(first != null) {
			res = first.data;
		}
		return res;
	}


	/**
	 * insert the element in the list
	 * @param data the data to be inserted
     * @param pos the position of the element to insert
	 */
	@Override
	public void add(E data, int pos) {
		Node<E> newNode = new Node<E>(data);
		size++;
		Node<E> aux = first;
		Node<E> prev = null;
		for(int i = 0; i < pos; i++) {
			prev = aux;
			aux = aux.next;
		}
		//prev is null if pos = 0
		if(prev == null) {
			newNode.next = first;
			first = newNode;
			//first.prev = newNode;
		}else {
			newNode.next = aux;
			prev.next = newNode;
			newNode.prev = prev;
			//if aux != null, newNode wont stay in the last position, so we need actualize aux.prev
			if(aux != null) aux.prev = newNode;
		}
	}


	/**
	 * get the element in the specified position
	 */
	@Override
	public E get(int pos) {
		E res = null;
		Node<E> aux = first;
		for(int i = 0; i <= pos; i++) {
			res = aux.data;
			aux = aux.next;
		}
		return res;
	}

	/**
	 * remove the element at specified position
	 * @param position
	 * @return
	 */
	@Override
	public E remove(int position) {
		size--;
		Node<E> prev = null;
		Node<E> aux = first;
		for(int i = 0; i < position; i++) {
			prev = aux;
			aux = aux.next;
		}
		E res = aux.data;
		if (prev == null) { first = aux.next; first.prev = null;} //eliminamos el primero
        else {
        	prev.next = aux.next;
        	if(aux.next != null) {
        		aux.next.prev = prev;
        	}
        }
		return res;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	
	public void reverse(){
		Node<E> prev = null;
		Node<E> current = first;
		Node<E> next = null;
		while(current != null) {
			next = current.next;
			current.next = prev;
			current.prev = next;
			prev = current;
			current = next;
		}
		first = prev;
	}
	
	/**
	*Find the middle of a given linked list in C and Java
	*Given a singly linked list, find middle of the linked list. 
	*For example, if given linked list is 1->2->3->4->5 then output should be 3.
	*If there are even nodes, then there would be two middle nodes,
	* we need to print second middle element. For example, if given linked
	*list is 1->2->3->4->5->6 then output should be 4.
	*/
	public E middle() {
		Node<E> aux = first;
		for(int i = 0; i < size/2; i++) {
			aux = aux.next;
		}
		return aux.data;
	}
	
	
	
	
	public String toString() {
		String res = "";
		for(int i = 0; i < size(); i++) {
			res += get(i) + "\n";
		}
		return res;
	}

}
