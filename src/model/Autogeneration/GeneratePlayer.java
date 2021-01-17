package model.Autogeneration;

import model.Autogeneration.NameOptions.NameLists;
import model.Player.Player;
import model.Player.Position;
import model.Player.Role;
import model.Player.Type;

import java.util.HashSet;
import java.util.Random;

/**
 * Desc: Class for player generation
 * Author: Christopher Banas
 */
public class GeneratePlayer {

    /** Set of all the names generated so far */
    HashSet<String> nameSet;

    /**
     * Constructor for GeneratePlayer
     */
    public GeneratePlayer(){
        nameSet = new HashSet<>();
    }

    /**
     * Generates a unique name
     * @return Name of player
     */
    public String generateName(){
        String name = "";
        int listLength = 2943; //length of arrays in NameLists
        while (name.equals("")){ //will break loop if name is not in nameSet
            int random = new Random().nextInt(listLength);
            String firstName = NameLists.firstNameList[random];
            String lastName = NameLists.lastNameList[random];
            name = firstName + " " + lastName;
            if(nameSet.contains(name)){ //O(1) time complexity
                name = "";
            }
        }
        nameSet.add(name);
        return name;
    }

    /**
     * Generates a type for a point guard
     * @param role Role of point guard
     * @return Type of point guard
     */
    public Type pointGuardType(Role role){
        int random;
        if(role.equals(Role.Superstar)){
            random = (int) (Math.random() * (9 - 5 + 1) + 5); //superstar types from range 5-9
        } else{
            random = (int) (Math.random() * (4 + 1)); //star to bench types from range 0-4
        }
        switch (random) {
            case 0:
                return Type.Playmaker;
            case 1:
                return Type.All_around;
            case 2:
                return Type.Offensive_playmaker;
            case 3:
                return Type.Defensive_playmaker;
            case 4:
                return Type.Perimeter_defender;
            case 5:
                return Type.Offensive_superstar; //superstar only types from range 5-9
            case 6:
                return Type.Point_god;
            case 7:
                return Type.Balanced_superstar;
            case 8:
                return Type.Lockdown_defender;
            case 9:
                return Type.Two_war_superstar;
            default:
                throw new IllegalStateException("Unexpected value: " + random);
        }
    }

    /**
     * Generates a type for a shooting guard
     * @param role Role of shooting guard
     * @return Type of shooting guard
     */
    public Type shootingGuardType(Role role){
        int random;
        if(role.equals(Role.Superstar)){
            random = (int) (Math.random() * (9 - 6 + 1) + 6); //superstar types from range 6-9
        } else{
            random = (int) (Math.random() * (5 + 1)); //star to bench types from range 0-5
        }
        switch (random) {
            case 0:
                return Type.Three_and_D;
            case 1:
                return Type.All_around;
            case 2:
                return Type.Three_level_scorer;
            case 3:
                return Type.Perimeter_defender;
            case 4:
                return Type.In_out_defender;
            case 5:
                return Type.Pure_shooter;
            case 6:
                return Type.Offensive_superstar; //superstar only types from range 6-9
            case 7:
                return Type.Balanced_superstar;
            case 8:
                return Type.Lockdown_defender;
            case 9:
                return Type.Two_war_superstar;
            default:
                throw new IllegalStateException("Unexpected value: " + random);
        }
    }

    /**
     * Generates a type for a small forward
     * @param role Role of small forward
     * @return Type of small forward
     */
    public Type smallForwardType(Role role){
        int random;
        if(role.equals(Role.Superstar)){
            random = (int) (Math.random() * (10 - 7 + 1) + 7); //superstar types from range 7-10
        } else{
            random = (int) (Math.random() * (6 + 1)); //star to bench types from range 0-6
        }
        switch (random) {
            case 0:
                return Type.Three_and_D;
            case 1:
                return Type.All_around;
            case 2:
                return Type.Three_level_scorer;
            case 3:
                return Type.Perimeter_defender;
            case 4:
                return Type.In_out_defender;
            case 5:
                return Type.Inside_defender;
            case 6:
                return Type.Pure_shooter;
            case 7:
                return Type.Balanced_superstar; //superstar only types from range 7-10
            case 8:
                return Type.Lockdown_defender;
            case 9:
                return Type.Two_war_superstar;
            case 10:
                return Type.Offensive_superstar;
            default:
                throw new IllegalStateException("Unexpected value: " + random);
        }
    }

    /**
     * Generates a type for a power forward
     * @param role Role of power forward
     * @return Type of power forward
     */
    public Type powerForwardType(Role role){
        int random;
        if(role.equals(Role.Superstar)){
            random = (int) (Math.random() * (10 - 8 + 1) + 8); //superstar types from range 8-10
        } else{
            random = (int) (Math.random() * (7 + 1)); //star to bench types from range 0-7
        }
        switch (random) {
            case 0:
                return Type.Energetic_rebounder;
            case 1:
                return Type.Post_player;
            case 2:
                return Type.In_out_defender;
            case 3:
                return Type.Perimeter_defender;
            case 4:
                return Type.Inside_defender;
            case 5:
                return Type.Pure_shooter;
            case 6:
                return Type.Stretch_big;
            case 7:
                return Type.Three_level_scorer;
            case 8:
                return Type.Paint_beast; //superstar only types from range 8-10
            case 9:
                return Type.Lockdown_defender;
            case 10:
                return Type.Two_war_superstar;
            default:
                throw new IllegalStateException("Unexpected value: " + random);
        }
    }

    /**
     * Generates a type for a center
     * @param role Role of center
     * @return Type of center
     */
    public Type centerType(Role role){
        int random;
        if(role.equals(Role.Superstar)){
            random = 4;
        } else{
            random = (int) (Math.random() * (3 + 1)); //star to bench types from range 0-3
        }
        switch (random) {
            case 0:
                return Type.Energetic_rebounder;
            case 1:
                return Type.Post_player;
            case 2:
                return Type.Inside_defender;
            case 3:
                return Type.Stretch_big;
            case 4:
                return Type.Paint_beast; //superstar only
            default:
                throw new IllegalStateException("Unexpected value: " + random);
        }
    }

    /**
     * Generates type given a position and role
     * @param position Position of player
     * @param role Role of player
     * @return Type of player
     */
    public Type generateType(Position position, Role role){
        switch (position) {
            case Point_guard:
                return pointGuardType(role);
            case Shooting_guard:
                return shootingGuardType(role);
            case Small_forward:
                return smallForwardType(role);
            case Power_forward:
                return powerForwardType(role);
            case Center:
                return centerType(role);
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * Generates position by random
     * @return Position of player
     */
    public Position generatePosition(){
        int numberOfPositions = 4; //starting at 0
        int random = new Random().nextInt(numberOfPositions);
        switch (random) {
            case 0:
                return Position.Point_guard;
            case 1:
                return Position.Shooting_guard;
            case 2:
                return Position.Small_forward;
            case 3:
                return Position.Power_forward;
            case 4:
                return Position.Center;
            default:
                throw new IllegalStateException("Unexpected value: " + random);
        }
    }

    /**
     * Generates role by random
     * @return Role of player
     */
    public Role generateRole(){
        int random = new Random().nextInt(240);
        if(random <= 20){ //0-20, rare
            return Role.Superstar;
        } else if(random <= 60){ //21-60, uncommon
            return Role.Star;
        } else if(random <= 120){ //61-120, average
            return Role.Star;
        } else if(random <= 180){ //121-180, common
            return Role.Sixth_man;
        } else{ //181-240
            return Role.Bench;
        }
    }

    /**
     * Generates age by random
     * @return Age of player
     */
    public int generateAge(){
        return (int) (Math.random() * (22 - 19 + 1) + 19); //age range 19-22
    }

    /**
     * Creates a completely random player
     * @return Player
     */
    public Player createPlayer(){
        Position position = generatePosition();
        Role role = generateRole();
        Type type = generateType(position, role);
        return new Player(generateName(), generateAge(), type, role, position);
    }

    /**
     * Creates a random player with a given name
     * @param name Name of player
     * @return Player
     */
    public Player createPlayer(String name){
        Position position = generatePosition();
        Role role = generateRole();
        Type type = generateType(position, role);
        return new Player(name, generateAge(), type, role, position);
    }

    /**
     * Creates a random player with a given position
     * @param position Position of player
     * @return Player
     */
    public Player createPlayer(Position position){
        Role role = generateRole();
        Type type = generateType(position, role);
        return new Player(generateName(), generateAge(), type, role, position);
    }

    /**
     * Creates a random player with a given role
     * @param role Role of player
     * @return Player
     */
    public Player createPlayer(Role role){
        Position position = generatePosition();
        Type type = generateType(position, role);
        return new Player(generateName(), generateAge(), type, role, position);
    }

    /**
     * Creates a random player with a given type
     * @param type Type of player
     * @return Player
     */
    public Player createPlayer(Type type){
        Position position = generatePosition();
        Role role = generateRole();
        return new Player(generateName(), generateAge(), type, role, position);
    }

    /**
     * Creates a random player given a position and role
     * @param position Position of player
     * @param role Role of player
     * @return Player
     */
    public Player createPlayer(Position position, Role role){
        Type type = generateType(position, role);
        return new Player(generateName(), generateAge(), type, role, position);
    }

    /**
     * Creates a random player given a position, role, and type
     * @param position Position of player
     * @param role Rol of player
     * @param type Type of player
     * @return Player
     */
    public Player createPlayer(Position position, Role role, Type type){
        return new Player(generateName(), generateAge(), type, role, position);
    }

    /**
     * Creates a player given name, age, position, role, and type
     * @param name Name of player
     * @param age Age of player
     * @param position Position of player
     * @param role Role of player
     * @param type Type of player
     * @return Player
     */
    public Player createPlayer(String name, int age, Position position, Role role, Type type){
        return new Player(name, age, type, role, position);
    }

}
