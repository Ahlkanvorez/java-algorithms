package algs.sorts;

/**
 *
 * @author robertmitchell
 */
public interface Sort {
    /**
     * 
     * @param data 
     */
    public void sort(final Comparable[] data);

    /**
     * 
     * @param data
     * @param low
     * @param high 
     */
    public void sort(final Comparable[] data, final int low, final int high);
}
