package Sockets.Handlers;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientHandling {

    private static String HOST = "localhost";
    private static int PORT = 2910;
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;

    public ClientHandling() throws IOException {
        connect();
    }

    public void sendToServer(String message) throws IOException {
        byte[] messageAsBytes = message.getBytes();
        outputStream.write(messageAsBytes, 0, messageAsBytes.length);
    }

    public String receiveFromServer() throws IOException {
        byte[] lenbytes = new byte[1024];
        int read = inputStream.read(lenbytes, 0, lenbytes.length);
        String message = new String(lenbytes, 0, read);
        return message;
    }

    public void connect() throws IOException {
        this.socket = new Socket(HOST, PORT);
        inputStream = socket.getInputStream();
        outputStream = socket.getOutputStream();
    }

    public void disconnect() throws IOException {
        socket.close();
    }
}
