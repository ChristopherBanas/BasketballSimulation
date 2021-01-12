package model.Games;

import model.Team.Team;

import java.util.ArrayList;

public class Playoffs {

    private int year;
    private Team champion;
    private Team lakers;
    private Team warriors;
    private Team sixers;
    private Team celtics;

    public Playoffs(ArrayList<Team> teams, int year){
        this.year = year;
        for(Team team : teams){
            if(team.getName().equals("Lakers")){
                lakers = team;
            } else if (team.getName().equals("Warriors")){
                warriors = team;
            } else if (team.getName().equals("Sixers")){
                sixers = team;
            } else{ //must be celtics
                celtics = team;
            }
        }
    }

    public PlayoffRound simulateRound(Team team1, Team team2, String roundType){
        int team1Wins = 0, team2Wins = 0;
        while(team1Wins < 4 || team2Wins < 4){ //loop until a team has 4 wins
            Game game = new Game(team1, team2);
            game.play();
            if(game.getWinner().getName().equals(team1.getName())){ //team1 is winner
                team1Wins += 1;
            } else {
                team2Wins += 1;
            }
            if(team1Wins == 4 || team2Wins == 4){
                break;
            }
        }
        PlayoffRound round;
        if(team1Wins > team2Wins){ //team1 won
            round = new PlayoffRound(team1, team1Wins, team2, team2Wins, roundType);
        } else{ //team2 won
            round = new PlayoffRound(team2, team2Wins, team1, team1Wins, roundType);
        }
        return round;
    }

    public void simulate(){
        PlayoffRound westRound = simulateRound(lakers, warriors, "West");
        System.out.println(westRound);
        PlayoffRound eastRound = simulateRound(sixers, celtics, "East");
        System.out.println(eastRound);
        PlayoffRound championshipRound = simulateRound(westRound.getWinner(), eastRound.getWinner(),
                "Championship");
        System.out.println(championshipRound);
        championshipRound.getWinner().addChampionship();
        System.out.printf("| The %s have won the %s championship!%n",
                championshipRound.getWinner().getName(), year);
        System.out.println(championshipRound.getWinner().toString());
    }

}
