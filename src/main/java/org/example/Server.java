package org.example;

import java.io.*;
import java.net.*;

public class Server{

    ServerSocket ss;

    public Server(){
        try{
            ss = new ServerSocket(8989);
            ss.setReuseAddress(true);
            System.out.println("I am Waiting for Client to Connect !!!!");

        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
    public static void main(String args[]){
        Server cc = new Server();
        try{
            while (true) {

                    Socket mSocket = cc.ss.accept();
                    System.out.println("New client connected" + mSocket.getInetAddress().getHostAddress());
                    ClientHandler clientSocket = new ClientHandler(mSocket);
                    new Thread(clientSocket).start();
            }

        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally{
            try{
               if(cc.ss != null){
                   cc.ss.close();
               }

            }catch(IOException e){
                e.printStackTrace();
            }
        }


    }


}
