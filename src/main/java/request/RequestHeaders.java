package request;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RequestHeaders {

    private final String DELIMITER = ": ";
    private final String CRLF = "\r\n";
    private final Map<String, String> headers = new HashMap<>();

    public void add(String fieldName, String fieldValue) {
        headers.put(fieldName, fieldValue);
    }

    @Override
    public String toString() {
        StringBuilder reqHeader = new StringBuilder();
        for (Entry entry : headers.entrySet()) {
            reqHeader
                .append(entry.getKey())
                .append(DELIMITER)
                .append(entry.getValue())
                .append(CRLF);
        }
        return reqHeader.toString();
    }
}
