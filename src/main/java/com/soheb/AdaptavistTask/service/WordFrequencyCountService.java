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
                String word = scanner.next().toLowerCase();
                if (frequency.containsKey(word)) {
                    long count = frequency.get(word);
                    count++;
                    frequency.put(word, count);
                } else {
                    frequency.put(word, 1L);
                }
            }
        }
        return frequency;
    }
}
