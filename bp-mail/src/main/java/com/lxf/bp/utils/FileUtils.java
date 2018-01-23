package com.lxf.bp.utils;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class FileUtils {

    public static String getFileTextFromClassPath(String fileName) throws IOException {
        InputStream resourceAsStream =
                FileUtils.class.getClassLoader().getResourceAsStream(fileName);

        return org.apache.commons.io.IOUtils.toString(resourceAsStream,"UTF-8");
    }

    public static ClassPathResource ClassPathResource(String fileName) throws IOException {
        return new ClassPathResource(fileName);
    }

    public static List<String> getTextAllForList(String fileName) throws IOException {
        InputStream resourceAsStream =
                FileUtils.class.getClassLoader().getResourceAsStream(fileName);

        return IOUtils.readLines(resourceAsStream,"UTF-8");
    }

    public static void writeAppendFile(String fileName,List<String> context) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
        IOUtils.writeLines(context,null,fileOutputStream);
    }


    public static void main(String[] args) throws IOException {

    }

}
