import domain.User;
import mediator.DatabaseServerManager;

import java.sql.SQLException;

public class Test
{
  public static void main(String[] args) throws SQLException
  {
    DatabaseServerManager databaseServerManager = new DatabaseServerManager();
    User user;
    user = databaseServerManager.getUserDB("user", "user");
    System.out.println(user.getRole());
  }
}
