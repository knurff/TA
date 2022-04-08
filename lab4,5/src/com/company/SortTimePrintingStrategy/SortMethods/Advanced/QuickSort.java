package com.company.SortTimePrintingStrategy.SortMethods.Advanced;

import com.company.SortTimePrintingStrategy.SortMethod;

public class QuickSort implements SortMethod {
    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public void sort(int[] arr, int first, int last) {
        if (arr.length == 0) return;
        if (first >= last) return;
        int middle = first + (last - first) / 2;
        int middle_element = arr[middle];
        int i = first, j = last;
        while (i <= j) {
            while (arr[i] < middle_element) {
                i++;
            }
            while (arr[j] > middle_element) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (first < j)
            sort(arr, first, j);

        if (last > i)
            sort(arr, i, last);
    }
}
