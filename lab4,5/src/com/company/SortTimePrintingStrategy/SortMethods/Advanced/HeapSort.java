package com.company.SortTimePrintingStrategy.SortMethods.Advanced;

import com.company.SortTimePrintingStrategy.SortMethod;

public class HeapSort implements SortMethod {

    @Override
    public void sort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) processHeapifying(arr, arr.length, i);
        for (int i = arr.length - 1; i >= 0; i--) {
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
        if (left < n && array[left] > array[largest]) largest = left;
        if (right < n && array[right] > array[largest]) largest = right;
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            processHeapifying(array, n, largest);
        }
    }
}
