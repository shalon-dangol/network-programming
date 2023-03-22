/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipnet;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
/**
 *
 * @author Shalon
 */
public class NetworkInterfaceDemo {
    public static void main(String[] args) throws SocketException, UnknownHostException{
        Enumeration<NetworkInterface> ips = NetworkInterface.getNetworkInterfaces();
        while(ips.hasMoreElements()){
            NetworkInterface ip = ips.nextElement();
            System.out.println(ip);
        }
        
        NetworkInterface e = NetworkInterface.getByName("eth0");
        InetAddress myip = InetAddress.getLocalHost();
        NetworkInterface m = NetworkInterface.getByInetAddress(myip);
        System.out.println("Network Interface: " +m.getDisplayName());
    }
}
