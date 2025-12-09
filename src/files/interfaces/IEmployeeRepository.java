package files.interfaces;

import files.models.Employee;
import java.util.List;

public interface IEmployeeRepository {
    void add(Employee employee);
    void update(Employee employee);
    void delete(String lastName);
    Employee findByLastName(String lastName);
    List<Employee> findByAge(int age);
    List<Employee> findByLastNameInitial(char initial);
    List<Employee> getAll();
    boolean isEmpty();
}


