package com.company;

import com.company.SortTimePrintingStrategy.SortMethods.Easy.BubbleSort;
import com.company.SortTimePrintingStrategy.SortMethods.Easy.InsertionSort;
import com.company.SortTimePrintingStrategy.SortMethods.Easy.SelectionSort;
import com.company.SortTimePrintingStrategy.StrategyContext;
import com.company.Utils.ArraysUtil;

public class Lab4 {
    public static void main(String[] args) {
        //int[] tenR = new int[10]; //створюємо для прикладу, щоб показати, що певний алгоритм сорт.працює
        int[] thousandR = new int[1000];
        int[]  tenThousandR = new int[10000];
        int[]  hundredThousandR = new int[100000];
        //ArraysUtil.fillArrayWithRandomValues(tenR);
        ArraysUtil.fillArrayWithRandomValues(thousandR);
        ArraysUtil.fillArrayWithRandomValues(tenThousandR);
        ArraysUtil.fillArrayWithRandomValues(hundredThousandR);
        //int[] tenC = new int[10];
        int[] thousandC = new int[1000];
        int[]  tenThousandC = new int[10000];
        int[]  hundredThousandC = new int[100000];
        //ArraysUtil.fillArrayWithConsistentValues(tenC);
        ArraysUtil.fillArrayWithConsistentValues(thousandC);
        ArraysUtil.fillArrayWithConsistentValues(tenThousandC);
        ArraysUtil.fillArrayWithConsistentValues(hundredThousandC);
        try {
            StrategyContext c = new StrategyContext(new BubbleSort());
            c.executeSort(thousandR.clone(), tenThousandR.clone(), hundredThousandR.clone(), false);
            c.executeSort(thousandC.clone(), tenThousandC.clone(),hundredThousandC.clone(), true);
            c.setStrategy(new InsertionSort());
            c.executeSort(thousandR.clone(), tenThousandR.clone(), hundredThousandR.clone(), false);
            c.executeSort(thousandC.clone(), tenThousandC.clone(),hundredThousandC.clone(), true);
            c.setStrategy(new SelectionSort());
            c.executeSort(thousandR.clone(), tenThousandR.clone(), hundredThousandR.clone(), false);
            c.executeSort(thousandC.clone(), tenThousandC.clone(),hundredThousandC.clone(), true);
        }catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }
    }

}
