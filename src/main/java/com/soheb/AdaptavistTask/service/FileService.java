package com.soheb.AdaptavistTask.service;

import com.soheb.AdaptavistTask.exception.InvalidFileException;

import java.io.File;

public class FileService {

    public File getValidFile(String path) throws InvalidFileException {
        var file = new File(path);
        if (!file.exists()) {
            throw new InvalidFileException("File does not exist");
        }
        if (!file.isFile()) {
            throw new InvalidFileException("Folder was provided. We need a file.");
        }
        if (!file.canRead()) {
            throw new InvalidFileException("File cannot be read.");
        }
        return file;
    }
}
