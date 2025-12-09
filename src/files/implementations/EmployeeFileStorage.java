package files.implementations;

import files.interfaces.IEmployeeStorage;
import files.models.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFileStorage implements IEmployeeStorage {
    private final String fileName;

    public EmployeeFileStorage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void save(List<Employee> employees) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(employees);
        }
    }

    @Override
    public List<Employee> load() throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Employee>) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException("Error deserializing employees", e);
        }
    }

    @Override
    public boolean exists() {
        return new File(fileName).exists();
    }
}


