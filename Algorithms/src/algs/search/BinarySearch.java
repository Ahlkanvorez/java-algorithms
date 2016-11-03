package algs.search;

/**
 * Created by Robert Mitchell on 11/2/16.
 */
public class BinarySearch {

    /**
     * Implements the Binary Search algorithm for finding an element of a list of objects which implement Comparable.
     * This search assumes the data given is sorted, and will not function properly on unsorted data. Moreover, it
     * assumes that target is not null, and will throw a NullPointerException if target is null.
     *
     * This method runs using O(lg N) comparisons, and no extra space; it is not recursive so it does not use stack
     * space.
     *
     * @param target The element to search for in the array.
     * @param data The array in which to search. This must be a sorted array.
     * @param <T> The type of element to search for, which must implement Comparable
     * @return The index of target, or the negative of 1 + the index in which it would appear.
     */
    public static <T extends Comparable<T>> int find(final T target, final T[] data) {
        int low = 0;
        int high = data.length - 1;
        while (low <= high) {
            final int mid = low + (high - low) / 2;
            final int cmp = target.compareTo(data[mid]);
            if (cmp < 0) {
                high = mid - 1;
            } else if (cmp > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    public static void main(final String[] args) {
        final Integer[] data = { 1, 2, 3, 4, 6, 7, 8, 9, 10, 12 };

        for (int i = 0; i < 13; i++) {
            System.out.printf("%d : %d%n", i, find(i, data));
        }
    }
}
