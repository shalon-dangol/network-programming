/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipnet;
import java.util.Scanner;
import java.net.UnknownHostException;
import java.net.InetAddress;
/**
 *
 * @author Shalon
 */
public class TestIPv4orIPv6 {
    public static void main(String[] args) throws UnknownHostException{
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter ip address: ");
    String s = sc.nextLine();
    InetAddress ip = InetAddress.getByName(s);
    
    if (ip.getAddress().length == 4){
            System.out.println("IPv4");
    }
    else if(ip.getAddress().length ==16){
            System.out.println("IPv6");
    }
    else{
            System.out.println("Wrong ip Address");
}
    
}
}
