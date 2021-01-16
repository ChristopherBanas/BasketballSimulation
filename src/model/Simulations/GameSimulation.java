package model.Simulations;

import model.Games.Game;
import model.Player.Player;
import model.Player.Role;

/**
 * Desc: Simulates a game by getting each player's individual stat's and adding them
 * Author: Christopher Banas
 */
public class GameSimulation {

    /** Game to be simulated */
    private final Game game;
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
    public void setRole(Role role){
        switch (role) {
            case Superstar:
                ROLE_FACTOR = 1.15;
                break;
            case Star:
                ROLE_FACTOR = 1;
                break;
            case Starter:
                ROLE_FACTOR = .85;
                break;
            case Sixth_man:
                ROLE_FACTOR = .70;
                break;
            case Bench:
                ROLE_FACTOR = .65;
                break;
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
     * Updates a single players stat to determine overtime winner
     * @param teamStats Team that will win overtime
     * @return Updated teamStats
     */
    public TeamStats overTime(TeamStats teamStats){
        PlayerStats stats = teamStats.getStatsList().get(0);
        teamStats.removeStat(stats);
        stats.updatePoints(1); //add a point to a player from winning team
        teamStats.updateStats(stats);
        return teamStats;
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

        if(team1Stats.getScore() == team2Stats.getScore()){ //tie, go into overtime
            int winner = (int) (Math.random() * (2 - 1 + 1) + 1); //randomly pick overtime winner
            if(winner == 2){
                team2Stats = overTime(team2Stats);
            } else{
                team1Stats = overTime(team1Stats);
            }
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
