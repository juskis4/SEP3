using System.Text.Json.Serialization;

namespace Client.Models
{
    public class GameCluster
    {
        [JsonPropertyName("GameId")]
        public int GameId { get; set; }
        
        [JsonPropertyName("GameName")] 
        public string GameName { get; set; }
        
        [JsonPropertyName("Price")] 
        public double Price { get; set; }
        
        [JsonPropertyName("Photo")] 
        public string Photo { get; set; }
    }
}