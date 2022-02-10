package request;

public class MessageBody {

    String body;

    public MessageBody() {
        this.body = "";
    }

    public MessageBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return body;
    }
}
