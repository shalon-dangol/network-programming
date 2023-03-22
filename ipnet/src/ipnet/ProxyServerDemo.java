/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipnet;

import java.io.IOException;
import java.net.*;

/**
 *
 * @author Shalon
 */
public class ProxyServerDemo {
    public static void main(String[] args) throws MalformedURLException, IOException{
       String proxyAddress = "193.167.10.10";
       //method 1 system property
       System.setProperty("http.Host", proxyAddress);
       System.setProperty("http.proxyPort","80");
       System.setProperty("http.nonProxyHosts","www.google.com|www.facebook.com");
       
       URL url = new URL("http://www.xyz.com");
       url.openConnection();
       
       System.setProperty("https.Host", proxyAddress);
       System.setProperty("https.proxyPort","80");
       System.setProperty("https.nonProxyHosts","www.google.com|www.facebook.com");
       
       //method 2 proxy class
       String p1 = "192.168.1.0";
       String p2 = "192.168.1.1";
       
       SocketAddress a = new InetSocketAddress(p1,80);
       SocketAddress b = new InetSocketAddress(p2,80);
       
       //create the proxy
       Proxy pr1 = new Proxy(Proxy.Type.HTTP,a);
       Proxy pr2 = new Proxy(Proxy.Type.HTTP,b);
       
       URL u1 = new URL("http://ww.asm.edu.np");
       URL u2 = new URL("http://www.xyz.edu.np");
       u1.openConnection(pr1);
       u2.openConnection(pr2);
       
        System.out.println(u1);
        System.out.println(u2);
       
       
    }
}
