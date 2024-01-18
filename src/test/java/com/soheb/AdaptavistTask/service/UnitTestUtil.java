package com.soheb.AdaptavistTask.service;

import java.io.File;

public class UnitTestUtil {
    public static File getResource(String resourceName) {
        ClassLoader classLoader = UnitTestUtil.class.getClassLoader();
        var resource = classLoader.getResource(resourceName);
        if (resource == null) {
            return null;
        }
        return new File(resource.getFile());
    }
}
