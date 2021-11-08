package Sockets.Handling;

import Sockets.Models.User;
import Sockets.Packages.UserPackage;
import com.google.gson.Gson;
import mediator.DatabaseServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

public class ServerHandling implements Runnable{
    private Socket socket;
    private DatabaseServer databaseServer;
    private Gson gson;

    public ServerHandling(DatabaseServer databaseServer) throws IOException, SQLException {
        connect(databaseServer);
    }

    private void connect(DatabaseServer databaseServer) throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(2910);
        System.out.println("Server started...");
        this.socket = serverSocket.accept();
        gson = new Gson();
        this.databaseServer = databaseServer;
    }

    public void run()
    {
        while(true)
        {
            try {
                InputStream inputStream = socket.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                Object obj = objectInputStream.readObject();
                if(obj instanceof UserPackage)
                {
                    UserPackage received = (UserPackage)obj;
                    switch (received.getType())
                    {
                        case "validateLogin" :
                            //Receive user from client
                            User user = received.getUser();
                            //Getting user from database with credentials given from Client
                            User userToBeSent = databaseServer.getUserDB(user.getUsername(), user.getPassword());
                            UserPackage toSentPackage = new UserPackage( userToBeSent, "lol");
                            //Sending back the user such that it can be validated
                            sendDataToServer(toSentPackage);
                            break;
                        default:
                            System.out.println("Type not found");
                    }
                }

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            }


        }

    public void sendDataToServer(UserPackage obj) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(obj);
        System.out.println("Sent object");
    }
    }

