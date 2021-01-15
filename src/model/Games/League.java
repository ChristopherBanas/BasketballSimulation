package model.Games;

import model.Player.Player;
import model.Team.Team;

import java.util.*;

/**
 * Desc: Class for league information
 * Author: Christopher Banas
 */
public class League {

    /** List of teams during this season */
    private ArrayList<Team> teamList;
    /** List of seasons that have occurred in this league */
    private ArrayList<Season> seasonList;
    /** Current year of league */
    private int year;

    /**
     * Constructor for League
     * @param teamList List of teams in this league
     */
    public League(ArrayList<Team> teamList){
        this.teamList = teamList;
        this.seasonList = new ArrayList<>();
        this.year = Calendar.getInstance().get(Calendar.YEAR);
    }

    /**
     * Simulates a new season and adds it to seasonlist
     */
    public void simulateNewSeason(){
        Season season = new Season(this.teamList, this.year);
        season.simulateSeason();
        season.simulatePlayoffs();
        this.seasonList.add(season);
    }

    /**
     * Builds a map of all the games userTeam has played
     * @param userTeam Team that the user is monitoring
     * @return Map of all games userTeam has played (key = game number, value = game)
     */
    public HashMap<Integer, Game> buildMap(Team userTeam){
        int count = 0;
        HashMap<Integer, Game> gameMap = new HashMap<>();
        Season season = seasonList.get(0);
        for(Game game : season.getGameList()){
            if(game.getTeam1().getName().equals(userTeam.getName()) ||
                    game.getTeam2().getName().equals(userTeam.getName())){
                count += 1;
                gameMap.put(count, game);
                System.out.printf("Game %s (%s Season)%n", count, this.year);
                game.printHeader();
            }
        }
        for(Game game : season.getPlayoffs().getGameList()){
            if(game.getTeam1().getName().equals(userTeam.getName()) ||
                    game.getTeam2().getName().equals(userTeam.getName())){
                count += 1;
                gameMap.put(count, game);
                System.out.printf("Game %s (%s Playoffs)%n", count, this.year);
                game.printHeader();
            }
        }
        return gameMap;
    }

    /**
     * Adds a year to this league and all the players within the teams
     */
    public void addYear(){
        this.year += 1;
        for(Team team : this.teamList){
            for(Player player : team.getRoster()){
                player.increaseAge();
            }
        }
    }
}
