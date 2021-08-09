public class CreditCalculator {


    public int calculateMonthlyPayment(int creditSum, int creditPeriod, int creditPercent) {
        return (creditSum + (creditSum * creditPercent * creditPeriod) / 100) / (creditPeriod * 12);
    }


    public int calculateRefundAmount(int creditSum, int creditPeriod, int creditPercent) {
        return creditSum + (creditPeriod * creditPercent * creditPeriod) / 100;
    }


    public int calculateOverpayment(int creditSum, int creditPeriod, int creditPercent) {
        return (creditSum * creditPercent * creditPeriod) / 100;
    }
}
