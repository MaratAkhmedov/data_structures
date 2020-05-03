package lineals;

import models.Queue;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayQueue<E> implements Queue<E> {
    protected static final int DEFAULT_CAPACITY = 50;
    protected E[] theArray;
    protected int size;

    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        this.theArray = (E[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * @return the size of the list
     * O(1)
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * add the element at the final of the list
     * @param data the data that should be added
     * O(1)
     */
    @Override
    public void add(E data) {
        if(size >= DEFAULT_CAPACITY) {
            duplicateArray();
        }
        theArray[size++] = data;

    }

    @SuppressWarnings("unchecked")
    private void duplicateArray() {
        E[] newArray =  (E[]) new Object[theArray.length * 2];
        System.arraycopy(theArray, 0, newArray, 0, size);
        theArray = newArray;
    }

    /**
     * remove the first element in the queue
     *
     * @return the removed element
     * O(n)
     */
    @Override
    public E remove() {
        if(size == 0) return null;

        E res = theArray[0];
        size--;
        for(int i = 0; i < size; i++) {
            theArray[i] = theArray[i + 1];
        }
        theArray[size] = null; //nullify the last element
        return res;
    }

    /**
     * get the element in the head
     *
     * @return the data of the element searched
     * O(1)
     */
    @Override
    public E get() {
        return theArray[0];
    }

    /**
     * checks if the list is empty
     *
     * @return true if the list is empty
     * O(1)
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Arrays.toString(theArray));
        //sb.append(Arrays.toString(Arrays.stream(theArray).filter(Objects::nonNull).toArray(Object[]::new)));
        return sb.toString();
    }
}
