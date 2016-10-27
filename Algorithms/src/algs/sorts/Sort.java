package algs.sorts;

/**
 *
 *
 *
 * @author robertmitchell
 */
public interface Sort<T extends Comparable<T>> {

    /**
     * 
     * @param data 
     */
    void sort(final T[] data);

    /**
     * 
     * @param data
     * @param low
     * @param high 
     */
    void sort(final T[] data, final int low, final int high);
}
