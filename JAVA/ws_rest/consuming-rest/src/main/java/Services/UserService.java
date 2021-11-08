package Services;

import Sockets.Handlers.ClientHandling;
import Sockets.Models.User;
import Sockets.Packages.UserPackage;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.io.IOException;

public class UserService implements IUserService {

    private ClientHandling clientHandling;
    private Gson gson;

    public UserService() throws IOException {
        clientHandling = new ClientHandling();
        gson = new Gson();
    }

    @Override
    public User ValidateLogin(String username, String password)
        throws IOException, ClassNotFoundException
    {
        //Sends user requested for validation from Client Blazor
        UserPackage userPackage = new UserPackage(new User(username,password), "validateLogin");
        clientHandling.sendToServer(userPackage);

        //Received back the confirmation and post it, such that it can be verified
        Object dataReceivedFromServer = clientHandling.receiveFromServer();
        userPackage = gson.fromJson((JsonElement) dataReceivedFromServer, UserPackage.class);
        return userPackage.getUser();
    }

}
