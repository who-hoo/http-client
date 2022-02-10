import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
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

    private List<String> findHostAddresses(URL url) throws UnknownHostException {
        List<String> hostAddressList = new ArrayList<>();
        System.out.println("(DNS Lookup...)");
        InetAddress[] allByName = InetAddress.getAllByName(url.getHost());
        for (InetAddress inetAddress : allByName) {
            hostAddressList.add(inetAddress.getHostAddress());
        }
        return hostAddressList;
    }

    private void connect(URL url) {
        try {
            String serverIP = findHostAddresses(url).get(0);
            int port = (url.getPort() == -1) ? 80 : url.getPort();
            System.out.println("TCP Connection : " + serverIP + " " + port);

            Socket socket = new Socket(serverIP, port);

            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream(), "UTF8"));
            BufferedWriter out = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream()));

            // TODO: Request 객체 생성
            // TODO: Request 메시지 전송
            // TODO: Response 처리

            out.close();
            in.close();
        } catch(UnknownHostException e) {
            throw new IllegalArgumentException("해당 도메인이 존재하지 않습니다.");
        } catch (IOException e) {
            throw new IllegalArgumentException("연결에 실패하였습니다.");
        }
    }
}
