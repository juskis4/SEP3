using System.Collections.Generic;
using System.IO;
using System.Text.Json;
using Client.Models;

namespace Client.Data.Impl
{
    public class CacheService : ICacheService //PRIMITIVE CACHING SERVICE
    {
        public IList<GameCluster> GameClustersCache { get; set; }
        public User CachedUser { get; set; }

        private string GamesCacheFile = @"games.json";
        private string UserCacheFile = @"users.json";

        public CacheService()
        {
            GameClustersCache = File.Exists(GamesCacheFile)
                ? ReadData<GameCluster>(GamesCacheFile)
                : new List<GameCluster>();

            CachedUser = File.Exists(UserCacheFile)
                ? JsonSerializer.Deserialize<User>(UserCacheFile)
                : new User(); 
        }
        
        private IList<T> ReadData<T>(string fileToRead)
        {
            using (var jsonReader = File.OpenText(fileToRead))
            {
                return JsonSerializer.Deserialize<List<T>>(jsonReader.ReadToEnd());
            }
        }

        public void SaveUserCache(User user)
        {
            string jsonUser = JsonSerializer.Serialize(user, new JsonSerializerOptions {WriteIndented = true});
            using (StreamWriter outoutFile = new StreamWriter(UserCacheFile, false)) ;
        }

        public User GetCachedUser()
        {
            return CachedUser;
        }

        public void SaveGameClusterCache(IList<GameCluster> gameClusters)
        {
            string jsonUser = JsonSerializer.Serialize(gameClusters, new JsonSerializerOptions {WriteIndented = true});
            using (StreamWriter outoutFile = new StreamWriter(GamesCacheFile,false)) ;
        }

        public IList<GameCluster> GetGameClusterCache()
        {
            return GameClustersCache;
        }
    }
}