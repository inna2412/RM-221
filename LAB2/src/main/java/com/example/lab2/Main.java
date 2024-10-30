package com.example.lab2;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {

    }

    public static void main(String[] args) {
        FirstTh firstTh = new FirstTh();

        ThreadGroup mainGroup = new ThreadGroup("Main Group");
        Thread th1 = new Thread(mainGroup, firstTh, "Th1");
        th1.setPriority(8);
        th1.setDaemon(true);
        Thread th2 = new Thread(mainGroup, firstTh, "Th2");
        th2.setPriority(2);
        th2.setDaemon(true);

        ThreadGroup gn = new ThreadGroup(mainGroup, "GN");
        Thread thA = new Thread(gn, firstTh, "ThA");
        thA.setPriority(3);
        thA.setDaemon(true);
        ThreadGroup gm = new ThreadGroup(mainGroup, "GM");
        Thread th11 = new Thread(gm, firstTh, "Th1");
        th11.setPriority(2);
        th11.setDaemon(true);
        Thread th12 = new Thread(gm, firstTh, "Th2");
        th12.setPriority(3);
        th12.setDaemon(true);
        Thread th13 = new Thread(gm, firstTh, "Th3");
        th13.setPriority(3);
        th13.setDaemon(true);

        ThreadGroup gh = new ThreadGroup(gn, "GH");
        Thread tha = new Thread(gh, firstTh, "Tha");
        tha.setPriority(4);
        tha.setDaemon(true);
        Thread thb = new Thread(gh, firstTh, "Thb");
        thb.setPriority(3);
        thb.setDaemon(true);
        Thread thc = new Thread(gh, firstTh, "Thc");
        thc.setPriority(6);
        thc.setDaemon(true);
        Thread thd = new Thread(gh, firstTh, "Thd");
        thd.setPriority(3);
        thd.setDaemon(true);

        System.out.println("\nAll threads starting:");
        th1.start();
        th2.start();
        thA.start();
        tha.start();
        thb.start();
        thc.start();
        thd.start();
        th11.start();
        th12.start();
        th13.start();

        printThreadGroupInfo(mainGroup, 0);

        System.out.println("завершение таска");

    }


    public static void printThreadGroupInfo(ThreadGroup group, int level) {

        printIndent(level);
        System.out.println("ThreadGroup[name=" + group.getName() + ",maxpri=" + group.getMaxPriority() + "]");

        group.list();
    }

    public static void printIndent(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
    }
}
