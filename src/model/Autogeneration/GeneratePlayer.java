package model.Autogeneration;

import model.Autogeneration.data.NameLists;
import model.Player.Player;

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

}
