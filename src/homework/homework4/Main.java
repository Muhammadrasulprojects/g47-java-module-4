package homework.homework4;

import java.util.Calendar;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        TaskExecutor taskExecutor = new TaskExecutor();

        Callable<String> callableTask = () -> {
            Thread.sleep(1000);
            return "Callable task completed";
        };

        Future<String> future = taskExecutor.executeCallableTask(callableTask);

        try {
            if (future.isDone()){
                System.out.println("Future result: " + future.get());
            } else {
                System.out.println("Task is still in progress.....");
            }
        } catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }

        // overloaded method bilan execute qilish
        taskExecutor.executeCallableTaskWithResult(callableTask);

        taskExecutor.shutdown();

    }
}
