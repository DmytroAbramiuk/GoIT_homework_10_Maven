package org.example.Task_2.contentReader;

import org.example.Task_2.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class ContentReader {

    private static HashMap<String, Integer> createMapping(String[] headersLine) {
        HashMap<String, Integer> headerIndexes = new HashMap<>();

        int index = 0;
        for (String header : headersLine) {
            headerIndexes.put(header, index);
            index++;
        }

        return headerIndexes;
    }

    public static List<User> readContent(File file) {
        List<User> userList = new ArrayList<>();
        String name;
        int age;
        String[] nextLine;

        try (Scanner scanner = new Scanner(new FileInputStream(file))) {
            String[] headersLine = scanner.nextLine().split(" ");

            HashMap<String, Integer> headerIndexes = createMapping(headersLine);

            while (scanner.hasNext()) {
                nextLine = scanner.nextLine().split(" ");

                name = nextLine[headerIndexes.get("name")];
                age = Integer.parseInt(nextLine[headerIndexes.get("age")]);
                userList.add(new User(name, age));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }
}
