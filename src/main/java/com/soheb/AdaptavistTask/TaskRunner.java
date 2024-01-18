package com.soheb.AdaptavistTask;

import com.soheb.AdaptavistTask.service.FileService;
import com.soheb.AdaptavistTask.service.PrettyPrinterService;
import com.soheb.AdaptavistTask.service.WordFrequencyCountService;
import com.soheb.AdaptavistTask.service.WordFrequencyService;

public class TaskRunner {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a file that you wish to get the word frequency");
            return;
        }

        var service = new WordFrequencyService(new FileService(), new WordFrequencyCountService(), new PrettyPrinterService());
        service.processFile(args[0]);
    }
}
