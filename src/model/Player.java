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

    public Player(String name, int age, Rating rating){
        this.name = name;
        this.age = age;
        this.rating = rating;
        this.type = getType(rating);
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
        updateType();
    }

    public PlayerType getType() {
        return type;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }

    public void updateType(){
        this.type = getType(this.rating);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return age == player.age &&
                Objects.equals(name, player.name) &&
                Objects.equals(rating, player.rating) &&
                type == player.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, rating, type);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", rating=" + rating +
                ", type=" + type +
                '}';
    }
}
