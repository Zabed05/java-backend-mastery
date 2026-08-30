package com.zabed;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class TestException {

    @Test
    void testSortArray() {

        // try {
            SortedArray arr = new SortedArray();

            // int unsorted[] = {2, 5, 1, 3, 4};
            // int unsorted[] = null;
        //     int sortedArray[] = arr.sortArray(unsorted);

        //     for (int i : sortedArray) {
        //         System.out.println(i);
        //     }
        // }
        // catch (NullPointerException e) {
        //     System.out.println("Exception generated");
        // }

        int unsorted[] = null;
        assertThrows(NullPointerException.class, ()-> arr.sortArray(unsorted));
    }
}
