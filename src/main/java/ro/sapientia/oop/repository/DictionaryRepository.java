package ro.sapientia.oop.repository;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

@Repository
public class DictionaryRepository {
    private ArrayList<String> words = new ArrayList<>();

    public DictionaryRepository() {
        try{
            File file = ResourceUtils.getFile("classpath:dict.txt");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String[] word = line.split(" ");
                words.add(word[0]);
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public boolean findWord(String word){
        word = word.toLowerCase();
        return Collections.binarySearch(words, word) >= 0;
    }
}
