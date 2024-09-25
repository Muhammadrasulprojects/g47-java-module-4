package homework.homework7.teacherTask;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Employee{
    private String name;
    private int age;
    private String position;

    public Employee(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    @Override
    public String toString() {
        return name + "," + age + "," + position;
    }

    public static Employee fromString(String line){
        String[] parts = line.split(",");
        return new Employee(parts[0], Integer.parseInt(parts[1]), parts[2]);
    }
}

public class EmployeeManager {
    public static void main(String[] args) {
        String fileName = "homework/homework7";

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Ali Valiev", 35, "Manager"));
        employees.add(new Employee("Qodirali Aliyev", 23, "Developer"));
        employees.add(new Employee("Johnson Smit", 26,"Designer"));

        writeEmployeesToFile(fileName, employees);

        List<Employee> readEmployees = readEmployeesFromFile(fileName);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static void writeEmployeesToFile(String fileName, List<Employee> employees){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            for (Employee employee : employees) {
                writer.write(employee.toString());
                writer.newLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static List<Employee> readEmployeesFromFile(String fileName){
        List<Employee> employees = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = reader.readLine()) != null){
                employees.add(Employee.fromString(line));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return employees;
    }
}
