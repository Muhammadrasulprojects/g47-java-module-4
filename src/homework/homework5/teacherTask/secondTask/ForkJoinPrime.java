package homework.homework5.teacherTask.secondTask;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinPrime {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        List<Integer> primes = pool.invoke(new PrimeTask(1, 1_000_000));
        System.out.println("primes.size() = " + primes.size());
    }
}
