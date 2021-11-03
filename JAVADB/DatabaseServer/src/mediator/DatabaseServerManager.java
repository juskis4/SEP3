package mediator;

import domain.User;

import javax.xml.crypto.Data;
import java.sql.*;

public class DatabaseServerManager implements DatabaseServer
{
  private Connection connection;

  private static DatabaseServerManager instance;
  private static Object lock = new Object();
  public DatabaseServerManager()
  {
  }

  @Override public User getUserDB (String username, String password) throws SQLException
  {
    User user = null;
     try(Connection connection = getConnection())
     {
       PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?;");
       statement.setString(1, username);
       statement.setString(2, password);

       ResultSet resultSet = statement.executeQuery();

       while(resultSet.next())
       {
         user = new User(Integer.parseInt(resultSet.getString("id")), resultSet.getString("username"), resultSet.getString("password"), resultSet.getString("photo"), resultSet.getString("first_name"), resultSet.getString("last_name"), Integer.parseInt(resultSet.getString("security_level")), resultSet.getString("role"));
       }
     }
     return user;
  }
  private Connection getConnection() throws SQLException
  {

    return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=sep3_project", "postgres","");
  }

  public static DatabaseServerManager getInstance() {
    if(instance == null)
    {
      synchronized (lock)
      {
        if(instance == null)
        {
          instance = new DatabaseServerManager();
        }
      }
    }
    return instance;
  }
}
