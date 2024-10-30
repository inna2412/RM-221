import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] mas = new int[10];
        Random rand = new Random();
        for (int i = 0; i < mas.length; i++) {
            mas[i] = rand.nextInt(100) + 1;
        }

        System.out.println("Generated random numbers: " + Arrays.toString(mas));

        double a = 2.5;
        double b = 1.7;
        double formulaC = -3.0;

        Thread calculationThread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " started.");
                for (int value : mas) {
                    double result = a * Math.pow(value, 2) + b * value + formulaC;
                    System.out.println(Thread.currentThread().getName() + ": For x = " + value + ": f(x) = " + result);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " finished.");
            }
        }, "CalculationThread1");

        Thread calculationThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " started.");
                for (int value : mas) {
                    double result = a * Math.pow(value, 2) + b * value + formulaC;
                    System.out.println(Thread.currentThread().getName() + ": For x = " + value + ": f(x) = " + result);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " finished.");
            }
        }, "CalculationThread2");

        calculationThread1.start();
        calculationThread2.start();

        calculationThread1.join();
        calculationThread2.join();

        System.out.println("\nProgram finished.");
    }
}
