package com.company.SortTimePrintingStrategy.SortMethods.Advanced;

import com.company.SortTimePrintingStrategy.SortMethod;

public class MergeSort implements SortMethod {
    private int comparisons = 0;
    private int swaps = 0;

    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public void sort(int[] arr, int first, int last) {
        comparisons++;
        if (first >= last) return;
        int mid = first + (last - first) / 2;
        sort(arr, first, mid);
        sort(arr, mid + 1, last);
        merge(arr, first, mid, last);
    }

    public void merge(int[] arr, int left, int mid, int right) {
        int subArrayOne = mid - left + 1;
        int subArrayTwo = right - mid;
        int[] leftArray = new int[subArrayOne];
        int[] rightArray = new int[subArrayTwo];
        System.arraycopy(arr, left, leftArray, 0, subArrayOne);
        for (int j = 0; j < subArrayTwo; j++) rightArray[j] = arr[mid + 1 + j];
        int indexOfSubArrayOne = 0;
        int indexOfSubArrayTwo = 0;
        int indexOfMergedArray = left;
        comparisons++;
        while (indexOfSubArrayOne < subArrayOne && indexOfSubArrayTwo < subArrayTwo) {
            comparisons += 2;
            if (leftArray[indexOfSubArrayOne] <= rightArray[indexOfSubArrayTwo]) {
                arr[indexOfMergedArray] = leftArray[indexOfSubArrayOne];
                indexOfSubArrayOne++;
            } else {
                swaps++;
                arr[indexOfMergedArray] = rightArray[indexOfSubArrayTwo];
                indexOfSubArrayTwo++;
            }
            indexOfMergedArray++;
        }
        comparisons++;
        while (indexOfSubArrayOne < subArrayOne) {
            comparisons++;
            arr[indexOfMergedArray] = leftArray[indexOfSubArrayOne];
            indexOfSubArrayOne++;
            indexOfMergedArray++;
        }
        comparisons++;
        while (indexOfSubArrayTwo < subArrayTwo) {
            comparisons++;
            arr[indexOfMergedArray] = rightArray[indexOfSubArrayTwo];
            indexOfSubArrayTwo++;
            indexOfMergedArray++;
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
