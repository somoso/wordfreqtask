package com.soheb.AdaptavistTask.service;

import java.util.Collections;
import java.util.Map;

public class PrettyPrinterService {

    public void prettyPrintInfo(Map<String, Long> frequency) {
        frequency.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(e -> System.out.printf("%s:%d%n", e.getKey(), e.getValue()));
    }
}
