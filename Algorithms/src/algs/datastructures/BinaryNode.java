package algs.datastructures;

import java.util.Objects;

/**
 * Created by Robert Mitchell on 11/1/16.
 */
public class BinaryNode<T> {
    private T value;
    private BinaryNode<T> left;
    private BinaryNode<T> right;

    private BinaryNode(final T value, final BinaryNode<T> left, final BinaryNode<T> right) {
        this.value = Objects.requireNonNull(value);
        this.left = left;
        this.right = right;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(final T value) {
        this.value = value;
    }

    public BinaryNode<T> getLeft() {
        return this.left;
    }

    public void setLeft(final BinaryNode<T> left) {
        this.left = left;
    }

    public BinaryNode<T> getRight() {
        return this.right;
    }

    public void setRight(final BinaryNode<T> right) {
        this.right = right;
    }

    @Override
    public boolean equals(final Object other) {
        if (other == null || !(other instanceof BinaryNode)) {
            return false;
        }
        final BinaryNode<?> o = (BinaryNode) other;
        return this.value.equals(o.value);
    }

    @Override
    public int hashCode() {
        int hash = 11;
        hash = 37 * hash + Objects.hashCode(this.value);
        return hash;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public static <T> BinaryNode<T> from(final T value, final BinaryNode<T> left, final BinaryNode<T> right) {
        return new BinaryNode<>(value, left, right);
    }
}
