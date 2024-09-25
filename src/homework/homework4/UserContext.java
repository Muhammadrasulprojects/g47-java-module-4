package homework.homework4;

public class UserContext {
    // ThreadLocal - har bir thread uchun alohida ma'lumotlarni saqlaydi
    private static final ThreadLocal<String> currentUser = ThreadLocal.withInitial(() -> "Unknown");

    public static void setUser(String user){
        currentUser.set(user);
    }

    public static String getUser(){
        return currentUser.get();
    }

    public static void removeUser(){
        currentUser.remove();
    }

    public static void main(String[] args) {
        Runnable task1 = () -> {
            setUser("User1");
            System.out.println("Task1: Current user is " + getUser());
            removeUser();
        };

        Runnable task2 = () -> {
            setUser("User2");
            System.out.println("Task2: Current user is " + getUser());
            removeUser();
        };

        new Thread(task1).start();
        new Thread(task2).start();
    }
}
