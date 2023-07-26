package org.example.Task_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class WordsCounterImpl implements WordsCounter{
    private final File file;

    public WordsCounterImpl(File file) {
        this.file = file;
    }

    @Override
    public void doAnalize() {
        String currentWord;
        HashMap<String, Integer> wordMap = new HashMap<>();

        try(Scanner scan = new Scanner(new FileInputStream(file))) {
            while(scan.hasNext()){
                currentWord = scan.next().toLowerCase();
                if(wordMap.size()==0){
                    wordMap.put(currentWord, 1);
                } else if(wordMap.get(currentWord)==null){
                    wordMap.put(currentWord, 1);
                } else {
                    wordMap.put(currentWord, wordMap.get(currentWord)+1);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        printSortedWordFrequency(wordMap);
    }

    private static void printSortedWordFrequency(Map<String, Integer> wordFrequency) {
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordFrequency.entrySet());

        Collections.sort(sortedList, (entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        for (Map.Entry<String, Integer> entry : sortedList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
