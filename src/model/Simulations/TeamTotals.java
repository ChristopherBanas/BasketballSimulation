package model.Simulations;

import model.Player;
import model.Team;

public class TeamTotals {

    private int passingAverage = 0;
    private int outsideDefenseAverage = 0;
    private int insideDefenseAverage = 0;
    private int reboundingAverage = 0;
    private int outsideScoringAverage = 0;
    private int insideScoringAverage = 0;

    public TeamTotals(Team team){
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

    public int getPassingAverage() {
        return passingAverage;
    }

    public int getOutsideDefenseAverage() {
        return outsideDefenseAverage;
    }

    public int getInsideDefenseAverage() {
        return insideDefenseAverage;
    }

    public int getReboundingAverage() {
        return reboundingAverage;
    }

    public int getOutsideScoringAverage() {
        return outsideScoringAverage;
    }

    public int getInsideScoringAverage() {
        return insideScoringAverage;
    }
}
