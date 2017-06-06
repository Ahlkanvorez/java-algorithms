package algs.datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by robertmitchell on 6/6/17.
 */
class BinaryNodeTest {
    final BinaryNode<String> left = BinaryNode.valueOf("left");
    final BinaryNode<String> right = BinaryNode.valueOf("right");

    @Test
    void testConstructorNullValue() {
        boolean erred = false;
        try {
            new BinaryNode<>(null, null, null);
        } catch (Exception e) {
            assertTrue(e instanceof NullPointerException);
            erred = true;
        } finally {
            assertTrue(erred);
        }
    }

    @Test
    void testConstructorNonNullValue() {
        boolean erred = false;
        try {
            new BinaryNode<>("x", null, null);
        } catch (Exception e) {
            erred = true;
        } finally {
            assertFalse(erred);
        }
    }

    @Test
    void testConstructorAssignment() {
        final String value = "value";
        final BinaryNode<String> node = new BinaryNode<>(value, left, right);
        assertEquals(node.getLeft(), left);
        assertEquals(node.getRight(), right);
        assertEquals(value, node.getValue());
    }

    @Test
    void testStaticFactoryOnlyValue() {
        final String value = "x";
        final BinaryNode<String> node = BinaryNode.valueOf(value);
        assertNull(node.getLeft());
        assertNull(node.getRight());
        assertEquals(node.getValue(), value);
    }

    @Test
    void testStaticFactoryWithRight() {
        final String value = "x";
        final BinaryNode<String> node = BinaryNode.withRight(value, right);
        assertEquals(node.getRight(), right);
        assertNull(node.getLeft());
        assertEquals(node.getValue(), value);
    }

    @Test
    void testStaticFactoryWithLeft() {
        final String value = "x";
        final BinaryNode<String> node = BinaryNode.withLeft(value, left);
        assertEquals(node.getLeft(), left);
        assertNull(node.getRight());
        assertEquals(node.getValue(), value);
    }

    @Test
    void testStaticFactoryWithLeftAndRight() {
        final String value = "value";
        final BinaryNode<String> node = BinaryNode.from(value, left, right);
        assertEquals(node.getLeft(), left);
        assertEquals(node.getRight(), right);
        assertEquals(value, node.getValue());
    }

    @Test
    void testSetLeft() {
        final BinaryNode<String> node = BinaryNode.withLeft("value", left);
        assertEquals(node.getLeft(), left);
        final BinaryNode<String> newLeft = BinaryNode.valueOf("newLeft");
        node.setLeft(newLeft);
        assertEquals(node.getLeft(), newLeft);
    }

    @Test
    void testSetRight() {
        final BinaryNode<String> node = BinaryNode.withRight("value", right);
        assertEquals(node.getRight(), right);
        final BinaryNode<String> newRight = BinaryNode.valueOf("newRight");
        node.setRight(newRight);
        assertEquals(node.getRight(), newRight);
    }

    @Test
    void testEqualsHashCodeAndToStringWithDifferentValueAndNullLeftAndNullRight() {
        final BinaryNode<String> x = BinaryNode.valueOf("x");
        final BinaryNode<String> y = BinaryNode.valueOf("y");
        assertNotEquals(x, y);
        assertNotEquals(x.hashCode(), y.hashCode());
        assertNotEquals(x.toString(), y.toString());
    }

    @Test
    void testEqualsHashCodeAndToStringWithSameValueAndNullLeftAndNullRight() {
        final BinaryNode<String> x1 = BinaryNode.valueOf("x");
        final BinaryNode<String> x2 = BinaryNode.valueOf("x");
        assertEquals(x1, x2);
        assertEquals(x1.hashCode(), x2.hashCode());
        assertEquals(x1.toString(), x2.toString());
    }

    @Test
    void testEqualsHashCodeAndToStringWithSameValueAndDifferentLeft() {
        final BinaryNode<String> x1 = BinaryNode.withLeft("x", left);
        final BinaryNode<String> x2 = BinaryNode.withLeft("x", right);
        assertEquals(x1, x2);
        assertEquals(x1.hashCode(), x2.hashCode());
        assertEquals(x1.toString(), x2.toString());
    }

    @Test
    void testEqualsHashCodeAndToStringWithSameValueAndDifferentRight() {
        final BinaryNode<String> x1 = BinaryNode.withRight("x", left);
        final BinaryNode<String> x2 = BinaryNode.withRight("x", right);
        assertEquals(x1, x2);
        assertEquals(x1.hashCode(), x2.hashCode());
        assertEquals(x1.toString(), x2.toString());
    }
}