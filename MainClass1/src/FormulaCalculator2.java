public class FormulaCalculator2 implements Runnable {
    private final double number1;
    private final double number2;

    public FormulaCalculator2(double number1, double number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    @Override
    public void run() {

        double part1 = Math.sqrt(number1) * Math.sin(Math.toRadians(number2));
        double part2 = Math.exp(number1 - number2);
        double result = part1 + part2;

        String formula = String.format("sqrt(%.2f) * sin(%.2f°) + exp(%.2f - %.2f)", number1, number2, number1, number2);

        System.out.println("Поток 2: Вычисляю формулу: " + formula);
        System.out.println("Поток 2: Результат вычисления: " + result);
    }
}

