package homework.homework5.teacherTask.fourthTask;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinFibonacci {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        int n = 12; // Fibonacci soni
        long result = pool.invoke(new FibonacciTask(n));
        System.out.println(n + " -chi Fibonacci soni: " + result);
    }
}