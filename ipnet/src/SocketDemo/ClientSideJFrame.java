/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SocketDemo;

import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

/**
 *
 * @author Shalon
 */
public class ClientSideJFrame {
    
    static JLabel lbl;
    static JTextArea textArea;
    static JTextField textfield;
    static JButton btn;
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        lbl = new JLabel("Client");
        textArea = new JTextArea(20,40);
        textfield = new JTextField(20);
        textArea.disable();
        btn = new JButton("Send");
        JPanel panel =  new JPanel();
        panel.add(lbl);
        panel.add(textArea);
        panel.add(textfield);
        panel.add(btn);
        frame.add(panel);
        frame.setSize(500,500);
        frame.setVisible(true);
        
        final Socket clientSocket;
        final BufferedReader in;
        final PrintWriter out;
        
        try{
            clientSocket = new Socket("127.0.0.1",1234);
              System.out.println("Client Started\n");
              out = new PrintWriter(clientSocket.getOutputStream());
              in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
              
              //action listener
              btn.addActionListener(new ActionListener() {
                  String msg;
                @Override
                public void actionPerformed(ActionEvent e) {
                   msg = textfield.getText();
                   textArea.setText(textArea.getText()+"\nMe:"+msg);
                   textfield.setText("");
                   out.println(msg);
                   out.flush();
                   
                }
              });
              
              Thread receiver = new Thread(new Runnable(){
              String msg;
              @Override
              public void run() {
                 try{
                     msg= in.readLine();
                     while(msg!=null){
                         textArea.setText(textArea.getText()+"\nServer:"+msg);
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
