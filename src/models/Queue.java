package models;

/**
 * Queue is a structure base in the principle FIFO (first in first out)
 * you cant
 * and has 2 operations, add and remove
 * Queue generally has 2 implementation, by LinkedList or by Priority
 * @param <E>
 */

public interface Queue<E> {
    /**
     *
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
     * remove the first element in the queue
     * @return the removed element
     * O(1)
     */
    public E remove();

    /**
     * get the element in the head
     * @return the data of the element searched
     * O(1)
     */
    public E get();

    /**
     * checks if the list is empty
     * @return true if the list is empty
     * O(1)
     */
    public boolean isEmpty();
}
