package org.example;

import java.io.*;
import java.net.Socket;


public class Client2 {
    BufferedReader buff;
    InputStreamReader isr;
    BufferedReader buff_console;
    InputStreamReader isr_console;

    PrintWriter pw;

    Socket ss;

    public Client2() {
        try {
            ss = new Socket("127.0.0.1", 8989);
            isr = new InputStreamReader(ss.getInputStream());
            buff = new BufferedReader(isr);
            pw = new PrintWriter(ss.getOutputStream(), true);
            isr_console = new InputStreamReader(System.in);
            buff_console = new BufferedReader(isr_console);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String args[]) throws Exception {
        Client2 cc = new Client2();

        String line = null;
        while (!"exit".equalsIgnoreCase(line)) {
            System.out.println("Enter line: ");
            line = cc.buff_console.readLine();
            cc.pw.println("client1 : " + line);
            cc.pw.flush();
//            System.out.println("Message from Server is " + cc.buff.readLine());
        }


        cc.buff.close();
        cc.pw.close();
    }
}
