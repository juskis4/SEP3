using WebSiteSEP3.Models;

namespace WebSiteSEP3.Authentication
{
    public interface IUserService
    {
        User ValidateUser(string username, string password);
    }
}