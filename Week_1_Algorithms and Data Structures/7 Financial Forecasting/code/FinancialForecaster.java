package com.company.inventory;

public class FinancialForecaster {

    // Recursive method to calculate future value
    public static double forecastValue(double presentValue, double growthRate, int years) {
        if (years == 0) return presentValue;
        return forecastValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    // Optimized recursive method using memoization (optional)
    public static double forecastMemo(double presentValue, double growthRate, int years, double[] memo) {
        if (years == 0) return presentValue;
        if (memo[years] != 0) return memo[years];
        memo[years] = forecastMemo(presentValue, growthRate, years - 1, memo) * (1 + growthRate);
        return memo[years];
    }
}
