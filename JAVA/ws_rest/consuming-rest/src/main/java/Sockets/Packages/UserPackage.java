package Sockets.Packages;


import Sockets.Models.User;

public class UserPackage extends SendingType{
    private User user;

    public UserPackage(String type, User user)
    {
        super(type);
        this.user = user;
    }


    public User getUser() {
        return user;
    }
}