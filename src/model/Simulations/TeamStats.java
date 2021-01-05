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
        updateFieldGoals(threePointers);
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
        updateFieldGoals(stats.getTwoPointers());
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
}
