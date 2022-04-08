package com.company.Utils;

import java.util.stream.IntStream;

public class ArraysUtil {
    private ArraysUtil() {
        throw new AssertionError();
    }

    public static void fillArrayWithRandomValues(int[] arr) {
        IntStream.range(0, arr.length)
                .forEach(i -> arr[i] = (int) Math.round((Math.random() * 40) - 20));
    }

    public static void fillArrayWithConsistentValues(int[] arr) {
        IntStream.range(0, arr.length)
                .forEach(i -> arr[i] = i + 1);
    }
}
