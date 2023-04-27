/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SocketDemo;

import com.sun.net.httpserver.*;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

/**
 *
 * @author Shalon
 */

public class HttpServerDemo {
    public static void main(String[] args) throws IOException {
        int port = 8000;

        // Create a new HTTP server
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        // Create a new handler for the root path
        server.createContext("/", new HttpHandler() {
            public void handle(HttpExchange exchange) throws IOException {
                String response = "<h1>Hello, World!</h1>";
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        });
        
         // Create a new handler for the root path
        server.createContext("/about", new HttpHandler() {
            public void handle(HttpExchange exchange) throws IOException {
                String response = "<h1>about</h1>";
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        });
        
          // Create a new handler for the root path
        server.createContext("/contact", new HttpHandler() {
            public void handle(HttpExchange exchange) throws IOException {
                String response = "<h1>contact</h1>";
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        });

        // Start the server
        server.start();

        System.out.println("Server started on port " + port);
    }
}