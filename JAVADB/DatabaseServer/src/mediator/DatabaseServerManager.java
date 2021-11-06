package mediator;

import Sockets.Models.User;

import java.sql.*;

public class DatabaseServerManager implements DatabaseServer
{
  private Connection connection;
  public DatabaseServerManager() throws SQLException {
    DriverManager.registerDriver(new org.postgresql.Driver());
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
         user = new User(Integer.parseInt(resultSet.getString("id")), resultSet.getString("username"),
                 resultSet.getString("password"), resultSet.getString("photo"),
                 resultSet.getString("firstname"), resultSet.getString("lastname"),
                 resultSet.getString("securityLevel"), resultSet.getString("role"));
       }
     }
     return user;
  }

  private Connection getConnection() throws SQLException
  {

    return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=sep3_database", "postgres","1234");
  }
}
