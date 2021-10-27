using System;
using System.Collections.Generic;
using System.Linq;
using WebSiteSEP3.Data;
using WebSiteSEP3.Models;

namespace WebSiteSEP3.Authentication
{
    public class InMemUserService : IUserService
    {
        private List<User> users;
        private string usersFile = "users.json";
        private IUserData _usersData;

        public InMemUserService(IUserData usersData)
        {
            _usersData = usersData;
        }

        public User ValidateUser(string username, string password)
        {
            users = _usersData.GetUsers().ToList();
            User first = users.FirstOrDefault(user => user.Username.Equals(username));
            
            if (first == null) throw new Exception("User not found");
            if (!first.Password.Equals(password)) throw new Exception("Incorrect password");

            return first;
        }
    }
}