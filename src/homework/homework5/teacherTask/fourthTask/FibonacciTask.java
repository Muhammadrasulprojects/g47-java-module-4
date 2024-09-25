package homework.homework5.teacherTask.fourthTask;

import java.util.concurrent.RecursiveTask;

public class FibonacciTask extends RecursiveTask<Long> {
    private int n;

    public FibonacciTask(int n) {
        this.n = n;
    }

    @Override
    protected Long compute() {
        if (n <= 10) {  // Kichik qiymatlar uchun oddiy hisoblash
            return fibonacci(n);
        } else {
            FibonacciTask task1 = new FibonacciTask(n - 1);
            FibonacciTask task2 = new FibonacciTask(n - 2);
            task1.fork();
            long result2 = task2.compute();
            long result1 = task1.join();
            return result1 + result2;
        }
    }

    private long fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}