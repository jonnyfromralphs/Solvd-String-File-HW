package org.example;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/words.txt");
        String content = FileUtils.readFileToString(file, "UTF-8");

        String[] words = StringUtils.split(content);

        Set<String> uniqueWords = new HashSet<>();

        for (String word : words) {
            String onlyAlphaNumeric = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            uniqueWords.add(onlyAlphaNumeric);
        }

        int count = uniqueWords.size();

        FileUtils.writeStringToFile(file, "\nNumber of unique words: " + count, "UTF-8", true);
    }
}
