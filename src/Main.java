public class Main {
    public static void main(String[] args) {
        int a = 674;
        int b = 462;

        // Потока для подсчета шагов 
        CounterThread counterThread = new CounterThread(a, b);
        Thread thread1 = new Thread(counterThread);
        thread1.start();

        //  Потока для умножения чисел
        MultiplyThread multiplyThread = new MultiplyThread(a, b);
        Thread thread2 = new Thread(multiplyThread);
        thread2.start();

    }
}
