package Sockets.Handling;

import Sockets.Models.User;
import Sockets.Packages.SendingType;
import Sockets.Packages.UserPackage;
import com.google.gson.Gson;
import mediator.DatabaseServerManager;

import javax.sound.sampled.AudioFormat;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

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
//                    SendingType userPackage = gson.fromJson();
//                    DatabaseServerManager.getInstance().getUserDB()
            }
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void sendDataToServer(String message)
    {
        byte[] dataToClient = message.getBytes();

    }


}
