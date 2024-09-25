package homework.homework1.priority;

class PriorityThread extends Thread {
    public PriorityThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(getName() + " priority: " + getPriority() + " ishlamoqda.");
    }
}

public class Main {
    public static void main(String[] args) {
        PriorityThread thread1 = new PriorityThread("Thread1");
        PriorityThread thread2 = new PriorityThread("Thread2");
        PriorityThread thread3 = new PriorityThread("Thread3");

        // Prioritylarni o'rnatish
        thread1.setPriority(Thread.MIN_PRIORITY); // 1
        thread2.setPriority(Thread.NORM_PRIORITY); // 5
        thread3.setPriority(Thread.MAX_PRIORITY); // 10

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
