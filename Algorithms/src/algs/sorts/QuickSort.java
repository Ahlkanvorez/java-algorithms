package algs.sorts;


import static algs.sorts.Utilities.shuffle;
import static algs.sorts.Utilities.swap;
import static java.lang.Math.pow;

/**
 * Implements the Quick Sort algorithm for an array of type T, where T implements the method .compareTo(T)
 *
 * Theoretically, the Quick Sort algorithm is an in-place algorithm.
 *
 * The Quick Sort algorithm has the following performance characteristics, as have been validated for this
 * implementation by empirical tests:
 *
 * - Worst case number of comparisons: O(N^2)
 * - Average case number of comparisons: O(N lg N)
 * - Best case number of comparisons: O(N lg N)
 *
 * - Guaranteed extra space usage: O(lg N) for the call-stack made by the recursive tree.
 *
 * @author Robert Mitchell <robert.mitchell36@gmail.com>
 */
public class QuickSort<T extends Comparable<T>> implements Sort<T> {
    private static final int SORT_CUTOFF = 11;
    private final Sort<T> INSERTION_SORT;

    public QuickSort() {
        this.INSERTION_SORT = new InsertionSort<>();
    }

    /**
     * Partitions the specified segment [low, high] of data such that there exists an element pivot at data[p] so that
     *   for every low <= k, j <= high  data[k < p] <= data[p] = pivot <= data[j > p]
     *
     * @param data the data from which to partition the specified segment.
     * @param low the first index to consider in partitioning this segment; the element at this index will become the
     *            pivot element.
     * @param high the last index to consider in partitioning this segment.
     * @return the index of the pivot, from which every element to the left is less than or equal to it, and every
     *          element to the right is greater than or equal to it.
     */
    @SuppressWarnings("empty-statement")
    private int partition(final T[] data, final int low, final int high) {
        final T pivot = data[low]; /* Make the first index the pivot value */
        int i = low - 1;  /* Set the left scan-index */
        int j = high + 1; /* Set the right scan-index */
        while (true) {
            /* Find the highest index on the left whose element
                is less than the pivot. */
            while (data[++i].compareTo(pivot) < 0);
            /* Find the lowest index on the right whose element
                is greater than the pivot. */
            while (data[--j].compareTo(pivot) > 0);
            /* If the pointers crossed, then we've finished partitioning. */
            if (i >= j) { 
                return j;
            }
            /* Exchange the element on the left which is greater than the pivot
                with the element on the right which is less than the pivot */
            swap(data, i, j);
        }
    }

    /**
     * Sorts, using the Quick Sort algorithm, the given array, data, on the inclusive interval [low, high]. This
     * implementation uses an Insertion Sort for sub-arrays of length 11 or less.
     * Note, that this method assumes low < high.
     *
     * @param data The array to be sorted
     * @param low The first index, inclusive, to be sorted
     * @param high The last index, inclusive, to be sorted
     */
    private void quickSort(final T[] data, final int low, final int high) {
        /* If the segment size is less than the cutoff (here 11), sort the
            sub-array with Insertion Sort, which performs better on arrays of
            that size. */
        if (high <= low + SORT_CUTOFF) {
            INSERTION_SORT.sort(data, low, high);
            return;
        }
        
        /* Partition the segment into a segment <= to data[p],
            and a segment >= data[p], then sort each segment recursively. */
        final int p = partition(data, low, high);
        quickSort(data, low, p);
        quickSort(data, p + 1, high);
    }
    
    /**
     * Sorts the entire array using the Quick Sort algorithm, after first shuffling the array in O(N) time to reduce
     * the probability of worst-case O(N^2) performance. This implementation uses an Insertion Sort for sub-arrays of
     * length 11 or less.
     *
     * @param data The array to be sorted.
     */
    @Override
    public void sort(final T[] data) {
        shuffle(data); // Reduces probability of worst-case performance.
        quickSort(data, 0, data.length - 1);
    }

    /**
     * Sorts, using the Quick Sort algorithm, the given array, data, on the inclusive interval [low, high].
     * Note, that this method assumes low < high. This implementation uses an Insertion Sort for sub-arrays of length
     * 11 or less.
     *
     * @param data The array to be sorted
     * @param low The first index, inclusive, to be sorted
     * @param high The last index, inclusive, to be sorted
     */
    @Override
    public void sort(final T[] data, final int low, final int high) {
        quickSort(data, low, high);
    }
    
    public static void main (final String[] args) {
        System.out.println("Testing Quick Sort:");
        Utilities.doublingTest(new QuickSort<Integer>(), (int) pow(2, 13), (int) pow(2, 25));
    }
}
