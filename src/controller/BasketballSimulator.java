package controller;

import model.Autogeneration.GenerateTeam;
import model.Team.Team;

import java.util.ArrayList;

public class BasketballSimulator {

    GenerateTeam teamGenerator;


    public BasketballSimulator(String option){
        this.teamGenerator = new GenerateTeam();
        switch (option){ //option received from Application
            case "1" -> startFromFile();
            case "2" -> startRandom();
        }
    }

    public void startFromFile(){
        //TODO open file browser
    }


    public void startRandom(){
        ArrayList<Team> teamList = new ArrayList<>();
        for(int i = 0; i<4; i++){ //generate 4 teams
            teamList.add(teamGenerator.createTeam());
        }
        for(Team team : teamList){
            System.out.println(team);
        }
    }
}
