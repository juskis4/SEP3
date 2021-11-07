using System.Collections;
using System.Collections.Generic;
using System.Threading.Tasks;
using Client.Models;

namespace Client.Data
{
    public interface IGameService
    {
        Task<Game> getGameAsync(int GameId);
        Task<IList<GameCluster>> getGameClusterAsync(int page);
    }
}