public class CounterThread implements Runnable {

    private int a, b;

    public CounterThread(int a, int b) // конструктор для передачи значений a и b
    {
        this.a = a;
        this.b = b;
    }
    @Override
    public void run() // метод run()
    {
        int steps = Steps(a, b);  // вызываем метод для подсчета наибольшего общего делителя
        System.out.println(Thread.currentThread().getName() +" Количество шагов для нахождения НОД: " + steps);
    }

    public int Steps(int a, int b) // метод для подсчета шагов
    {
        int steps = 0;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
            steps++;
        }
        return steps;
    }
}


