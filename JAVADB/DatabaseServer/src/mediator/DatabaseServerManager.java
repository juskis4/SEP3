package mediator;

import Sockets.Models.User;

import java.sql.*;

public class DatabaseServerManager implements DatabaseServer
{
  public DatabaseServerManager() throws SQLException {
    DriverManager.registerDriver(new org.postgresql.Driver());
    try {
      Class.forName("org.postgresql.Driver");
    }
    catch (java.lang.ClassNotFoundException e) {
      System.out.println(e.getMessage());
    }
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
                 resultSet.getString("first_name"), resultSet.getString("last_name"),
                 resultSet.getString("security_level"), resultSet.getString("role"));
       }
     }
     return user;
  }

  private Connection getConnection() throws SQLException
  {
    String url = "jdbc:postgresql://ella.db.elephantsql.com:5432/zgckhgwi";
    String username = "zgckhgwi";
    String password = "S_S0QYXJm9u10Vi53oEXaHAJo0W5Q7vB";
    return DriverManager.getConnection(url, username, password);
  }
}
