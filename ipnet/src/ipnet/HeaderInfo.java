/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipnet;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.Date;

/**
 *
 * @author Shalon
 */
public class HeaderInfo {
    public static void main(String[] args) throws MalformedURLException, IOException {
        URL url = new URL("https://www.google.com");
        URLConnection conn = url.openConnection();
        InputStream stream = conn.getInputStream();
        
        //method 3
        System.out.println(conn.getContentType());
        System.out.println(new Date(conn.getDate()));
        System.out.println(conn.getContentLength());
        System.out.println(conn.getExpiration());
        
        //method 2 
        System.out.println(conn.getHeaderField("contenct-type"));
        System.out.println(conn.getHeaderField("content-length"));
        System.out.println(conn.getHeaderField("date"));
        System.out.println(conn.getHeaderField("last-modified"));
        
        
    }
}
