import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter implements Runnable {
    private static final HashMap<String, Double> exchangeRates = new HashMap<>();

    static {
        exchangeRates.put("USD", 0.056);
        exchangeRates.put("EUR", 0.052);
        exchangeRates.put("RUB", 5.73);
        exchangeRates.put("RON", 0.26);
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите сумму в MDL: ");
        double amountInMDL = scanner.nextDouble();

        System.out.print("Введите целевую валюту (USD, EUR, RUB, RON): ");
        String targetCurrency = scanner.next().toUpperCase();

        if (exchangeRates.containsKey(targetCurrency)) {
            double rate = exchangeRates.get(targetCurrency);
            double convertedAmount = convert(amountInMDL, rate);
            System.out.println(amountInMDL + " MDL = " + convertedAmount + " " + targetCurrency);
        } else {
            System.out.println("Неверная валюта.");
        }
    }

    private double convert(double amount, double rate) {
        return amount * rate;
    }
}
