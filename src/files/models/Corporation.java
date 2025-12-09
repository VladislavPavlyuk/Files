package files.models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Corporation {
    private static List<Employee> employees = new ArrayList<>();
    private static final String FILE_NAME = "employees.dat";

    public Corporation(){}

    public static void addEmployee(Scanner scanner) {
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter position: ");
        String position = scanner.nextLine();
        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        employees.add(new Employee(lastName, age, position, salary));
        System.out.println("Employee added.");
    }

    public static void editEmployee(Scanner scanner) {
        System.out.print("Enter last name of employee to edit: ");
        String lastName = scanner.nextLine();
        for (Employee employee : employees) {
            if (employee.getLastName().equalsIgnoreCase(lastName)) {
                System.out.print("Enter new age: ");
                int age = scanner.nextInt();
                scanner.nextLine(); // consume newline
                System.out.print("Enter new position: ");
                String position = scanner.nextLine();
                System.out.print("Enter new salary: ");
                double salary = scanner.nextDouble();
                scanner.nextLine(); // consume newline

                employee.setAge(age);
                employee.setPosition(position);
                employee.setSalary(salary);
                System.out.println("Employee updated.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void deleteEmployee(Scanner scanner) {
        System.out.print("Enter last name of employee to delete: ");
        String lastName = scanner.nextLine();
        employees.removeIf(employee -> employee.getLastName().equalsIgnoreCase(lastName));
        System.out.println("Employee deleted.");
    }

    public static void searchEmployee(Scanner scanner) {
        System.out.print("Enter last name to search: ");
        String lastName = scanner.nextLine();
        for (Employee employee : employees) {
            if (employee.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println(employee);
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void displayEmployees(Scanner scanner) {
        System.out.print("Enter age or initial of last name: ");
        String input = scanner.nextLine();
        try {
            int age = Integer.parseInt(input);
            for (Employee employee : employees) {
                if (employee.getAge() == age) {
                    System.out.println(employee);
                }
            }
        } catch (NumberFormatException e) {
            char initial = input.charAt(0);
            for (Employee employee : employees) {
                if (employee.getLastName().charAt(0) == initial) {
                    System.out.println(employee);
                }
            }
        }
    }

    public static void saveEmployees() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
        } catch (IOException e) {
            System.out.println("Error saving employees: " + e.getMessage());
        }
    }

    public static void loadEmployees() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (List<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading employees: " + e.getMessage());
        }
    }

    public static List<Employee> getEmployees() {
        return employees;
    }

    public static void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("Список сотрудников пуст.");
            return;
        }

        System.out.println("\n=== Список сотрудников ===");
        System.out.println(String.format("%-20s %-8s %-20s %-15s", "Фамилия", "Возраст", "Должность", "Зарплата"));
        System.out.println("--------------------------------------------------------------------------------");
        for (Employee employee : employees) {
            System.out.println(String.format("%-20s %-8d %-20s %-15.2f",
                    employee.getLastName(),
                    employee.getAge(),
                    employee.getPosition(),
                    employee.getSalary()));
        }
        System.out.println("--------------------------------------------------------------------------------\n");
    }
}
