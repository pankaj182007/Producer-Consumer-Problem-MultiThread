public class Consumer extends Thread{

    Company c;
    public Consumer(Company c)
    {
        this.c=c;
    }

    public void run() {
        while (true)
        {
            try {
                c.consumeItem();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
