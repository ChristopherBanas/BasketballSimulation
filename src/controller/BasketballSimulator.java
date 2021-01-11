package controller;

import model.Autogeneration.GenerateTeam;
import model.Team;

import java.util.ArrayList;

public class BasketballSimulator {

    GenerateTeam teamGenerator;


    public BasketballSimulator(String option){
        this.teamGenerator = new GenerateTeam();
        switch (option){ //option received from Application
            case "1" -> startFromFile();
            case "2" -> startByCreating();
            case "3" -> startRandom();
        }
    }

    public void startFromFile(){

    }

    public void startByCreating(){

    }

    public void startRandom(){
        ArrayList<Team> teamList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            teamList.add(teamGenerator.createTeam());
        }
    }
}
