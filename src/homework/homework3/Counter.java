package homework.homework3;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger sum = new AtomicInteger(0);

    public void Counter(){
        sum.incrementAndGet(); // atomic tarzda 1ga oshiradi
    }

    public int getSum(){
        return sum.get();
    }

    // atomic ishlatilingan uchun setter ishlatish kerak emas
}
