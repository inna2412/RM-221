class Dollar implements Runnable{
    double value;

    public Dollar(double value){
        this.value = value;
    }
    @Override
    public void run(){
        for(int i = 0; i < 2; i++){
            try {
                System.out.println(Thread.currentThread().getName() + " Конвертируем леи в доллары...");
                Thread.sleep(1000);
            }catch(InterruptedException ignored){}
        }
        System.out.println(value + " MDL = " + (value/17.59) + " USD");
    }
}