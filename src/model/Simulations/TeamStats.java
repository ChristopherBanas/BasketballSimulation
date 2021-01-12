package model.Simulations;


import model.Team.Team;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Desc: Class for team stat's during a game simulation
 * Author: Christopher Banas
 */
public class TeamStats {

    /** Team whose these stats belong to */
    private final Team team;
    /** Points scored during the game */
    private int score;
    /** Field goals made during the game (twos + threes) */
    private int fieldGoals;
    /** Three pointers made during the game */
    private int threePointers;
    /** Rebounds grabbed during the game */
    private int rebounds;
    /** Assists made during the game */
    private int assists;
    /** List of all individual player stat lines for this team's roster */
    private ArrayList<PlayerStats> statsList;

    /**
     * Constructor for TeamStats
     * @param team Team whose these stats belong to
     */
    public TeamStats(Team team){
        this.team = team;
        this.score = 0;
        this.fieldGoals = 0;
        this.threePointers = 0;
        this.rebounds = 0;
        this.assists = 0;
        statsList = new ArrayList<>();
    }

    /**
     * Getter for team
     * @return Team
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Getter for score
     * @return Score
     */
    public int getScore(){
        return score;
    }

    /**
     * Updates score
     * @param score Score to be added
     */
    public void updateScore(int score){
        this.score += score;
    }

    /**
     * Getter for field goals
     * @return Field goals made
     */
    public int getFieldGoals() {
        return fieldGoals;
    }

    /**
     * Updates field goals
     * @param fieldGoals Field goals to be added
     */
    public void updateFieldGoals(int fieldGoals) {
        this.fieldGoals += fieldGoals;
    }

    /**
     * Getter for three pointers
     * @return Three pointers made
     */
    public int getThreePointers(){
        return threePointers;
    }

    /**
     * Updates three pointers
     * @param threePointers Three pointers to be added
     */
    public void updateThreePointers(int threePointers) {
        this.threePointers += threePointers;
    }

    /**
     * Getter for rebounds
     * @return Rebounds
     */
    public int getRebounds() {
        return rebounds;
    }

    /**
     * Updates rebounds
     * @param rebounds Rebounds to be added
     */
    public void updateRebounds(int rebounds) {
        this.rebounds += rebounds;
    }

    /**
     * Getter for assists
     * @return Assists
     */
    public int getAssists() {
        return assists;
    }

    /**
     * Updates assists
     * @param assists Assists to be added
     */
    public void updateAssists(int assists) {
        this.assists += assists;
    }

    /**
     * Updates stats list
     * @param stats Stats to be added
     */
    public void updateList(PlayerStats stats){
        statsList.add(stats);
    }

    /**
     * Getter for stats list
     * @return Stats list
     */
    public ArrayList<PlayerStats> getStatsList() {
        return statsList;
    }

    /**
     * Updates all stats within this object
     * @param stats Stats to be added to team total
     */
    public void updateStats(PlayerStats stats){
        updateList(stats);
        updateScore(stats.getTotalPoints());
        updateThreePointers(stats.getThreePointers());
        updateFieldGoals(stats.getFieldGoals());
        updateRebounds(stats.getRebounds());
        updateAssists(stats.getAssists());
    }

    /**
     * Equals method for team states
     * @param o Team states to be compared
     * @return If equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamStats teamStats = (TeamStats) o;
        return score == teamStats.score &&
                fieldGoals == teamStats.fieldGoals &&
                threePointers == teamStats.threePointers &&
                rebounds == teamStats.rebounds &&
                assists == teamStats.assists &&
                Objects.equals(team, teamStats.team) &&
                Objects.equals(statsList, teamStats.statsList);
    }

    /**
     * Hash method
     * @return Hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(team, score, fieldGoals, threePointers, rebounds, assists, statsList);
    }

    /**
     * Finds the length of longest name in stats array
     * @return Length of longest name in stats array
     */
    public int longestName(){
        int largest = statsList.get(0).getPlayer().getName().length();
        for(PlayerStats stats : statsList){
            if(stats.getPlayer().getName().length() > largest){
                largest = stats.getPlayer().getName().length();
            }
        }
        return largest + 5;
    }

    /**
     * Generates box score
     * @return String of box score
     */
    @Override
    public String toString() {
        StringBuilder boxScore = new StringBuilder();
        int longestName = longestName();
        boxScore.append(" \n");
        boxScore.append(String.format("| %s Box Score\n", team.getName()));
        boxScore.append("|\n");
        boxScore.append("|\n");
        boxScore.append(String.format("| %s "+"%"+longestName+"s"+" %10s %10s %5s %6s", "Name", "Points",
                "Rebounds", "Assists", "3PM", "FGM\n"));
        for(PlayerStats stats : statsList){
            int spacing = longestName - stats.getPlayer().getName().length();
            boxScore.append("|\n");
            boxScore.append(String.format("| %s "+"%"+spacing+"s"+" %8s %11s %9s %5s\n", stats.getPlayer().getName(),
                    stats.getTotalPoints(), stats.getRebounds(), stats.getAssists(),
                    stats.getThreePointers(), stats.getFieldGoals()));
        }
        boxScore.append("| \n");
        int spacing = longestName - 6;
        boxScore.append(String.format("| %s "+"%"+spacing+"s"+" %8s %11s %9s %5s\n", "TOTALS", score, rebounds,
                assists, threePointers, fieldGoals));
        return boxScore.toString();
    }
}
