package org.example.Task_2.JsonFormatCreator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.Task_2.User;
import org.example.Task_2.contentReader.ContentReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonFormatCreatorImpl implements JsonFormatCreator {
    private final File fromFile;

    public JsonFormatCreatorImpl(File fromFile) {
        this.fromFile = fromFile;
    }

    @Override
    public void toJson() throws IOException {
        List<User> userList = ContentReader.readContent(fromFile);
        new File("src/files/task_2.json").createNewFile();
        File toFile = new File("src/files/task_2.json");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try(FileWriter fw = new FileWriter(toFile)){
            fw.write(gson.toJson(userList));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
