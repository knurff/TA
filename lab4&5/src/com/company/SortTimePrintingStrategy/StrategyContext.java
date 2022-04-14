package com.company.SortTimePrintingStrategy;


import com.company.Utils.ElapsedTimeCounter;

public class StrategyContext {
    private SortMethod strategy;

    public StrategyContext(SortMethod sm) {
        this.strategy = sm;
    }

    public void setStrategy(SortMethod sm) {
        this.strategy = sm;
    }

    public void executeSort(String isAlreadySorted, int[]... arrays) {
        for (int[] arr : arrays) {
            ElapsedTimeCounter.printSortingTime(strategy, arr, isAlreadySorted);
        }
    }
}
