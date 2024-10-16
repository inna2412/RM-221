public class FormulaCalculator implements Runnable {
    private final double number1;
    private final double number2;

    // Конструктор для инициализации чисел
    public FormulaCalculator(double number1, double number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    @Override
    public void run() {
        // Формула: (число1^2 * cos(число2)) + ln(число1 + число2)
        double part1 = Math.pow(number1, 2) * Math.cos(number2);
        double part2 = Math.log(number1 + number2);
        double result = part1 + part2;

        String formula = String.format("(%.2f^2 * cos(%.2f)) + ln(%.2f + %.2f)", number1, number2, number1, number2);

        System.out.println("Вычисляю формулу: " + formula);
        System.out.println("Результирую вычисления: " + result);
    }
}




