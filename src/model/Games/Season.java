package model.Games;

import model.Player.Player;
import model.Simulations.PlayerStats;
import model.Team.Team;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Season {

    /** List of games during this season */
    private ArrayList<Game> gameList;
    /** List of teams during this season */
    private ArrayList<Team> teamList;
    /** Map of Players with a list of their game stats */
    private HashMap<Player, ArrayList<PlayerStats>> playerStatsMap;
    /** Map of player with high point avg during the season */
    private HashMap<Player, Double> highestPointMap;
    /** Map of player with high reb avg during the season */
    private HashMap<Player, Double> highestRebMap;
    /** Map of player with high ast avg during the season */
    private HashMap<Player, Double> highestAstMap;
    /** Map of player with most 3pm during the season */
    private HashMap<Player, Integer> highestThreeMap;
    /** Playoffs for this season */
    private Playoffs playoffs;
    /** Season year */
    private int year;


    public Season(ArrayList<Team> teamList, int year){
        this.gameList = new ArrayList<>();
        this.teamList = teamList;
        this.playerStatsMap = new HashMap<>();
        this.highestPointMap = new HashMap<>();
        this.highestRebMap = new HashMap<>();
        this.highestAstMap = new HashMap<>();
        this.highestThreeMap = new HashMap<>();
        this.year = year;
    }

    /**
     * Line teams up against each other and add all games to gameList
     */
    public void arrangeGames(){
        for(Team team1 : this.teamList){ //loop through teams
            for(Team team2 : this.teamList){ //loop through teams to see who can play who
                if(!team1.equals(team2)){ //teams cant play each themselves
                    Game game = new Game(team1, team2); //teams will play each other twice
                    this.gameList.add(game);
                }
            }
        }
    }

    /**
     * Parse through gameList and play the games
     */
    public void playGames(){
        for(Game game : this.gameList){
            game.play();
        }
    }

    /**
     * Parse through played games and update season stats
     */
    public void parseGameStats(){
        for(Game game : this.gameList){
            for(PlayerStats stats : game.getTeam1BoxScore().getStatsList()){
                updateSeasonStats(stats);
            }
            for(PlayerStats stats : game.getTeam2BoxScore().getStatsList()){
                updateSeasonStats(stats);
            }
        }
    }

    /**
     * Enter data into playerStatsMap
     * @param stats Stats to be entered
     */
    public void updateSeasonStats(PlayerStats stats){
        if(this.playerStatsMap.containsKey(stats.getPlayer())){ //in map
            ArrayList<PlayerStats> statsList = this.playerStatsMap.get(stats.getPlayer());
            statsList.add(stats);
            this.playerStatsMap.put(stats.getPlayer(), statsList);
        } else{ //not in map yet
            this.playerStatsMap.put(stats.getPlayer(), new ArrayList<>(List.of(stats)));
        }
    }

    /**
     * Rounding method used to round doubles when calculating season averages
     * @param value Double to be rounded
     * @return Rounded double
     */
    public double round(double value) {
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    /**
     * Parse through playerStatsMap to determine highest pts, rebs, and asts averages
     */
    public void parseSeasonStats(){
        HashMap<Player, Integer> pointsMap = new HashMap<>();
        HashMap<Player, Integer> reboundsMap = new HashMap<>();
        HashMap<Player, Integer> assistsMap = new HashMap<>();
        HashMap<Player, Integer> threeMap = new HashMap<>();
        for(ArrayList<PlayerStats> statsList : this.playerStatsMap.values()){ //loop through all stats
            for(PlayerStats stats : statsList){
                pointsMap = updatePlayerStats(pointsMap, stats.getTotalPoints(), stats.getPlayer());
                reboundsMap = updatePlayerStats(reboundsMap, stats.getRebounds(), stats.getPlayer());
                assistsMap = updatePlayerStats(assistsMap, stats.getAssists(), stats.getPlayer());
                threeMap = updatePlayerStats(threeMap, stats.getThreePointers(), stats.getPlayer());
            }
        }

        double highest = 0;
        for(Player player : pointsMap.keySet()){
            double avgPoints = (double) pointsMap.get(player) / (this.teamList.size()*3); //avg
            if(avgPoints > highest){
                highest = avgPoints;
                this.highestPointMap.clear();
                this.highestPointMap.put(player, round(avgPoints));
            }
        }

        highest = 0;
        for(Player player : reboundsMap.keySet()){
            double avgRebs = (double) reboundsMap.get(player) / (this.teamList.size()*3); //avg
            if(avgRebs > highest){
                highest = avgRebs;
                this.highestRebMap.clear();
                this.highestRebMap.put(player, round(avgRebs));
            }
        }

        highest = 0;
        for(Player player : assistsMap.keySet()){
            double avgAsts = (double) assistsMap.get(player) / (this.teamList.size()*3); //avg
            if(avgAsts > highest){
                highest = avgAsts;
                this.highestAstMap.clear();
                this.highestAstMap.put(player, round(avgAsts));
            }
        }

        highest = 0;
        for(Player player : threeMap.keySet()){
            int threes = threeMap.get(player);
            if(threes > highest){
                highest = threes;
                this.highestThreeMap.clear();
                this.highestThreeMap.put(player, threes);
            }
        }
    }

    /**
     * Update given map with given stats
     * @param map Map to be updates
     * @param statNum Number to be entered into map (value)
     * @param player Player that statNum belongs to (key)
     * @return Updated map
     */
    public HashMap<Player, Integer> updatePlayerStats(HashMap<Player, Integer> map, Integer statNum, Player player){
        if(map.containsKey(player)){ //key in map
            int updateName = map.get(player);
            updateName += statNum;
            map.put(player, updateName);
        } else{ //key not in map
            map.put(player, statNum);
        }
        return map;
    }

    /**
     * Getter for games list
     * @return List of games during this season
     */
    public ArrayList<Game> getGameList() {
        return gameList;
    }

    /**
     * Getter for total player stats map
     * @return Map containing all player stats during season
     */
    public HashMap<Player, ArrayList<PlayerStats>> getPlayerStatsMap() {
        return playerStatsMap;
    }

    /**
     * Getter for highest points per game map
     * @return Map containing player who averaged most points per game
     */
    public HashMap<Player, Double> getHighestPointMap() {
        return highestPointMap;
    }

    /**
     * Getter for highest rebounds per game map
     * @return Map containing player who averaged most rebounds per game
     */
    public HashMap<Player, Double> getHighestRebMap() {
        return highestRebMap;
    }

    /**
     * Getter for highest assists per game map
     * @return Map containing player who averaged most assists per game
     */
    public HashMap<Player, Double> getHighestAstMap() {
        return highestAstMap;
    }

    /**
     * Getter for most threes per season map
     * @return Map containg player who scored most threes during the season
     */
    public HashMap<Player, Integer> getHighestThreeMap() {
        return highestThreeMap;
    }

    /**
     * Getter for year of this season
     * @return Year
     */
    public int getYear() {
        return year;
    }

    /**
     * Simulates this season
     */
    public void simulate(){
        arrangeGames();
        playGames();
        parseGameStats();
        parseSeasonStats();
    }


}
