package homework.homework4;

import java.util.concurrent.*;

public class TaskExecutor {
    private final ExecutorService executor;

    public TaskExecutor() {
        // yagona executor yaratildi
        executor = Executors.newSingleThreadExecutor();
    }

    public void executeRunnableTask(Runnable task){
        executor.execute(task);
    }

    public <V> Future<V> executeCallableTask(Callable<V> task){
        return executor.submit(task);
    }

    public <V> void executeCallableTaskWithResult(Callable<V> task){
        Future<V> future = executor.submit(task);
        try {
            if (future.isDone()){
                System.out.println("Task result: " + future.get());
            }
        } catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
    }

    public void shutdown(){
        executor.shutdown();
    }
}