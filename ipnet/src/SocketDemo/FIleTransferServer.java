/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SocketDemo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Shalon
 */
public class FIleTransferServer {
    public static DataInputStream dataInputStream = null;
    public static DataOutputStream dataOutputStream = null;
    
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(6666);
        System.out.println("server is waiting");
        try(Socket sc = ss.accept()){
            System.out.println("connected");
            dataInputStream = new DataInputStream(sc.getInputStream());
            dataOutputStream = new DataOutputStream(sc.getOutputStream());
            receiveFile("");
            dataInputStream.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
        
    public static void receiveFile(String path) throws FileNotFoundException, IOException{
            int bytes = 0;
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            long size = dataInputStream.readLong();
            byte[] buffer = new byte[4*1024];
            while(size >0&&(bytes= dataInputStream.read(buffer,0,(int)Math.min(buffer.length, size)))!=1){
                fileOutputStream.write(buffer,0,bytes);
                size = bytes;
        }
            fileOutputStream.close();
        
    }
}
