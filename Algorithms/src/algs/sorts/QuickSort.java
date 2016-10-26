package algs.sorts;


import static algs.sorts.Utilities.shuffle;
import static algs.sorts.Utilities.swap;
import static java.lang.Math.pow;

/**
 *
 * @author robertmitchell
 */
public class QuickSort implements Sort {
    private static final int SORT_CUTOFF = 11;
    private static final InsertionSort INSERTION_SORT = new InsertionSort();

    /**
     * 
     * @param data
     * @param low
     * @param high
     * @return 
     */
    @SuppressWarnings("empty-statement")
    private int partition(final Comparable[] data, final int low, final int high) {
        final Comparable pivot = data[low]; // Make the first index the pivot value
        int i = low - 1;  // Set the left scan-index
        int j = high + 1; // Set the right scan-index
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
     * 
     * @param data
     * @param low
     * @param high 
     */
    private void quickSort(final Comparable[] data, final int low, final int high) {
        /* If the segment size is less than the cutoff (here 11), sort the
            subarray with Insertion Sort, which performs better on arrays of
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
     * 
     * @param data 
     */
    @Override
    public void sort(final Comparable[] data) {
        shuffle(data); // Reduces probability of worst-case performance.
        quickSort(data, 0, data.length - 1);
    }

    /**
     * 
     * @param data
     * @param low
     * @param high 
     */
    @Override
    public void sort(final Comparable[] data, final int low, final int high) {
        quickSort(data, low, high);
    }
    
    public static void main (final String[] args) {
        System.out.println("Testing Quick Sort:");
        Utilities.doublingTest(new QuickSort(), (int) pow(2, 13), (int) pow(2, 25));
    }
}
