package Sockets.Handling;

import Sockets.Models.User;
import Sockets.Packages.SendingType;
import com.google.gson.Gson;
import mediator.DatabaseServerManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerHandling implements Runnable{
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private boolean running;
    private Gson gson;

    public ServerHandling() throws IOException
    {
        connect(socket);
    }

    private void connect(Socket socket) throws IOException
    {
        this.socket = socket;
        gson = new Gson();
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    public void run()
    {
        SendingType sendingType;
        try {
            sendingType = gson.fromJson(in.readLine(),SendingType.class);

            switch (sendingType.getType())
            {
                case "validateUser" :
                    User user = sendingType;
                    DatabaseServerManager.getInstance().getUserDB()
            }
        }
    }

    public void sendToServer(String message)
    {

    }


}
