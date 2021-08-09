import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class CreditCalculatorTest {
    Random random = new Random();

    final int PERIODLOW = 1;
    final int PERIODHIGH = 72;

    final int PERCENTLOW = 1;
    final int PERCENTHIGH = 9;

    final int creditSum = random.nextInt();
    final int creditPercent = random.nextInt(PERCENTHIGH-PERCENTLOW)+PERIODLOW;
    final int creditPeriod = random.nextInt(PERIODHIGH-PERIODLOW)+PERIODLOW;

    @Test
    public void testCalculateMonthlyPayment(){
        CreditCalculator creditCalculator = new CreditCalculator();

        int monthPaymentSum =
                creditCalculator.calculateMonthlyPayment(creditSum, creditPeriod, creditPercent);

        int expected = creditSum * (creditPercent+(creditPercent / (1 + creditPercent) * creditPeriod - 1));

        Assertions.assertEquals(expected,monthPaymentSum);

    }

    @Test
    public void testCalculateRefundAmount(){
        CreditCalculator creditCalculator = new CreditCalculator();

        int refundAmount =
                creditCalculator.calculateRefundAmount(creditSum, creditPeriod, creditPercent);

        int expected = creditSum + (creditPeriod * creditPercent * creditPeriod) / 100;

        Assertions.assertEquals(expected,refundAmount);
    }

    @Test
    public void testCalculateOverpayment(){
        CreditCalculator creditCalculator = new CreditCalculator();

        int overpayment = creditCalculator.calculateOverpayment(creditSum, creditPeriod, creditPercent);

        int expected = (creditSum * creditPercent * creditPeriod) / 100;

        Assertions.assertEquals(expected,overpayment);
    }
}