package com.company.SortTimePrintingStrategy.SortMethods.Advanced;

import com.company.SortTimePrintingStrategy.SortMethod;

public class HeapSort implements SortMethod {
    private int comparisons = 0;
    private int swaps = 0;

    @Override
    public void sort(int[] arr) {
        comparisons++;
        for (int i = arr.length / 2 - 1; i >= 0; i--) processHeapifying(arr, arr.length, i);
        comparisons++;
        for (int i = arr.length - 1; i >= 0; i--) {
            swaps++;
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            processHeapifying(arr, i, 0);
        }
    }

    private void processHeapifying(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        comparisons += 2;
        if (left < n && array[left] > array[largest]) largest = left;
        comparisons += 2;
        if (right < n && array[right] > array[largest]) largest = right;
        comparisons++;
        if (largest != i) {
            swaps++;
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            processHeapifying(array, n, largest);
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
