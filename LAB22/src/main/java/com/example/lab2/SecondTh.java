package com.example.lab2;

public class SecondTh implements Runnable {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Second Th");
        }
    }
}
