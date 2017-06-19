package algs.math.numbertheory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SieveOfEratosthenes implements Sieve {
    private final List<Integer> primes;

    public SieveOfEratosthenes() {
        primes = new ArrayList<>();
        primes.add(2);
    }

    /** Returns the nth prime number, where 2 is the first.
     *
     * @param p the index of the desired prime, where 2 is the first prime.
     * @return The nth prime number.
     */
    public int getPrime(final int p) {
        if (p < primes.size()) {
            return primes.get(p - 1);
        }
        for (int i = primes.get(primes.size() - 1) + 1; primes.size() <= p; ++i) {
            boolean isPrime = true;
            for (int prime : primes) {
                if (i % prime == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(i);
            }
        }
        return primes.get(p - 1);
    }

    /** Determines whether the given prime has been found with the current sieve.
     * Note: This method runs in O(Log(P)) time, using O(1) space, where P is the number of primes found.
     *
     * @param prime the target prime.
     * @return true if the sieve has found the given prime, false otherwise.
     */
    public boolean isKnownPrime(final int prime) {
        return Collections.binarySearch(primes, prime) >= 0;
    }

    /** The index of the given prime, where the index of 2 is 1.
     * Note: This method runs in O(Log(P)) time, using O(1) space, where P is the number of primes found.
     *
     * @param prime the prime whose index is desired.
     * @return the index of the given prime number.
     */
    public int getPrimeIndex(final int prime) {
        return 1 + Collections.binarySearch(primes, prime);
    }

    /** The list of prime factors in sorted order from least to greatest for the given number.
     * The possible factors are only those for which isKnownPrime will return true, thus, if the given
     * number has a prime factor for which that method returns false, it will not appear in the factors list.
     * The product of the factors list is guaranteed to be less than or equal to the target, being equal when it is
     * the full factorization.
     * Note: This method runs in O(P) time, where P is the number of primes found.
     *
     * @param n The number whose prime factorization is desired.
     * @return the list of prime factors
     */
    public List<Integer> primeFactorize(final int n) {
        final List<Integer> factors = new ArrayList<>();
        primes.forEach(prime -> {
            if (n % prime == 0) {
                int m = n / prime;
                for (int i = 0; i < m; ++i) {
                    // Add the factor as many times as it divides n.
                    factors.add(prime);
                }
            }
        });
        return factors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SieveOfEratosthenes that = (SieveOfEratosthenes) o;

        return primes.equals(that.primes);
    }

    @Override
    public int hashCode() {
        return primes != null ? 11 * primes.hashCode() : 0;
    }

    @Override
    public String toString() {
        return primes.toString();
    }

    public static void main(String[] args) {
        final Sieve sieve = new SieveOfEratosthenes();
        for (int i = 1; i < 1000; ++i) {
            System.out.println(sieve.getPrime(i));
        }
    }
}
