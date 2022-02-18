package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Combinator {
    private Object[] elements;
    private int k;
    private final ArrayList<Object> combinations = new ArrayList<>();

    public Combinator(Object[] elements, int k) {
        this.elements = elements;
        this.k = k;
    }


    public Combinator(int N, int k) {
        int[] ints = new int[N];
        for (int i = 1; i <= N; i++) {
            ints[i - 1] = i;
        }
        this.elements = Arrays.stream(ints)
                .boxed()
                .toArray();
        this.k = k;
    }

    public Combinator() {
    }

    public void setElements(Object[] elements) {
        this.elements = elements;
    }

    public void setElements(int N) {
        int[] ints = new int[N];
        for (int i = 1; i <= N; i++) {
            ints[i - 1] = i;
        }
        this.elements = Arrays.stream(ints)
                .boxed()
                .toArray();
    }

    public Object[] getElements() {
        return elements;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public ArrayList<Object> generateSubsets() {
        subsetGenerator(this.elements, k, 0, new Object[k]);
        return this.combinations;
    }

    public ArrayList<Object> generateSubsets(int k) {
        setK(k);
        subsetGenerator(this.elements, k, 0, new Object[k]);
        return this.combinations;
    }

    public ArrayList<Object> generateSubsets(int N, int k) {
        setElements(N);
        setK(k);
        this.subsetGenerator(this.elements, k, 0, new Object[k]);
        return this.combinations;
    }

    public void subsetGenerator(Object[] arr, int k, int start, Object[] result) {
        if (k == 0) {
            this.combinations.add(Arrays.copyOf(result, result.length));
            return;
        }
        for (int i = start; i <= arr.length - k; i++) {
            result[result.length - k] = arr[i];
            subsetGenerator(arr, k - 1, i + 1, result);
        }
    }
}
