package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientHandler implements Runnable {

    BufferedReader buff;
    InputStreamReader isr;

    private final Socket mSocket;

    public ClientHandler(Socket socket) {
        mSocket = socket;
        try {
            isr = new InputStreamReader(mSocket.getInputStream());
            buff = new BufferedReader(isr);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void run() {
        System.out.println("hello");
        String clientLine = null;
        while (true) {
            try {
                if (((clientLine = buff.readLine()) != null)) {
                    System.out.println("Message from the client: " + clientLine);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
