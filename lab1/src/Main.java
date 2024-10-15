


public class Main {
    public static void main(String[] args) {

        int[] numbers = {10,5,3,6,7,11,30,2,99,1,3};
        threadOne[] someThreads= new threadOne[2];
        someThreads[0]= new threadOne();
        someThreads[1]= new threadOne();

        System.out.println("numbers array:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }


         someThreads[0].setMassive(numbers,0,numbers.length/2);
         someThreads[1].setMassive(numbers,numbers.length/2,numbers.length);




        threadConnect anotherSomeThread= new threadConnect(someThreads);
        for (threadOne someThread:someThreads) {
            someThread.start();
            try {

                Thread.sleep(10);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        anotherSomeThread.readMassive(numbers);
        anotherSomeThread.start();


        try {

            anotherSomeThread.join();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        numbers=anotherSomeThread.returnMassive();
        System.out.println("\nnumbers array sorted:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }

    }
}