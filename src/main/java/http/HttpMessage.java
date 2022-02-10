package http;

public abstract class HttpMessage {

    protected StartLine startLine;
    private final Header header;
    private final Body body;

    protected HttpMessage() {
        this.header = new Header();
        this.body = new Body();
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
