public class Main {
    public static void main(String[] args) {

        CurrencyConverter currencyConverter = new CurrencyConverter();
        Thread currencyConverterThread = new Thread(currencyConverter);

        FileProcessor fileProcessorThread = new FileProcessor("C:/Users/nikol/Desktop/Универ/Лабораторные/Третий курс/I-СЕМЕСТР/PCD/Lab№1/Lab№1/lab1/src/input.txt");

        /*currencyConverterThread.setPriority(Thread.MAX_PRIORITY);
        fileProcessorThread.setPriority(Thread.MIN_PRIORITY);*/

        currencyConverterThread.start();

        try {
            currencyConverterThread.join();
            System.out.println("Первый поток завершен. Запускаем второй поток.");

            fileProcessorThread.start();
            fileProcessorThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Все операции завершены.");
    }
}
