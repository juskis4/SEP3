package mediator;

import domain.User;

import java.sql.SQLException;

public interface DatabaseServer
{
  User getUserDB(String username, String password) throws SQLException;
}
