public class CreditCalculator {


    public double CalculateMonthlyPayment(int creditSum, int creditPeriod, double creditPercent) {
        return creditSum * (creditPercent + (creditPercent / (1 + creditPercent) * creditPeriod - 1));
    }


    public double CalculateRefundAmount(int creditPeriod, double monthPaymentSum) {
        return creditPeriod * monthPaymentSum;
    }


    public double CalculateOverpayment(double refundAmount, int creditSum) {
        return refundAmount - creditSum;
    }
}
