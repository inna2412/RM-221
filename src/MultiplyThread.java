public class MultiplyThread implements Runnable
{
    private int a, b;

    public MultiplyThread(int a, int b) // Конструктор для передачи значений a и b
    {
        this.a = a;
        this.b = b;
    }

    // Реализуем метод run() для умножения чисел
    @Override
    public void run()
    {
        int result = a * b;  // Умножаем числа
        System.out.println("Результат умножения " + a + " и " + b + ": " + result);
    }

}
