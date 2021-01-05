package model.Simulations;

import model.Game;
import model.Player;
import model.PlayerRole;
import model.Team;

public class GameSimulation {

    private Game game;
    private TeamTotals team1Stats;
    private TeamTotals team2Stats;
    private double ROLE_FACTOR  = 0.0;
    private final double OUTSIDE_FACTOR = 18.0;
    private final double INSIDE_FACTOR = 7.5;
    private final double REBOUND_FACTOR = 13;
    private final double ASSIST_FACTOR = 10.0;

    public GameSimulation(Game game){
        this.game = game;
        this.team1Stats = new TeamTotals(game.getTeam1());
        this.team2Stats = new TeamTotals(game.getTeam2());
    }


    public void setRole(PlayerRole role){
        switch (role){
            case STAR -> ROLE_FACTOR = 1.25;
            case STARTER -> ROLE_FACTOR = .60;
            case SIXTH_MAN -> ROLE_FACTOR = .50;
            case BENCH -> ROLE_FACTOR = .40;
        }
    }

    public PlayerStats team1PlayerStatGenerator(Player player){
        setRole(player.getRole());
        int outsideTotal = (int) (((player.getRating().getOutsideShotRating() + team1Stats.getPassingAverage() -
                        team2Stats.getOutsideDefenseAverage()) / OUTSIDE_FACTOR) * ROLE_FACTOR);
        int insideTotal = (int) (((player.getRating().getInsideShotRating() + team1Stats.getPassingAverage() -
                                team2Stats.getInsideDefenseAverage()) / INSIDE_FACTOR) * ROLE_FACTOR);
        int rebounds = (int) (((player.getRating().getReboundRating() + team1Stats.getReboundingAverage() -
                        (team2Stats.getInsideDefenseAverage() -
                                player.getRating().getReboundRating())) / REBOUND_FACTOR) * ROLE_FACTOR);
        int assists = (int) (((player.getRating().getPassingRating() + team1Stats.getInsideScoringAverage() +
                        team1Stats.getOutsideScoringAverage() - team2Stats.getOutsideDefenseAverage() -
                        team2Stats.getInsideDefenseAverage()) / ASSIST_FACTOR) * ROLE_FACTOR);
        return new PlayerStats(player, outsideTotal,insideTotal, rebounds, assists);
    }

    public PlayerStats team2PlayerStatGenerator(Player player){
        setRole(player.getRole());
        int outsideTotal = (int) (((player.getRating().getOutsideShotRating() + team2Stats.getPassingAverage() -
                team1Stats.getOutsideDefenseAverage()) / OUTSIDE_FACTOR) * ROLE_FACTOR);
        int insideTotal = (int) (((player.getRating().getInsideShotRating() + team2Stats.getPassingAverage() -
                team1Stats.getInsideDefenseAverage()) / INSIDE_FACTOR) * ROLE_FACTOR);
        int rebounds = (int) (((player.getRating().getReboundRating() + team2Stats.getReboundingAverage() -
                (team1Stats.getInsideDefenseAverage() -
                        player.getRating().getReboundRating())) / REBOUND_FACTOR) * ROLE_FACTOR);
        int assists = (int) (((player.getRating().getPassingRating() + team2Stats.getInsideScoringAverage() +
                team2Stats.getOutsideScoringAverage() - team1Stats.getOutsideDefenseAverage() -
                team1Stats.getInsideDefenseAverage()) / ASSIST_FACTOR) * ROLE_FACTOR);
        return new PlayerStats(player, outsideTotal, insideTotal, rebounds, assists);
    }


    public void runSimulation() {
        TeamStats team1Stats = new TeamStats(game.getTeam1());
        TeamStats team2Stats = new TeamStats(game.getTeam2());

        for(Player player : game.getTeam1().getRoster()){
            PlayerStats stats = team1PlayerStatGenerator(player);
            team1Stats.updateStats(stats);
            System.out.println(player.getName()  + " " + stats.getTotalPoints() + "/" + stats.getRebounds() +
                    "/" + stats.getAssists());
        }
        System.out.println("three "+ team1Stats.getThreePointers());
        System.out.println("fg "+ team1Stats.getFieldGoals());
        System.out.println("reb "+ team1Stats.getRebounds());
        System.out.println("assist "+ team1Stats.getAssists());
        System.out.println("score "+ team1Stats.getScore());

        System.out.println("");
        for(Player player : game.getTeam2().getRoster()){
            PlayerStats stats = team2PlayerStatGenerator(player);
            team2Stats.updateStats(stats);
            System.out.println(player.getName()  + " " + stats.getTotalPoints() + "/" + stats.getRebounds() +
                    "/" + stats.getAssists());
        }
        System.out.println("three "+ team2Stats.getThreePointers());
        System.out.println("fg "+ team2Stats.getFieldGoals());
        System.out.println("reb "+ team2Stats.getRebounds());
        System.out.println("assist "+ team2Stats.getAssists());
        System.out.println("score "+ team2Stats.getScore());

        if(team1Stats.getScore() == team2Stats.getScore()){ //tie, re run simulation
            runSimulation();
        }

        game.setTeam1BoxScore(team1Stats);
        game.setTeam2BoxScore(team2Stats);
        if(team1Stats.getScore() > team2Stats.getScore()){ //team1 won
            game.setWinner(game.getTeam1());
        } else if(team1Stats.getScore() < team2Stats.getScore()){ //team2 won
            game.setWinner(game.getTeam2());
        }
    }


}
