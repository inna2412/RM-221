import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double leu=0;
        Scanner sc = new Scanner(System.in);
        while(leu>=0){
            System.out.print("Введите сумму в леях:");
            leu = Double.parseDouble(sc.nextLine());
            Euro EUR = new Euro(leu);
            Thread USD = new Thread(new Dollar(leu));
            EUR.start();
            USD.start();
            while (EUR.isAlive() || USD.isAlive())
            {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

