package com.company;

import com.company.SortTimePrintingStrategy.SortMethods.Advanced.HeapSort;
import com.company.SortTimePrintingStrategy.SortMethods.Advanced.MergeSort;
import com.company.SortTimePrintingStrategy.SortMethods.Advanced.QuickSort;
import com.company.SortTimePrintingStrategy.SortMethods.Advanced.ShellSort;
import com.company.SortTimePrintingStrategy.StrategyContext;
import com.company.Utils.ArraysUtil;

public class Lab5 {

    public static void main(String[] args) {
        int[] Con10 = new int[10];
        int[] Con100 = new int[100];
        int[] Con1000 = new int[1000];
        int[] Con5000 = new int[5000];
        int[] Con10000 = new int[10000];
        int[] Con20000 = new int[20000];
        int[] Con50000 = new int[50000];
        ArraysUtil.fillArrayWithConsistentValues(Con10);
        ArraysUtil.fillArrayWithConsistentValues(Con100);
        ArraysUtil.fillArrayWithConsistentValues(Con1000);
        ArraysUtil.fillArrayWithConsistentValues(Con5000);
        ArraysUtil.fillArrayWithConsistentValues(Con10000);
        ArraysUtil.fillArrayWithConsistentValues(Con20000);
        ArraysUtil.fillArrayWithConsistentValues(Con50000);
        int[] Rev10 = new int[10];
        int[] Rev100 = new int[100];
        int[] Rev1000 = new int[1000];
        int[] Rev5000 = new int[5000];
        int[] Rev10000 = new int[10000];
        int[] Rev20000 = new int[20000];
        int[] Rev50000 = new int[50000];
        ArraysUtil.fillArrayWithReverseValues(Rev10);
        ArraysUtil.fillArrayWithReverseValues(Rev100);
        ArraysUtil.fillArrayWithReverseValues(Rev1000);
        ArraysUtil.fillArrayWithReverseValues(Rev5000);
        ArraysUtil.fillArrayWithReverseValues(Rev10000);
        ArraysUtil.fillArrayWithReverseValues(Rev20000);
        ArraysUtil.fillArrayWithReverseValues(Rev50000);
        int[] Rand10 = new int[10];
        int[] Rand100 = new int[100];
        int[] Rand1000 = new int[1000];
        int[] Rand5000 = new int[5000];
        int[] Rand10000 = new int[10000];
        int[] Rand20000 = new int[20000];
        int[] Rand50000 = new int[50000];
        ArraysUtil.fillArrayWithRandomValues(Rand10);
        ArraysUtil.fillArrayWithRandomValues(Rand100);
        ArraysUtil.fillArrayWithRandomValues(Rand1000);
        ArraysUtil.fillArrayWithRandomValues(Rand5000);
        ArraysUtil.fillArrayWithRandomValues(Rand10000);
        ArraysUtil.fillArrayWithRandomValues(Rand20000);
        ArraysUtil.fillArrayWithRandomValues(Rand50000);
        try {
            StrategyContext c = new StrategyContext(new QuickSort());
            c.executeSort("ALREADY SORTED", Con10.clone(), Con100.clone(), Con1000.clone(), Con5000.clone(), Con10000.clone(), Con20000.clone(), Con50000.clone());
            c.executeSort("REVERSE SORTED", Rev10.clone(), Rev100.clone(), Rev1000.clone(), Rev5000.clone(), Rev10000.clone(), Rev20000.clone(), Rev50000.clone());
            c.executeSort("UNSORTED", Rand10.clone(), Rand100.clone(), Rand1000.clone(), Rand5000.clone(), Rand10000.clone(), Rand20000.clone(), Rand50000.clone());
            c.setStrategy(new MergeSort());
            c.executeSort("ALREADY SORTED", Con10.clone(), Con100.clone(), Con1000.clone(), Con5000.clone(), Con10000.clone(), Con20000.clone(), Con50000.clone());
            c.executeSort("REVERSE SORTED", Rev10.clone(), Rev100.clone(), Rev1000.clone(), Rev5000.clone(), Rev10000.clone(), Rev20000.clone(), Rev50000.clone());
            c.executeSort("UNSORTED", Rand10.clone(), Rand100.clone(), Rand1000.clone(), Rand5000.clone(), Rand10000.clone(), Rand20000.clone(), Rand50000.clone());
            c.setStrategy(new ShellSort());
            c.executeSort("ALREADY SORTED", Con10.clone(), Con100.clone(), Con1000.clone(), Con5000.clone(), Con10000.clone(), Con20000.clone(), Con50000.clone());
            c.executeSort("REVERSE SORTED", Rev10.clone(), Rev100.clone(), Rev1000.clone(), Rev5000.clone(), Rev10000.clone(), Rev20000.clone(), Rev50000.clone());
            c.executeSort("UNSORTED", Rand10.clone(), Rand100.clone(), Rand1000.clone(), Rand5000.clone(), Rand10000.clone(), Rand20000.clone(), Rand50000.clone());
            c.setStrategy(new HeapSort());
            c.executeSort("ALREADY SORTED", Con10.clone(), Con100.clone(), Con1000.clone(), Con5000.clone(), Con10000.clone(), Con20000.clone(), Con50000.clone());
            c.executeSort("REVERSE SORTED", Rev10.clone(), Rev100.clone(), Rev1000.clone(), Rev5000.clone(), Rev10000.clone(), Rev20000.clone(), Rev50000.clone());
            c.executeSort("UNSORTED", Rand10.clone(), Rand100.clone(), Rand1000.clone(), Rand5000.clone(), Rand10000.clone(), Rand20000.clone(), Rand50000.clone());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


}
