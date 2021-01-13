package model.Games;

import model.Player.Player;
import model.Team.Team;

import java.util.*;

public class League {

    /** List of teams during this season */
    private ArrayList<Team> teamList;
    /** List of seasons that have occurred in this league */
    private ArrayList<Season> seasonList;
    private Team userTeam;
    private int year;

    public League(ArrayList<Team> teamList, Team userTeam){
        this.teamList = teamList;
        this.userTeam = userTeam;
        this.year = Calendar.getInstance().get(Calendar.YEAR);
    }

    public void simulateNewSeason(){
        Season season = new Season(this.teamList, this.year);
        season.simulateSeason();
        season.simulatePlayoffs();
        if(promptUser()){
            printGames(season);
        }
        addYear();
    }

    public boolean promptUser(){
        Scanner scanner = new Scanner(System.in);
        String input = "";
        Set<String> yesInputSet = new HashSet<>(Arrays.asList("yes", "y", "Yes", "Y"));
        Set<String> noInputSet = new HashSet<>(Arrays.asList("no", "No", "n", "N"));
        while(!yesInputSet.contains(input) && !noInputSet.contains(input)){
            System.out.printf("Would you like to see box scores from your team's (%s) schedule?%n",
                    this.userTeam.getName());
            System.out.print("> ");
            input = scanner.nextLine();
            if(!yesInputSet.contains(input) && !noInputSet.contains(input)){
                System.out.println("Error: Enter yes or no");
            }
        }
        System.out.println("");
        boolean bool = false;
        if(yesInputSet.contains(input)){
            bool = true;
        }
        return bool;
    }

    public HashMap<Integer, Game> buildMap(Season season, HashMap<Integer, Game> gameMap){
        int count = 0;
        for(Game game : season.getGameList()){
            if(game.getTeam1().getName().equals(this.userTeam.getName()) ||
                    game.getTeam2().getName().equals(this.userTeam.getName())){
                count += 1;
                gameMap.put(count, game);
                System.out.printf("Game %s (%s Season)%n", count, this.year);
                game.printHeader();
            }
        }
        for(Game game : season.getPlayoffs().getGameList()){
            if(game.getTeam1().getName().equals(this.userTeam.getName()) ||
                    game.getTeam2().getName().equals(this.userTeam.getName())){
                count += 1;
                gameMap.put(count, game);
                System.out.printf("Game %s (%s Playoffs)%n", count, this.year);
                game.printHeader();
            }
        }
        return gameMap;
    }

    public void printGames(Season season){
        HashMap<Integer, Game> gameMap = new HashMap<>();
        gameMap = buildMap(season, gameMap);
        Scanner scanner = new Scanner(System.in);
        String input = "";
        Set<String> validInputSet = new HashSet<>(Arrays.asList("done", "Done", "d", "D"));
        while(!validInputSet.contains(input)){
            System.out.println("Enter which game you would like to see the box score of (enter done to exit)");
            System.out.print("> ");
            input = scanner.nextLine();
            if(!validInputSet.contains(input)){
                try{
                    if(!gameMap.containsKey(Integer.parseInt(input))){
                        System.out.println("Error: Enter a valid game number");
                    } else{
                        Game game = gameMap.get(Integer.parseInt(input));
                        game.printTotalResults();
                    }
                }catch (NumberFormatException e){
                    System.out.println("Error: Enter only a number");
                }
            }
        }
    }

    public void addYear(){
        this.year += 1;
        for(Team team : this.teamList){
            for(Player player : team.getRoster()){
                player.increaseAge();
            }
        }
    }

}
