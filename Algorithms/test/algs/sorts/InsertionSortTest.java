package algs.sorts;

import org.junit.jupiter.api.Test;
import algs.sorts.Utilities;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by robertmitchell on 6/3/17.
 */
class InsertionSortTest {
    final int N = 500;
    final Integer[] data = new Integer[N];
    final InsertionSort<Integer> sort = new InsertionSort<>();

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
}