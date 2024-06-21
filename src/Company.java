public class Company {

    int n;

    // for inter thread communication
    boolean f=false;
//f=false then chance is to run producer
//f=true then chance is to run consumer
    synchronized public void produceItem( int n) throws InterruptedException {
        if(f)
        {
            wait();
        }
        this.n=n;
        System.out.println("Produced : "+this.n);
        f=true;
        notify();
    }

    synchronized public int consumeItem() throws InterruptedException {
        if(!f)
        {
            wait();
        }
        System.out.println("Consumed : "+this.n);
        f=false;
        notify();
        return n;

    }
}
