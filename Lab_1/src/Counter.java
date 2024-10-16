public class Counter extends Thread {
    private int start;
    private int stop;
    private int pass;
    String id;

    public Counter(int start, int stop, int pass, String id)
    {
        this.start = start;
        this.stop = stop;
        this.pass = pass;
        this.id = id;
    }

    public void run()
    {
        for (int i = start; i <= stop; i+=pass)
        {
            System.out.println(id + "\t" + i);
        }
    }
}
