package request;

import java.net.URL;

public class RequestLine {

    private final String SP = " ";
    private final String CRLF = "\n";

    private final HttpMethod method;
    private final String requestTarget;
    private String httpVersion = "HTTP/1.1";

    public RequestLine(URL url, HttpMethod method) {
        this.method = method;
        this.requestTarget = url.getPath() + url.getFile() + url.getQuery();
    }

    public RequestLine(URL url, HttpMethod method, String httpVersion) {
        this.method = method;
        this.requestTarget = url.getPath() + url.getFile() + url.getQuery();
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
