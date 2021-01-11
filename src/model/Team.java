package model;

import model.Player.Player;
import model.Simulations.PlayerStats;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Desc: Class for team information
 * Author: Christopher Banas
 */
public class Team {

    /** Name of team */
    private String name;
    /** Team wins */
    private int wins;
    /** Team losses */
    private int losses;
    /** Coach of team */
    private Coach coach;
    /** Roster of team */
    private ArrayList<Player> roster;

    /**
     * Constructor for team when no coach has been assigned
     * @param name Name of team
     */
    public Team(String name){
        this.name = name;
        this.wins = 0;
        this.losses = 0;
        this.roster = new ArrayList<>();
    }

    /**
     * Constructor for team when a coach has been assigned
     * @param name Name of team
     * @param coach Coach for team
     */
    public Team(String name, Coach coach){
        this.name = name;
        this.wins = 0;
        this.losses = 0;
        this.coach = coach;
        this.roster = new ArrayList<>();
        coach.setTeam(this);
    }

    /**
     * Getter for name
     * @return Name of team
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name
     * @param name New name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for wins
     * @return Team wins
     */
    public int getWins() {
        return wins;
    }

    /**
     * Add a win
     */
    public void addWin() {
        wins = wins + 1;
    }

    /**
     * Getter for losses
     * @return Team losses
     */
    public int getLosses() {
        return losses;
    }

    /**
     * Add a loss
     */
    public void addLoss() {
        losses = losses + 1;
    }

    /**
     * Getter for coach
     * @return Team coach
     */
    public Coach getCoach() {
        return coach;
    }

    /**
     * Setter for coach
     * @param coach New coach
     */
    public void setCoach(Coach coach) {
        this.coach = coach;
        coach.setTeam(this);
    }

    /**
     * Remove coach from team
     */
    public void removeCoach() {
        this.coach.setTeam(null);
        this.coach = null;
    }

    /**
     * Getter for team roster
     * @return Team roster
     */
    public ArrayList<Player> getRoster() {
        return roster;
    }

    /**
     * Add a player to roster
     * @param player Player to be added
     */
    public void addPlayer(Player player) {
        roster.add(player);
        player.setTeam(this);
    }

    public void addMultiplePlayers(ArrayList<Player> players){
        for(Player player : players){
            addPlayer(player);
        }
    }

    /**
     * Remove a player from roster
     * @param player Player to be removed
     */
    public void removePlayer(Player player){
        roster.remove(player);
        player.setTeam(null);
    }

    /**
     * Equals method for Team
     * @param o Team to be compared
     * @return If same team or not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return wins == team.wins &&
                losses == team.losses &&
                Objects.equals(name, team.name) &&
                Objects.equals(coach, team.coach) &&
                Objects.equals(roster, team.roster);
    }

    /**
     * Hash method for team
     * @return Hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, wins, losses, coach, roster);
    }


    /**
     * Finds the length of longest name in roster array
     * @return Length of longest name in roster array
     */
    public int longestName(){
        int largest = this.roster.get(0).getName().length();
        for(Player player : this.roster){
            if(player.getName().length() > largest){
                largest = player.getName().length();
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
        String coach;
        if(this.coach == null){
            coach = "No coach";
        } else{
            coach = this.coach.getName();
        }
        StringBuilder teamString = new StringBuilder();
        int longestName = longestName();
        teamString.append(" \n");
        teamString.append(String.format("| %s Team\n", this.name));
        teamString.append(String.format("| Coach: %s\n", coach));
        teamString.append("""
                |
                |
                """);
        teamString.append(String.format("| %s "+"%"+(longestName+1)+"s"+" %20s %20s %5s %5s %6s %6s %12s %10s", "Name",
                "Role", "Type", "Position", "3", "2", "Reb", "Pass", "In_Defense", "Out_Defense\n"));
        for(Player player : this.roster){
            int spacing = longestName - player.getName().length();
            teamString.append("|\n");
            teamString.append(String.format("| %s "+"%"+(spacing+5)+"s"+" %20s %20s %5s %5s %6s %6s %12s %10s\n",
                    player.getName(), player.getRole(), player.getType(), player.getPosition(),
                    player.getRating().getOutsideShotRating(), player.getRating().getInsideShotRating(),
                    player.getRating().getReboundRating(), player.getRating().getPassingRating(),
                    player.getRating().getInsideDefenseRating(), player.getRating().getOutsideDefenseRating()));
        }
        return teamString.toString();
    }

}
