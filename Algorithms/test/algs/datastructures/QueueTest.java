package algs.datastructures;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by robertmitchell on 6/5/17.
 */
class QueueTest {
    static Queue<Integer> queue;

    @BeforeAll
    static void init() {
        queue = Queue.newInstance();
    }

    @Test
    void testNewInstanceNotNull() {
        assertNotNull(queue);
    }

    @Test
    void testNewInstanceEmptySize() {
        assertEquals(0, queue.size());
    }

    @Test
    void testNewInstanceIsDoublyLinkedList() {
        assertTrue(queue instanceof DoublyLinkedList);
    }

    @Test
    void testEnqueueOntoEmptyQueue() {
        boolean erred = false;
        try {
            queue.enqueue(5);
        } catch (final Exception e) {
            erred = true;
        } finally {
            assertFalse(erred);
            assert queue.size() == 1;
        }
    }

    @Test
    void testEnqueueOntoNonEmptyQueue() {
        if (queue.size() == 0) {
            queue.enqueue(0);
        }
        boolean erred = false;
        try {
            queue.enqueue(1);
        } catch (final Exception e) {
            erred = true;
        } finally {
            assertFalse(erred);
            assert queue.size() == 2;
        }
    }

    @Test
    void testDequeueFromNonemptyQueue() {
        queue = Queue.newInstance();
        queue.enqueue(0);
        boolean erred = false;
        Integer val = null;
        try {
            val = queue.dequeue();
        } catch (final Exception e) {
            erred = true;
        } finally {
            assertFalse(erred);
            assertNotNull(val);
            assert val == 0;
        }
    }

    @Test
    void testDequeueFromEmptyQueue() {
        queue = Queue.newInstance();
        boolean erred = false;
        Integer val = null;
        try {
            val = queue.dequeue();
        } catch (Exception e) {
            erred = true;
            assertTrue(e instanceof IndexOutOfBoundsException);
        } finally {
            assertTrue(erred);
            assertNull(val);
        }
    }

    @Test
    void testSizeOfEmptyQueue() {
        queue = Queue.newInstance();
        assertEquals(0, queue.size());
    }

    @Test
    void testSizeOfNonEmptyQueue() {
        queue = Queue.newInstance();
        queue.enqueue(0);
        queue.enqueue(1);
        assertEquals(2, queue.size());
    }

    @Test
    void testSizeOfQueueAfterDequeue() {
        queue = Queue.newInstance();
        queue.enqueue(0);
        queue.enqueue(1);
        queue.dequeue();
        assertEquals(1, queue.size());
    }
}