import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final List<Thread> threads = new ArrayList<>(); // Храним ссылки на потоки для запуска

    public static void main(String[] args) {

        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();

        ThreadGroup groupGE = new ThreadGroup(mainGroup, "GE");

        ThreadGroup groupGH = new ThreadGroup(groupGE, "GH");

        ThreadGroup groupGK = new ThreadGroup(mainGroup, "GK");


        threads.add(createThread(groupGH, "Tha", 4));
        threads.add(createThread(groupGH, "Thb", 3));
        threads.add(createThread(groupGH, "Thc", 2));
        threads.add(createThread(groupGH, "Thd", 1));

        threads.add(createThread(groupGE, "ThA", 3));

        threads.add(createThread(groupGK, "GK-Th1", 3));
        threads.add(createThread(groupGK, "GK-Th2", 6));
        threads.add(createThread(groupGK, "GK-Th3", 3));

        threads.add(createThread(mainGroup, "Th1", 3));
        threads.add(createThread(mainGroup, "Th2", 7));

        startAllThreads();

        printGroupInfo(mainGroup);

        mainGroup.list();
    }


    private static Thread createThread(ThreadGroup group, String name, int priority) {
        Thread thread = new Thread(group, () -> {
            try {
                Thread.sleep(1000); // Задержка для демонстрации активности потока
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, name);
        thread.setPriority(priority);
        return thread;
    }


    private static void startAllThreads() {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    private static void printThreadInfo(Thread thread) {
        System.out.println("Имя потока: " + thread.getName());
        System.out.println("Группа потока: " + thread.getThreadGroup().getName());
        System.out.println("Приоритет потока: " + thread.getPriority());
        System.out.println("---------------");
    }


    private static void printGroupInfo(ThreadGroup group) {
        System.out.println("Группа: " + group.getName());
        System.out.println("  Родительская группа: " + (group.getParent() != null ? group.getParent().getName() : "нет"));
        System.out.println("  Количество активных потоков: " + group.activeCount());
        System.out.println("  Количество подгрупп: " + group.activeGroupCount());

        Thread[] threadsInGroup = new Thread[group.activeCount() + 10]; // с запасом
        int numThreads = group.enumerate(threadsInGroup, false);
        for (int i = 0; i < numThreads; i++) {
            printThreadInfo(threadsInGroup[i]);
        }

        ThreadGroup[] subGroups = new ThreadGroup[group.activeGroupCount()];
        int numGroups = group.enumerate(subGroups, false);
        for (int i = 0; i < numGroups; i++) {
            printGroupInfo(subGroups[i]);
        }
    }
}