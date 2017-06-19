package algs.math.numbertheory;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by robertmitchell on 6/19/17.
 */
class SieveOfEratosthenesTest {
    static final Sieve sieve = new SieveOfEratosthenes();

    @Test
    void testConstructorPrimes() {
        assertTrue(sieve.isKnownPrime(2));
        assertFalse(sieve.isKnownPrime(3));
    }

    @Test
    void testGetPrimeUnknownPrime() {
        int p = sieve.getPrime(5);
        assertTrue(sieve.isKnownPrime(p));
    }

    @Test
    void testGetPrimeIndex() {
        final int index = 20;
        int p = sieve.getPrime(index);
        assertEquals(index, sieve.getPrimeIndex(p));
    }

    @Test
    void testPrimeFactorizePrime() {
        // ensure 5, the 3rd prime, has been found
        sieve.getPrime(3);
        List<Integer> factors = sieve.primeFactorize(5);
        assertEquals(factors, Arrays.asList(5));
    }
}