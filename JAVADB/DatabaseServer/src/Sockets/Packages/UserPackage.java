package Sockets.Packages;


import Sockets.Models.User;

public class UserPackage{
    private User user;

    public UserPackage(String type, User user)
    {
        this.user = user;
    }


    public User getUser() {
        return user;
    }
}
