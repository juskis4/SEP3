using System.Text.Json.Serialization;

namespace Client.Models
{
    public class User
    {
        [JsonPropertyName("Id")]
        public int Id { get; set; }

        [JsonPropertyName("Username")]
        public string Username { get; set; }

        [JsonPropertyName("Password")] 
        public string Password { get; set; }

        [JsonPropertyName("Photo")]
        public string Photo { get; set; }
        
        [JsonPropertyName("FirstName")]
        public string FirstName { get; set; }
        
        [JsonPropertyName("LastName")]
        public string LastName { get; set; }
        
        [JsonPropertyName("SecurityLevel")]
        public int SecurityLevel { get; set; }
        
        [JsonPropertyName("Role")]
        public string Role { get; set; }
    }
}