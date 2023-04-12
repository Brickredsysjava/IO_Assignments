package io.q6;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Product implements Serializable {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Product 1", 10.0));
        products.add(new Product(2, "Product 2", 20.0));

        // Serialize the products list
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("products.ser"));
        out.writeObject(products);
        out.close();

        // Deserialize the products list
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("products.ser"));
        List<Product> deserializedProducts = (List<Product>) in.readObject();
        in.close();

        for (Product product : deserializedProducts) {
            System.out.println("Id: " + product.getId());
            System.out.println("Name: " + product.getName());
            System.out.println("Price: " + product.getPrice());
            System.out.println();
        }
    }
}

