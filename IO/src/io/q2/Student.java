package io.q2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {
    private String name;
    private int rollNumber;
    private List<String> subjects;

    public Student(String name, int rollNumber, List<String> subjects) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John wick", 1, List.of("Maths", "Science")));
        students.add(new Student("Bronson", 2, List.of("History", "Geography")));

        // Serialize the students list
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("students.ser"));
        out.writeObject(students);
        out.close();

        // Deserialize the students list
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("students.ser"));
        List<Student> deserializedStudents = (List<Student>) in.readObject();
        in.close();

        for (Student student : deserializedStudents) {
            System.out.println("Name: " + student.getName());
            System.out.println("Roll number: " + student.getRollNumber());
            System.out.println("Subjects: " + student.getSubjects());
            System.out.println();
        }
    }
}

