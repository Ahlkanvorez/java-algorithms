package algs.sorts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by robertmitchell on 6/3/17.
 */
class MergeSortTest extends SortTest {
    MergeSortTest() {
        super();
        super.sort = new MergeSort<>();
    }
}