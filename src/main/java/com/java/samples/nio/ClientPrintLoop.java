package com.java.samples.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class ClientPrintLoop {
    private static int PORT = 10008;

    public static void main(String[] args) throws IOException {
        // Client
        try (Socket client = new Socket(InetAddress.getLocalHost(), PORT)) {
            while (true) {
                BufferedReader buferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                buferedReader.lines().forEach(s -> System.out.println(s));
            }
        }
    }
}
