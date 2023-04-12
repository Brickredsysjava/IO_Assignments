package io.q1;

import java.io.*;
import java.util.Date;

public class Employee implements Serializable {
    private String name;
    private int age;
    private double salary;
    private Date hireDate;

    public Employee(String name, int age, double salary, Date hireDate) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Employee employee = new Employee("John wick", 35, 5000000.0, new Date());

        // Serialize the employee object
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.ser"));
        out.writeObject(employee);
        out.close();

        // Deserialize the employee object
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.ser"));
        Employee deserializedEmployee = (Employee) in.readObject();
        in.close();

        System.out.println("Name: " + deserializedEmployee.getName());
        System.out.println("Age: " + deserializedEmployee.getAge());
        System.out.println("Salary: " + deserializedEmployee.getSalary());
        System.out.println("Hire date: " + deserializedEmployee.getHireDate());
    }
}

