package com.codecool.webroute;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RootController implements HttpHandler {

    private WebController webController;

    RootController(WebController webController) {
        this.webController = webController;
    }

    public void handle(HttpExchange httpExchange) {

        String path = httpExchange.getRequestURI().getPath();
        String firstSegment = getFirstSegmentOfURI(path);
        HttpMethod httpMethod = httpExchange.getRequestMethod().equals("GET") ? HttpMethod.GET : HttpMethod.POST;

        Class<WebController> aClass = WebController.class;

        for (Method method : aClass.getDeclaredMethods()) {

            if (method.isAnnotationPresent(WebRoute.class)) {

                Annotation annotation = method.getAnnotation(WebRoute.class);
                WebRoute webRoute = (WebRoute) annotation;

                if (webRoute.method().equals(httpMethod) && webRoute.path().equals(firstSegment)) {

                    try {
                        method.invoke(webController, httpExchange);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private String getFirstSegmentOfURI(String path) {
        String[] segments = path.split("/");
        return segments.length == 0 ? "/" : "/" + segments[1];
    }
}
