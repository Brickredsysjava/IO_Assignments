package io.q4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
class Person implements Serializable {
    private String name;
    private int age;
    private String address;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
}
public class Car implements Serializable {
    private String make;
    private String model;
    private int year;
    private Person owner;

    public Car(String make, String model, int year, Person owner) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.owner = owner;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public Person getOwner() {
        return owner;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Ford", "Shelby", 1979, new Person("John wick", 35, "123 Main St")));
        cars.add(new Car("Toyota", "Camry", 2019, new Person("Jane Smith", 40, "456 Oak Ave")));

        // Serialize the cars list
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("cars.ser"));
        out.writeObject(cars);
        out.close();

        // Deserialize the cars list
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("cars.ser"));
        List<Car> deserializedCars = (List<Car>) in.readObject();
        in.close();

        for (Car car : deserializedCars) {
            System.out.println("Make: " + car.getMake());
            System.out.println("Model: " + car.getModel());
            System.out.println("Year: " + car.getYear());
            System.out.println("Owner name: " + car.getOwner().getName());
            System.out.println("Owner age: " + car.getOwner().getAge());
            System.out.println("Owner address: " + car.getOwner().getAddress());
            System.out.println();
        }
    }
}



