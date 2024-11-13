public class Main {
    public static void main(String[] args) {
        // Создаем группы потоков
        ThreadGroup G1 = new ThreadGroup("G1"), G2 = new ThreadGroup("G2");
        ThreadGroup G3 = new ThreadGroup(G1, "G3");

        // Создаем потоки с переопределенным методом run()
        Thread ThA = new MyThread(G1, "ThA");
        Thread Thf = new MyThread(G3, "Thf");
        Thread Thb = new MyThread(G3, "Thb");
        Thread Thc = new MyThread(G3, "Thc");
        Thread Thd = new MyThread(G3, "Thd");
        Thread Th8 = new MyThread(G2, "Th8");
        Thread Th9 = new MyThread(G2, "Th9");
        Thread Th3 = new MyThread(G2, "Th3");
        Thread Th1 = new MyThread("Th1");
        Thread Th2 = new MyThread("Th2");

        // Задаем приоритеты потокам
        Thf.setPriority(3);
        Thb.setPriority(7);
        Thc.setPriority(3);
        Thd.setPriority(3);
        ThA.setPriority(3);
        Th8.setPriority(3);
        Th9.setPriority(4);
        Th3.setPriority(3);
        Th1.setPriority(3);
        Th2.setPriority(3);

        // Запускаем потоки
        ThA.start();
        Thf.start();
        Thb.start();
        Thc.start();
        Thd.start();
        Th8.start();
        Th9.start();
        Th3.start();
        Th1.start();
        Th2.start();

        // Логика вывода информации по группам
        String delimiter = "---------------------------------------------------------------------------\n";
        System.out.println("G1 Group: ");
        G1.list();
        System.out.println(delimiter + "G2 Group: ");
        G2.list();
        System.out.println(delimiter + "G3 Group: ");
        G3.list();
        System.out.println(delimiter + "Main Group: ");
        ThreadGroup sys = Thread.currentThread().getThreadGroup();
        sys.list();
    }
}

// Класс, представляющий поток
class MyThread extends Thread {
    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        // Логика работы потока
        try {
            // Поток работает в течение 1 секунды
            Thread.sleep(1000);
            System.out.println(getName() + " завершен.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}