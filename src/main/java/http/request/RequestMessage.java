package http.request;

import http.HttpMessage;
import http.HttpMethod;
import java.net.URL;

public class RequestMessage extends HttpMessage {

    public RequestMessage(URL url, HttpMethod method) {
        super();
        this.startLine = new RequestLine(url, method);
    }

    public RequestMessage(URL url, HttpMethod method, String httpVersion) {
        super();
        this.startLine = new RequestLine(url, method, httpVersion);
    }
}
