package org.example.Task_2;

import org.example.Task_2.JsonFormatCreator.JsonFormatCreator;
import org.example.Task_2.JsonFormatCreator.JsonFormatCreatorImpl;

import java.io.File;
import java.io.IOException;

public class JsonFormatCreatorTest {
    public static void main(String[] args) throws IOException {
        JsonFormatCreator jsonFormatCreator = new JsonFormatCreatorImpl(new File("src/files/task_2.txt"));
        jsonFormatCreator.toJson();
    }
}