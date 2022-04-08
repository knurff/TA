package com.company;

import com.company.SortTimePrintingStrategy.SortMethods.Advanced.HeapSort;
import com.company.SortTimePrintingStrategy.SortMethods.Advanced.MergeSort;
import com.company.SortTimePrintingStrategy.SortMethods.Advanced.QuickSort;
import com.company.SortTimePrintingStrategy.SortMethods.Advanced.ShellSort;
import com.company.SortTimePrintingStrategy.StrategyContext;
import com.company.Utils.ArraysUtil;

public class Lab5 {
    public static void main(String[] args) {
        //int[] tenR = new int[10]; //створюємо для прикладу, щоб показати, що певний алгоритм сорт.працює
        int[] hundredThousandR = new int[100_000];
        int[] millionR = new int[1000_000];
        //ArraysUtil.fillArrayWithRandomValues(tenR);
        ArraysUtil.fillArrayWithRandomValues(hundredThousandR);
        ArraysUtil.fillArrayWithRandomValues(millionR);
        //int[] tenC = new int[10];
        int[] hundredThousandC = new int[100000];
        int[] millionC = new int[1000_000];
        //ArraysUtil.fillArrayWithConsistentValues(tenC);
        ArraysUtil.fillArrayWithConsistentValues(hundredThousandC);
        ArraysUtil.fillArrayWithConsistentValues(millionC);
        try {
            StrategyContext c = new StrategyContext(new QuickSort());
            c.executeSort(hundredThousandR.clone(), millionR.clone(), false);
            c.executeSort(hundredThousandC.clone(), millionC.clone(), true);
            c.setStrategy(new MergeSort());
            c.executeSort(hundredThousandR.clone(), millionR.clone(), false);
            c.executeSort(hundredThousandC.clone(), millionC.clone(), true);
            c.setStrategy(new ShellSort());
            c.executeSort(hundredThousandR.clone(), millionR.clone(), false);
            c.executeSort(hundredThousandC.clone(), millionC.clone(), true);
            c.setStrategy(new HeapSort());
            c.executeSort(hundredThousandR.clone(), millionR.clone(), false);
            c.executeSort(hundredThousandC.clone(), millionC.clone(), true);
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }
    }

}
