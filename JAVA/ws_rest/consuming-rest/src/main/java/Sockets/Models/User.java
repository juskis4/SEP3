package Sockets.Models;

public class User {
    private String Id;
    private String Username;
    private String Password;
    private String Photo;
    private String LastName;
    private String FirstName;
    private String SecurityLevel;
    private String Role;

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

    public boolean equals(Object obj)
    {
        if(!(obj instanceof User))
            return false;
        User other = (User)obj;
        if(Id == null && FirstName == null && LastName == null && Photo == null && SecurityLevel == null && Role == null)
        {
            if(!other.Username.equals(Username)) throw new IllegalArgumentException("User not found");
            if(!other.Password.equals(Password)) throw new IllegalArgumentException("Password is incorrect");
                return true;
        }
        return other.Password.equals(Password) && other.Username.equals(Username) && other.Id.equals(Id) && other.FirstName.equals(FirstName) &&
                other.LastName.equals(LastName) && other.Photo.equals(Photo) && other.SecurityLevel.equals(SecurityLevel) &&
                other.Role.equals(Role);
    }
}
