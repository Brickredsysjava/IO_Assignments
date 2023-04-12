package io.q8;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Invoice implements Serializable {
    private int number;
    private Date date;
    private List<LineItem> lineItems;

    public Invoice(int number, Date date, List<LineItem> lineItems) {
        this.number = number;
        this.date = date;
        this.lineItems = lineItems;
    }

    public int getNumber() {
        return number;
    }

    public Date getDate() {
        return date;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Invoice> invoices = new ArrayList<>();

        List<LineItem> lineItems1 = new ArrayList<>();
        lineItems1.add(new LineItem("Item 1", 2, 10.0));
        lineItems1.add(new LineItem("Item 2", 3, 20.0));
        invoices.add(new Invoice(1, new Date(), lineItems1));

        List<LineItem> lineItems2 = new ArrayList<>();
        lineItems2.add(new LineItem("Item 3", 1, 5.0));
        lineItems2.add(new LineItem("Item 4", 4, 15.0));
        invoices.add(new Invoice(2, new Date(), lineItems2));

        // Serialize the invoices list
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("invoices.ser"));
        out.writeObject(invoices);
        out.close();

        // Deserialize the invoices list
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("invoices.ser"));
        List<Invoice> deserializedInvoices = (List<Invoice>) in.readObject();
        in.close();

        for (Invoice invoice : deserializedInvoices) {
            System.out.println("Invoice Number: " + invoice.getNumber());
            System.out.println("Invoice Date: " + invoice.getDate());
            System.out.println("Line Items:");
            for (LineItem lineItem : invoice.getLineItems()) {
                System.out.println("Description: " + lineItem.getDescription());
                System.out.println("Quantity: " + lineItem.getQuantity());
                System.out.println("Price: " + lineItem.getPrice());
                System.out.println();
            }
            System.out.println();
        }
    }
}

class LineItem implements Serializable {
    private String description;
    private int quantity;
    private double price;

    public LineItem(String description, int quantity, double price) {
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}

