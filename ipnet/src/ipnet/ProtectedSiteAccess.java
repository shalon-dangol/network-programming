/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipnet;

import java.awt.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

/**
 *
 * @author Shalon
 */
public class ProtectedSiteAccess {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(new GridLayout(2,2));
        
        JLabel lbl_username= new JLabel("Username");
        JTextField username = new JTextField();
        
        JLabel lbl_password= new JLabel("Password");
        JPasswordField password = new JPasswordField();
        
        panel.add(lbl_username);
        panel.add(username);
        panel.add(lbl_password);
        panel.add(password);
        
        int res = JOptionPane.showConfirmDialog(frame,panel,"Login",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
        if(res == JOptionPane.OK_OPTION){
            String u = username.getText();
            char[] p = password.getPassword();
            Authenticator.setDefault(new CustomAuthenticator(u,p));
            try{
                URL url = new URL("https://www.asm.edu.np/dashboard.html");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                
                InputStream stream = conn.getInputStream();
                InputStreamReader r = new InputStreamReader(stream);
                int c;
                while((c = r.read())!= -1){
                    System.out.println((char)c);
                }
                
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }else{
            System.out.println("you cancel the login");
        }
    }

private static class CustomAuthenticator extends Authenticator{
  private  String uname;
  private char[] pass;
    public CustomAuthenticator(String u, char[] p){
        this.uname = u;
        this.pass = p;
    }
    @Override
    protected PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(uname,pass);
    }
}
}