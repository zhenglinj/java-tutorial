package com.java.samples.nio;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


/**
 * 实现一个服务器应用，只简单要求能够同时服务多个客户端请求即可。
 * 使用java.io和java.net中的同步、阻塞式API，可以简单实现。
 */
public class IOServer extends Thread {
    private static int PORT = 10008;

    private ServerSocket serverSocket;

    public int getPort() {
        return serverSocket.getLocalPort();
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(PORT);
            Executor executor = Executors.newFixedThreadPool(8);
            while (true) {
                Socket socket = serverSocket.accept();
                RequesHandler requesHandler = new RequesHandler(socket);
                //requesHandler.start();
                executor.execute(requesHandler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // Server start
        IOServer server = new IOServer();
        server.start();
    }
}

// 简化实现，不做读取，直接发送字符串
class RequesHandler extends Thread {
    private Socket socket;

    RequesHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream());) {
            out.println("Hello world!");
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
