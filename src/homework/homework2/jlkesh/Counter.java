package homework.homework2.jlkesh;

public class Counter {
    private int sum = 0;

    // synch method
    public synchronized void increment(){
        sum++;
    }

    // synch blok
    public void incrementBlock(){
        synchronized (this){
            sum++;
        }
    }

    public int getSum(){
        return sum;
    }
}
