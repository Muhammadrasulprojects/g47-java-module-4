package homework.homework2.jlkesh;

public class DeadlockExample {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void method1(){
        synchronized (lock1){
            System.out.println("Lock1 qo'lga olindi, method1 davom etmoqda...");

            try{
                Thread.sleep(50);
            } catch (InterruptedException e){
                e.printStackTrace();
            }

            synchronized (lock2){
                System.out.println("Lock2 qo'lga olindi, method1 tugadi.");
            }
        }
    }

    public void method2(){
        synchronized (lock2){
            System.out.println("Lock2 qo'lga olindi, method2 davom etmoqda...");

            try{
                Thread.sleep(50);
            } catch (InterruptedException e){
                e.printStackTrace();
            }

            synchronized (lock1){
                System.out.println("Lock1 qo'lga olindi, method2 tugadi.");
            }
        }
    }

    public static void main(String[] args) {
        DeadlockExample deadlockExample = new DeadlockExample();

        Thread thread1 = new Thread(deadlockExample::method1);
        Thread thread2 = new Thread(deadlockExample::method2);

        thread1.start();
        thread2.start();
    }
}
