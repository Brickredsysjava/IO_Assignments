package io.q3;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MapSerialization implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");

        // Serialize the map
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("map.ser"));
        out.writeObject(map);
        out.close();

        // Deserialize the map
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("map.ser"));
        Map<Integer, String> deserializedMap = (Map<Integer, String>) in.readObject();
        in.close();

        for (Map.Entry<Integer, String> entry : deserializedMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}

