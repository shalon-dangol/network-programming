/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SocketDemo;

import java.io.BufferedReader;
import java.net.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 *
 * @author Shalon
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket sc = new Socket("localhost",1111);
        PrintWriter p = new PrintWriter(sc.getOutputStream(),true);
        Scanner scan = new Scanner(System.in);
        System.out.println("enter number");
        int num = scan.nextInt();
        p.println(num);
        BufferedReader r = new BufferedReader(new InputStreamReader(sc.getInputStream()));
        
        System.out.println(r.read());
        p.flush();
        sc.close();
        
        
//        r.write(scan.nextLine());
//        r.flush();
        
    }
    
   
    
}
