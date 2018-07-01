package com.codecool.webroute;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.lang.reflect.Method;

public class RootController implements HttpHandler {

    public void handle(HttpExchange httpExchange) {

        String path = httpExchange.getRequestURI().getPath();
        String firstSegment = getFirstSegmentOfURI(path);
        System.out.println(firstSegment);

        Class<WebController> aClass = WebController.class;

        for (Method method : aClass.getDeclaredMethods()) {


        }
    }

    private String getFirstSegmentOfURI(String path) {
        String[] segments = path.split("/");
        return segments.length == 0 ? "/" : "/" + segments[1];
    }
}
