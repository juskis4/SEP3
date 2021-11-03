package Packages;

import Models.User;

public class UserPackage extends SendingType{
    private User user;

    UserPackage(String type, User user)
    {
        super(type);
        this.user = user;
    }


    public User getUser() {
        return user;
    }
}
