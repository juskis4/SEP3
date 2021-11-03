package Sockets.Handlers;

import java.io.IOException;

public interface ConnectionHandler {
    void sendToServer(String message) throws IOException;
    void receiveFromServer(String message) throws IOException;
    void connect() throws IOException;
    void disconnect() throws IOException;
}
