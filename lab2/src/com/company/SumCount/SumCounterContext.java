package com.company.SumCount;

import com.company.SumCount.SumCounter;

public class SumCounterContext {
    private SumCounter sumCounter;

    public SumCounterContext(SumCounter sumCounter) {
        this.sumCounter = sumCounter;
    }

    public void setSumCounter(SumCounter sumCounter) {
        this.sumCounter = sumCounter;
    }

    public int executeSum(int[] arr) {
        return sumCounter.count(arr);
    }
}
