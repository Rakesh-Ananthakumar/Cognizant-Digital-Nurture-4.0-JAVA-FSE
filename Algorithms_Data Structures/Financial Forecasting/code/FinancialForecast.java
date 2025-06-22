public class FinancialForecast {
    public static double futureValue(int year, double initialValue, double growthRate) {
        if (year == 0) {
            return initialValue;
        }
        return futureValue(year - 1, initialValue, growthRate) * (1 + growthRate);
    }

    public static void main(String[] args) {
        double initialInvestment = 10000.0;
        double annualGrowthRate = 0.07; 
        int targetYear = 10;     

        double result = futureValue(targetYear, initialInvestment, annualGrowthRate);
        System.out.printf("Future Value after %d years: ₹%.2f%n", targetYear, result);
    }
}
