/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipnet;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author Shalon
 */
public class URLConnectionConfigDemo {
    public static void main(String[] args) throws MalformedURLException, IOException {
        URL url = new URL("http://asm.edu.np");
        
        URLConnection conn = url.openConnection();
        System.out.println(conn.getURL());
        
        conn.setDoInput(true);
        System.out.println(conn.getDoInput());
        
        conn.setDoOutput(false);
        System.out.println(conn.getDoOutput());
        
        conn.setAllowUserInteraction(false);
        conn.setUseCaches(true);
        conn.setUseCaches(false);
        Date d = new Date();
        
        conn.setIfModifiedSince(500000000);//Jan 1st 1970
        
        System.out.println(conn.getIfModifiedSince());
        
        conn.setReadTimeout(5000);
    }
}
