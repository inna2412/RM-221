class Euro extends Thread{
    double value;

    public Euro(double value){
        this.value = value;
    }

    public void run(){

        for(int i = 0; i < 2; i++){
            try {
                System.out.println(getName() + " Конвертируем леи в евро...");
                Thread.sleep(1000);
            }catch(InterruptedException ignored){}
        }
        System.out.println(value + " MDL = " + (value/19.16) + " EUR");
    }
}
