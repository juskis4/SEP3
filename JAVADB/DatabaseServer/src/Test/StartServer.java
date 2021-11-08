package Test;

import Sockets.Handling.ServerHandling;
import Sockets.Models.User;
import Sockets.Packages.UserPackage;
import mediator.DatabaseServer;
import mediator.DatabaseServerManager;

import javax.imageio.IIOException;
import java.io.IOException;
import java.net.ServerSocket;
import java.sql.SQLException;

public class StartServer
{
  public static void main(String[] args) throws SQLException, IOException
  {
    DatabaseServer databaseServer = new DatabaseServerManager();
    ServerHandling serverHandling = new ServerHandling(databaseServer);
    Thread thread = new Thread(serverHandling);
    thread.start();
    User user = databaseServer.getUserDB("admin", "admin");
    User user1 = databaseServer.getUserDB("user", "user");
    UserPackage userPackage = new UserPackage(user, "lol");
    //UserPackage userPackage1 = new UserPackage(user1);
    serverHandling.sendDataToServer(userPackage);
    System.out.println("sent");

  }
}
