/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SocketDemo;

import java.io.BufferedReader;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author Shalon
 */
public class ClientMachine {
    public static void main(String[] args) throws IOException {
//        JFrame frame = new JFrame();
//        JPanel p = new JPanel();
//        JLabel lbl = new JLabel("client");
//        JTextArea t = new JTextArea(10,30);
//        JTextField mField = new JTextField(20);
//        JButton btn = new JButton("click");
//        GroupLayout layout = new GroupLayout(p);
//        layout.setVerticalGroup(layout.createSequentialGroup().addComponent(lbl).addComponent(t));
//        p.add(mField);
//        p.add(btn);
//        frame.add(p);
//        frame.setSize(500,500);
//        frame.setVisible(true);

          final Socket clientSocket;
          final BufferedReader in;
          final PrintWriter out;
          final Scanner sc = new Scanner(System.in);
          try{
              clientSocket = new Socket("192.168.1.1",1234);
              System.out.println("Client Started\n");
              out = new PrintWriter(clientSocket.getOutputStream());
              in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
              
              Thread sender = new Thread (new  Runnable(){
                  String msg;

                  @Override
                  public void run() {
                      while(true){
                          msg= sc.nextLine();
                          out.println(msg);
                          out.flush();
                      }
                  }
                  
              });
              sender.start();
          
          
          Thread receiver = new Thread(new Runnable(){
              String msg;
              @Override
              public void run() {
                 try{
                     msg= in.readLine();
                     while(msg!=null){
                         System.out.println("Server: "+msg);
                         msg= in.readLine();
                     }
                     System.out.println("Server out of service");
                     out.close();
                     clientSocket.close();
                 }catch(IOException e){
                     e.printStackTrace();
                 }
              }
              
          });
          receiver.start();
          
        
    }catch(IOException e){
    e.printStackTrace();
}
    }
}
