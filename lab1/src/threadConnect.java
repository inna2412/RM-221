public class threadConnect extends Thread{
    private threadOne[] waiting;
    private int[][] parts=new int[2][];
    int[] mass;
    public threadConnect(threadOne[] save){
        this.waiting=save;
    }
   
    public void readMassive(int[] numbers) {
        this.mass = numbers;
    }
    public int[] returnMassive(){

        return mass;
    }

    @Override
    public void run(){
        try {
            int i=0;
            for (threadOne waitNow:waiting) {
                waitNow.join();
                parts[i]=waitNow.mass;
                i++;
            }
            Thread.sleep(0);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        int[] merged = new int[parts[0].length + parts[1].length]; // Создаем новый массив для объединения
        int i = 0; // Индекс для первого массива
        int j = 0; // Индекс для второго массива
        int k = 0; // Индекс для объединенного массива

        
        while (i < parts[0].length || j < parts[1].length) {
            if (i < parts[0].length && (j >= parts[1].length || parts[0][i] <= parts[1][j])) {
                merged[k++] = parts[0][i++]; // Добавляем элемент из первого массива
            } else {
                merged[k++] = parts[1][j++]; // Добавляем элемент из второго массива
            }
        }
    mass=merged;

    }
}
