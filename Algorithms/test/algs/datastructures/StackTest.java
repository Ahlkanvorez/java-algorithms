package algs.datastructures;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by robertmitchell on 6/5/17.
 */
class StackTest {
    static Stack<Integer> stack;

    @BeforeAll
    static void init() {
        stack = Stack.newInstance();
    }

    @Test
    void testNewInstanceNotNull() {
        assertNotNull(stack);
    }

    @Test
    void testNewInstanceEmptySize() {
        assertEquals(0, stack.size());
    }

    @Test
    void testNewInstanceIsDoublyLinkedList() {
        assertTrue(stack instanceof DoublyLinkedList);
    }

    @Test
    void testPushOntoEmptyStack() {
        boolean erred = false;
        try {
            stack.push(5);
        } catch (final Exception e) {
            erred = true;
        } finally {
            assertFalse(erred);
            assert stack.size() == 1;
        }
    }

    @Test
    void testPushOntoNonEmptyStack() {
        if (stack.size() == 0) {
            stack.push(0);
        }
        boolean erred = false;
        try {
            stack.push(1);
        } catch (final Exception e) {
            erred = true;
        } finally {
            assertFalse(erred);
            assert stack.size() == 2;
        }
    }

    @Test
    void testPopFromNonemptyStack() {
        stack = Stack.newInstance();
        stack.push(0);
        stack.push(1);
        boolean erred = false;
        Integer val = null;
        try {
            val = stack.pop();
        } catch (final Exception e) {
            erred = true;
        } finally {
            assertFalse(erred);
            assertNotNull(val);
            assert val == 1;
        }
    }

    @Test
    void testPopFromEmptyStack() {
        stack = Stack.newInstance();
        boolean erred = false;
        Integer val = null;
        try {
            val = stack.pop();
        } catch (Exception e) {
            erred = true;
            assertTrue(e instanceof IndexOutOfBoundsException);
        } finally {
            assertTrue(erred);
            assertNull(val);
        }
    }

    @Test
    void testSizeOfEmptyStack() {
        stack = Stack.newInstance();
        assertEquals(0, stack.size());
    }

    @Test
    void testSizeOfNonEmptyStack() {
        stack = Stack.newInstance();
        stack.push(0);
        stack.push(1);
        assertEquals(2, stack.size());
    }

    @Test
    void testSizeOfStackAfterPop() {
        stack = Stack.newInstance();
        stack.push(0);
        stack.push(1);
        stack.pop();
        assertEquals(1, stack.size());
    }
}