package model.Simulations;


import model.Team;

import java.util.ArrayList;
import java.util.Objects;

public class TeamStats {

    private Team team;
    private int score;
    private int fieldGoals;
    private int threePointers;
    private int rebounds;
    private int assists;
    private ArrayList<PlayerStats> statsList;

    public TeamStats(Team team){
        this.team = team;
        this.score = 0;
        this.fieldGoals = 0;
        this.threePointers = 0;
        this.rebounds = 0;
        this.assists = 0;
        statsList = new ArrayList<>();
    }

    public Team getTeam() {
        return team;
    }

    public int getScore(){
        return score;
    }

    public void updateScore(int score){
        this.score += score;
    }

    public int getFieldGoals() {
        return fieldGoals;
    }

    public void updateFieldGoals(int fieldGoals) {
        this.fieldGoals += fieldGoals;
    }

    public int getThreePointers(){
        return threePointers;
    }

    public void updateThreePointers(int threePointers) {
        this.threePointers += threePointers;
    }

    public int getRebounds() {
        return rebounds;
    }

    public void updateRebounds(int rebounds) {
        this.rebounds += rebounds;
    }

    public int getAssists() {
        return assists;
    }

    public void updateAssists(int assists) {
        this.assists += assists;
    }

    public void updateList(PlayerStats stats){
        statsList.add(stats);
    }

    public ArrayList<PlayerStats> getStatsList() {
        return statsList;
    }

    public void updateStats(PlayerStats stats){
        updateList(stats);
        updateScore(stats.getTotalPoints());
        updateThreePointers(stats.getThreePointers());
        updateFieldGoals(stats.getFieldGoals());
        updateRebounds(stats.getRebounds());
        updateAssists(stats.getAssists());
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(team, score, fieldGoals, threePointers, rebounds, assists, statsList);
    }

    public int longestName(){
        int largest = statsList.get(0).getPlayer().getName().length();
        for(PlayerStats stats : statsList){
            if(stats.getPlayer().getName().length() > largest){
                largest = stats.getPlayer().getName().length();
            }
        }
        return largest + 5;
    }

    @Override
    public String toString() {
        StringBuilder boxScore = new StringBuilder();
        int longestName = longestName();
        boxScore.append(" \n");
        boxScore.append(String.format("| %s Box Score\n", team.getName()));
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
