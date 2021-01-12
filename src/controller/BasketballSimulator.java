package controller;

import model.Autogeneration.GenerateTeam;
import model.Team.Team;

import java.util.ArrayList;

public class BasketballSimulator {

    GenerateTeam teamGenerator;


    public BasketballSimulator(String option){
        this.teamGenerator = new GenerateTeam();
        //option received from Application
        if ("1".equals(option)) {
            startFromFile();
        } else if ("2".equals(option)) {
            startRandom();
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
