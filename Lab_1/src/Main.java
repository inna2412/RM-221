

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int size = 10;

        int[] numbers = new int[size];
        Random random = new Random();


        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt(10) + 1; // Случайные числа от 1 до 10
        }


        Thread[] threads = new Thread[size];

        for (int i = 0; i < numbers.length; i++) {
            threads[i] = new Thread(new NumberSquare(numbers[i]));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Все вычисления завершены.");
    }
}

class NumberSquare extends Thread {
    private final int number;

    public NumberSquare(int number) {
        this.number = number;
    }


    public void run() {
        int square = number * number;
        System.out.println("Квадрат числа " + number + " равен " + square + "name : " + getName());
    }
}