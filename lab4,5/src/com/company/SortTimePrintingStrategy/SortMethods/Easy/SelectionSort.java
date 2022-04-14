package com.company.SortTimePrintingStrategy.SortMethods.Easy;

import com.company.SortTimePrintingStrategy.SortMethod;

public class SelectionSort implements SortMethod {
    private long comparisons = 0;
    private long swaps = 0;

    @Override
    public  void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                comparisons++;
                if (arr[j] < min) {
                    swaps++;
                    index = j;
                    min = arr[j];
                }
            }
            arr[index] = arr[i];
            arr[i] = min;
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
