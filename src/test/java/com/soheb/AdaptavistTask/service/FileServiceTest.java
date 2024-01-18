package com.soheb.AdaptavistTask.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileServiceTest {

    private FileService fileService;

    @BeforeEach
    void setUp() {
        fileService = new FileService();
    }

    @Test
    void returnsValidFileForValidPath() {
        var file = UnitTestUtil.getResource("quick-brown-fox.txt");
        var expectedFile = fileService.getValidFile(file.getAbsolutePath());
        Assertions.assertNotNull(expectedFile);
        Assertions.assertEquals(file.getAbsolutePath(), expectedFile.getAbsolutePath());
    }
}
