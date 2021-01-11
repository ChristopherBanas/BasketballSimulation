package model.Simulations;

import model.Player.Player;
import model.Team.Team;

/**
 * Desc: Class for team totals of a simulation
 * Author: Christopher Banas
 */
public class TeamTotals {

    /** Team whose totals are calculated */
    private Team team;
    /** Average passing rating of team */
    private int passingAverage = 0;
    /** Average outside defense rating of team */
    private int outsideDefenseAverage = 0;
    /** Average inside defense rating of team */
    private int insideDefenseAverage = 0;
    /** Average rebounding rating of team */
    private int reboundingAverage = 0;
    /** Average outside scoring rating of team */
    private int outsideScoringAverage = 0;
    /** Average inside scoring rating of team */
    private int insideScoringAverage = 0;

    /**
     * Constructs TeamTotals and calculates all values
     * @param team Team whose totals are calculated
     */
    public TeamTotals(Team team){
        this.team = team;
        for(Player player : team.getRoster()){
            passingAverage += player.getRating().getPassingRating();
            outsideDefenseAverage += player.getRating().getOutsideDefenseRating();
            insideDefenseAverage += player.getRating().getInsideDefenseRating();
            reboundingAverage += player.getRating().getReboundRating();
            outsideScoringAverage += player.getRating().getOutsideShotRating();
            insideScoringAverage += player.getRating().getInsideShotRating();
        }
        int rosterSize = team.getRoster().size();
        passingAverage = passingAverage/rosterSize;
        outsideDefenseAverage = outsideDefenseAverage/rosterSize;
        insideDefenseAverage = insideDefenseAverage/rosterSize;
        reboundingAverage = reboundingAverage/rosterSize;
        outsideScoringAverage = outsideScoringAverage/rosterSize;
        insideScoringAverage = insideScoringAverage/rosterSize;
    }

    /**
     * Getter for team
     * @return Team
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Getter for passing average
     * @return Passing average of team
     */
    public int getPassingAverage() {
        return passingAverage;
    }

    /**
     * Getter for outside defense
     * @return Outside defense average of team
     */
    public int getOutsideDefenseAverage() {
        return outsideDefenseAverage;
    }

    /**
     * Getter for inside defense
     * @return Inside defense average of team
     */
    public int getInsideDefenseAverage() {
        return insideDefenseAverage;
    }

    /**
     * Getter for rebounding average
     * @return Rebounding average of team
     */
    public int getReboundingAverage() {
        return reboundingAverage;
    }

    /**
     * Getter for outside scoring average
     * @return Outside scoring average of team
     */
    public int getOutsideScoringAverage() {
        return outsideScoringAverage;
    }

    /**
     * Getter for inside scoring average
     * @return Inside scoring average of team
     */
    public int getInsideScoringAverage() {
        return insideScoringAverage;
    }
}
