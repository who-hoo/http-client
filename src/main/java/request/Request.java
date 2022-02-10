package request;

import java.net.MalformedURLException;
import java.net.URL;

public class Request {

    private final URL url;
    private final HttpMethod method;
    private final RequestLine startLine;
    private final RequestHeaders header;
    private final MessageBody body;

    public Request(URL url) {
        this.url = url;
        this.method = HttpMethod.GET;
        this.startLine = new RequestLine(url, method);
        this.header = new RequestHeaders();
        this.body = new MessageBody();
    }

    public Request(HttpMethod method, URL url) {
        this.url = url;
        this.method = method;
        this.startLine = new RequestLine(url, method);
        this.header = new RequestHeaders();
        this.body = new MessageBody();
    }

    public void addHeader(String fieldName, String fieldValue) {
        this.header.add(fieldName, fieldValue);
    }

    public void addBody(String bodyContent) {
        this.body.append(bodyContent);
    }

    public String getMessage() {
        return ""
            + this.startLine
            + this.header
            + this.body;
    }
}
