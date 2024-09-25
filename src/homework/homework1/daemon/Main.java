package homework.homework1.daemon;

class DaemonThread extends Thread {
    public DaemonThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(getName() + " ishlamoqda...");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        DaemonThread daemonThread = new DaemonThread("DaemonThread");
        daemonThread.setDaemon(true); // Daemon thread qilish
        daemonThread.start();

        try {
            Thread.sleep(2000); // Main threadni 2 soniya kutish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread tugadi.");
    }
}