package http.request;

import http.HttpMessage;
import http.HttpMethod;
import java.net.URL;

public class Request {

    private final URL url;
    private final HttpMethod method;
    private final HttpMessage message;

    public Request(URL url) {
        this.url = url;
        this.method = HttpMethod.GET;
        this.message = new RequestMessage(url, method);
    }

    public Request(HttpMethod method, URL url) {
        this.url = url;
        this.method = method;
        this.message = new RequestMessage(url, method);
    }

    public void addHeader(String fieldName, String fieldValue) {
        this.message.addHeader(fieldName, fieldValue);
    }

    public void addBody(String bodyContent) {
        this.message.addBody(bodyContent);
    }

    public String getMessage() {
        return message.getMessage();
    }
}
