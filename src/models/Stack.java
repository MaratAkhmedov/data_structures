package models;

/**
 * Stack is a structure base in the principle LIFO (Last in first out)
 * and has 2 operations, push and pop
 * @param <E>
 */

public interface Stack<E> {
	/**
	 * Pushes (inserts) the element in the top of the stack.
	 * O(1)
	 */
	public void push(E e);
	
	/**
	 * return the top element of the stack and dont remove it
	 * @return the element of the top
	 * O(1)
	 */
	public E peek();
	
	/**
	 * return the top element of the stack and removes it
	 * @return the element of the top
	 * O(1)
	 */
	public E pop();
	
	/**
	 * return if the stack is empty
	 * @return true if is empty and false if ist empty
	 * O(1)
	 */
	public boolean isEmpty();

}
