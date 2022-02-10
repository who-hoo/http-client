import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Browser {

    private URL getUrl(String input) throws IllegalArgumentException {
        try {
            URL url = new URL(input);
            return url;
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("유효하지 않은 url 형식입니다.");
        }
    }

    private List<String> findHostAddresses(URL url) throws IllegalArgumentException {
        List<String> hostAddressList = new ArrayList<>();
        try {
            System.out.println("(DNS Lookup...)");
            InetAddress[] allByName = InetAddress.getAllByName(url.getHost());
            for (InetAddress inetAddress : allByName) {
                hostAddressList.add(inetAddress.getHostAddress());
            }
        } catch (UnknownHostException e) {
            throw new IllegalArgumentException("해당 도메인이 존재하지 않습니다.");
        }
        return hostAddressList;
    }
}
