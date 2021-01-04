package model.Simulations;

import model.Game;
import model.Player;
import model.Team;

import java.util.Random;

public class GameSimulation {

    private Game game;
    private TotalStats team1Stats;
    private TotalStats team2Stats;

    public GameSimulation(Game game){
        this.game = game;
        this.team1Stats = getTotalStats(game.getTeam1());
        this.team2Stats = getTotalStats(game.getTeam2());
    }

    public TotalStats getTotalStats(Team team){
        TotalStats stats = new TotalStats();
        for(Player player : team.getRoster()){
            //stats.setOffense(player.getRating().getOffense());
            //stats.setDefense(player.getRating().getDefense());
            //stats.setOverall(player.getRating().getOverall());
        }
        return stats;
    }


    public void runSimulation() {

    }


}
