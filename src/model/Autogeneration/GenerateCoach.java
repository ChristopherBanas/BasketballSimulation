package model.Autogeneration;

import model.Autogeneration.data.NameLists;
import model.Coach;

import java.util.HashSet;
import java.util.Random;

public class GenerateCoach {

    private HashSet<String> nameSet;

    public GenerateCoach(){
        this.nameSet = new HashSet<>();
    }

    /**
     * Generates a unique name
     * @return Name of coach
     */
    public String generateName(){
        String name = "";
        int listLength = 2943; //length of arrays in NameLists
        while (name.equals("")){ //will break loop if name is not in nameSet
            int random = new Random().nextInt(listLength);
            String firstName = NameLists.firstNameList.get(random); //O(1) time complexity
            String lastName = NameLists.lastNameList.get(random); //O(1) time complexity
            name = firstName + " " + lastName;
            if(nameSet.contains(name)){ //O(1) time complexity
                name = "";
            }
        }
        nameSet.add(name);
        return name;
    }

    /**
     * Generates age by random
     * @return Age of coach
     */
    public int generateAge(){
        return (int) (Math.random() * (60 - 45 + 1) + 45); //age range 60-45
    }

    public Coach createCoach(){
        return new Coach(generateName(), generateAge());
    }

    public Coach createCoach(String name){
        return new Coach(name, generateAge());
    }

    public Coach createCoach(String name, int age){
        return new Coach(name, age);
    }
}
