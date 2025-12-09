package files.service;

import files.models.Corporation;
import files.models.Employee;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CorporationFabric {
    private static final String FILE_NAME = "employees.dat";

    public static void createCorporation() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("Файл " + FILE_NAME + " не найден. Создание начального списка сотрудников...");
            generateDefaultEmployees();
        }

        Corporation corporation = new Corporation();
        corporation.loadEmployees();
        corporation.displayAllEmployees();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. Edit Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Search Employee by Last Name");
            System.out.println("5. Display Employees by Age or Last Name Initial");
            System.out.println("6. Save and Exit");
            System.out.print("Choose an option: ");
            
            int choice;
            try {
                String input = scanner.nextLine();
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number from 1 to 6.");
                continue;
            }

            switch (choice) {
                case 1:
                    corporation.addEmployee(scanner);
                    break;
                case 2:
                    corporation.editEmployee(scanner);
                    break;
                case 3:
                    corporation.deleteEmployee(scanner);
                    break;
                case 4:
                    corporation.searchEmployee(scanner);
                    break;
                case 5:
                    corporation.displayEmployees(scanner);
                    break;
                case 6:
                    corporation.saveEmployees();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");
        }
    }
}

    private static void generateDefaultEmployees() {
        List<Employee> defaultEmployees = new ArrayList<>();
        defaultEmployees.add(new Employee("Иванов", 30, "Менеджер", 50000.0));
        defaultEmployees.add(new Employee("Петров", 25, "Разработчик", 60000.0));
        defaultEmployees.add(new Employee("Сидоров", 35, "Директор", 80000.0));
        defaultEmployees.add(new Employee("Козлов", 28, "Аналитик", 55000.0));
        defaultEmployees.add(new Employee("Смирнов", 32, "Тестировщик", 45000.0));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(defaultEmployees);
            System.out.println("Создан начальный список из " + defaultEmployees.size() + " сотрудников.");
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла сотрудников: " + e.getMessage());
        }
    }
}
