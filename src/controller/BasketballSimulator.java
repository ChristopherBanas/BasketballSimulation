package controller;

import model.Autogeneration.GenerateTeam;
import model.Games.League;
import model.Team.Team;

import java.util.*;

public class BasketballSimulator {

    GenerateTeam teamGenerator;
    ArrayList<Team> teamList;

    public BasketballSimulator(String option){
        this.teamGenerator = new GenerateTeam();
        this.teamList = new ArrayList<>();
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
        for(int i = 0; i<4; i++){ //generate 4 teams
            this.teamList.add(teamGenerator.createTeam());
        }
        for(Team team : this.teamList){
            System.out.println(team);
        }
        chooseTeam();
    }

    public void chooseTeam(){
        Set<String> lakersSet = new HashSet<>(Arrays.asList("lakers", "Lakers", "l", "L", "laker", "Laker", "LAKERS"));
        Set<String> warriorsSet = new HashSet<>(Arrays.asList("warriors", "Warriors", "w", "W", "warrior", "Warrior",
                "WARRIORS"));
        Set<String> sixersSet = new HashSet<>(Arrays.asList("sixers", "Sixers", "s", "S", "six", "Six", "76ers",
                "SIXERS"));
        Set<String> cetlicsSet = new HashSet<>(Arrays.asList("celtics", "Celtics", "c", "C", "celtic", "Celtic",
                "CELTICS"));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter team you wish to monitor");
        String input = "";
        while(!lakersSet.contains(input) && !warriorsSet.contains(input) && !sixersSet.contains(input) &&
                !cetlicsSet.contains(input)){
            System.out.print("> ");
            input = scanner.nextLine();
            if(!lakersSet.contains(input) && !warriorsSet.contains(input) && !sixersSet.contains(input) &&
                    !cetlicsSet.contains(input)){
                System.out.println("Error: Enter correct team name");
            }
        }
        Team chosenTeam = null;
        if (lakersSet.contains(input)){
            chosenTeam = findTeam("Lakers");
        } else if (warriorsSet.contains(input)){
            chosenTeam = findTeam("Warriors");
        } else if (sixersSet.contains(input)){
            chosenTeam = findTeam("Sixers");
        } else{ //celtics
            chosenTeam = findTeam("Celtics");
        }
        startLeague(chosenTeam);
    }

    public Team findTeam(String name){
        for(Team team : this.teamList){
            if(team.getName().equals(name)){
                return team;
            }
        }
        return null;
    }

    public void startLeague(Team userTeam){
        League league = new League(this.teamList, userTeam);
        league.simulateNewSeason();
    }
}
