package com.codecool.webroute;

import com.sun.net.httpserver.HttpExchange;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import java.io.IOException;

class WebController {

    @WebRoute("/test")
    void onTest(HttpExchange httpExchange) throws IOException {
        sendDataToTwig(httpExchange, "This is a test!");
    }

    @WebRoute("/another-test")
    void onAnotherTest(HttpExchange httpExchange) throws IOException {
        sendDataToTwig(httpExchange, "This is another test!");
    }

    private void sendDataToTwig(HttpExchange httpExchange, String dataString) throws IOException {
        JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/test.twig");
        JtwigModel model = JtwigModel.newModel();
        Data data = new Data(dataString);
        model.with("data", data);
        ResponseSender.sendResponse(httpExchange, template.render(model));
    }
}
