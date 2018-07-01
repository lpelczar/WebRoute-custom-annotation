package com.codecool.webroute;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class WebServer {

    public void start() throws IOException {

        HttpServer server = HttpServer.create(new InetSocketAddress(9000), 0);
        server.createContext("/", new WebController());
        server.setExecutor(null);
        server.start();
    }
}
