public class ThreadGroupExample {

    public static void main(String[] args) {
        // Создаем основную группу потоков Main
        ThreadGroup mainGroup = new ThreadGroup("Main");
        Thread th1 = new Thread(mainGroup, new SimpleTask(), "Th1");
        th1.setPriority(3);
        Thread th2 = new Thread(mainGroup, new SimpleTask(), "Th2");
        th2.setPriority(6);

        // Создаем группу G2 внутри Main
        ThreadGroup g2 = new ThreadGroup(mainGroup, "G2");

        // Создаем группу G1 внутри G2
        ThreadGroup g1 = new ThreadGroup(g2, "G1");

        // Создаем потоки в группе G1 с приоритетами, как указано в схеме
        Thread tha = new Thread(g1, new SimpleTask(), "Tha");
        tha.setPriority(1);

        Thread thb = new Thread(g1, new SimpleTask(), "Thb");
        thb.setPriority(3);

        Thread thd = new Thread(g1, new SimpleTask(), "Thd");
        thd.setPriority(3);

        Thread thc = new Thread(g1, new SimpleTask(), "Thc");
        thc.setPriority(8);

        // Создаем поток ThA в группе G2
        Thread tha2 = new Thread(g2, new SimpleTask(), "ThA");
        tha2.setPriority(1);

        // Создаем группу G3 внутри Main
        ThreadGroup g3 = new ThreadGroup(mainGroup, "G3");

        // Создаем потоки в группе G3 с приоритетами, как указано в схеме
        Thread th1_g3 = new Thread(g3, new SimpleTask(), "Th1");
        th1_g3.setPriority(4);

        Thread th2_g3 = new Thread(g3, new SimpleTask(), "Th2");
        th2_g3.setPriority(3);

        Thread th3_g3 = new Thread(g3, new SimpleTask(), "Th3");
        th3_g3.setPriority(5);

        // Запускаем все потоки
        tha.start();
        thb.start();
        thd.start();
        thc.start();
        tha2.start();
        th1_g3.start();
        th2_g3.start();
        th3_g3.start();
        th1.start();
        th2.start();

        // Выводим иерархическую информацию по группам и потокам
        System.out.println("=== Иерархия групп и потоков с помощью list() ===");
        mainGroup.list(); // Использование list() для вывода структуры

        // Рекурсивный вывод дополнительной информации о группах и потоках
        System.out.println("\n=== Рекурсивный вывод информации о группах и потоках ===");
        printGroupInfo(mainGroup);
    }

    // Метод для рекурсивного вывода информации о группах и потоках
    public static void printGroupInfo(ThreadGroup group) {
        System.out.println("Группа: " + group.getName());
        System.out.println("  Родительская группа: " + (group.getParent() != null ? group.getParent().getName() : "нет"));
        System.out.println("  Количество активных потоков: " + group.activeCount());
        System.out.println("  Количество подгрупп: " + group.activeGroupCount());

        // Получаем потоки в группе
        Thread[] threads = new Thread[group.activeCount()];
        int threadCount = group.enumerate(threads, false);
        for (int i = 0; i < threadCount; i++) {
            Thread t = threads[i];
            System.out.println("Имя потока: " + t.getName());
            System.out.println("Группа потока: " + t.getThreadGroup().getName());
            System.out.println("Приоритет потока: " + t.getPriority());
            System.out.println("---------------");
        }

        // Получаем подгруппы и вызываем метод рекурсивно
        ThreadGroup[] subGroups = new ThreadGroup[group.activeGroupCount()];
        int groupCount = group.enumerate(subGroups, false);
        for (int i = 0; i < groupCount; i++) {
            System.out.println();
            printGroupInfo(subGroups[i]);
        }
    }

    // Простой класс задачи для потоков
    static class SimpleTask implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(100); // Простая пауза для демонстрации работы потоков
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " завершен.");
        }
    }
}