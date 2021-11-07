using System.Collections;
using System.Collections.Generic;
using Client.Models;

namespace Client.Data
{
    public interface ICacheService //PRIMITIVE CACHING SERVICE INTERFACE
    {
        public void SaveUserCache(User user);
        public User GetCachedUser();
        public void SaveGameClusterCache(IList<GameCluster> gameClusters);
        public IList<GameCluster> GetGameClusterCache();
    }
}