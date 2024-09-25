package homework.homework3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadSafeListExample {
    public static void main(String[] args) {
        // Thread-safe ro'uxat yaratish
        List<String> safeList = Collections.synchronizedList(new ArrayList<>());

        // elementlar qo'shish
        safeList.add("item 1");
        safeList.add("item 2");

        // elementlarni o'qish
        synchronized (safeList){
            for (String item : safeList) { // iteratsiya qilayotganda sinxronlash
                System.out.println(item);
            }
        }

        // elementni yangilash
        safeList.set(0, "Updated item 1");

        // elementni o'chirish
        safeList.remove("item 2");

    }
}
