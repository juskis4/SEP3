package Models;

import java.io.IOException;

public interface IUserModel {
    User ValidateUser(String username, String password) throws IOException;
}
