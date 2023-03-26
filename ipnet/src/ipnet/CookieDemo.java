/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipnet;

import java.io.IOException;
import java.net.*;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Shalon
 */
public class CookieDemo {
    
    public static void main(String[] args) throws MalformedURLException, IOException {
        CookieManager manager = new CookieManager();
        manager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        
        CookieManager manager2 = new CookieManager();
        manager2.setCookiePolicy(CookiePolicy.ACCEPT_ORIGINAL_SERVER);
        
        CookieHandler.setDefault(manager);
        
        URL url = new URL("https://www.youtube.com");
        URLConnection conn = url.openConnection();
        conn.getContent();
        
        URL url2 = new URL("https://www.google.com");
        URLConnection conn2 = url2.openConnection();
        conn2.getContent();
        
        CookieStore storeCookie = manager.getCookieStore();
        List<HttpCookie> cookies = storeCookie.getCookies();
        
        for(HttpCookie cookie:cookies){
            System.out.println("Domain"+cookie.getDomain());
            System.out.println("max age"+cookie.getMaxAge());
            System.out.println("name of cookie:"+cookie.getName());
            System.out.println("value of cookie"+cookie.getValue());
            System.out.println("version"+cookie.getVersion());
        }
        
        
    }
}
