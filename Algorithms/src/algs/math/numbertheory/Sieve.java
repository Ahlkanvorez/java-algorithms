package algs.math.numbertheory;

import java.util.List;

/**
 * Created by robertmitchell on 6/10/17.
 */
public interface Sieve {

    /** Returns the nth prime number, where 2 is the first.
     *
     * @param n the index of the desired prime, where 2 is the first prime.
     * @return The nth prime number.
     */
    int getPrime(int n);

    /** Determines whether the given prime has been found with the current sieve.
     *
     * @param prime the target prime.
     * @return true if the sieve has found the given prime, false otherwise.
     */
    boolean isKnownPrime(int prime);

    /** The index of the given prime, where the index of 2 is 1.
     *
     * @param prime the prime whose index is desired.
     * @return the index of the given prime number.
     */
    int getPrimeIndex(int prime);

    /** The list of prime factors in sorted order from least to greatest for the given number.
     * The possible factors are only those for which isKnownPrime will return true, thus, if the given
     * number has a prime factor for which that method returns false, it will not appear in the factors list.
     * The product of the factors list is guaranteed to be less than or equal to the target, being equal when it is
     * the full factorization.
     *
     * @param n The number whose prime factorization is desired.
     * @return the list of prime factors
     */
    List<Integer> primeFactorize(int n);
}
