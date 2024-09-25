package homework.homework5.teacherTask.secondTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class PrimeTask extends RecursiveTask<List<Integer>> {
    private static final int THRESHOLD = 10_000;
    private int start, end;

    public PrimeTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected List<Integer> compute() {
        if (end - start <= THRESHOLD){
            List<Integer> primes = new ArrayList<>();
            for (int i = start; i < end; i++) {
                if (isPrime(i)){
                    primes.add(i);
                }
            }
            return primes;
        } else {
            int middle = (start + end) / 2;
            PrimeTask leftTask = new PrimeTask(start, middle);
            PrimeTask rightTask = new PrimeTask(middle + 1, end);
            leftTask.fork();
            List<Integer> rightResult = rightTask.compute();
            List<Integer> leftResult = leftTask.join();
            leftResult.addAll(rightResult);
            return leftResult;
        }
    }

    private boolean isPrime(int n){
        if (n <= 1) return false;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}
