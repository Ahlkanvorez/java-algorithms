package algs.datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by robertmitchell on 6/5/17.
 */
class PairTest {
    @Test
    void testConstructorNullParameters() {
        final Pair<Integer, Integer> p = new Pair<>(null, null);
        assertNotNull(p);
    }

    @Test
    void testConstructorParameterAssignments() {
        final Pair<Integer, String> p = new Pair<>(5, "x");
        assertEquals(5, (int) p.getA());
        assertEquals("x", p.getB());
    }

    @Test
    void testToString() {
        final Pair<Integer, String> p = new Pair<>(5, "x");
        assertEquals("( 5, x )", p.toString());
    }

    @Test
    void testEqualsAndHashcodeEqualPairs() {
        final Pair<Integer, String> p1 = new Pair<>(5, "x");
        final Pair<Integer, String> p2 = new Pair<>(5, "x");
        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void testEqualsAndHashcodeDifferentFirstParam() {
        final Pair<Integer, String> p1 = new Pair<>(5, "x");
        final Pair<Integer, String> p2 = new Pair<>(4, "x");
        assertNotEquals(p1, p2);
        assertNotEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void testEqualsAndHashcodeDifferentSecondParam() {
        final Pair<Integer, String> p1 = new Pair<>(5, "x");
        final Pair<Integer, String> p2 = new Pair<>(5, "y");
        assertNotEquals(p1, p2);
        assertNotEquals(p1.hashCode(), p2.hashCode());
    }
}