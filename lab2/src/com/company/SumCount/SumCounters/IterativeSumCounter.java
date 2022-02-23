package com.company.SumCount.SumCounters;

import com.company.SumCount.SumCounter;

public class IterativeSumCounter implements SumCounter {
    @Override
    public int count(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }
}
