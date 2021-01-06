package model.Simulations;

import model.Game;
import model.Player;
import model.PlayerRole;

/**
 * Desc: Simulates a game by getting each player's individual stat's and adding them
 * Author: Christopher Banas
 */
public class GameSimulation {

    /** Game to be simulated */
    private Game game;
    /** Total stats of team 1 */
    private TeamTotals team1Stats;
    /** Total stats of team 2 */
    private TeamTotals team2Stats;
    /** Affects player's production based on their role */
    private double ROLE_FACTOR  = 0.0;
    /** Affect's how many threes are made (higher means less) */
    private final double OUTSIDE_FACTOR = 17.0;
    /** Affect's how many two are made (higher means less) */
    private final double INSIDE_FACTOR = 7.5;
    /** Affect's how many rebounds are grabbed (higher means less) */
    private final double REBOUND_FACTOR = 13;
    /** Affect's how many assists are made (higher means less) */
    private final double ASSIST_FACTOR = 10.0;

    /**
     * Constructor for game simulation
     * @param game Game to be simulated
     */
    public GameSimulation(Game game){
        this.game = game;
        this.team1Stats = new TeamTotals(game.getTeam1());
        this.team2Stats = new TeamTotals(game.getTeam2());
    }

    /**
     * Sets role factor
     * @param role Role of player
     */
    public void setRole(PlayerRole role){
        switch (role){
            case STAR -> ROLE_FACTOR = 1.25;
            case STARTER -> ROLE_FACTOR = .60;
            case SIXTH_MAN -> ROLE_FACTOR = .50;
            case BENCH -> ROLE_FACTOR = .45;
        }
    }

    /**
     * Generates stats for a player on team 1
     * @param player Player whose stats will be generated
     * @return PlayerStats of player
     */
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
        return new PlayerStats(player, outsideTotal, insideTotal, rebounds, assists);
    }

    /**
     * Generates stats for a player on team 2
     * @param player Player whose stats will be generated
     * @return PlayerStats of player
     */
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

    /**
     * Runs the simulation by generating individual player stat lines and combining them, then tells game who won
     */
    public void runSimulation() {
        TeamStats team1Stats = new TeamStats(game.getTeam1());
        TeamStats team2Stats = new TeamStats(game.getTeam2());

        for(Player player : game.getTeam1().getRoster()){
            PlayerStats stats = team1PlayerStatGenerator(player);
            team1Stats.updateStats(stats);
        }

        for(Player player : game.getTeam2().getRoster()){
            PlayerStats stats = team2PlayerStatGenerator(player);
            team2Stats.updateStats(stats);
        }

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
