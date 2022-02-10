package http.request;

import http.HttpMethod;
import java.net.URL;

public class RequestLine {

    private final String SP = " ";
    private final String CRLF = "\r\n";

    private final HttpMethod method;
    private final String requestTarget;
    private String httpVersion = "HTTP/1.1";

    private String getRequestTarget(URL url) {
        String requestTarget = url.getPath() + ((url.getQuery() == null) ? "" : url.getQuery());
        return requestTarget.isBlank() ? "/" : requestTarget;
    }

    public RequestLine(URL url, HttpMethod method) {
        this.method = method;
        this.requestTarget = getRequestTarget(url);
    }

    public RequestLine(URL url, HttpMethod method, String httpVersion) {
        this.method = method;
        this.requestTarget = getRequestTarget(url);
        this.httpVersion = httpVersion;
    }

    @Override
    public String toString() {
        return method.getValue()
            + SP
            + requestTarget
            + SP
            + httpVersion
            + CRLF;
    }
}
