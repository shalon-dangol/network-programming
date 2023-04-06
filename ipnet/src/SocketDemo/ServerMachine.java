/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SocketDemo;

import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author Shalon
 */
public class ServerMachine {
    public static void main(String[] args) throws IOException {
//        JFrame frame = new JFrame();
//        JPanel p = new JPanel();
//        JLabel lbl = new JLabel("server");
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

          final ServerSocket  serverSocket;
          final Socket clientSocket;
          final BufferedReader in;
          final PrintWriter out;
          final Scanner sc = new Scanner(System.in);
          
          try{
              serverSocket = new ServerSocket(1234);
              clientSocket = serverSocket.accept();
              System.out.println("server started\n");
              out = new PrintWriter(clientSocket.getOutputStream());
              in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
              Thread sender = new Thread(new Runnable() {
                  String msg;
                  @Override
                  public void run() {
                      while(true){
                          msg = sc.nextLine();
                          out.println(msg);
                          out.flush();
                      }
                  }
              });
              sender.start();
              
              Thread receive = new Thread(new Runnable(){
                  String msg;

                  @Override
                  public void run() {
                      try{
                          msg=in.readLine();
                          while(msg!=null){
                              System.out.println("Client: "+msg);
                              msg = in.readLine();
                              
                          }
                          System.out.println("Client Disconnected");
                          out.close();
                          serverSocket.close();
                          
                      }catch(IOException e){
                          e.printStackTrace();
                      }
                  }
                  
              });
              receive.start();
          }catch(IOException e){
              e.printStackTrace();
          }
    }
}
