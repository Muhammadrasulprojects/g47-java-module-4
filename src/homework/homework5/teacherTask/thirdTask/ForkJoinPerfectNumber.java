package homework.homework5.teacherTask.thirdTask;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinPerfectNumber {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        List<Integer> perfectNumbers = pool.invoke(new PerfectNumberTask(1,1_000_000));
        System.out.println("perfectNumbers = " + perfectNumbers);
    }
}
