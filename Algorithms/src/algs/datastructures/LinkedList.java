package algs.datastructures;

/**
 * Defines the ADT of a Linked List, specifying that a Linked List must have the functionality to add or remove an item,
 * to set or get the value at a specified index, and to insert an item into the list at a given index, as well as
 * retrieve the size of the list.
 *
 * The performance of these methods will depend on the implementation, but in general, size should be O(1), add should
 * be O(1) unless the implementation is quite simple, and insert, get, remove, and set should be O(N); where N is the
 * size of the list, and we're counting the number of times we must transition from one node to another within the list.
 *
 * TODO: Consider renaming to just List, since nothing in particular about these methods make it a Linked List.
 *
 * Created by Robert Mitchell on 11/1/16.
 */
public interface LinkedList<T> {

    /**
     * Inserts a new node containing the given value at the end of the list. This also increases the size by 1.
     *
     * @param t The value to add to the end of the list.
     */
    void add(final T t);

    /**
     * Inserts a new node containing the given value into the specified position, and shifts the existing value ahead
     * one index in the list. Note that nodes are zero-indexed, so inserting at index 0 will create a new first element
     * (a new root element), and inserting at index size() - 1 will create a new last element (the tail element). This
     * also increases the size by 1.
     *
     * @param index The index of the linked list to alter.
     * @param t The value to assign to the given index.
     */
    void insert(final int index, final T t);

    /**
     * Returns the value at the node of the specified index, and then deletes that node from the list. Note that nodes
     * are zero-indexed, so removing index 0 will return the first element (the root element), and removing index
     * size() - 1 will return the last element (the tail element). This also decreases the size by 1.
     *
     * @param index The index of the node to be removed, whose value is desired.
     * @return The value at the specified node.
     */
    T remove(final int index);

    /**
     * Returns the value at the node of the specified index. Note that nodes are zero-indexed, so getting index 0 will
     * return the first element (the root element), and getting index size() - 1 will return the last element (the tail
     * element).
     *
     * @param index The index of the node whose value is desired.
     * @return The value at the specified node.
     */
    T get(final int index);

    /**
     * Sets the value of the node at the specified index to the specified value. Note that nodes are zero-indexed, so
     * setting index 0 will alter the first element (the root element), and setting index size() - 1 will alter the last
     * element (the tail element).
     *
     * @param index The index of the linked list to alter.
     * @param t The value to assign to the given index.
     */
    void set(final int index, final T t);

    /**
     * Returns the number of elements in the Linked List.
     *
     * @return the size of the list.
     */
    int size();
}
