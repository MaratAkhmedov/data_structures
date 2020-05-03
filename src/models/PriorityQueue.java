package models;

/**
 * although the methods inside PriorityQueue are similar as in Queue
 * The concept of PriorityQueue is different
 * In java PriorityQueue is the class that
 * add data according to their Natural order or if we pass instance of Comparable
 * to contructor it will order elements according with Comparable priority
 * so Priority Queue isnt normal Queue becouse the order of the elements
 * isnt FIFO (first in first out).
 *
 */

public interface PriorityQueue<E> {
    /**
     *
     * @return the size of the list
     * O(1)
     */
    public int size();

    /**
     * add the element at the final of the list
     * @param data the data that should be added
     * O(n) with arrays
     * O(log n) with heaps
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
