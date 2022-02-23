package com.company;

import com.company.AckermannFunction.AckermannFunction;
import com.company.AckermannFunction.AckermannFunctionImpls.AckermannFunctionImpl;
import com.company.SumCount.SumCounters.IterativeSumCounter;
import com.company.SumCount.SumCounters.RecursionSumCounter;
import com.company.SumCount.SumCounterContext;

public class Main {

    public static void main(String[] args) {
        try {
            int[] arr = new int[]{1, 8, 0, -10};
            SumCounterContext sumCounterContext = new SumCounterContext(new IterativeSumCounter());
            System.out.println(sumCounterContext.executeSum(arr));
            sumCounterContext.setSumCounter(new RecursionSumCounter());
            System.out.println(sumCounterContext.executeSum(arr));
            AckermannFunction ackermannFunction = new AckermannFunctionImpl();
            System.out.println(ackermannFunction.count(3, 3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
