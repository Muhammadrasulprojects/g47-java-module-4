package homework.homework5.teacherTask.thirdTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class PerfectNumberTask extends RecursiveTask<List<Integer>> {
    private static final int THRESHOLD = 100000;
    private int start, end;

    public PerfectNumberTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected List<Integer> compute() {
        if (end - start <= THRESHOLD) {
            List<Integer> perfectNumbers = new ArrayList<>();
            for (int i = start; i <= end; i++) {
                if (isPerfect(i)) {
                    perfectNumbers.add(i);
                }
            }
            return perfectNumbers;
        } else {
            int middle = (start + end) / 2;
            PerfectNumberTask leftTask = new PerfectNumberTask(start, middle);
            PerfectNumberTask rightTask = new PerfectNumberTask(middle + 1, end);
            leftTask.fork();
            List<Integer> rightResult = rightTask.compute();
            List<Integer> leftResult = leftTask.join();
            leftResult.addAll(rightResult);
            return leftResult;
        }
    }

    private boolean isPerfect(int n) {
        int sum = 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                sum += i + (n / i);
            }
        }
        return sum == n && n != 1;
    }
}
