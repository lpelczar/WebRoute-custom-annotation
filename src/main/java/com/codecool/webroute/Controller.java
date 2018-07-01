package com.codecool.webroute;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class Controller implements HttpHandler {

    public void handle(HttpExchange httpExchange) {

        String path = httpExchange.getRequestURI().getPath();
        System.out.println(path);

    }
}
