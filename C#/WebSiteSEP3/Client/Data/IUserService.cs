using System.Threading.Tasks;
using Client.Models;

namespace Client.Data
{
    public interface IUserService
    {
        Task<User> ValidateLoginAsync(string username, string password);
        Task<User> RegisterUserAsync(string Username,string Password, string Photo, string FirstName, string LastName);//ID AND SECURITY LEVEL SHOULD BE GENERATED AUTOMATICALLY IN SERVER SIDE
    }
}