package algs.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Robert Mitchell on 5/17/17.
 */
class BinarySearchTest {
    final int N = 500;
    final Integer[] evenLengthNumbers = new Integer[N];
    final Integer[] oddLengthNumbers = new Integer[N + 1];

    @BeforeEach
    void setUp() {
        for (int i = 0; i < N; ++i) {
            evenLengthNumbers[i] = oddLengthNumbers[i] = i;
        }
        oddLengthNumbers[N] = N;
    }

    @Test
    void evenLengthNumbersFirstElementFind() {
        int target = 0;
        int index = BinarySearch.find(target, evenLengthNumbers);
        assert index == 0;
        assert evenLengthNumbers[index] == target;
    }

    @Test
    void oddLengthNumbersFirstElementFind() {
        int target = 0;
        int index = BinarySearch.find(target, oddLengthNumbers);
        assert index == 0;
        assert oddLengthNumbers[index] == target;
    }

    @Test
    void evenLengthNumbersLastElementFind() {
        int target = N - 1;
        int index = BinarySearch.find(target, evenLengthNumbers);
        assert index == N - 1;
        assert evenLengthNumbers[index] == target;
    }

    @Test
    void oddLengthNumbersLastElementFind() {
        int target = N;
        int index = BinarySearch.find(target, oddLengthNumbers);
        assert index == N;
        assert oddLengthNumbers[index] == target;
    }

    @Test
    void evenLengthNumbersLeftMiddleElementFind() {
        int target = N / 2;
        int index = BinarySearch.find(target, evenLengthNumbers);
        assert index == N / 2;
        assert evenLengthNumbers[index] == target;
    }

    @Test
    void evenLengthNumbersRightMiddleElementFind() {
        int target = N / 2 + 1;
        int index = BinarySearch.find(target, evenLengthNumbers);
        assert index == N / 2 + 1;
        assert evenLengthNumbers[index] == target;
    }

    @Test
    void oddLengthNumbersMiddleElementFind() {
        int target = N / 2;
        int index = BinarySearch.find(target, oddLengthNumbers);
        assert index == N / 2;
        assert oddLengthNumbers[index] == target;
    }
}