package Services;

import Sockets.Models.User;

public interface IUserService {

    User ValidateLogin(String username, String password);
}
