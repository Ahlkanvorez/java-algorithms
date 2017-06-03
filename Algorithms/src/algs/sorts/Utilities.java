package algs.sorts;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Implements a few utility methods which are commonly needed in implementing sorting algorithms, as well as a few
 * convenience methods for performing benchmarking tests, such as testing on arrays of sizes on a exponential curve
 * (as is done in the DoublingTest method).
 *
 * @author Robert Mitchell <robert.mitchell36@gmail.com>
 */
public class Utilities {
    /**
     * Performs repeated trials with the given data specifications of the provided sort.
     * 
     * @param s The sort to use for this test.
     * @param T The number of trials to perform.
     * @param N The length of the trial arrays to use for sorting.
     * @param R The range of integers [-R / 2, R / 2] to select random values from for use in sorting.
     */
    public static boolean testSort(final Sort<Integer> s, final int T, final int N, final int R) {
        final List<Double> times = new LinkedList<>();
        boolean passed = true;
        for (int t = 0; t < T; ++t) {
            final Integer[] data = new Integer[N];
            for (int n = 0; n < data.length; ++n) {
                data[n] = (int)(Math.random() * R - (R / 2));
            }
            
            final long start = System.currentTimeMillis();
            s.sort(data);
            final double time = (System.currentTimeMillis() - start) / 1000.0;
            // System.out.printf("Elapsed time: %.4f s%n", time);
            
            times.add(time);
            
            if (!isSorted(data)) {
                System.out.printf("Failed case: %s%n", Arrays.toString(data));
                passed = false;
            }
        }

        System.out.printf("%d trials length %8d: %.4f s%n", T, N,
                times.stream().reduce((a, b) -> a + b).get() / times.size());
        return passed;
    }
    
    /**
     * Performs 50 trials of the provided sort on integer arrays of length 10,000 with random values on [-10, 10].
     * 
     * @param s The sort to test.
     */
    public static void testSort(final Sort<Integer> s) {
        // T = trials, N = length of array, R = range of values.
        final int T = 50;
        final int N = 10000;
        final int R = 20;
        testSort(s, T, N, R);
    }
    
    /**
     * Performs 20 trials on arrays of length 2^min through 2^max of the given sort.
     * 
     * @param s The sort to test.
     * @param min The smallest exponent to use for the length of the test array (viz. 2^min).
     * @param max The largest exponent to use for the length of the test array (viz. 2^max).
     */
    public static void doublingTest(final Sort<Integer> s, final int min, final int max) {
        final int T = 20;
        final int R = 20;
        for (int N = min; N < max; N *= 2) {
            testSort(s, T, N, R);
        }
    }
    
    /**
     * Exchanges the elements at the two provided indices in the given array.
     * 
     * @param data The data in which to exchange elements.
     * @param i The first element to exchange.
     * @param j The second element to exchange.
     */
    public static void swap(final Object[] data, final int i, final int j) {
        /* Assume the indices are within the bounds of the array. */
        final Object tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
    
    /**
     * Checks whether the provided array is sorted according to it's natural ordering, defined by .compareTo(T).
     * 
     * @param data The array to test whether it is sorted.
     * @return True if the array is sorted in the order specified by the data's .compareTo(T), false otherwise.
     */
    public static <T extends Comparable<T>> boolean isSorted(final T[] data) {
        return isSorted(data, 0, data.length - 1);
    }

    /**
     * Checks whether the provided array is sorted according to it's natural ordering, defined by .compareTo(T), on the
     * given interval.
     *
     * @param data The array to test whether it is sorted.
     * @param low The least index in the interval to check.
     * @param high The greatest index in the interval to check.
     * @return True if the array is sorted in the order specified by the data's .compareTo(T), false otherwise.
     */
    public static <T extends Comparable<T>> boolean isSorted(final T[] data, final int low, final int high) {
        if (data == null || data.length == 0) {
            return false;
        }
        if (data.length == 1 || high - low <= 1) {
            return true;
        }
        for (int i = low + 1; i <= high; ++i) {
            if (data[i].compareTo(data[i - 1]) < 0) {
                return false; /* No element should be less than it's predecessor. */
            }
        }
        return true;
    }

    /**
     * Shuffles the array using the Knuth-Shuffle (Fischer-Yates Shuffle).
     * This shuffling algorithm runs in O(N) time.
     * 
     * @param data The array to shuffle.
     */
    public static void shuffle(final Object[] data) {
        for (int i = data.length - 1; i > 0; --i) {
            swap(data, i, (int) (Math.random() * i));
        }
    }
}
