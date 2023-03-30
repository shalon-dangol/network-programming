/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipnet;

import java.io.*;
import java.net.*;
import java.util.Date;

/**
 *
 * @author Shalon
 */
public class HttpHeaderConfig {
    public static void main(String[] args) throws MalformedURLException, IOException {
        URL url = new URL("http://www.asm.edu.np");
    URLConnection conn = url.openConnection();
    Date d = new Date();
    conn.setRequestProperty("Date",d.toString());
    conn.setRequestProperty("Name", "xyz");
    conn.setRequestProperty("CIty", "KTM");
    conn.addRequestProperty("date","2023/12/12");
    //    conn.connect();
        System.out.println(conn.getRequestProperty("date"));
    //InputStream stream = conn.getInputStream();
    //conn.setRequestProperty("pqr","123);
    
    //to check security consideration in URLConnection 
        System.out.println(conn.getPermission());
    }
}
