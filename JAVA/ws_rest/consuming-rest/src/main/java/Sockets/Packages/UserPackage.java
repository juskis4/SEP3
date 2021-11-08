package Sockets.Packages;


import Sockets.Models.User;

import java.io.Serializable;

public class UserPackage implements Serializable{
    private User user;
    private static final long serialVersionUID = 6529685098267757690L;
    private String type;

    public UserPackage(User user, String type)
    {
        this.user = user;
        this.type = type;
    }


    public User getUser() {
        return user;
    }
}