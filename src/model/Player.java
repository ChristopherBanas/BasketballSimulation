package model;

import java.util.Objects;

/**
 * Desc: Class for player information
 * Author: Christopher Banas
 */
public class Player {

    /** Name of player */
    private String name;
    /** Age of player */
    private int age;
    /** Rating of player */
    private Rating rating;
    /** Type of player */
    private PlayerType type;
    /** Team of player */
    private Team team;

    /**
     * Constructor for Player when team isn't known
     * @param name Name of player
     * @param age Age of player
     * @param rating Rating of player
     */
    public Player(String name, int age, Rating rating){
        this.name = name;
        this.age = age;
        this.rating = rating;
        this.type = getType(rating);
    }
    /**
     * Constructor for Player when team is known
     * @param name Name of player
     * @param age Age of player
     * @param rating Rating of player
     * @param team Team of player
     */
    public Player(String name, int age, Rating rating, Team team){
        this.name = name;
        this.age = age;
        this.rating = rating;
        this.type = getType(rating);
        this.team = team;
    }


    /**
     * Generates a player's type based off of their ratings
     * @param rating Player's ratings
     * @return What PlayerType they are
     */
    public PlayerType getType(Rating rating){
        int difference = rating.getOffense() - rating.getDefense();
        if(difference < -10){ //defense is higher than offense by 10+
            return PlayerType.DEFENSE;
        } else if(difference > 10){ //offense is higher than defense by 10+
            return PlayerType.OFFENSE;
        } else{ //difference is between 10
            return PlayerType.BALANCED;
        }
    }

    /**
     * Getter for name
     * @return Player name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for age
     * @return Player age
     */
    public int getAge() {
        return age;
    }

    /**
     * Increase a player's age
     */
    public void increaseAge() {
        age = age + 1;
    }

    /**
     * Getter for rating
     * @return Player rating
     */
    public Rating getRating() {
        return rating;
    }

    /**
     * Setter for rating
     * @param rating New rating
     */
    public void setRating(Rating rating) {
        this.rating = rating;
        updateType();
    }

    /**
     * Getter for type
     * @return PlayerType
     */
    public PlayerType getType() {
        return type;
    }

    /**
     * Updates type
     */
    public void updateType(){
        this.type = getType(this.rating);
    }

    /**
     * Equals method for player
     * @param o Player to be compared to
     * @return If player is the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return age == player.age &&
                Objects.equals(name, player.name) &&
                Objects.equals(rating, player.rating) &&
                Objects.equals(team, player.team) &&
                type == player.type;
    }

    /**
     * Hash method for player
     * @return Hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, age, rating, type, team);
    }

    /**
     * String method for player
     * @return String of player
     */
    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", rating=" + rating +
                ", type=" + type +
                ", team=" + team.getName() +
                '}';
    }

    /**
     * Getter for player team
     * @return Team of player
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Setter for player team
     * @param team Team of player
     */
    public void setTeam(Team team) {
        this.team = team;
    }
}
