package Services;

import Sockets.Models.User;

import java.io.IOException;

public interface IUserService {

    User ValidateLogin(String username, String password) throws IOException;
}
