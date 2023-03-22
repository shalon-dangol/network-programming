/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipnet;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Scanner;
/**
 *
 * @author Shalon
 */
public class URLEncoding {
    public static void main(String[] args) throws MalformedURLException{
//    Scanner sc = new Scanner(System.in);
//    System.out.println("Enter query:");
//    String q = sc.nextLine();
//    String url = "https://www.google.com?q="+q;
//    
//    System.out.println("original url: "+url +q);
//    String encoderdUrl = URLEncoder.encode(url+q);
//    
//    String eq = URLEncoder.encode(q);
//    System.out.println(url+eq);
    
    String url2 = "\n https://www.abc.com?name=ram&city=ktm&q=what is network programming?";
    
    URL u = new URL(url2);
    String o = u.getProtocol()+"://";
    o+= u.getAuthority()+"?";
    o+="name="+URLEncoder.encode("ram"+"&");
    o+="city="+URLEncoder.encode("ktm"+"&");
    o+="q="+URLEncoder.encode("what is network programming?"+"&");
        System.out.println(o);
    
        //decoder
        System.out.println(URLDecoder.decode("https://www.google.com/search?q=%2F%40%23%24%3F%21%3F%24%3F%23%24%3F%23%23&sxsrf=AJOqlzXUuMpDeC7-RV09RJdbL8y5GKshRw%3A1679447894033&ei=VlcaZITXAc2MseMPsM2ciAY&ved=0ahUKEwiE2pH5ru79AhVNRmwGHbAmB2EQ4dUDCA8&uact=5&oq=%2F%40%23%24%3F%21%3F%24%3F%23%24%3F%23%23&gs_lcp=Cgxnd3Mtd2l6LXNlcnAQAzIFCCEQoAEyBQghEKABOgsIABCABBCxAxCDAToFCAAQgAQ6BQguEIAEOgUIABCiBEoECEEYAFAAWMQUYM4zaABwAXgAgAGqAYgB6A6SAQQwLjE0mAEAoAEBwAEB&sclient=gws-wiz-serp"));
    }
    
}
