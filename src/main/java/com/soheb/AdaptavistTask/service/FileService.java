package com.soheb.AdaptavistTask.service;

import java.io.File;

public class FileService {

    public File getValidFile(String path) {
        var file = new File(path);
        if (!file.exists()) {
            return null;
        }
        return file;
    }
}
