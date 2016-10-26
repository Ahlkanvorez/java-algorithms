package algs.sorts;

/**
 *
 * @author robertmitchell
 */
public class InsertionSort implements Sort {

    /**
     *
     * @param data the data to sort
     * @param low the index indicating the beginning of the segment to sort
     * @param high the index indicating the end of the segment to sort
     */
    @Override
    public void sort(final Comparable[] data, final int low, final int high) {
        /* Iterate through every element of data, allowing
            elements to "fall" to their proper position.*/
        for (int i = low + 1; i < high + 1; ++i) {
            final Comparable datum = data[i]; // Record the current element
            int j = i - 1;
            /* As long as the element is greater than its predecessor,
                shift the predecessors right one index. */
            for (; j >= low && datum.compareTo(data[j]) < 0; --j) {
                data[j + 1] = data[j];
            } // Place the current element in it's proper position.
            data[j + 1] = datum;
        }
    }
    
    /**
     *
     * @param data The array to sort.
     */
    @Override
    public void sort(final Comparable[] data) {
        sort(data, 0, data.length - 1);
    }
    
    public static void main(final String[] args) {
        System.out.println("Testing Insertion Sort:");
        Utilities.doublingTest(new InsertionSort(),
                (int) Math.pow(2, 13),
                (int) Math.pow(2, 18));
    }
}
