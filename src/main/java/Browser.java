import java.net.MalformedURLException;
import java.net.URL;

public class Browser {

    private URL getUrl(String input) throws IllegalArgumentException {
        try {
            URL url = new URL(input);
            return url;
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("유효하지 않은 url 형식입니다.");
        }
    }
}
