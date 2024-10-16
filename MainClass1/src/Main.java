public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Значения для первой формулы
        double number1 = 5.0;
        double number2 = 14.0;

        // Значения для второй формулы
        double number3 = 23.0;
        double number4 = 60.0;

        // Создаем и запускаем первый поток
        Runnable calculator1 = new FormulaCalculator(number1, number2);
        Thread thread1 = new Thread(calculator1);
        thread1.start();


        Runnable calculator2 = new FormulaCalculator2(number3, number4);
        Thread thread2 = new Thread(calculator2);
        thread2.start();
        
        thread1.join();
        thread2.join();

        System.out.println("Главный поток завершен.");
    }
}


