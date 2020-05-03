package lineals;

import models.List;

import java.util.Arrays;

public class ArrayList<E> implements List<E> {

    private int size = 0;
    private static final int DEFAULT_CAPACITY = 30;
    private E array[];

    @SuppressWarnings("unchecked")
    public ArrayList() {
        array = (E[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * @return the size of the list
     * O(1)
     */
    @Override
    public int size() {
        return size;
    }

    public void add(E e) {
        if (size == array.length) {
            ensureCapacity();
        }
        array[size++] = e;
    }

    /**
     * add the element to the specific position
     *
     * @param position is the position you want to insert the element
     * @param data     is the element you want to insert
     */
    @Override
    public void add(E data, int position) {
        if (array.length == size()) ensureCapacity();
        for (int i = size; i > position; i--) {
            array[i] = array[i - 1];
        }
        array[position] = data;
        size++;
    }

    /**
     * remove the element at the specified position
     *
     * @param position
     * @return the removed element
     * O(n)
     */
    @Override
    public E remove(int position) {
        E removeItem = array[position];
        for (int i = position; i < size() - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return removeItem;
    }

    @SuppressWarnings("unckecked")
    private void ensureCapacity() {
        array = (E[]) new Object[array.length * 2];
        E[] old = array;
        for (int i = 0; i < size(); i++) {
            array[i] = old[i];
        }
    }



    @SuppressWarnings("unchecked")
    public E get(int i) {
        if (i>= size || i <0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return (E) array[i];
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
}
