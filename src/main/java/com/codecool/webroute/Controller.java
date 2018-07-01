package com.codecool.webroute;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class Controller implements HttpHandler {

    public void handle(HttpExchange httpExchange) {

        String path = httpExchange.getRequestURI().getPath();

    }

    @WebRoute("/test")
    private void onTest(HttpExchange httpExchange) throws IOException {
    }

    private void sendResponse(HttpExchange httpExchange, String response) throws IOException {
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
