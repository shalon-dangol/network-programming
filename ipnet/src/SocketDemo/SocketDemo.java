/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SocketDemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

/**
 *
 * @author Shalon
 */
public class SocketDemo {
      public static void main(String[] args) throws IOException, UnknownHostException {
          try{
//              Socket sc = new Socket();
//        SocketAddress address = new InetSocketAddress("s1.yahoo.com",2222);
//        sc.connect(address);
//        sc.close();
        
        //Getting information about the socket
        Socket sc2 = new Socket("localhost",3333);
        SocketAddress scAddress = sc2.getRemoteSocketAddress();
        System.out.println(scAddress);
        
        //new socket
        Socket sc3 = new Socket();
        sc3.connect(scAddress);//reconnect with new socket
          }catch(Exception ex){
              ex.printStackTrace();
          }
        
        
        
        
    }
}
