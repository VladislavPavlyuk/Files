package files.service;

import files.factories.ServiceFactory;
import files.models.Employee;
import files.presentation.EmployeeDisplay;
import files.services.EmployeeService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CorporationFabric {
    private static final String FILE_NAME = "employees.dat";
    private final EmployeeService employeeService;
    private final EmployeeDisplay display;
    private final files.interfaces.IInputReader inputReader;

    public CorporationFabric() {
        this.employeeService = ServiceFactory.createEmployeeService(FILE_NAME);
        this.display = new EmployeeDisplay();
        this.inputReader = ServiceFactory.createInputReader();
    }

    public void createCorporation() {
        files.interfaces.IEmployeeStorage storage = ServiceFactory.createEmployeeStorage(FILE_NAME);
        
        if (!storage.exists()) {
            System.out.println("Файл " + FILE_NAME + " не найден. Создание начального списка сотрудников...");
            generateDefaultEmployees();
        }
        
        try {
            employeeService.loadEmployees();
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке сотрудников: " + e.getMessage());
        }

        display.displayAll(employeeService.getAllEmployees());

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
                String input = inputReader.readLine("");
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number from 1 to 6.");
                continue;
            }

            switch (choice) {
                case 1:
                    employeeService.addEmployee();
                    break;
                case 2:
                    employeeService.editEmployee();
                    break;
                case 3:
                    employeeService.deleteEmployee();
                    break;
                case 4:
                    employeeService.searchEmployee();
                    break;
                case 5:
                    employeeService.displayEmployeesByFilter();
                    break;
                case 6:
                    try {
                        employeeService.saveEmployees();
                    } catch (IOException e) {
                        System.out.println("Ошибка при сохранении: " + e.getMessage());
                    }
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");
            }
        }
    }

    private void generateDefaultEmployees() {
        List<Employee> defaultEmployees = new ArrayList<>();
        defaultEmployees.add(new Employee("Иванов", 30, "Менеджер", 50000.0));
        defaultEmployees.add(new Employee("Петров", 25, "Разработчик", 60000.0));
        defaultEmployees.add(new Employee("Сидоров", 35, "Директор", 80000.0));
        defaultEmployees.add(new Employee("Козлов", 28, "Аналитик", 55000.0));
        defaultEmployees.add(new Employee("Смирнов", 32, "Тестировщик", 45000.0));

        try {
            ServiceFactory.createEmployeeStorage(FILE_NAME).save(defaultEmployees);
            System.out.println("Создан начальный список из " + defaultEmployees.size() + " сотрудников.");
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла сотрудников: " + e.getMessage());
        }
    }
}
