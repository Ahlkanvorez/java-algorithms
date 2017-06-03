package algs.sorts;

/**
 * Implements the Insertion Sort algorithm for an array of type T, where T implements the method .compareTo(T)
 *
 * Theoretically, the Insertion Sort algorithm is an on-line, in-place, stable algorithm.
 *
 * The Insertion Sort algorithm has the following performance characteristics, as have been validated for this
 * implementation by empirical tests:
 *
 * - Worst case number of comparisons: O(N^2)
 * - Average case number of comparisons: O(N^2)
 * - Best case number of comparisons: O(N)
 *
 * - Guaranteed extra space usage: O(1).
 *
 * @author Robert Mitchell <robert.mitchell36@gmail.com>
 */
public class InsertionSort<T extends Comparable<T>> implements Sort<T> {
    /**
     * Sorts, using the Insertion Sort algorithm, the given array, data, on the inclusive interval [low, high].
     * Note, that this method assumes low < high.
     *
     * @param data The array to be sorted
     * @param low The first index, inclusive, to be sorted
     * @param high The last index, inclusive, to be sorted
     */
    @Override
    public void sort(final T[] data, final int low, final int high) {
        /* Iterate through every element of data, allowing
            elements to "fall" to their proper position.*/
        for (int i = low + 1; i < high + 1; ++i) {
            final T datum = data[i]; // Record the current element
            int j = i - 1;
            /* As long as the element is greater than its predecessor,
                shift the predecessors right one index. */
            for (; j >= low && datum.compareTo(data[j]) < 0; --j) {
                data[j + 1] = data[j];
            } /* Place the current element in it's proper position. */
            data[j + 1] = datum;
        }
    }
    
    /**
     * Sorts the entire given array using the Insertion Sort algorithm.
     *
     * @param data The array to sort.
     */
    @Override
    public void sort(final T[] data) {
        sort(data, 0, data.length - 1);
    }

    public static void main(final String[] args) {
        System.out.println("Testing Insertion Sort:");
        Utilities.doublingTest(new InsertionSort<Integer>(),
                (int) Math.pow(2, 13),
                (int) Math.pow(2, 18));
    }
}
