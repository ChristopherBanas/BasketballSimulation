package model.Autogeneration;

import model.Autogeneration.data.NameLists;
import model.Player.Player;
import model.Player.Position;
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

    public Type generateType(){
        int numberOfTypes = 9; //not including god type and starting at 0
        //TODO CHANGE
        int random = new Random().nextInt(numberOfTypes);
        return switch (random){
            case 0 -> Type.THREE_AND_D;
            case 1 -> Type.ALL_AROUND;
            case 2 -> Type.PAINT_BEAST;
            case 3 -> Type.OFFENSIVE_PLAYMAKER;
            case 4 -> Type.DEFENSIVE_PLAYMAKER;
            case 5 -> Type.ENERGETIC_REBOUNDER;
            case 6 -> Type.THREE_LEVEL_SCORER;
            case 7 -> Type.POST_PLAYER;
            case 8 -> Type.PERIMETER_DEFENDER;
            case 9 -> Type.PURE_SHOOTER;
            default -> throw new IllegalStateException("Unexpected value: " + random);
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

}
