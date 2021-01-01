package model;

/**
 * Desc: Class for player information
 * Author: Christopher Banas
 */
public class Player {

    private String name;
    private int age;
    private PlayerType type;
    private Rating rating;

    public Player(String name, int age, Rating rating){
        this.name = name;
        this.age = age;
        this.rating = rating;
        //TODO type generation using ratings stats
    }
}
