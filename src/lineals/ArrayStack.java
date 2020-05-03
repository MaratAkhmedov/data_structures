package lineals;

import models.Stack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

public class ArrayStack<E> implements Stack<E> {
    protected static final int DEFAULT_CAPACITY = 50;
    protected E[] theArray;
    protected int top;
    protected int size;

    public ArrayStack() {
        theArray = (E[]) new Object[DEFAULT_CAPACITY];
        top = -1;
        size = 0;
    }

    /**
     * Pushes (inserts) the element in the top of the stack.
     * @param e
     */
    @Override
    public void push(E e) {
        if(size == DEFAULT_CAPACITY){
            duplicateArray();
        }
        size++;
        theArray[++top] = e;
    }

    /**
     * return the top element of the stack and dont remove it
     * @return the element of the top
     */
    @Override
    public E peek() {
        return theArray[top];
    }

    /**
     * return the top element of the stack and removes it
     * @return the element of the top
     */
    @Override
    public E pop() {
        if(size == 0) return null;
        E res = theArray[top];
        theArray[top--] = null; //not obligatory
        size--;
        return res;
    }

    /**
     * return if the stack is empty
     * @return true if is empty and false if ist empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //@SuppressWarnings("unchecked")
    private void duplicateArray() {
        E[] newArray =  (E[]) new Object[theArray.length * 2];
        System.arraycopy(theArray, 0, newArray, 0, top);
        theArray = newArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Arrays.toString(theArray));
        //sb.append(Arrays.toString(Arrays.stream(theArray).filter(Objects::nonNull).toArray(Object[]::new)));
        return sb.toString();
    }
}
