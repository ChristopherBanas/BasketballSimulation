package model.Autogeneration;

import model.Autogeneration.data.NameLists;
import model.Autogeneration.data.TeamList;
import model.Coach;
import model.GenerateCoach;
import model.Player.Player;
import model.Player.Role;
import model.Player.Type;
import model.Team;

import java.util.HashSet;
import java.util.Random;

public class GenerateTeam {

    private HashSet<String> nameSet;
    private GeneratePlayer playerGenerator;
    private GenerateCoach coachGenerator;
    private int ROSTER_SIZE = 9;

    public GenerateTeam(){
        this.nameSet = new HashSet<>();
        this.playerGenerator = new GeneratePlayer();
        this.coachGenerator = new GenerateCoach();
    }

    public String generateName(){
        String name = "";
        int listLength = 4;
        while (name.equals("")){
            int random = new Random().nextInt(listLength);
            name = TeamList.teamNameList.get(random); //O(1) time complexity
            if(nameSet.contains(name)){ //O(1) time complexity
                name = "";
            }
        }
        nameSet.add(name);
        return name;
    }

    public Coach generateCoach(){
        return coachGenerator.createCoach();
    }

    public Team generateGodTeam(){
        Team team = new Team(generateName(), generateCoach());
        for(int i=0; i<ROSTER_SIZE; i++){
            Player player = playerGenerator.createPlayer(Type.GOD);
            team.addPlayer(player);
        }
        return team;
    }

    /**
    public Team generateSuperTeam(){}

    public Team generateContendingTeam(){}

    public Team generatePlayoffTeam(){}

    public Team generateAverageTeam(){}

    public Team generateTankingTeam(){}

    public TeamType generateRandomTeamType(){
        int random = new Random().nextInt(200);
        if(random <= 5){ //0-5, very rare
            return TeamType.SUPER_TEAM;
        } else if(random <= 40){ //6-40, rare
            return TeamType.CONTENDING_TEAM;
        } else if(random <= 110){ //41-110, average
            return TeamType.PLAYOFF_TEAM;
        } else{ //111-200, common
            return TeamType.AVERAGE_TEAM;
        }
    }


    public Team generateTeamType(TeamType teamType){
        if(teamType == null){
            teamType = generateRandomTeamType();
        }
        return switch (teamType){
            case GOD_TEAM -> generateGodTeam();
            case SUPER_TEAM -> generateSuperTeam();
            case CONTENDING_TEAM -> generateContendingTeam();
            case PLAYOFF_TEAM -> generatePlayoffTeam();
            case AVERAGE_TEAM -> generateAverageTeam();
        };
    }
     */

}
