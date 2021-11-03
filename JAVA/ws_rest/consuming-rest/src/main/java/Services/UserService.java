package Services;

import Sockets.Models.User;

import java.util.ArrayList;

public class UserService implements IUserService{

    private ArrayList<User> users;


    public UserService()
    {
        users = new ArrayList<>();
    }

    @Override
    public User ValidateLogin(String username, String password) {
        User user = new User(username,password);
        for (User findUser:
             users) {
            try {
                if(user.equals(findUser))
                {
                    return user;
                }
            }
            catch (Exception e){
                e.getMessage();
            }
        }
        return null;
    }

    public void seed()
    {
        User user = new User("Ionut","12345");
        users.add(user);
    }
    
}
