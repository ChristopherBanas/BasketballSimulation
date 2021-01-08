package model.Autogeneration;

import model.Autogeneration.data.NameLists;
import model.Player.Player;
import model.Player.Position;
import model.Player.Role;
import model.Player.Type;

import java.util.HashSet;
import java.util.Random;


public class GeneratePlayer {

    HashSet<String> nameSet;

    public GeneratePlayer(){
        nameSet = new HashSet<>();
    }

    public String generateName(){
        String name = "";
        int listLength = 2944;
        while (name.equals("")){ //will break loop if name is not in nameSet
            int random = new Random().nextInt(listLength);
            String firstName = NameLists.firstNameList.get(random);
            String lastName = NameLists.lastNameList.get(random);
            name = firstName + " " + lastName;
            if(nameSet.contains(name)){
                name = "";
            }
        }
        nameSet.add(name);
        return name;
    }

    public Type pointGuardType(Role role){
        int random;
        if(role.equals(Role.SUPERSTAR)){
            random = (int) (Math.random() * (9 - 5 + 1) + 5); //superstar types from range 5-9
        } else{
            random = (int) (Math.random() * (4 + 1)); //star to bench types from range 0-4
        }
        return switch (random){
            case 0 -> Type.PLAYMAKER;
            case 1 -> Type.ALL_AROUND;
            case 2 -> Type.OFFENSIVE_PLAYMAKER;
            case 3 -> Type.DEFENSIVE_PLAYMAKER;
            case 4 -> Type.PERIMETER_DEFENDER;
            case 5 -> Type.OFFENSIVE_SUPERSTAR; //superstar only types from range 5-9
            case 6 -> Type.POINT_GOD;
            case 7 -> Type.BALANCED_SUPERSTAR;
            case 8 -> Type.LOCKDOWN_DEFENDER;
            case 9 -> Type.TWO_WAY_SUPERSTAR;
            default -> throw new IllegalStateException("Unexpected value: " + random);
        };
    }

    public Type shootingGuardType(Role role){
        int random;
        if(role.equals(Role.SUPERSTAR)){
            random = (int) (Math.random() * (9 - 6 + 1) + 6); //superstar types from range 6-9
        } else{
            random = (int) (Math.random() * (5 + 1)); //star to bench types from range 0-5
        }
        return switch (random){
            case 0 -> Type.THREE_AND_D;
            case 1 -> Type.ALL_AROUND;
            case 2 -> Type.THREE_LEVEL_SCORER;
            case 3 -> Type.PERIMETER_DEFENDER;
            case 4 -> Type.INSIDE_OUTSIDE_DEFENDER;
            case 5 -> Type.PURE_SHOOTER;
            case 6 -> Type.OFFENSIVE_SUPERSTAR; //superstar only types from range 6-9
            case 7 -> Type.BALANCED_SUPERSTAR;
            case 8 -> Type.LOCKDOWN_DEFENDER;
            case 9 -> Type.TWO_WAY_SUPERSTAR;
            default -> throw new IllegalStateException("Unexpected value: " + random);
        };
    }

    public Type smallForwardType(Role role){
        int random;
        if(role.equals(Role.SUPERSTAR)){
            random = (int) (Math.random() * (10 - 7 + 1) + 7); //superstar types from range 7-10
        } else{
            random = (int) (Math.random() * (6 + 1)); //star to bench types from range 0-6
        }
        return switch (random){
            case 0 -> Type.THREE_AND_D;
            case 1 -> Type.ALL_AROUND;
            case 2 -> Type.THREE_LEVEL_SCORER;
            case 3 -> Type.PERIMETER_DEFENDER;
            case 4 -> Type.INSIDE_OUTSIDE_DEFENDER;
            case 5 -> Type.INSIDE_DEFENDER;
            case 6 -> Type.PURE_SHOOTER;
            case 7 -> Type.BALANCED_SUPERSTAR; //superstar only types from range 7-10
            case 8 -> Type.LOCKDOWN_DEFENDER;
            case 9 -> Type.TWO_WAY_SUPERSTAR;
            case 10 -> Type.OFFENSIVE_SUPERSTAR;
            default -> throw new IllegalStateException("Unexpected value: " + random);
        };
    }

    public Type powerForwardType(Role role){
        int random;
        if(role.equals(Role.SUPERSTAR)){
            random = (int) (Math.random() * (10 - 8 + 1) + 8); //superstar types from range 8-10
        } else{
            random = (int) (Math.random() * (7 + 1)); //star to bench types from range 0-7
        }
        return switch (random){
            case 0 -> Type.ENERGETIC_REBOUNDER;
            case 1 -> Type.POST_PLAYER;
            case 2 -> Type.INSIDE_OUTSIDE_DEFENDER;
            case 3 -> Type.PERIMETER_DEFENDER;
            case 4 -> Type.INSIDE_DEFENDER;
            case 5 -> Type.PURE_SHOOTER;
            case 6 -> Type.STRETCH_BIG;
            case 7 -> Type.THREE_LEVEL_SCORER;
            case 8 -> Type.PAINT_BEAST; //superstar only types from range 8-10
            case 9 -> Type.LOCKDOWN_DEFENDER;
            case 10 -> Type.TWO_WAY_SUPERSTAR;
            default -> throw new IllegalStateException("Unexpected value: " + random);
        };
    }

    public Type centerType(Role role){
        int random;
        if(role.equals(Role.SUPERSTAR)){
            random = 4;
        } else{
            random = (int) (Math.random() * (3 + 1)); //star to bench types from range 0-3
        }
        return switch (random){
            case 0 -> Type.ENERGETIC_REBOUNDER;
            case 1 -> Type.POST_PLAYER;
            case 2 -> Type.INSIDE_DEFENDER;
            case 3 -> Type.STRETCH_BIG;
            case 4 -> Type.PAINT_BEAST; //superstar only
            default -> throw new IllegalStateException("Unexpected value: " + random);
        };
    }

    public Type generateType(Position position, Role role){
        return switch (position){
            case POINT_GUARD -> pointGuardType(role);
            case SHOOTING_GUARD -> shootingGuardType(role);
            case SMALL_FORWARD -> smallForwardType(role);
            case POWER_FORWARD -> powerForwardType(role);
            case CENTER -> centerType(role);
        };
    }

    public Position generatePosition(){
        int numberOfPositions = 4; //starting at 0
        int random = new Random().nextInt(numberOfPositions);
        return switch (random){
            case 0 -> Position.POINT_GUARD;
            case 1 -> Position.SHOOTING_GUARD;
            case 2 -> Position.SMALL_FORWARD;
            case 3 -> Position.POWER_FORWARD;
            case 4 -> Position.CENTER;
            default -> throw new IllegalStateException("Unexpected value: " + random);
        };
    }

    public Role generateRole(){
        int random = new Random().nextInt(240);
        if(random <= 20){ //0-20
            return Role.SUPERSTAR;
        } else if(random <= 60){ //21-60
            return Role.STAR;
        } else if(random <= 120){ //61-120
            return Role.STARTER;
        } else if(random <= 180){ //121-180
            return Role.SIXTH_MAN;
        } else{ //181-240
            return Role.BENCH;
        }
    }

    public int generateAge(){
        return (int) (Math.random() * (22 - 19 + 1) + 19);
    }

    public Player createPlayer(){
        Position position = generatePosition();
        Role role = generateRole();
        Type type = generateType(position, role);
        return new Player(generateName(), generateAge(), type, role, position);
    }

    public Player createPlayer(String name){
        Position position = generatePosition();
        Role role = generateRole();
        Type type = generateType(position, role);
        return new Player(name, generateAge(), type, role, position);
    }

    public Player createPlayer(Position position){
        Role role = generateRole();
        Type type = generateType(position, role);
        return new Player(generateName(), generateAge(), type, role, position);
    }

    public Player createPlayer(Role role){
        Position position = generatePosition();
        Type type = generateType(position, role);
        return new Player(generateName(), generateAge(), type, role, position);
    }

    public Player createPlayer(Type type){
        Position position = generatePosition();
        Role role = generateRole();
        return new Player(generateName(), generateAge(), type, role, position);
    }

    public Player createPlayer(Position position, Role role){
        Type type = generateType(position, role);
        return new Player(generateName(), generateAge(), type, role, position);
    }

    public Player createPlayer(Position position, Role role, Type type){
        return new Player(generateName(), generateAge(), type, role, position);
    }

    public Player createPlayer(String name, int age, Position position, Role role, Type type){
        return new Player(name, age, type, role, position);
    }

}
