/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SocketDemo;

import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.Scanner;
import javax.swing.*;
/**
 *
 * @author Shalon
 */
public class DateClientSide {
    static JButton button;
    static JTextArea txtArea;
    public static void main(String[] args) throws IOException {
//         Socket soc = new Socket("localhost",1111);
//        BufferedReader in=new BufferedReader(new InputStreamReader(soc.getInputStream()  ));
//        String out = in.toString();
//        JFrame frame = new JFrame();
//        button = new JButton ("date");
//        txtArea = new JTextArea();
//        JPanel panel = new JPanel();
//        panel.add(button);
//        panel.add(txtArea);
//        frame.add(panel);
//        frame.setSize(500,500);
//        frame.setVisible(true);
//         button.addActionListener(new ActionListener() {
//            Date date = new Date();
//            String showDate =  date.toString();
//            @Override
//            public void actionPerformed(ActionEvent e) {
//               txtArea.setText(showDate);
//                txtArea.setText(out);
//            }
//    });
       
        
//        PrintWriter p = new PrintWriter(sc.getOutputStream(),true);
//        Date showDate = new Date();
//        System.out.println("date: "+ showDate);
        
    Socket soc=new Socket(InetAddress.getLocalHost(),5217);        
        BufferedReader in=new BufferedReader(new InputStreamReader(soc.getInputStream()  ));
        String out = in.readLine().toString();
        
        
    }
}
