package model;

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
        this.roster = new ArrayList<Player>();
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
        this.roster = new ArrayList<Player>();
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
        this.wins = this.wins++;
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
        this.losses = this.losses++;
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
    }

    /**
     * Remove a player from roster
     * @param player Player to be removed
     */
    public void removePlayer(Player player){
        roster.remove(player);
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
     * String method for team
     * @return String of team
     */
    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", wins=" + wins +
                ", losses=" + losses +
                ", coach=" + coach +
                ", roster=" + roster +
                '}';
    }
}
