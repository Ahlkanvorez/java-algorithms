package algs.sorts;

import static algs.sorts.Utilities.swap;

/**
 *
 * @author robertmitchell
 */
public class SelectionSort<T extends Comparable<T>> implements Sort<T> {

    /**
     * 
     * @param data
     * @param low
     * @param high 
     */
    @Override
    public void sort(T[] data, int low, int high) {
        /* Loop through all of the data; all items in data before i are sorted,
            and after i are unsorted. */
        for (int i = low; i < high; ++i) {
            int min = i; // The first unsorted item is at i.
            // Search the remaining unsorted data
            for (int j = i; j < high; ++j) {
                // If we find a smaller item than that at min, update min.
                if (data[j].compareTo(data[min]) < 0) {
                    min = j;
                }
            }
            swap(data, min, i); // Place the minimal datum in it's proper position.
        }
    }

    /**
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
