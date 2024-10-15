public class threadOne extends Thread{
    int[] mass;
    public void setMassive(int[] inputMass,int start, int stop){
        mass=new int[stop-start];
        System.arraycopy(inputMass, start, this.mass, 0, stop-start);
    }
    @Override
    public void run(){
        try {
            Thread.sleep(0);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }


        int n = mass.length;
        boolean swapped;


        for (int i = 0; i < n - 1; i++) {
            swapped = false;


            for (int j = 0; j < n - 1 - i; j++) {

                if (mass[j] > mass[j + 1]) {

                    int temp = mass[j];
                    mass[j] = mass[j + 1];
                    mass[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        System.out.println("\nsorted numbers from thread:");
        for (int number : mass) {
            System.out.print(number + " ");
        }


    }
}
