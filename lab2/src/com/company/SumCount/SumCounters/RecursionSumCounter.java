package com.company.SumCount.SumCounters;

import com.company.SumCount.SumCounter;

public class RecursionSumCounter implements SumCounter {
    @Override
    public int count(int[] arr) {
        return implRecursion(arr, 0, 0);
    }

    private int implRecursion(int[] arr, int position, int sum) {
        if (arr.length == position) return sum;
        sum += arr[position];
        return implRecursion(arr, position + 1, sum);
    }
}
