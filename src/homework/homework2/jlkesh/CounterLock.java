package homework.homework2.jlkesh;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterLock {
    private int sum = 0;
    private final Lock lock = new ReentrantLock();

    public void increment(){
        lock.lock();
        try {
            sum++;
        } finally {
            lock.unlock();
        }
    }

    public int getSum(){
        return sum;
    }
}
