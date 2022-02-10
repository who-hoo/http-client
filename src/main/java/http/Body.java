package http;

public class Body {

    String body;

    public Body() {
        this.body = "";
    }

    public Body(String body) {
        this.body = body;
    }

    public void append(String bodyContent) {
        this.body += bodyContent;
    }

    @Override
    public String toString() {
        return body;
    }
}
