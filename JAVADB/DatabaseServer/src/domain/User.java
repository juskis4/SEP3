package domain;

public class User
{
  private int id;
  private String Username;
  private String Password;
  private String Photo;
  private String FirstName;
  private String LastName;
  private int SecurityLevel;
  private String Role;

  public User(int id, String username, String password, String photo, String firstName, String lastName, int securityLevel, String role)
  {
    this.id = id;
    this.Username = username;
    this.Password= password;
    this.Photo = photo;
    this.FirstName = firstName;
    this.LastName = lastName;
    this.SecurityLevel = securityLevel;
    this.Role = role;
  }

  public int getId()
  {
    return id;
  }

  public String getUsername()
  {
    return Username;
  }

  public String getPassword()
  {
    return Password;
  }
  public String getPhoto()
  {
    return Photo;
  }

  public String getFirstName()
  {
    return FirstName;
  }

  public String getLastName()
  {
    return LastName;
  }

  public int getSecurityLevel()
  {
    return SecurityLevel;
  }

  public String getRole()
  {
    return Role;
  }
}
