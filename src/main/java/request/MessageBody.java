package request;

public class MessageBody {

    String body;

    public MessageBody() {
        this.body = "";
    }

    public MessageBody(String body) {
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
