package algs.math.numbertheory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robertmitchell on 6/10/17.
 */
public class SieveOfEratosthenes implements Sieve {
    private final List<Integer> primes;

    public SieveOfEratosthenes() {
        primes = new ArrayList<>();
        primes.add(2);
    }

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

    public static void main(String[] args) {
        final Sieve sieve = new SieveOfEratosthenes();
        for (int i = 1; i < 1000; ++i) {
            System.out.println(sieve.getPrime(i));
        }
    }
}
