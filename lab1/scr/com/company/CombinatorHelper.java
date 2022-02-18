package com.company;

import java.util.Arrays;
import java.util.List;

public class CombinatorHelper {

    public static String toString(List<Object> list) {
        if (list.size() == 0) {
            return "{}";
        }
        StringBuilder res = new StringBuilder();
        res.append('{');
        for (Object j : list) {
            res.append(Arrays.toString((Object[]) j));
            res.append(", ");
        }
        return res.replace(res.length() - 2, res.length(), "").append('}').toString();
    }
}
