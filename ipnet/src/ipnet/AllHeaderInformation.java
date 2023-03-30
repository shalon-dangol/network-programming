/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipnet;

import java.io.*;
import java.net.*;

/**
 *
 * @author Shalon
 */
public class AllHeaderInformation {
    public static void main(String[] args) throws MalformedURLException, IOException {
        URL url = new URL("https://www.google.com");
        URLConnection conn = url.openConnection();
        InputStream stream = conn.getInputStream();
        
        for(int i=0;;i++){
            String header = conn.getHeaderField(i);
            if(header == null){
                break;
            }
            System.out.println(conn.getHeaderFieldKey(i)+"="+header);
        }
    }
}
