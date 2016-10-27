package algs.sorts;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author robertmitchell
 */
public class Utilities {
    /**
     * 
     * @param s
     * @param T
     * @param N
     * @param R 
     */
    public static void testSort(final Sort<Integer> s, final int T, final int N, final int R) {
        final List<Double> times = new LinkedList<>();
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
            }
        }
        
        System.out.printf("%d trials length %8d: %.4f s%n", T, N,
                times.stream().reduce((a, b) -> a + b).get() / times.size());
    }
    
    /**
     * 
     * @param s 
     */
    public static void testSort(final Sort<Integer> s) {
        // T = trials, N = length of array, R = range of values.
        final int T = 50;
        final int N = 10000;
        final int R = 20;
        testSort(s, T, N, R);
    }
    
    /**
     * 
     * @param s
     * @param min
     * @param max 
     */
    public static void doublingTest(final Sort<Integer> s, final int min, final int max) {
        final int T = 20;
        final int R = 20;
        for (int N = min; N < max; N *= 2) {
            testSort(s, T, N, R);
        }
    }
    
    /**
     * 
     * @param data
     * @param i
     * @param j 
     */
    public static void swap(final Object[] data, final int i, final int j) {
        if (data != null &&
            i >= 0 && i < data.length &&
            j >= 0 && j < data.length) {
            final Object tmp = data[i];
            data[i] = data[j];
            data[j] = tmp;
        }
    }
    
    /**
     * 
     * @param data
     * @return 
     */
    public static <T extends Comparable<T>> boolean isSorted(final T[] data) {
        if (data == null || data.length == 1) {
            return false;
        }
        for (int i = 1; i < data.length; ++i) {
            if (data[i].compareTo(data[i - 1]) < 0) {
                return false; // No element should be less than it's predecessor.
            }
        }
        return true;
    }

    /**
     * 
     * @param data 
     */
    public static void shuffle(Object[] data) {
        for (int i = data.length - 1; i > 0; --i) {
            swap(data, i, (int) (Math.random() * i));
        }
    }
}
