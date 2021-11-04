import Sockets.Handling.ServerHandling;
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
  }
}
