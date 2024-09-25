package homework.homework1.thread;

class MyThread extends Thread {
    public MyThread(String name){
        super(name); // thread nom berish
    }

    @Override
    public void run() {
        System.out.println("Thread ishlamoqda: " + getName());
    }
}

public class Main{
    public static void main(String[] args) {
        Thread thread1 = new Thread("Thread1");
        thread1.start();
    }
}