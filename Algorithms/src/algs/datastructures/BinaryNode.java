package algs.datastructures;

import java.util.Objects;

/**
 * Implements a Node with two children or neighbors, of generic type, which contains a single value of that type.
 * The node is mutable in all parameters, but can only be instantiated through the static factory method
 * from(value, left ,right).
 *
 * Created by Robert Mitchell on 11/1/16.
 */
public class BinaryNode<T> {

    private T value;
    private BinaryNode<T> left;
    private BinaryNode<T> right;

    /**
     * Creates a new node with the specified value, and left and right children or neighbors.
     * Note that, because this is protected, it can only be invoked by classes in the same package or who extend it.
     * This is to encourage using the static factory methods instead.
     *
     * @param value The underlying value in the node.
     * @param left The left neighbor or child of this node.
     * @param right The right neighbor or child of this node.
     */
    protected BinaryNode(final T value, final BinaryNode<T> left, final BinaryNode<T> right) {
        this.value = Objects.requireNonNull(value);
        this.left = left;
        this.right = right;
    }

    /**
     * Returns the underlying value of this node.
     *
     * @return the underlying value of this node.
     */
    public T getValue() {
        return this.value;
    }

    /**
     * Sets the underlying value of this node.
     *
     * @param value the new underlying value of this node.
     */
    public void setValue(final T value) {
        this.value = value;
    }

    /**
     * Returns the left neighbor or child of this node.
     *
     * @return the left neighbor or child of this node.
     */
    public BinaryNode<T> getLeft() {
        return this.left;
    }

    /**
     * Sets the left neighbor or child of this node.
     *
     * @param left the new left neighbor or child of this node, which can be null.
     */
    public void setLeft(final BinaryNode<T> left) {
        this.left = left;
    }

    /**
     * Returns the right neighbor or child of this node.
     *
     * @return the right neighbor or child of this node.
     */
    public BinaryNode<T> getRight() {
        return this.right;
    }

    /**
     * Sets the right neighbor or child of this node.
     *
     * @param right the new right neighbor or child of this node, which can be null.
     */
    public void setRight(final BinaryNode<T> right) {
        this.right = right;
    }

    /**
     * Determines whether this node is equal to the given object, based on the underlying value.
     * Two nodes are equal iff they have the same underlying value. Their left and right nodes are not taken into
     * consideration.
     *
     * TODO: Check whether this forms an equivalence relation or not (symmetry, reflexivity, & transitivity)
     *
     * @param other The other object to test against for equality.
     * @return True if the other node has an equal underlying value to that of this one, false otherwise.
     */
    @Override
    public boolean equals(final Object other) {
        if (other == null || !(other instanceof BinaryNode)) {
            return false;
        }
        final BinaryNode<?> o = (BinaryNode) other;
        return this.value.equals(o.value);
    }

    /**
     * Determines the hashCode of this node based solely on the underlying value. The left and right referenced nodes
     * are not taken into consideration.
     *
     * @return the hashCode of this node, based on the value it contains.
     */
    @Override
    public int hashCode() {
        return 11 * 37 + Objects.hashCode(this.value);
    }

    /**
     * Returns a String representation of this Node, based solely on the underlying value. The left and right referenced
     * nodes are not taken into consideration.
     *
     * @return the toString of the underlying value.
     */
    @Override
    public String toString() {
        return value.toString();
    }

    /**
     * A static factory for creating BinaryNode objects which have both links.
     *
     * @param value The underlying value of the node.
     * @param left The left child or neighbor of the node.
     * @param right The right child or neighbor of the node.
     * @param <T> The generic type this node instance should have.
     * @return A BinaryNode of the specified type with the given value and left, right neighbors/children.
     */
    public static <T> BinaryNode<T> from(final T value, final BinaryNode<T> left, final BinaryNode<T> right) {
        return new BinaryNode<>(value, left, right);
    }

    /**
     * A static factory for creating BinaryNode objects which have a null right link.
     *
     * @param value The underlying value of the node.
     * @param left The left child or neighbor of the node.
     * @param <T> The generic type this node instance should have.
     * @return A BinaryNode of the specified type with the given value and left neighbor/child.
     */
    public static <T> BinaryNode<T> withLeft(final T value, final BinaryNode<T> left) {
        return new BinaryNode<>(value, left, null);
    }

    /**
     * A static factory for creating BinaryNode objects which have a null left link.
     *
     * @param value The underlying value of the node.
     * @param right The right child or neighbor of the node.
     * @param <T> The generic type this node instance should have.
     * @return A BinaryNode of the specified type with the given value and right neighbor/child.
     */
    public static <T> BinaryNode<T> withRight(final T value, final BinaryNode<T> right) {
        return new BinaryNode<>(value, null, right);
    }

    /**
     * A static factory for creating BinaryNode objects which have null links for left and right neighbors.
     *
     * @param value The underlying value of the node.
     * @param <T> The generic type this node instance should have.
     * @return A BinaryNode with the specified underlying value.
     */
    public static <T> BinaryNode<T> valueOf(final T value) {
        return new BinaryNode<>(value, null, null);
    }
}
