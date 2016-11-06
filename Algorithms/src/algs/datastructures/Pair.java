package algs.datastructures;

/**
 * Created by robertmitchell on 11/5/16.
 */
public class Pair<A, B> {

    private final A a;
    private final B b;

    public Pair(final A a, final B b) {
        this.a = a;
        this.b = b;
    }

    public A getA() {
        return this.a;
    }

    public B getB() {
        return this.b;
    }

    @Override
    public int hashCode() {
        int hash = 37;
        hash = 11 * hash + a.hashCode();
        hash = 11 * hash + b.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Pair)) {
            return false;
        }
        return other == this || (this.a.equals(((Pair) other).a) && this.b.equals(((Pair) other).b));
    }

    @Override
    public String toString() {
        return "( " + a.toString() + ", " + b.toString() + " )";
    }
}
