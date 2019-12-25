package com.java.samples.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class JavaIo {
    public static void testStream() {
        String fileName = System.getProperty("usr.dir") + "/src/main/resources";
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void main(String[] args) {
    }
}
