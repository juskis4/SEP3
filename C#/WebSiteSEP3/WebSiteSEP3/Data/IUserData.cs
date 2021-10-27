using System.Collections.Generic;
using WebSiteSEP3.Models;

namespace WebSiteSEP3.Data
{
    public interface IUserData
    {
        IList<User> GetUsers();
        void AddUser(User user);
        void Update(User user);
        User Get(int userID);
    }
}