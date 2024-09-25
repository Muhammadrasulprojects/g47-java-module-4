package homework.homework5.teacherTask.firstTask;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinSum {
    public static void main(String[] args) {
        int[] array = new Random().ints(1_000_000, 1, 201).toArray();
        ForkJoinPool pool = new ForkJoinPool();
        long result = pool.invoke(new SumTask(array, 0, array.length));
        System.out.println("result = " + result);
    }
}
