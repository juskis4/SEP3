using System;
using System.Net;
using System.Net.Http;
using System.Text.Json;
using System.Threading.Tasks;
using Client.Models;

namespace Client.Data.Impl
{
    public class UserService : IUserService
    {
        private readonly HttpClient Client = new HttpClient();
        private readonly string Uri = "https://localhost:5001/";
        public async Task<User> ValidateLoginAsync(string username, string password) //FIXED CLASS NAME ACCORDING TO C# NAMING CONVENTION
        {
            HttpResponseMessage responseMessage =
                await Client.GetAsync($"{Uri}/SEP3Group3/validate?username={username}&password={password}");
            String reply = await responseMessage.Content.ReadAsStringAsync();

            if (responseMessage.StatusCode == HttpStatusCode.OK)
            {
                string userAsJson = await responseMessage.Content.ReadAsStringAsync();
                User resultUser = JsonSerializer.Deserialize<User>(userAsJson);
                return resultUser;
            }

            throw new Exception("User not found/Password incorrect");
        }

        public async Task<User> RegisterUserAsync(string Username, string Password, string Photo, string FirstName, string LastName)
        {
            HttpResponseMessage responseMessage =
                await Client.GetAsync($"{Uri}/SEP3Group3/register?username={Username}&password={Password}&photo={Photo}&firstname={FirstName}&lastname={LastName}");
            String reply = await responseMessage.Content.ReadAsStringAsync();

            if (responseMessage.StatusCode == HttpStatusCode.OK)
            {
                string userAsJson = await responseMessage.Content.ReadAsStringAsync();
                User resultUser = JsonSerializer.Deserialize<User>(userAsJson);
                return resultUser; //EXPECTED A USUAL USER TO BE RETURNED
            }

            throw new Exception("User could not be registered");
        }
    }
}