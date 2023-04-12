package io.q5;

import java.io.*;

public class Rectangle implements Serializable {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Rectangle rect = new Rectangle(10.0, 20.0);

        // Serialize the rectangle
        DataOutputStream out = new DataOutputStream(new FileOutputStream("rect.dat"));
        out.writeDouble(rect.getWidth());
        out.writeDouble(rect.getHeight());
        out.close();

        // Deserialize the rectangle
        DataInputStream in = new DataInputStream(new FileInputStream("rect.dat"));
        double width = in.readDouble();
        double height = in.readDouble();
        in.close();

        Rectangle deserializedRect = new Rectangle(width, height);
        System.out.println("Width: " + deserializedRect.getWidth());
        System.out.println("Height: " + deserializedRect.getHeight());
    }
}
