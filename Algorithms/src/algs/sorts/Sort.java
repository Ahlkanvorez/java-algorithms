package algs.sorts;

/**
 * Provides a generic interface for a Sort, which can sort an array as a whole, or some segment of an array.
 * This interface can be used to sort an array of any type which implements the .compareTo(T) method.
 *
 * @author Robert Mitchell <robert.mitchell36@gmail.com>
 */
public interface Sort<T extends Comparable<T>> {

    /**
     * Sorts the entire given array.
     * 
     * @param data The array to be sorted
     */
    void sort(final T[] data);

    /**
     * Sorts the given array, data, on the interval [low, high], inclusive.
     * Note, that this method assumes low < high.
     * 
     * @param data The array to be sorted
     * @param low The first index, inclusive, to be sorted
     * @param high The last index, inclusive, to be sorted
     */
    void sort(final T[] data, final int low, final int high);
}
