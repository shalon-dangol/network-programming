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
public class ServerSideJFrame {
    static JLabel lbl;
    static JTextArea textArea;
    static JTextField textField;
    static JButton btn;
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        lbl = new JLabel("Server");
        textArea = new JTextArea(20,40);
        textField = new JTextField(20);
        textArea.disable();
        btn = new JButton("Send");
        JPanel panel =  new JPanel();
        panel.add(lbl);
        panel.add(textArea);
        panel.add(textField);
        panel.add(btn);
        frame.add(panel);
        frame.setSize(500,500);
        frame.setVisible(true);
        
        final ServerSocket  serverSocket;
          final Socket clientSocket;
          final BufferedReader in;
          final PrintWriter out;
          
          try{
              serverSocket = new ServerSocket(1234);
              clientSocket = serverSocket.accept();
              System.out.println("server started\n");
              out = new PrintWriter(clientSocket.getOutputStream());
              in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
              btn.addActionListener(new ActionListener() {
                  String msg;
                  @Override
                  public void actionPerformed(ActionEvent e) {
                      msg = textField.getText();
                   textArea.setText(textArea.getText()+"\nMe:"+msg);
                   textField.setText("");
                   out.println(msg);
                   out.flush();
                  }
              });
              
              Thread receive = new Thread(new Runnable(){
                  String msg;

                  @Override
                  public void run() {
                      try{
                          msg=in.readLine();
                          while(msg!=null){
                             textArea.setText(textArea.getText()+"\nClient:"+msg);;
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
