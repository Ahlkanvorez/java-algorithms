package algs.sorts;

import static algs.sorts.Utilities.swap;

/**
 * Implements the Selection Sort algorithm for an array of type T, where T implements the method .compareTo(T)
 *
 * Theoretically, the Selection Sort algorithm is an in-place, stable algorithm.
 *
 * The Selection Sort algorithm has the following performance characteristics, as have been validated for this
 * implementation by empirical tests:
 *
 * - Worst case number of comparisons: O(N^2)
 * - Average case number of comparisons: O(N^2)
 * - Best case number of comparisons: O(N^2)
 *
 * - Guaranteed extra space usage: O(1).
 *
 * @author Robert Mitchell <robert.mitchell36@gmail.com>
 */
public class SelectionSort<T extends Comparable<T>> implements Sort<T> {


    /**
     * Sorts, using the Selection Sort algorithm, the given array, data, on the inclusive interval [low, high].
     * Note, that this method assumes low < high.
     *
     * @param data The array to be sorted
     * @param low The first index, inclusive, to be sorted
     * @param high The last index, inclusive, to be sorted
     */
    @Override
    public void sort(final T[] data, final int low, final int high) {
        /* Loop through all of the data; all items in data before i are sorted,
            and after i are unsorted. */
        for (int i = low; i < high; ++i) {
            int min = i; // The first unsorted item is at i.
            /* Search the remaining unsorted data */
            for (int j = i; j < high; ++j) {
                /* If we find a smaller item than that at min, update min. */
                if (data[j].compareTo(data[min]) < 0) {
                    min = j;
                }
            }
            swap(data, min, i); /* Place the minimal datum in it's proper position. */
        }
    }

    /**
     * Sorts the entire given array using the Selection Sort algorithm.
     *
     * @param data The array to sort.
     */
    @Override
    public void sort(final T[] data) {
        sort(data, 0, data.length);
    }
    
    public static void main(final String[] args) {
        System.out.println("Testing Selection Sort:");
        Utilities.doublingTest(new SelectionSort<Integer>(),
                (int) Math.pow(2, 13),
                (int) Math.pow(2, 18));
    }
}
