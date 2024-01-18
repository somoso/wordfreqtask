package com.soheb.AdaptavistTask.service;

import java.io.File;

public class FileService {

    public File getValidFile(String path) {
        return new File(path);
    }
}
