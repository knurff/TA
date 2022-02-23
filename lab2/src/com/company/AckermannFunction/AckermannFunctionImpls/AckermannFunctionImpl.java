package com.company.AckermannFunction.AckermannFunctionImpls;

import com.company.AckermannFunction.AckermannFunction;

public class AckermannFunctionImpl implements AckermannFunction {
    @Override
    public int count(int m, int n) {
        if (m == 0) return n + 1;
        if (m > 0 & n == 0) return count(m - 1, 1);
        return count(m - 1, count(m, n - 1));
    }
}
