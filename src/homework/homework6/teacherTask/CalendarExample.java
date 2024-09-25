package homework.homework6.teacherTask;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class CalendarExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Yilni kiriting (yyyy): ");
        int year = scanner.nextInt();
        System.out.println("Oyni kiriting (1-12): ");
        int month = scanner.nextInt() - 1; // index starts from 0

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, 1);

        int startDay = calendar.get(Calendar.DAY_OF_WEEK);
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy");
        System.out.println(sdf.format(calendar.getTime()));

        System.out.println("Sun  Mon  Tue  Wed  Thu  Fri  Sat");

        for (int i = 1; i < startDay; i++) {
            System.out.println("    ");
        }

        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%2d   ", day);
            if ((startDay + day - 1) % 7 == 0){
                System.out.println();
            }
        }
        System.out.println();

        scanner.close();
    }
}
