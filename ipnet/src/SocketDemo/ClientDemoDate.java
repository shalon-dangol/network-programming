/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SocketDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author Shalon
 */
public class ClientDemoDate {
        public static void main(String[] args) throws IOException {
        Socket sc=new Socket("localhost",3333);
        BufferedReader in=new BufferedReader(new InputStreamReader(sc.getInputStream()));
        
        String line;
        while((line=in.readLine())!=null){
            System.out.println(line);
        }
    }

}
