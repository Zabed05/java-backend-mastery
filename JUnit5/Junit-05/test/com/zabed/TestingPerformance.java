package com.zabed;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import java.time.Duration;

import org.junit.Test;

public class TestingPerformance {
    
    @Test
    public void testSortingMethod_Performance(){
        SortedArray arr = new SortedArray();

        int unsorted[] = {2, 5, 3};

        assertTimeout(Duration.ofMillis(100), ()-> arr.sortArray(unsorted));
    }
}