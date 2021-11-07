using System;
using System.Collections;
using System.Collections.Generic;
using System.Net;
using System.Net.Http;
using System.Text.Json;
using System.Threading.Tasks;
using Client.Data;
using Client.Models;

public class GameService : IGameService
    {
        
        private readonly HttpClient Client = new HttpClient();
        private readonly string Uri = "https://localhost:5001/";
        
        public async Task<Game> getGameAsync(int GameId) //GET A SINGE GAME FOR PURCHASE PAGE DISPLAY
        {
           HttpResponseMessage responseMessage = await Client.GetAsync($"{Uri}/SEP3Group3/GetGame?Id={GameId}");
           String reply = await responseMessage.Content.ReadAsStringAsync();

           if (responseMessage.StatusCode == HttpStatusCode.OK)
           {
               string gameAsJson = await responseMessage.Content.ReadAsStringAsync();
               Game receivedGame = JsonSerializer.Deserialize<Game>(gameAsJson);
               return receivedGame;
           }

           throw new Exception("Game not found!"); 
        }

        public async Task<IList<GameCluster>> getGameClusterAsync(int page) //GETS THE GAMES FOR PAGE DISPLAY WITH LESS VARIABLES
        {
            HttpResponseMessage responseMessage = await Client.GetAsync($"{Uri}/SEP3Group3/GetGameCluster?Page={page}"); //PAGE SHOULD CONTAIN A CERTAIN AMOUNT OF GAMES TO KEEP IT ORGANIZED
            String reply = await responseMessage.Content.ReadAsStringAsync();

            if (responseMessage.StatusCode == HttpStatusCode.OK)
            {
                string gameClusterAsJson = await responseMessage.Content.ReadAsStringAsync();
                IList<GameCluster> receivedGameCluster = JsonSerializer.Deserialize<IList<GameCluster>>(gameClusterAsJson);
                return receivedGameCluster;
            }

            throw new Exception("Game page (GameCluster) loading error"); 
        }
    }