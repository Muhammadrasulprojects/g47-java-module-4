package homework.homework1.runnable;

class MyRunnable implements Runnable{
    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Thread ishlamoqda: " + name);

        try {
            // Sleep methodini ishlatish
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + " tugadi.");
    }
}

public class Main {
    public static void main(String[] args) {
        Thread thread2 = new Thread(new MyRunnable("RunnableThread"));
        thread2.start();
    }
}