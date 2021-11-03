package Handlers;


import org.apache.catalina.Host;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class HandlerImpl implements ConnectionHandler {

    private static String HOST = "localhost";
    private static int PORT = 5001;
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;

    private HandlerImpl() throws IOException {
        connect();
    }

    @Override
    public void sendToServer(String message) throws IOException {

    }

    @Override
    public void receiveFromServer(String message) throws IOException {

    }

    @Override
    public void connect() throws IOException {
        this.socket = new Socket(HOST, PORT);
        inputStream = socket.getInputStream();
        outputStream = socket.getOutputStream();
    }

    @Override
    public void disconnect() throws IOException {
        socket.close();
    }
}
