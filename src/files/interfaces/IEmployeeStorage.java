package files.interfaces;

import files.models.Employee;
import java.io.IOException;
import java.util.List;

public interface IEmployeeStorage {
    void save(List<Employee> employees) throws IOException;
    List<Employee> load() throws IOException;
    boolean exists();
}


