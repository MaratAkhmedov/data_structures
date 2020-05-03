package lineals;

import models.Stack;

/**
 * stach that returns the minimum element of the stack in constant time
 * top element should be always the minimum of the stack
 */

public class MinStack<E extends Comparable<E>> implements Stack<E> {
    LinkedStack<E> stack;
    LinkedStack<E> minimum;

    public MinStack() {
        this.stack = new LinkedStack<E>();
        minimum = new LinkedStack<E>();
    }

    /**
     * Pushes (inserts) the element in the top of the stack.
     *
     * @param
     */

    @Override
    public void push(E e) {
        if(stack.top == null) {
            minimum.push(e);
        }
        //if new value < top actualize minimum
        else if(e.compareTo(stack.top.data) < 0) {
           minimum.push(e);
        }
        stack.push(e);
    }

    /**
     * return the top element of the stack and dont remove it
     *
     * @return the element of the top
     */
    @Override
    public E peek() {
        return stack.peek();
    }

    /**
     * return the top element of the stack and removes it
     *
     * @return the element of the top
     */
    @Override
    public E pop() {
        E res = stack.pop();
        if(minimum.top.data == res) {
            minimum.pop();
        }
        return res;
    }

    /**
     * return if the stack is empty
     *
     * @return true if is empty and false if ist empty
     */
    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * returns the minimum of the stack
     * @return the minimum of the stack
     */
    public E getMinimum() {
        return minimum.top.data;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("stack = [");
        Node<E> node = stack.top;
        while(node != null) {
            res.append(node.toString());

            if(node.next != null)  res.append(", ");
            node = node.next;
        }
        res.append("]");
        res.append("\nminimum = " + this.minimum.top.data);
        return res.toString();
    }
}
