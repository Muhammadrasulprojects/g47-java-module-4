package homework.homework2.jlkesh;

public class CounterVolatile {
    private volatile int sum = 0; // volatile field

    public synchronized void increment(){
       sum++;
    }

    public int getSum(){
        return sum;
    }
}
