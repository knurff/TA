package com.company.Utils.TimerHelper;

import com.company.Lists.List;


public class TimerHelper {

    private TimerHelper() {
        throw new AssertionError();
    }


    public static void fillListFront(List<Integer> list, int n) {
        while (n > 0) {
            list.add(0, (int) Math.round((Math.random() * 40) - 20));
            n--;
        }
    }

    public static void dellListFront(List<Integer> list) {
        while (!list.isEmpty()) {
            list.remove(0);
        }
    }

    public static void fillListEnd(List<Integer> list, int n) {
        for (int i = 0; i < n; i++) {
            list.add(i, (int) Math.round((Math.random() * 40) - 20));
        }
    }

    public static void dellListEnd(List<Integer> list) {
        while (!list.isEmpty()) {
            list.remove(list.size() - 1);
        }
    }

    public static void fillListAGN(List<Integer> list, int n) {
        for (int i = 0; i < n; i++) {
            list.add(i / 2, (int) Math.round((Math.random() * 40) - 20));
        }
    }

    public static void dellListAGN(List<Integer> list) {
        while (!list.isEmpty()) {
            list.remove((list.size() - 1) / 2);
        }
    }

    public static int indexingPrepare(List<Integer> list1, List<Integer> list2) {
        int searchValue = (int) Math.round((Math.random() * 70) + 30);
        if (!list1.contains(searchValue) && !list2.contains(searchValue)) {
            int index = (int) Math.round(Math.random() * (list1.size()));
            list1.add(index, searchValue);
            list2.add(index, searchValue);
            return searchValue;
        } else return Integer.MIN_VALUE;
    }

    public static void indexing(List<Integer> list, int searchValue, int n) {
        int index = list.getByValue(searchValue);
        int previous = index;
        for (int i = 0; i < n - 1 && index == previous; i++) {
            previous = list.getByValue(searchValue);
        }
    }
}
