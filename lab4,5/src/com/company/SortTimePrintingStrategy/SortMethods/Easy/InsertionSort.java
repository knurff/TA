package com.company.SortTimePrintingStrategy.SortMethods.Easy;

import com.company.SortTimePrintingStrategy.SortMethod;

public class InsertionSort implements SortMethod {
    private long comparisons = 0;
    private long swaps = 0;

    @Override
    public void sort(int[] arr){
        for (int left = 0; left < arr.length; left++) {
            int value = arr[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                comparisons++;
                if (value < arr[i]) {
                    swaps++;
                    arr[i + 1] = arr[i];
                } else {
                    break;
                }
            }
            arr[i + 1] = value;
        }
    }

    @Override
    public String getInfo() {
        String info = " Number of comparisons: " + comparisons + " Number of permutations: " + swaps;
        comparisons = 0;
        swaps = 0;
        return info;
    }
}
