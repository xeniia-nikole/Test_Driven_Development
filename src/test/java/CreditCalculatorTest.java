import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class CreditCalculatorTest {
    Random random = new Random();
    final int creditSum = random.nextInt();

    final int PERIODLOW = 30;
    final int PERIODHIGH = 2190;

    final double PERCENTLOW = 5.0;
    final double PERCENTHIGH = 9.7;



    @Test
    public void testCalculateMonthlyPayment(){
        CreditCalculator creditCalculator = new CreditCalculator();
        double creditPercent = PERCENTLOW+(PERCENTHIGH-PERCENTLOW)*random.nextDouble();
        int creditPeriod = random.nextInt(PERIODHIGH-PERIODLOW)+PERIODLOW;

        double monthPaymentSum =
                creditCalculator.CalculateMonthlyPayment(creditSum, creditPeriod, creditPercent);

        double expected = creditSum*(creditPercent+(creditPercent/(1+creditPercent)*creditPeriod-1));

        Assertions.assertEquals(expected,monthPaymentSum);

    }

    @Test
    public void testCalculateRefundAmount(){
        CreditCalculator creditCalculator = new CreditCalculator();
        double monthPaymentSum = random.nextDouble();
        int creditPeriod = random.nextInt(PERIODHIGH-PERIODLOW)+PERIODLOW;

        double refundAmount =
                creditCalculator.CalculateRefundAmount(creditPeriod, monthPaymentSum);

        double expected = creditPeriod*monthPaymentSum;

        Assertions.assertEquals(expected,refundAmount);
    }

    @Test
    public void testCalculateOverpayment(){
        CreditCalculator creditCalculator = new CreditCalculator();
        double refundAmount = random.nextDouble();

        double overpayment = creditCalculator.CalculateOverpayment(refundAmount, creditSum);

        double expected = refundAmount - creditSum;

        Assertions.assertEquals(expected,overpayment);
    }
}