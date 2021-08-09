import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static CreditCalculator creditCalculator = new CreditCalculator();

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в приложение 'Кредитный калькулятор'\n");
        while (true) {
            System.out.println("Для завершения работы приложения введите '0'\n\n" +
                    "Для проведения рассчетов введите\n" +
                    "-- общую сумму кредита в рублях");
            int creditSum = scanner.nextInt();
            if (creditSum == 0)break;
            System.out.println("-- срок на который выдан кредит в годах:");
            int creditPeriod = scanner.nextInt();
            System.out.println("-- процентную ставку по кредиту:");
            int creditPercent = scanner.nextInt();

            System.out.println("Сумма ежемесячного платежа составит: " +
                    creditCalculator.calculateMonthlyPayment(creditSum, creditPeriod, creditPercent));
            System.out.println("Общий размер суммы выплаты банку составит: " +
                    creditCalculator.calculateRefundAmount(creditSum, creditPeriod, creditPercent));
            System.out.println("Сумма переплат составит: " +
                    creditCalculator.calculateOverpayment(creditSum, creditPeriod, creditPercent));
        }
        System.out.println("Завершение работы приложения");
    }
}