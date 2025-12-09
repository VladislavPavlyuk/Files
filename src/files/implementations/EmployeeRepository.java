package files.implementations;

import files.interfaces.IEmployeeRepository;
import files.models.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private final List<Employee> employees;

    public EmployeeRepository() {
        this.employees = new ArrayList<>();
    }

    public EmployeeRepository(List<Employee> employees) {
        this.employees = new ArrayList<>(employees);
    }

    @Override
    public void add(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void update(Employee employee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getLastName().equalsIgnoreCase(employee.getLastName())) {
                employees.set(i, employee);
                return;
            }
        }
    }

    @Override
    public void delete(String lastName) {
        employees.removeIf(emp -> emp.getLastName().equalsIgnoreCase(lastName));
    }

    @Override
    public Employee findByLastName(String lastName) {
        return employees.stream()
                .filter(emp -> emp.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Employee> findByAge(int age) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getAge() == age) {
                result.add(employee);
            }
        }
        return result;
    }

    @Override
    public List<Employee> findByLastNameInitial(char initial) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (!employee.getLastName().isEmpty() && 
                employee.getLastName().charAt(0) == initial) {
                result.add(employee);
            }
        }
        return result;
    }

    @Override
    public List<Employee> getAll() {
        return new ArrayList<>(employees);
    }

    @Override
    public boolean isEmpty() {
        return employees.isEmpty();
    }
}


