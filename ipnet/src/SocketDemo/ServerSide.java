/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SocketDemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 *
 * @author Shalon
 */
public class ServerSide {
    public static PrintWriter printWriter = null;
    public static void main(String[] args) throws IOException {
        ServerSocket socketServer = new ServerSocket(5555);
        System.out.println("system is waiting");
        
        while(true){
        Socket sc = socketServer.accept();
        System.out.println("new request is accepted");
        printWriter= new PrintWriter(sc.getOutputStream(),true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Date date = new Date();
                printWriter.println(date);
                printWriter.flush();
            }
        }).start();
    }
}
}
