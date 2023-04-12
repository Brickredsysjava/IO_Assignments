package io.q7;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class SetSerialization implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Set<String> set = new HashSet<>();
        set.add("One");
        set.add("Two");

        // Serialize the set
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("set.ser"));
        out.writeObject(set);
        out.close();

        // Deserialize the set
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("set.ser"));
        Set<String> deserializedSet = (Set<String>) in.readObject();
        in.close();

        for (String str : deserializedSet) {
            System.out.println(str);
        }
    }
}
