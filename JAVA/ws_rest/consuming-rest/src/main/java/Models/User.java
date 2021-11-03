package Models;

public class User {
    public String Id;
    public String Username;
    public String Password;
    public String Photo;
    public String LastName;
    public String FirstName;
    public String SecurityLevel;
    public String Role;

    public User(String id, String username, String password, String photo, String lastName, String firstName, String securityLevel, String role) {
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
        this(null,username,password,null,null,null,null,null);
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
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
