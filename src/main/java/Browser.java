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
import request.Request;

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

            Request req = new Request(url);
            req.addHeader("Accept", "text/html");
            req.addHeader("Host", url.getHost());
            req.addHeader("User-Agent", "Mozilla/5.0");

            sendRequestMessage(out, req);
            readResponse(in);

            out.close();
            in.close();
        } catch (UnknownHostException e) {
            throw new IllegalArgumentException("해당 도메인이 존재하지 않습니다.");
        } catch (IOException e) {
            throw new IllegalArgumentException("연결에 실패하였습니다.");
        }
    }

    private void sendRequestMessage(BufferedWriter out, Request req) throws IOException {
        System.out.println("\n * Request");

        System.out.println(req.getMessage());
        out.write(req.getMessage());
        out.write("\r\n");
        out.flush();
    }

    private void readResponse(BufferedReader in) throws IOException {
        System.out.println("\n * Response");

        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
    }
}
