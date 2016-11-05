package algs.datastructures;

/**
 * Created by Robert Mitchell on 11/2/16.
 */
public interface Queue<T> {
    /**
     * Adds the given item to the end of the queue, increasing the size by one.
     *
     * @param t The item to add to the end of the queue.
     */
    void enqueue(final T t);

    /**
     * Removes the first (the front) item from the queue, and returns it, decreasing the size by one.
     *
     * @return the first item in the queue.
     */
    T dequeue();

    /**
     * Returns the number of items currently in the queue.
     *
     * @return The number of items in the queue.
     */
    int size();

    /**
     * Returns an object which implements all the Queue methods.
     *
     * @param <T> The type of the data contained on the Queue
     * @return a new object which implements all the Queue methods.
     */
    static <T> Queue<T> newInstance() {
        return new DoublyLinkedList<>();
    }
}
