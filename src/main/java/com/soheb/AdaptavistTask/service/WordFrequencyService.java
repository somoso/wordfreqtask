package com.soheb.AdaptavistTask.service;

import com.soheb.AdaptavistTask.exception.InvalidFileException;

import java.io.File;

public class WordFrequencyService {

    private final FileService fileService;
    private final WordFrequencyCountService countService;
    private final PrettyPrinterService prettyPrinterService;

    public WordFrequencyService(FileService fileService, WordFrequencyCountService countService, PrettyPrinterService prettyPrinterService) {
        this.fileService = fileService;
        this.countService = countService;
        this.prettyPrinterService = prettyPrinterService;
    }

    public void processFile(String fullPath) {
        File file;
        try {
            file = fileService.getValidFile(fullPath);
        } catch (InvalidFileException e) {
            System.err.println(e.getMessage());
            return;
        }

        var frequency = countService.getWordFrequency(file);
        prettyPrinterService.prettyPrintInfo(frequency);
    }
}
