package com.company.inventory;

public class ForecastDemo {
    public static void main(String[] args) {
        double presentValue = 10000;    // ₹10,000
        double growthRate = 0.08;       // 8% annual growth
        int years = 5;

        double futureValue = FinancialForecaster.forecastValue(presentValue, growthRate, years);
        System.out.printf("Future Value after %d years (recursive): ₹%.2f%n", years, futureValue);

        double[] memo = new double[years + 1];
        double futureValueMemo = FinancialForecaster.forecastMemo(presentValue, growthRate, years, memo);
        System.out.printf("Future Value after %d years (memoized): ₹%.2f%n", years, futureValueMemo);
    }
}
