package files.services;

import files.interfaces.IEmployeeRepository;
import files.interfaces.IEmployeeStorage;
import files.interfaces.IInputReader;
import files.models.Employee;

import java.io.IOException;
import java.util.List;

public class EmployeeService {
    private final IEmployeeRepository repository;
    private final IEmployeeStorage storage;
    private final IInputReader inputReader;

    public EmployeeService(IEmployeeRepository repository, IEmployeeStorage storage, IInputReader inputReader) {
        this.repository = repository;
        this.storage = storage;
        this.inputReader = inputReader;
    }

    public void loadEmployees() throws IOException {
        if (storage.exists()) {
            List<Employee> employees = storage.load();
            for (Employee employee : employees) {
                repository.add(employee);
            }
        }
    }

    public void saveEmployees() throws IOException {
        storage.save(repository.getAll());
    }

    public void addEmployee() {
        String lastName = inputReader.readLine("Enter last name: ");
        int age = inputReader.readInt("Enter age: ");
        String position = inputReader.readLine("Enter position: ");
        double salary = inputReader.readDouble("Enter salary: ");

        repository.add(new Employee(lastName, age, position, salary));
        System.out.println("Employee added.");
    }

    public void editEmployee() {
        String lastName = inputReader.readLine("Enter last name of employee to edit: ");
        Employee employee = repository.findByLastName(lastName);
        
        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }

        int age = inputReader.readInt("Enter new age: ");
        String position = inputReader.readLine("Enter new position: ");
        double salary = inputReader.readDouble("Enter new salary: ");

        employee.setAge(age);
        employee.setPosition(position);
        employee.setSalary(salary);
        repository.update(employee);
        System.out.println("Employee updated.");
    }

    public void deleteEmployee() {
        String lastName = inputReader.readLine("Enter last name of employee to delete: ");
        repository.delete(lastName);
        System.out.println("Employee deleted.");
    }

    public void searchEmployee() {
        String lastName = inputReader.readLine("Enter last name to search: ");
        Employee employee = repository.findByLastName(lastName);
        
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void displayEmployeesByFilter() {
        String input = inputReader.readLine("Enter age or initial of last name: ");
        try {
            int age = Integer.parseInt(input);
            List<Employee> employees = repository.findByAge(age);
            employees.forEach(System.out::println);
        } catch (NumberFormatException e) {
            if (!input.isEmpty()) {
                char initial = input.charAt(0);
                List<Employee> employees = repository.findByLastNameInitial(initial);
                employees.forEach(System.out::println);
            }
        }
    }

    public List<Employee> getAllEmployees() {
        return repository.getAll();
    }

    public boolean isEmpty() {
        return repository.isEmpty();
    }
}


