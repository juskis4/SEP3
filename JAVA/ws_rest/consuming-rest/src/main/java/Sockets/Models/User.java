package Sockets.Models;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class User{
    @Expose(serialize = true, deserialize = false)
    public int Id;
    @Expose(serialize = true, deserialize = false)
    public String Username;
    @Expose(serialize = true, deserialize = true)
    public String Password;
    @Expose(serialize = true, deserialize = true)
    public String Photo;
    @Expose(serialize = true, deserialize = true)
    public String LastName;
    @Expose(serialize = true, deserialize = true)
    public String FirstName;
    @Expose(serialize = true, deserialize = true)
    public String SecurityLevel;
    @Expose(serialize = true, deserialize = true)
    public String Role;



    public User(int id, String username, String password, String photo, String lastName, String firstName, String securityLevel, String role) {
        Id = id;
        Username = username;
        Password = password;
        Photo = photo;
        LastName = lastName;
        FirstName = firstName;
        SecurityLevel = securityLevel;
        Role = role;
    }

    public User(String username, String password)
    {
        this(-1,username,password,null,null,null,null,null);
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getSecurityLevel() {
        return SecurityLevel;
    }

    public void setSecurityLevel(String securityLevel) {
        SecurityLevel = securityLevel;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }
}