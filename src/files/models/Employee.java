package files.models;

import java.io.*;
import java.util.*;

class Employee implements Serializable {
    private String lastName;
    private int age;
    private String position;
    private double salary;

    public Employee(String lastName, int age, String position, double salary) {
        this.lastName = lastName;
        this.age = age;
        this.position = position;
        this.salary = salary;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}