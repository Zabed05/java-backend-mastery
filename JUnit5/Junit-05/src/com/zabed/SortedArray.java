package com.zabed;

import java.util.Arrays;

public class SortedArray {

    public int[] sortArray(int[] arr){
        
        for (int i = 0; i < 1000000; i++) {
            Arrays.sort(arr);
        }
        return arr;
    }
}