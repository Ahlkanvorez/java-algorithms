package algs.datastructures;

import java.util.Objects;

/**
 * Created by Robert Mitchell on 11/1/16.
 */
public class BinaryNode<T> {

    /**  */
    private T value;

    /**  */
    private BinaryNode<T> left;

    /**  */
    private BinaryNode<T> right;

    /**
     *
     * @param value
     * @param left
     * @param right
     */
    private BinaryNode(final T value, final BinaryNode<T> left, final BinaryNode<T> right) {
        this.value = Objects.requireNonNull(value);
        this.left = left;
        this.right = right;
    }

    /**
     *
     * @return
     */
    public T getValue() {
        return this.value;
    }

    /**
     *
     * @param value
     */
    public void setValue(final T value) {
        this.value = value;
    }

    /**
     *
     * @return
     */
    public BinaryNode<T> getLeft() {
        return this.left;
    }

    /**
     *
     * @param left
     */
    public void setLeft(final BinaryNode<T> left) {
        this.left = left;
    }

    /**
     *
     * @return
     */
    public BinaryNode<T> getRight() {
        return this.right;
    }

    /**
     *
     * @param right
     */
    public void setRight(final BinaryNode<T> right) {
        this.right = right;
    }

    /**
     *
     * @param other
     * @return
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
     *
     * @return
     */
    @Override
    public int hashCode() {
        return 11 * 37 + Objects.hashCode(this.value);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return value.toString();
    }

    /**
     *
     * @param value
     * @param left
     * @param right
     * @param <T>
     * @return
     */
    public static <T> BinaryNode<T> from(final T value, final BinaryNode<T> left, final BinaryNode<T> right) {
        return new BinaryNode<>(value, left, right);
    }
}
