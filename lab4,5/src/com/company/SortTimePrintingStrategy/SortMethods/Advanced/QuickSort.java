package com.company.SortTimePrintingStrategy.SortMethods.Advanced;

import com.company.SortTimePrintingStrategy.SortMethod;

public class QuickSort implements SortMethod {
    private int comparisons = 0;
    private int swaps = 0;

    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public void sort(int[] arr, int first, int last) {
        comparisons++;
        if (arr.length == 0) return;
        comparisons++;
        if (first >= last)
            return;
        int middle = first + (last - first) / 2;
        int middle_element = arr[middle];
        int i = first, j = last;
        comparisons++;
        while (i <= j) {
            comparisons++;
            while (arr[i] < middle_element) {
                comparisons++;
                i++;
            }
            comparisons++;
            while (arr[j] > middle_element) {
                comparisons++;
                j--;
            }
            if (i <= j) {
                swaps++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        comparisons++;
        if (first < j)
            sort(arr, first, j);
        comparisons++;
        if (last > i)
            sort(arr, i, last);
    }

    @Override
    public String getInfo() {
        String info = " Number of comparisons: " + comparisons + " Number of permutations: " + swaps;
        comparisons = 0;
        swaps = 0;
        return info;
    }
}
