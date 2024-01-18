package com.soheb.AdaptavistTask.service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class UnitTestUtil {
    public static File getResource(String resourceName) throws IOException, URISyntaxException {
        ClassLoader classLoader = UnitTestUtil.class.getClassLoader();
        var resource = classLoader.getResource(resourceName);
        if (resource == null) {
            return null;
        }
        return new File(resource.getFile());
    }
}
