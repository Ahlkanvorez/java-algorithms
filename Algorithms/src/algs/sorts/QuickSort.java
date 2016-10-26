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

    @SuppressWarnings("empty-statement")
    private int partition(final Comparable[] data, final int low, final int high) {
        final Comparable pivot = data[low];
        int i = low - 1;
        int j = high + 1;
        while (true) {
            while (data[++i].compareTo(pivot) < 0);
            while (data[--j].compareTo(pivot) > 0);
            if (i >= j) {
                return j;
            }
            swap(data, i, j);
        }
    }
    
    private void quickSort(final Comparable[] data, final int low, final int high) {
        if (high <= low + SORT_CUTOFF) {
            INSERTION_SORT.sort(data, low, high);
            return;
        }
        
        final int p = partition(data, low, high);
        quickSort(data, low, p);
        quickSort(data, p + 1, high);
    }
    
    @Override
    public void sort(final Comparable[] data) {
        shuffle(data); // Reduces probability of worst-case performance.
        quickSort(data, 0, data.length - 1);
    }

    @Override
    public void sort(final Comparable[] data, final int low, final int high) {
        quickSort(data, low, high);
    }
    
    public static void main (final String[] args) {
        System.out.println("Testing Quick Sort:");
        Utilities.doublingTest(new QuickSort(), (int) pow(2, 13), (int) pow(2, 25));
    }
}
