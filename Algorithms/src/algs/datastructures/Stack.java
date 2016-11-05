package algs.datastructures;

/**
 * Created by Robert Mitchell on 11/2/16.
 */
public interface Stack<T> {
    /**
     * Adds the given item to the top of the stack, increasing the size by one.
     *
     * @param t The item to add to the end of the stack.
     */
    void push(final T t);

    /**
     * Removes the top item from the stack, and returns it, decreasing the size by one.
     *
     * @return the top item in the stack.
     */
    T pop();

    /**
     * Returns the number of items currently in the stack.
     *
     * @return The number of items in the stack.
     */
    int size();

    /**
     * Returns an object which implements all the Stack methods.
     *
     * @param <T> The type of the data contained on the Stack
     * @return a new object which implements all the Stack methods.
     */
    static <T> Stack<T> newInstance() {
        return new DoublyLinkedList<>();
    }
}
