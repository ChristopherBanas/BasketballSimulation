package model.Simulations;

import model.Game;
import model.Player;
import model.TeamTotals;

public class GameSimulation {

    private Game game;
    private TeamTotals team1Stats;
    private TeamTotals team2Stats;

    public GameSimulation(Game game){
        this.game = game;
        this.team1Stats = new TeamTotals(game.getTeam1());
        this.team2Stats = new TeamTotals(game.getTeam2());
    }

    public PlayerStats team1PlayerStatGenerator(Player player){
        int outsideTotal = (player.getRating().getOutsideShotRating() + team1Stats.getPassingAverage() -
                team2Stats.getOutsideDefenseAverage()) / 10;
        int insideTotal = (player.getRating().getInsideShotRating() + team1Stats.getPassingAverage() -
                team2Stats.getInsideDefenseAverage()) / 10;
        int rebounds = (player.getRating().getReboundRating() + team1Stats.getReboundingAverage() -
                (team2Stats.getInsideDefenseAverage() - player.getRating().getReboundRating())) / 10;
        int assists = (player.getRating().getPassingRating() + team1Stats.getInsideScoringAverage() +
                team1Stats.getOutsideScoringAverage() - team2Stats.getOutsideDefenseAverage() -
                team2Stats.getInsideDefenseAverage()) / 10;
        return new PlayerStats(player, outsideTotal,insideTotal, rebounds, assists);
    }

    public void runSimulation() {
        for(Player player : game.getTeam1().getRoster()){
            PlayerStats stats = team1PlayerStatGenerator(player);
            System.out.println(stats.toString());
        }
    }


}
