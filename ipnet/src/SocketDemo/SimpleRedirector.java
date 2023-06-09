/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SocketDemo;

/**
 *
 * @author Shalon
 */

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class SimpleRedirector {
    public static void main(String[] args) throws IOException {
        int port = 7000;
        String redirectTo = "http://www.google.com/";

        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                exchange.getResponseHeaders().set("Location", redirectTo);
                exchange.sendResponseHeaders(301, -1);
                exchange.close();
            }
        });
        server.setExecutor(null);
        server.start();
    }
}