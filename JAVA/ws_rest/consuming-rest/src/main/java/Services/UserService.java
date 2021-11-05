package Services;

import Sockets.Handlers.ClientHandling;
import Sockets.Models.User;
import Sockets.Packages.UserPackage;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

public class UserService implements IUserService{

    private ClientHandling clientHandling;
    private Gson gson;

    public UserService() throws IOException {
       clientHandling = new ClientHandling();
       gson = new Gson();
    }

    @Override
    public User ValidateLogin(String username, String password) throws IOException {
        //Sends user requested for validation from Client Blazor
        UserPackage userPackage = new UserPackage("validateLogin", new User(username,password));
        String dataToBeSent = gson.toJson(userPackage);
        clientHandling.sendToServer(dataToBeSent);

        //Received back the confirmation and post it, such that it can be verified
        String dataReceivedFromServer = clientHandling.receiveFromServer();
        userPackage = gson.fromJson(dataReceivedFromServer, UserPackage.class);
        return userPackage.getUser();
    }
    
}
