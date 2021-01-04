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
            stats.setOffense(player.getRating().getOffense());
            stats.setDefense(player.getRating().getDefense());
            stats.setOverall(player.getRating().getOverall());
        }
        return stats;
    }


    public void runSimulation(){
        //both teams have good offense
        boolean highScore = team1Stats.getOffense() > 800 && team2Stats.getOffense() > 800;
        //both teams have good defense
        boolean lowScore = team1Stats.getDefense() > 800 && team2Stats.getDefense() > 800;
        int MAX_HIGH_SCORE = 140; //highest score possible for high scoring games
        int MIN_HIGH_SCORE = 100; //lowest score possible for high scoring games
        int MAX_LOW_SCORE = 99; //highest score possible for low scoring games
        int MIN_LOW_SCORE = 75; //lowest score possible for high scoring games
        int MAX_BAL_SCORE = 120; //highest score possible for balanced scoring games
        int MIN_BAL_SCORE = 90; //lowest score possible for balanced scoring games
        int winnerPoints;
        int loserPoints;
        if(highScore){
            winnerPoints = (int)(Math.random() * (MAX_HIGH_SCORE - MIN_HIGH_SCORE + 1) + MIN_HIGH_SCORE);
            loserPoints = (int)(Math.random() * ((winnerPoints-1) - MIN_HIGH_SCORE + 1) + MIN_HIGH_SCORE);
        } else if(lowScore){
            winnerPoints = (int)(Math.random() * (MAX_LOW_SCORE - MIN_LOW_SCORE + 1) + MIN_LOW_SCORE);
            loserPoints = (int)(Math.random() * ((winnerPoints-1) - MIN_LOW_SCORE + 1) + MIN_LOW_SCORE);
        } else{ //balanced score
            winnerPoints = (int)(Math.random() * (MAX_BAL_SCORE - MIN_BAL_SCORE + 1) + MIN_BAL_SCORE);
            loserPoints = (int)(Math.random() * ((winnerPoints-1) - MIN_BAL_SCORE + 1) + MIN_BAL_SCORE);
        }
        //TODO determine who wins and assign them points decided
    }


}
