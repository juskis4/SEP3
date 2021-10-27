using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text.Json;
using WebSiteSEP3.Models;

namespace WebSiteSEP3.Data
{
    public class UsersJSONData : IUserData
    {
        private IList<User> users;
        private string usersFile = "JsonFiles/users.json";

        public UsersJSONData()
        {
            string content = File.ReadAllText(usersFile);
                users = JsonSerializer.Deserialize<List<User>>(content);
            }

        public void AddUser(User user)
        {
            var _users = GetUsers();
            int max = users.Max(user => user.Id);
            user.Id = (++max);
            user.Role = "Member";
            user.Photo = "default.png";
            user.SecurityLevel = 0;
            _users.Add(user);
            users = _users;
            WriteUsersToFile();
        }

        public IList<User> GetUsers()
        {
            List<User> tmp = new List<User>(users);
            return tmp;
        }

        public void Update(User user)
        {
            //to be updated
            User toUpdate = users.First(u => u.Id == user.Id);
            toUpdate.Username = user.Username;
            toUpdate.Role = user.Role;
            toUpdate.SecurityLevel = user.SecurityLevel;
            toUpdate.Password = user.Password;
            WriteUsersToFile();
        }

        public User Get(int userID)
        {
            return users.FirstOrDefault(u => u.Id == userID);
        }
        
        private void WriteUsersToFile()
        {
            string userAsJson = JsonSerializer.Serialize(users);
            File.WriteAllText(usersFile, userAsJson);
        }
    }
}