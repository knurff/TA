package com.company.SortTimePrintingStrategy;

import Print.PrinterImpls.TemplatePrinter;
import Print.Printer;
import com.company.Utils.ElapsedTimeCounter;

public class StrategyContext {
    private SortMethod strategy;
    private final Printer printer;

    public StrategyContext(SortMethod sm){
        this.strategy = sm;
        printer = new TemplatePrinter();
    }
    public void setStrategy(SortMethod sm) {
        this.strategy = sm;
    }
    public void executeSort(int[] thousand, int[] tenThousand, int[] hundredThousand, boolean isAlreadySorted) {
        //strategy.sort(ten);
        //printer.printArr(ten, strategy);
        ElapsedTimeCounter.count(strategy, thousand, isAlreadySorted);
        ElapsedTimeCounter.count(strategy, tenThousand, isAlreadySorted);
        ElapsedTimeCounter.count(strategy, hundredThousand, isAlreadySorted);
    }
    public void executeSort(int[] ten, int[] thousand, int[] tenThousand, int[] hundredThousand, boolean isAlreadySorted) {
        //strategy.sort(ten);
        //printer.printArr(ten, strategy);
        ElapsedTimeCounter.count(strategy, thousand, isAlreadySorted);
        ElapsedTimeCounter.count(strategy, tenThousand, isAlreadySorted);
        ElapsedTimeCounter.count(strategy, hundredThousand, isAlreadySorted);
    }

    public void executeSort(int[] hundredThousand, int[] million, boolean isAlreadySorted) {
        ElapsedTimeCounter.count(strategy, hundredThousand, isAlreadySorted);
        ElapsedTimeCounter.count(strategy, million, isAlreadySorted);
    }
}
