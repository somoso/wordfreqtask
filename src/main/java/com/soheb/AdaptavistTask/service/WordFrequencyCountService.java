package com.soheb.AdaptavistTask.service;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.util.Scanner;

public class WordFrequencyCountService {

    public Map<String, Long> getWordFrequency(File toRead) throws FileNotFoundException {
        Map<String, Long> frequency = new HashMap<>();
        try (Scanner scanner = new Scanner(toRead)) {
            while (scanner.hasNext()) {
                var sanitisedWord = sanitiseWord(scanner);
                if (sanitisedWord.isBlank()) {
                    continue;
                }
                collectWordFrequency(frequency, sanitisedWord);
            }
        }
        return frequency;
    }

    private String sanitiseWord(Scanner scanner) {
        var word = scanner.next().toLowerCase();
        return word.replaceAll("[^A-Z-a-z]*","");
    }

    private void collectWordFrequency(Map<String, Long> frequency, String sanitisedWord) {
        if (frequency.containsKey(sanitisedWord)) {
            long count = frequency.get(sanitisedWord);
            count++;
            frequency.put(sanitisedWord, count);
        } else {
            frequency.put(sanitisedWord, 1L);
        }
    }

    
}
