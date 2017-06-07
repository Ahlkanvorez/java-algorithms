package algs.datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Note: This class only tests the methods DoublyLinkedList inherits from List, since those from Queue and Stack are
 * respectively tested in QueueTest and StackTest.
 *
 * Created by robertmitchell on 6/7/17.
 */
class DoublyLinkedListTest {

    @Test
    void testSizeAfterConstructor() {
        final List<Object> lst = new DoublyLinkedList<>();
        assertEquals(0, lst.size());
    }

    @Test
    void testGetOutOfBounds() {
        final List<Object> lst = new DoublyLinkedList<>();
        boolean erred = false;
        try {
            lst.get(1);
        } catch (Exception e) {
            assertTrue(e instanceof IndexOutOfBoundsException);
            erred = true;
        } finally {
            assertTrue(erred);
            assertEquals(0, lst.size());
        }
    }

    @Test
    void testGetInBounds() {
        final List<String> lst = new DoublyLinkedList<>();
        lst.add("x");
        lst.add("y");
        assertEquals("x", lst.get(0));
        assertEquals("y", lst.get(1));
        assertEquals(2, lst.size());
    }

    @Test
    void testSetOutOfBounds() {
        final List<String> lst = new DoublyLinkedList<>();
        boolean erred = false;
        try {
            lst.set(1, "x");
        } catch (Exception e) {
            assertTrue(e instanceof IndexOutOfBoundsException);
            erred = true;
        } finally {
            assertTrue(erred);
            assertEquals(0, lst.size());
        }
    }

    @Test
    void testSetInBounds() {
        final List<String> lst = new DoublyLinkedList<>();
        lst.add("x");
        lst.add("y");
        lst.set(1, "a");
        lst.set(0, "b");
        assertEquals("b", lst.get(0));
        assertEquals("a", lst.get(1));
        assertEquals(2, lst.size());
    }

    @Test
    void testRemoveOutOfBounds() {
        final List<String> lst = new DoublyLinkedList<>();
        boolean erred = false;
        try {
            lst.remove(1);
        } catch (Exception e) {
            assertTrue(e instanceof IndexOutOfBoundsException);
            erred = true;
        } finally {
            assertTrue(erred);
            assertEquals(0, lst.size());
        }
    }

    @Test
    void testRemoveInBounds() {
        final List<String> lst = new DoublyLinkedList<>();
        lst.add("x");
        lst.add("y");
        assertEquals("y", lst.remove(1));
        assertEquals("x", lst.remove(0));
        assertEquals(0, lst.size());
    }

    @Test
    void testInsertOutOfBounds() {
        final List<String> lst = new DoublyLinkedList<>();
        boolean erred = false;
        try {
            lst.insert(1, "x");
        } catch (Exception e) {
            assertTrue(e instanceof IndexOutOfBoundsException);
            erred = true;
        } finally {
            assertTrue(erred);
            assertEquals(0, lst.size());
        }
    }

    @Test
    void testInsertAtZeroEmpty() {
        final List<String> lst = new DoublyLinkedList<>();
        boolean erred = false;
        try {
            lst.insert(0, "x");
        } catch (Exception e) {
            erred = true;
        } finally {
            assertFalse(erred);
            assertEquals("x", lst.get(0));
            assertEquals(1, lst.size());
        }
    }

    @Test
    void testInsertAtZeroNonEmpty() {
        final List<String> lst = new DoublyLinkedList<>();
        boolean erred = false;
        lst.add("y");
        try {
            lst.insert(0, "x");
        } catch (Exception e) {
            erred = true;
        } finally {
            assertFalse(erred);
            assertEquals("x", lst.get(0));
            assertEquals(2, lst.size());
        }
    }

    @Test
    void testInsertAtEnd() {
        final List<String> lst = new DoublyLinkedList<>();
        boolean erred = false;
        lst.add("y");
        try {
            lst.insert(lst.size(), "x");
        } catch (Exception e) {
            assertTrue(e instanceof IndexOutOfBoundsException);
            erred = true;
        } finally {
            assertFalse(erred);
            assertEquals("x", lst.get(lst.size() - 1));
            assertEquals(2, lst.size());
        }
    }

    @Test
    void testEqualsSmallerSize() {
        final List<String> a = new DoublyLinkedList<>();
        final List<String> b = new DoublyLinkedList<>();
        a.add("x");
        a.add("y");
        b.add("x");
        assertNotEquals(a, b);
        assertNotEquals(a.hashCode(), b.hashCode());
        assertNotEquals(a.toString(), b.toString());
    }

    @Test
    void testEqualsLargerSize() {
        final List<String> a = new DoublyLinkedList<>();
        final List<String> b = new DoublyLinkedList<>();
        a.add("x");
        b.add("x");
        b.add("y");
        assertNotEquals(a, b);
        assertNotEquals(a.hashCode(), b.hashCode());
        assertNotEquals(a.toString(), b.toString());
    }

    @Test
    void testEqualsSameSizeDifferentElements() {
        final List<String> a = new DoublyLinkedList<>();
        final List<String> b = new DoublyLinkedList<>();
        a.add("x");
        a.add("z");
        b.add("x");
        b.add("y");
        assertNotEquals(a, b);
        assertNotEquals(a.hashCode(), b.hashCode());
        assertNotEquals(a.toString(), b.toString());
    }

    @Test
    void testEqualsSameSizeSameElements() {
        final List<String> a = new DoublyLinkedList<>();
        final List<String> b = new DoublyLinkedList<>();
        a.add("x");
        a.add("y");
        b.add("x");
        b.add("y");
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
        assertEquals(a.toString(), b.toString());
    }
}