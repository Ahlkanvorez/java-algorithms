package algs.sorts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by robertmitchell on 6/3/17.
 */
public abstract class SortTest {
    final int N = 500;
    final int INTERVAL_LOW = 13;
    final int INTERVAL_HIGH = 27;
    final Integer[] data = new Integer[N];
    Sort<Integer> sort;

    @Test
    void sortSortedDataTest() {
        for (int i = 0; i < data.length; ++i) {
            data[i] = i;
        }
        sort.sort(data);
        assertTrue(Utilities.isSorted(data));
    }

    @Test
    void sortReverseSortedDataTest() {
        for (int i = 0; i < data.length; ++i) {
            data[i] = data.length - i;
        }
        sort.sort(data);
        assertTrue(Utilities.isSorted(data));
    }

    @Test
    void sortRandomDataTest() {
        for (int i = 0; i < data.length; ++i) {
            data[i] = i;
        }
        boolean sortsProperly = true;
        for (int i = 0; i < 1000; ++i) {
            Utilities.shuffle(data);
            sort.sort(data);
            sortsProperly &= Utilities.isSorted(data);
        }
        assertTrue(sortsProperly);
    }

    @Test
    void sortEmptyDataTest() {
        Integer[] data = new Integer[0];
        boolean threwException = false;
        try {
            sort.sort(data);
        } catch (Exception e) {
            threwException = true;
        } finally {
            assertFalse(threwException);
        }
    }
    @Test
    void sortSortedIntervalTest() {
        for (int i = 0; i < data.length; ++i) {
            data[i] = i;
        }
        sort.sort(data, INTERVAL_LOW, INTERVAL_HIGH);
        assertTrue(Utilities.isSorted(data, INTERVAL_LOW, INTERVAL_HIGH));
    }

    @Test
    void sortReverseSortedIntervalTest() {
        for (int i = 0; i < data.length; ++i) {
            data[i] = data.length - i;
        }
        sort.sort(data, INTERVAL_LOW, INTERVAL_HIGH);
        assertTrue(Utilities.isSorted(data, INTERVAL_LOW, INTERVAL_HIGH));
    }

    @Test
    void sortRandomIntervalTest() {
        for (int i = 0; i < data.length; ++i) {
            data[i] = i;
        }
        boolean sortsProperly = true;
        for (int i = 0; i < 1000; ++i) {
            Utilities.shuffle(data);
            sort.sort(data, INTERVAL_LOW, INTERVAL_HIGH);
            sortsProperly &= Utilities.isSorted(data, INTERVAL_LOW, INTERVAL_HIGH);
        }
        assertTrue(sortsProperly);
    }

    @Test
    void sortEmptyIntervalTest() {
        boolean threwException = false;
        try {
            sort.sort(data, INTERVAL_LOW, INTERVAL_LOW);
        } catch (Exception e) {
            System.err.println(e);
            threwException = true;
        } finally {
            assertFalse(threwException);
        }
    }
}
