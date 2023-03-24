/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package httpexamples;

import java.net.*;

/**
 *
 * @author Shalon
 */
public class HttpKeepAliveDemo {
    public static void main(String[] args) throws MalformedURLException{
        URL url = new URL("http://asm.edu.np");
        System.setProperty("http.keepAlive","true");
        System.setProperty("http.maxConnection","30");
        System.setProperty("http.keepAlive.remainingData","true");
    }
}
