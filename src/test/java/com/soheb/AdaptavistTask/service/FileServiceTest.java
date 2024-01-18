package com.soheb.AdaptavistTask.service;

import com.soheb.AdaptavistTask.exception.InvalidFileException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Comparator;
import java.util.Set;

public class FileServiceTest {

    private FileService fileService;

    @BeforeEach
    void setUp() {
        fileService = new FileService();
    }

    @Test
    void returnsValidFileForValidPath() throws InvalidFileException {
        var file = UnitTestUtil.getResource("quick-brown-fox.txt");
        var expectedFile = fileService.getValidFile(file.getAbsolutePath());
        Assertions.assertNotNull(expectedFile);
        Assertions.assertEquals(file.getAbsolutePath(), expectedFile.getAbsolutePath());
    }

    @Test
    void returnsNullForInvalidPath() throws InvalidFileException {
        Assertions.assertThrows(InvalidFileException.class, () ->
                fileService.getValidFile("/this/file/does/not/exist"));
    }

    @Test
    void returnsNullForFolder() throws IOException {
        File folder = null;
        try {
            folder = Files.createTempDirectory("dummy").toFile();
            final File finalFolder = folder;
            Assertions.assertThrows(InvalidFileException.class, () ->
                    fileService.getValidFile(finalFolder.getAbsolutePath())
            );
        } finally {
            if (folder != null) {
                deleteTempFolder(folder.toPath());
            }
        }
    }

    @Test
    void returnsNullForUnreadableFile() throws IOException {
        // Got answer from here: https://stackoverflow.com/a/664443
        Path tempPath = null;
        try {
            Set<PosixFilePermission> ownerWritable = PosixFilePermissions.fromString("-w-------");
            FileAttribute<?> permissions = PosixFilePermissions.asFileAttribute(ownerWritable);
            tempPath = Files.createTempDirectory("dummy");
            var unreadableFile = Files.createFile(Path.of(tempPath.toFile().getAbsolutePath(), "tempy"), permissions);
            Assertions.assertThrows(InvalidFileException.class, () ->
                    fileService.getValidFile(unreadableFile.toFile().getAbsolutePath()));
        } finally {
            if (tempPath != null) {
                deleteTempFolder(tempPath);
            }
        }
    }

    private void deleteTempFolder(Path toDelete) throws IOException {
        try (var deleteStream = Files.walk(toDelete)) {
                deleteStream.sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        }
    }
}
