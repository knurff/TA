package com.company.Utils;

import com.company.SortTimePrintingStrategy.SortMethod;
import com.google.common.base.Stopwatch;

public class ElapsedTimeCounter {
    private ElapsedTimeCounter() {
        throw new AssertionError();
    }

    public static void count(SortMethod sortMethod, int[] arr, boolean isAlreadySorted) {
        String status;
        String type = String.valueOf(sortMethod.getClass());
        String[] typeArray = type.split("[ .]");
        if (isAlreadySorted) status = "ALREADY SORTED ";
        else status = "UNSORTED ";
        String result;
        Stopwatch timer = Stopwatch.createStarted();
        sortMethod.sort(arr);
        result = timer.stop().toString();
        System.out.println("Elapsed time to sort " + status + arr.length +
                "-length array: " + result + " Sort method: " + typeArray[typeArray.length - 1]);
    }
}
