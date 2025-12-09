package files.presentation;

import files.models.Employee;

import java.util.List;

public class EmployeeDisplay {
    public void displayAll(List<Employee> employees) {
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

    public void displayList(List<Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("Сотрудники не найдены.");
            return;
        }
        employees.forEach(System.out::println);
    }
}


