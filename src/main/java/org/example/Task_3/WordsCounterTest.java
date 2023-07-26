package org.example.Task_3;

import java.io.File;

public class WordsCounterTest {
    public static void main(String[] args) {
        WordsCounter counter = new WordsCounterImpl(new File("src/files/task_3.txt"));
        counter.doAnalize();
    }
}
