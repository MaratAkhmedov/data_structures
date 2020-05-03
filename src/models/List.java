package models;

/**
 *List - A list is an ordered list of objects.
 *  You can add an element anywhere in the list,
 *  change an element anywhere in the list,
 *  or remove an element from any position in the list.
 * @param <E>
 */

public interface List<E> {
	/**
	 * @return the size of the list
	 * O(1)
	 */
	public int size();

	/**
	 * add the element at the final of the list
	 * @param data the data that should be added
	 * O(n)
	 */
	public void add(E data);
	
	/**
	 * @param data el elemento que quieres insertar
	 * @param pos la posicion a la que quieres insertar
	 * O(1) -> en el mejor de los casos
	 * O(n) ->en elpeor de los casos
	 */
	public void add(E data, int pos);
	
	/**
	 * remove the element at the specified position
	 * @return the removed element
	 * O(n)
	 */
	public E remove(int position);
	
	/**
	 * get the element that stay in pos
	 * @param pos the position of the element that we are looking for
	 * @return the data of the element searched
	 * O(n) -> en el peor de los casos
	 * O(1) -> en el mejor de los casos
	 */
	public E get(int pos);
	
	/**
	 * checks if the list is empty
	 * @return true if the list is empty
	 * O(1)
	 */
	public boolean isEmpty();
}
