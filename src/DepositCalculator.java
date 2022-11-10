import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        new DepositCalculator().settlementDeposit();
    }

    double calculateComplexPercent(double amount, double yearRate, int period) {
        double payment = amount * Math.pow((1 + yearRate / 12), 12 * period);
        return calculationProfit(payment, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int period) {
        return calculationProfit(amount + amount * yearRate * period, 2);
    }

    double calculationProfit(double payment, int trustLevel) {
        double levelService = Math.pow(10, trustLevel);
        return Math.round(payment * levelService) / levelService;
    }

    void settlementDeposit() {
        int period, depositType;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();
        double profit = 0;
        if (depositType == 1) {
            profit = calculateSimplePercent(amount, 0.06, period);
        } else if (depositType == 2) {
            profit = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + profit);
    }
}
