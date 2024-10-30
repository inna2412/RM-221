public class Main {

    public static void main(String[] args) {
        // Создаем основную группу потоков
        ThreadGroup mainGroup = new ThreadGroup("Main");
        ThreadGroup groupG7 = new ThreadGroup(mainGroup, "G7");
        ThreadGroup groupG3 = new ThreadGroup(groupG7, "G3");
        ThreadGroup groupG2 = new ThreadGroup(mainGroup, "G2");

        groupG3.setMaxPriority(7);
        groupG2.setMaxPriority(7);

        Thread[] threads = {
                createAndStart(groupG3, "Tha", 6),
                createAndStart(groupG3, "Thb", 3),
                createAndStart(groupG3, "Thc", 6),
                createAndStart(groupG3, "Thd", 3),
                createAndStart(groupG7, "ThA", 7),
                createAndStart(mainGroup, "Th1", 6),
                createAndStart(mainGroup, "Th2", 3),
                createAndStartDaemon(groupG2, "Th1", 7),
                createAndStartDaemon(groupG2, "Th2", 3),
                createAndStartDaemon(groupG2, "Th3", 3)
        };

        System.out.println("Информация о группах и потоках:");
        mainGroup.list();
        System.out.println("Количество живых групп в группе: " + mainGroup.activeGroupCount());
        System.out.println("Максимальный приоритет для нитей в группе Main: " + mainGroup.getMaxPriority());
        System.out.println("Максимальный приоритет для нитей в группе G7: " + groupG7.getMaxPriority());
        System.out.println("Максимальный приоритет для нитей в группе G3: " + groupG3.getMaxPriority());
        System.out.println("Максимальный приоритет для нитей в группе G2: " + groupG2.getMaxPriority());

        for (Thread thread : threads) {
            if (thread != null && !thread.isDaemon()) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

    }

    private static Thread createAndStart(ThreadGroup group, String name, int priority) {
        Thread thread = new Thread(group, () -> {
            System.out.println("Поток: " + name + ", Группа: "
                    + Thread.currentThread().getThreadGroup().getName() +
                    ", Приоритет: " + Thread.currentThread().getPriority());
        }, name);
        thread.setPriority(priority);
        thread.start();
        return thread;
    }

    private static Thread createAndStartDaemon(ThreadGroup group, String name, int priority) {
        Thread thread = new Thread(group, () -> {
            while (true) {
                System.out.println("Демон поток: " + name + ", Группа: "
                        + Thread.currentThread().getThreadGroup().getName() +
                        ", Приоритет: " + Thread.currentThread().getPriority());
            }
        }, name);
        thread.setPriority(priority);
        thread.setDaemon(true);
        thread.start();
        return thread;
    }
}
