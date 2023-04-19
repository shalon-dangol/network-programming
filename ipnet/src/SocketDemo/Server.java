/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SocketDemo;

import java.io.*;
import java.net.*;

/**
 *
 * @author Shalon
 */
public class Server {
    public static void main(String[] args) throws IOException, SocketException{
        ServerSocket serverSocket = new ServerSocket(3333);
        Socket sc = serverSocket.accept();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(sc.getInputStream()));
//        PrintWriter stream = new PrintWriter(sc.getOutputStream(),true);
//        int num = Integer.parseInt(reader.readLine());
//        
//        System.out.println(num*num);
//        stream.flush();
//        stream.close();
        
    }
}
