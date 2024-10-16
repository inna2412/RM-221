import java.util.Scanner;

public class Main {
    // Курсы валют
    private static final double USD_TO_EUR = 0.92;
    private static final double USD_TO_MDL = 17.59;
    private static final double EUR_TO_USD = 1.09;
    private static final double EUR_TO_MDL = 19.27;
    private static final double MDL_TO_USD = 0.057;
    private static final double MDL_TO_EUR = 0.052;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Выбор валюты для конвертации
        System.out.println("Выберите валюту для конвертации:");
        System.out.println("1 - USD");
        System.out.println("2 - EUR");
        System.out.println("3 - MDL");
        int fromCurrency = scanner.nextInt();

        System.out.println("Выберите валюту, в которую хотите перевести:");
        System.out.println("1 - USD");
        System.out.println("2 - EUR");
        System.out.println("3 - MDL");
        int toCurrency = scanner.nextInt();

        // Ввод суммы
        System.out.println("Введите сумму для конвертации:");
        double amount = scanner.nextDouble();

        // Создаем и запускаем поток для конвертации валют
        CurrencyConverterTask conversionTask = new CurrencyConverterTask(fromCurrency, toCurrency, amount);
        Thread conversionThread = new Thread(conversionTask);
        conversionThread.start();

        // Запускаем поток для отслеживания дедлайна
        DeadlineTask deadlineTask = new DeadlineTask(conversionThread, 3000); // 3 секунды дедлайн
        Thread deadlineThread = new Thread(deadlineTask);
        deadlineThread.start();

        // Ожидание завершения потока конвертации
        try {
            conversionThread.join();  // Ожидаем завершения потока конвертации
            deadlineThread.join();    // Ожидаем завершения потока дедлайна
        } catch (InterruptedException e) {
            System.out.println("Произошло прерывание потока.");
        }
    }

    // Класс задачи для конвертации валют
    static class CurrencyConverterTask implements Runnable {
        private int fromCurrency;
        private int toCurrency;
        private double amount;

        public CurrencyConverterTask(int fromCurrency, int toCurrency, double amount) {
            this.fromCurrency = fromCurrency;
            this.toCurrency = toCurrency;
            this.amount = amount;
        }

        @Override
        public void run() {
            double result = convertCurrency(fromCurrency, toCurrency, amount);
            if (result != 0) {
                System.out.println("Результат конвертации: " + result);
            } else {
                System.out.println("Ошибка при конвертации.");
            }
        }

                                                                                                              // Метод для конвертации валют
        private double convertCurrency(int fromCurrency, int toCurrency, double amount) {
            double conversionRate = 1.0;

                                                                                                       // Определяем курс в зависимости от выбранных валют
            if (fromCurrency == 1 && toCurrency == 2) {  // USD -> EUR
                conversionRate = USD_TO_EUR;
            } else if (fromCurrency == 1 && toCurrency == 3) {  // USD -> MDL
                conversionRate = USD_TO_MDL;
            } else if (fromCurrency == 2 && toCurrency == 1) {  // EUR -> USD
                conversionRate = EUR_TO_USD;
            } else if (fromCurrency == 2 && toCurrency == 3) {  // EUR -> MDL
                conversionRate = EUR_TO_MDL;
            } else if (fromCurrency == 3 && toCurrency == 1) {  // MDL -> USD
                conversionRate = MDL_TO_USD;
            } else if (fromCurrency == 3 && toCurrency == 2) {  // MDL -> EUR
                conversionRate = MDL_TO_EUR;
            } else if (fromCurrency == toCurrency) {  // Конвертация в ту же валюту
                conversionRate = 1.0;
            } else {
                System.out.println("Некорректный выбор валют.");
                return 0;
            }

            try {
                                                                                      // Имитируем задержку выполнения (100 мс для демонстрации дедлайна)
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Процесс конвертации был прерван.");
                return 0;
            }

            return amount * conversionRate;
        }
    }

                                                                                            // Класс задачи для отслеживания дедлайна
    static class DeadlineTask implements Runnable {
        private Thread taskThread;
        private long deadlineMillis;

        public DeadlineTask(Thread taskThread, long deadlineMillis) {
            this.taskThread = taskThread;
            this.deadlineMillis = deadlineMillis;

        }

        @Override
        public void run() {
            try {
                System.out.println("Имя потока" +Thread.currentThread().getName());
                Thread.sleep(deadlineMillis);
                if (taskThread.isAlive()) {                                                               // Проверяем, завершился ли поток конвертации
                    System.out.println("Дедлайн истек. Конвертация не выполнена вовремя.");
                    taskThread.interrupt();                                                                      // Прерываем поток, если дедлайн истек
                }
            } catch (InterruptedException e) {
                System.out.println("Поток дедлайна был прерван.");
            }
        }
    }
}
