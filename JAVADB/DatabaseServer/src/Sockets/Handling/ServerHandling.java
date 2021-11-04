package Sockets.Handling;

import Sockets.Models.User;
import Sockets.Packages.SendingType;
import Sockets.Packages.UserPackage;
import com.google.gson.Gson;
import mediator.DatabaseServer;
import mediator.DatabaseServerManager;

import javax.sound.sampled.AudioFormat;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

public class ServerHandling implements Runnable{
    private Socket socket;
    private ServerSocket serverSocket;
    private DatabaseServer databaseServer;
    private BufferedReader in;
    private PrintWriter out;
    private boolean running;
    private Gson gson;

    public ServerHandling(Socket socket, DatabaseServer databaseServer) throws IOException, SQLException {
        connect(socket, databaseServer);
    }

    private void connect(Socket socket, DatabaseServer databaseServer) throws IOException
    {
        serverSocket = new ServerSocket(2910);
        System.out.println("Server started...");
        this.socket = socket;
        gson = new Gson();
        this.databaseServer = databaseServer;
    }

    public void run()
    {
        try {
            InputStream inputStream = socket.getInputStream();
            byte[] lenbytes = new byte[1024];
            int read = inputStream.read(lenbytes,0, lenbytes.length);
            String message = new String(lenbytes, 0, read);
            System.out.println("Tier 2: " + message);

            SendingType received = gson.fromJson(message, SendingType.class);

            switch (received.getType())
            {
                case "validateUser" :
                    //Receive user from client
                    UserPackage userPackage = gson.fromJson(message, UserPackage.class);
                    User user = userPackage.getUser();

                    //Getting user from database with credentials given from Client
                    User userToBeSent = databaseServer.getUserDB(user.getUsername(), user.getPassword());
                    UserPackage toSentPackage = new UserPackage("validateUser", userToBeSent);

                    //Sending back the user such that it can be validated
                    String replyToClient = gson.toJson(toSentPackage);
                    sendDataToServer(replyToClient);


            }
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void sendDataToServer(String message) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        byte[] messageAsBytes = message.getBytes();
        outputStream.write(messageAsBytes, 0, messageAsBytes.length);
        socket.close();
    }


}
