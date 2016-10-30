package algs.sorts;

import java.util.Arrays;


/**
 * Implements the Merge Sort algorithm for an array of type T, where T implements the method .compareTo(T)
 *
 * Theoretically, the Merge Sort algorithm is a stable algorithm.
 *
 * The Merge Sort algorithm has the following performance characteristics, as have been validated for this
 * implementation by empirical tests:
 *
 * - Worst case number of comparisons: O(N lg N)
 * - Average case number of comparisons: O(N lg N)
 * - Best case number of comparisons: O(N lg N)
 *
 * - Guaranteed extra space usage: O(N) for the auxiliary array.
 *
 * @author Robert Mitchell <robert.mitchell36@gmail.com>
 */
public class MergeSort<T extends Comparable<T>> implements Sort<T> {
    private static final int SORT_THRESHOLD = 11; /* A few brief trials found this to be a good threshold choice. */
    private final Sort<T> INSERTION_SORT;

    /**
     * Initializes the INSERTION_SORT used for sub-arrays of length 11 or less, for better performance.
     */
    public MergeSort() {
        this.INSERTION_SORT = new InsertionSort<>();
    }

    /**
     * Merges the two sorted segments [low, mid - 1], [mid, high] from the aux array into the data array.
     * 
     * @param data The array in which the merge should be placed.
     * @param aux The auxiliary array containing the sorted segments to merge.
     * @param low The first index, inclusive, to be merged.
     * @param mid The middle index to be merged, and the first index of the second sorted segment.
     * @param high The last index, inclusive, to be merged.
     */
    private void merge(final T[] data, final T[] aux,
            final int low, final int mid, final int high) {
        /* This library is faster than a manual copy via a for-loop. */
        System.arraycopy(data, low, aux, low, high - low + 1);

         /* Combine the two sub-arrays in sorted order */
        for (int i = low, j = mid + 1, k = low; k <= high; ++k) {
            if (i > mid) {
                data[k] = aux[j++];
            } else if (j > high) {
                data[k] = aux[i++];
            } else if (aux[j].compareTo(aux[i]) < 0) {
                data[k] = aux[j++]; /* Prioritize left block to maintain stability */
            } else {
                data[k] = aux[i++];
            }
        }
    }

    /**
     * Sorts, using the Merge Sort algorithm, the given array, data, on the inclusive interval [low, high]. This
     * implementation uses an Insertion Sort for sub-arrays of length 11 or less.
     * Note, that this method assumes low < high.
     *
     * @param data The array to be sorted.
     * @param aux The auxiliary array to use for storing sorted segments prior to merges.
     * @param low The first index, inclusive, to be sorted.
     * @param high The last index, inclusive, to be sorted.
     */
    private void sort(final T[] data, final T[] aux,
            final int low, final int high) {
        /* SORT_THRESHOLD = 11.
          If the segment is below the threshold in length, sort using insertion sort. */
        if (high <= low + SORT_THRESHOLD) {
            INSERTION_SORT.sort(data, low, high);
            return;
        }

        /* Otherwise, sort each half, then merge them. */
        final int mid = low + (high - low) / 2;
        sort(data, aux, low, mid);
        sort(data, aux, mid + 1, high);
        merge(data, aux, low, mid, high);
    }

    /**
     * Sorts, using the Merge Sort algorithm, the given array, data, on the inclusive interval [low, high].
     * Note, that this method assumes low < high. This implementation uses an Insertion Sort for sub-arrays of length
     * 11 or less.
     *
     * @param data The array to be sorted
     * @param low The first index, inclusive, to be sorted
     * @param high The last index, inclusive, to be sorted
     */
    @Override
    public void sort(final T[] data, final int low, final int high) {
        final T[] aux = Arrays.copyOf(data, high + 1);
        sort(data, aux, low, high);
    }

    /**
     * Sorts the entire array using the Merge Sort algorithm. This implementation uses an Insertion Sort for sub-arrays
     * of length 11 or less.
     *
     * @param data The array to be sorted.
     */
    @Override
    public void sort(final T[] data) {
        sort(data, 0, data.length - 1);
    }

    public static void main(final String[] args) {
        System.out.println("Testing Merge Sort:");
        Utilities.doublingTest(new MergeSort<Integer>(), (int) Math.pow(2, 13), (int) Math.pow(2, 25));
    }
}
