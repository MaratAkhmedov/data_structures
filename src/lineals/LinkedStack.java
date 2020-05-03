package lineals;

import models.Stack;

public class LinkedStack<E> implements Stack<E>{
	 protected Node<E> top;
	 protected int size;


	public LinkedStack() {
		top = null;
		size = 0;
	}

	/**
	 * Pushes (inserts) the element in the top of the stack.
	 */
	@Override
	public void push(E e) {
		top = new Node<E>(e, top);
		size++;
	}

	/**
	 * return the top element of the stack and dont remove it
	 * @return the element of the top
	 */
	@Override
	public E peek() {
		return top.data;
	}

	/**
	 * return the top element of the stack and removes it
	 * @return the element of the top
	 */
	@Override
	public E pop() {
		E res = top.data;
		top = top.next;
		return res;
	}

	/**
	 * return if the stack is empty
	 * @return true if is empty and false if ist empty
	 */
	@Override
	public boolean isEmpty() {
		return top == null;
	}
	
	public String toString() {
		 StringBuilder res = new StringBuilder();
	     res.append("["); 
	     Node<E> node = top;
	     while(node != null) {
	    	 res.append(node.toString());

	    	 if(node.next != null)  res.append(", ");
	    	 node = node.next;
	     }
	     res.append("]"); 
	     return res.toString(); 
	}

}
