/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SocketDemo;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Shalon
 */
public class FIleTransferClient {
    public static DataOutputStream dataOutputStream = null;
    public static void main(String[] args) {
        try(Socket sc = new Socket("localhost", 5555)) {
           dataOutputStream = new DataOutputStream(sc.getOutputStream());
           sendFile("");
           dataOutputStream.close();
           sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void sendFile(String file) throws FileNotFoundException, IOException{
        int bytes = 0;
        File f = new File(file);
        FileInputStream fileInputStream = new FileInputStream(file);
        dataOutputStream.writeLong(f.length());
        
        byte[] buffer = new byte[4*1024];
        while((bytes=fileInputStream.read(buffer))!=1){
            dataOutputStream.write(buffer,0,bytes);
            dataOutputStream.flush();
        }
    }
}
