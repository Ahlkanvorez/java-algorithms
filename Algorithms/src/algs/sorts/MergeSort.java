package algs.sorts;

import java.util.Arrays;

/**
 *
 * @author robertmitchell
 */
public class MergeSort implements Sort {
    private static final int SORT_THRESHOLD = 11;
    private static final Sort INSERTION_SORT = new InsertionSort();
    
    /**
     * 
     * @param data
     * @param aux
     * @param low
     * @param mid
     * @param high 
     */
    private void merge(final Comparable[] data, final Comparable[] aux,
            final int low, final int mid, final int high) {
        // This library is faster than a manual copy via a for-loop.
        System.arraycopy(data, low, aux, low, high - low + 1);

         /* Combine the two subarrays in sorted order */
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
     * 
     * @param data
     * @param aux
     * @param low
     * @param high 
     */
    private void sort(final Comparable[] data, final Comparable[] aux,
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
     * 
     * @param data
     * @param low
     * @param high 
     */
    @Override
    public void sort(Comparable[] data, int low, int high) {
        Comparable[] aux = Arrays.copyOf(data, high + 1);
        sort(data, aux, low, high);
    }

    /**
     * 
     * @param data 
     */
    @Override
    public void sort(final Comparable[] data) {
        sort(data, 0, data.length - 1);
    }

    public static void main(final String[] args) {
        System.out.println("Testing Merge Sort:");
        Utilities.doublingTest(new MergeSort(), (int) Math.pow(2, 13), (int) Math.pow(2, 25));
    }
}
