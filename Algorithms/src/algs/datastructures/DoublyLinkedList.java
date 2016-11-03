package algs.datastructures;

import java.util.Objects;

/**
 * Created by Robert Mitchell on 11/1/16.
 */
public class DoublyLinkedList<T> implements LinkedList<T> {

    /** The first node in the list. */
    private BinaryNode<T> root;

    /** The last node in the list. */
    private BinaryNode<T> tail;

    /** The number of nodes in the list. */
    private int size;

    /**
     * Returns the BinaryNode object at the specified index, allowing other methods to not need to traverse the linked
     * list's internal nodes.
     *
     * This operation is O(N), but will in general use closer to ~ N / 2 node traversals, since it traverses half the
     * list starting from the closer node to the target node.
     *
     * @param index The index of the desired node.
     * @return The BinaryNode object at the specified node.
     */
    private BinaryNode<T> getNode(final int index) {
        /* Iterate through the list from the root if the index is closer to it, or from the tail if
         * the index is closer to it, to the desired index.
         */
        BinaryNode<T> iterator = root;
        if (index < size / 2) {
            for (int i = 0; i < index; ++i, iterator = iterator.getRight());
        } else {
            iterator = tail;
            for (int i = size; i > index + 1; --i, iterator = iterator.getLeft());
        }
        return iterator;
    }

    /**
     * Inserts a new node containing the given value at the end of the list. This also increases the size by 1.
     *
     * This operation is O(1), since the tail of the list is already recorded, only three references need to be changed.
     *
     * @param t The value to add to the end of the list.
     */
    @Override
    public void add(final T t) {
        if (tail == null) {
            /* If there is no tail, then there is no root, and the list is empty. So create a new node with the given
             * value, and make it both the root and the tail.
             */
            root = tail = BinaryNode.valueOf(t);
        } else {
            /* Otherwise, there's already a tail, so make the tail point forward (right) to the new element, and make
             * the new element the new tail of the list.
             */
            tail.setRight(BinaryNode.withLeft(t, tail));
            tail = tail.getRight();
        }
        size++;
    }

    /**
     * Inserts a new node containing the given value into the specified position, and shifts the existing value ahead
     * one index in the list. Note that nodes are zero-indexed, so inserting at index 0 will create a new first element
     * (a new root element), and inserting at index size() - 1 will create a new last element (the tail element). This
     * also increases the size by 1.
     *
     * If index is closer to the root than the tail, then the iteration to the index of insertion will begin from the
     * root, whereas if it is closer to the tail, it will begin from the tail. Because of this, at most half of the list
     * will be passed over during an insertion operation, making the O(N) performance closer to ~ N / 2.
     *
     * This throws an IndexOutOfBoundsException if the specified index is below zero or greater than size().
     *
     * @param index The index of the linked list to alter.
     * @param t The value to assign to the given index.
     */
    @Override
    public void insert(final int index, final T t) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index + " is out of bounds; the size of the list is: " + size);
        }
        if (index == 0) {
            /* If we're inserting at the beginning, then make a new node whose right reference refer to the current
             * root, and record the new node as the root.
             */
            BinaryNode<T> tmp = root;
            root = BinaryNode.withRight(t, tmp);
            tmp.setLeft(root);
        } else if (index == size) {
            /* If the index is size, then just perform an add operation. */
            this.add(t);
            return; /* Return so we don't accidentally increment the size twice. */
        } else {
            BinaryNode<T> node = getNode(index);
            /* Then insert a new node containing the desired element in that position, by making the new node refer
             * right to the old node in that position, and left to the node immediately prior to that position, and
             * making the prior node refer right to the new node, and the original node in this position refer left to
             * the new node.
             */
            final BinaryNode<T> tmp = node.getLeft();
            node.setLeft(BinaryNode.from(t, tmp, node));
            tmp.setRight(node.getLeft());
        }
        ++size;
    }

    /**
     * Returns the value at the node of the specified index, and then deletes that node from the list. Note that nodes
     * are zero-indexed, so removing index 0 will return the first element (the root element), and removing index
     * size() - 1 will return the last element (the tail element). This also decreases the size by 1.
     *
     * If index is closer to the root than the tail, then the iteration to the index of removal will begin from the
     * root, whereas if it is closer to the tail, it will begin from the tail. Because of this, at most half of the list
     * will be passed over during a remove operation, making the O(N) performance closer to ~ N / 2.
     *
     * This throws an IndexOutOfBoundsException if the specified index is below zero or greater than size().
     *
     * @param index The index of the node to be removed, whose value is desired.
     * @return The value at the specified node.
     */
    @Override
    public T remove(final int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index + " is out of bounds; the size of the list is: " + size);
        }
        /* Iterate through the list from the root if the index is closer to it, or from the tail if
         * the index is closer to it, to the desired index.
         */
        BinaryNode<T> node = getNode(index);
        /* Repair the links for the remaining nodes, so that the removed node is not referenced. */
        if (node.getLeft() != null) {
            node.getLeft().setRight(node.getRight());
        }
        if (node.getRight() != null) {
            node.getRight().setLeft(node.getLeft());
        }
        if (node == root) {
            root = root.getRight();
        } else if (node== tail) {
            tail = tail.getLeft();
        }
        size--;
        return node.getValue();
    }

    /**
     * Returns the value at the node of the specified index. Note that nodes are zero-indexed, so getting index 0 will
     * return the first element (the root element), and getting index size() - 1 will return the last element (the tail
     * element).
     *
     * If index is closer to the root than the tail, then the iteration to the index of access will begin from the
     * root, whereas if it is closer to the tail, it will begin from the tail. Because of this, at most half of the list
     * will be passed over during a get operation, making the O(N) performance closer to ~ N / 2.
     *
     * This throws an IndexOutOfBoundsException if the specified index is below zero or greater than size().
     *
     * @param index The index of the node whose value is desired.
     * @return The value at the specified node.
     */
    @Override
    public T get(final int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index + " is out of bounds; the size of the list is: " + size);
        }
        return getNode(index).getValue();
    }

    /**
     * Sets the value of the node at the specified index to the specified value. Note that nodes are zero-indexed, so
     * setting index 0 will alter the first element (the root element), and setting index size() - 1 will alter the last
     * element (the tail element).
     *
     * If index is closer to the root than the tail, then the iteration to the index to be set will begin from the
     * root, whereas if it is closer to the tail, it will begin from the tail. Because of this, at most half of the list
     * will be passed over during a set operation, making the O(N) performance closer to ~ N / 2.
     *
     * This throws an IndexOutOfBoundsException if the specified index is below zero or greater than size().
     *
     * @param index The index of the linked list to alter.
     * @param t The value to assign to the given index.
     */
    @Override
    public void set(final int index, final T t) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index + " is out of bounds; the size of the list is: " + size);
        }
        getNode(index).setValue(t);
    }

    /**
     * Returns the number of elements in the Linked List.
     *
     * This is an O(1) operation.
     *
     * @return the size of the list.
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Checks whether this DoublyLinkedList is equal to the specified object.
     *
     * Two DoublyLinkedLists are equal iff they are the same size, and contain the same values in the same order.
     *
     * @param other The object with which to test for equality.
     * @return True if the other object is equal to this DoublyLinkedList, false otherwise.
     */
    @Override
    public boolean equals(final Object other) {
        if (other == null || !(other instanceof DoublyLinkedList)) {
            return false;
        }
        if (this == other) {
            return true;
        }
        final DoublyLinkedList<T> o = (DoublyLinkedList<T>) other;
        if (this.size() != o.size()) {
            System.out.println(this.size + " " + o.size());
            return false;
        }
        /* Test corresponding nodes for equality. */
        for (BinaryNode<T> r1 = this.root, r2 = o.root; r1 != null; r1 = r1.getRight(), r2 = r2.getRight()) {
            if (!r1.equals(r2) || r1.getRight() != null && r2.getRight() == null ||
                    r1.getRight() == null && r2.getRight() != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Computes a hashCode for the instance invoked from, based on the hashCodes of the nodes contained in the list,
     * which are in turn based on the values contained therein.
     *
     * @return The hashCode for this object computed based on the values it contains.
     */
    @Override
    public int hashCode() {
        int hash = 61;
        for (BinaryNode<T> iterator = root; iterator != null; iterator = iterator.getRight()) {
            hash = 37 * hash + Objects.hashCode(iterator);
        }
        return hash;
    }

    /**
     * Returns a String containing the .toString() of each element in the list, formatted as follows:
     * { element1.toString(), element2.toString(), ..., elementN.toString() }
     * where N = size().
     *
     * @return A String representation of the elements of the list.
     */
    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder("{ ");
        for (BinaryNode<T> iterator = root; iterator != tail; iterator = iterator.getRight()) {
            str.append(iterator.toString()).append(", ");
        }
        return str.append(tail.toString()).append(" }").toString();
    }

    /** TODO: Implement JUnit tests for this class. */
    public static void main(final String[] args) {
        final Integer[] data = {1, 2, 3, 4, 5};
        final LinkedList<Integer> lst = new DoublyLinkedList<>();

        for (final Integer i : data) {
            lst.add(i);
            System.out.println(lst);
        }

        for (int i = 0; i < 5; ++i) {
            System.out.printf("index %d: %d%n", i, lst.get(i));
        }


        lst.insert(0, 25);
        System.out.println(lst + " " + lst.size());

        lst.insert(lst.size(), 26);
        System.out.println(lst + " " + lst.size());

        lst.insert(lst.size() / 2, 27);
        System.out.println(lst + " " + lst.size());

        lst.set(0, 0);
        System.out.println(lst + " " + lst.size());

        lst.set(lst.size() - 1, lst.size());
        System.out.println(lst + " " + lst.size());

        lst.set(lst.size() / 2, lst.size() / 2);
        System.out.println(lst + " " + lst.size());

        int tmp = lst.remove(0);
        System.out.println(lst + " : " + tmp + " " + lst.size());

        tmp = lst.remove(lst.size() - 1);
        System.out.println(lst + " : " + tmp + " " + lst.size());

        tmp = lst.remove(lst.size() / 2);
        System.out.println(lst + " : " + tmp + " " + lst.size());

        final LinkedList<Integer> other = new DoublyLinkedList<>();
        for (int i = 1; i < 6; ++i) {
            other.add(i);
        }

        System.out.printf("%s, %s : %b%n", other.toString(), lst.toString(), other.equals(lst));
        System.out.printf("%s, %s : %b%n", other.toString(), other.toString(), other.equals(other));

        lst.set(2, 3);
        System.out.printf("%s, %s : %b%n", other.toString(), lst.toString(), other.equals(lst));
    }
}
