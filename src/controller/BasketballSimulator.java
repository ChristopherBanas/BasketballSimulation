package controller;

import controller.ValidInputs.TeamInputs;
import model.Autogeneration.GenerateTeam;
import model.Games.Game;
import model.Games.League;
import model.Team.Team;

import java.util.*;

/**
 * Desc: Controls user input to properly simulate a basketball league
 * Author: Christopher Banas
 */
public class BasketballSimulator {

    /** Generator for teams */
    private final GenerateTeam teamGenerator;
    /** List of teams */
    private ArrayList<Team> teamList;
    /** Team that user wishes to monitor */
    private Team userTeam;
    /** League this simulation is running under */
    private League league;

    /**
     * Constructor for BasketballSimulator
     * @param option What option the user selected in Application
     */
    public BasketballSimulator(String option){
        this.teamGenerator = new GenerateTeam();
        this.teamList = new ArrayList<>();
        //option received from Application
        if ("1".equals(option)) {
            startFromFile();
        } else if ("2".equals(option)) {
            startRandom();
        }
        chooseTeam();
        startLeague();

    }

    /**
     * Constructs team from a given file
     */
    public void startFromFile(){
        FileReader fileReader = new FileReader();
        this.teamList = fileReader.run();
    }

    /**
     * Constructs team from teamGenerator
     */
    public void startRandom(){
        for(int i = 0; i<4; i++){ //generate 4 teams
            this.teamList.add(teamGenerator.createTeam());
        }
    }

    /**
     * Prompts the user which team they would like to monitor
     */
    public void chooseTeam(){
        for(Team team : this.teamList){
            System.out.println(team);
        }
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while(!TeamInputs.lakersSet.contains(input) && !TeamInputs.warriorsSet.contains(input) &&
                !TeamInputs.sixersSet.contains(input) && !TeamInputs.cetlicsSet.contains(input)){
            System.out.println("Enter team you wish to monitor");
            System.out.print("> ");
            input = scanner.nextLine();
            if(!TeamInputs.lakersSet.contains(input) && !TeamInputs.warriorsSet.contains(input) &&
                    !TeamInputs.sixersSet.contains(input) && !TeamInputs.cetlicsSet.contains(input)){
                System.out.println("Error: Enter correct team name");
                System.out.println("");
            }
        }
        if (TeamInputs.lakersSet.contains(input)){
            this.userTeam = findTeam("Lakers");
        } else if (TeamInputs.warriorsSet.contains(input)){
            this.userTeam = findTeam("Warriors");
        } else if (TeamInputs.sixersSet.contains(input)){
            this.userTeam = findTeam("Sixers");
        } else{ //celtics
            this.userTeam = findTeam("Celtics");
        }
    }

    /**
     * Finds the team in teamList that the user chose to monitor
     * @param name Name of chosen team
     * @return Chosen team
     */
    public Team findTeam(String name){
        for(Team team : this.teamList){
            if(team.getName().equals(name)){
                return team;
            }
        }
        return null;
    }

    /**
     * Print out desired games from current season
     */
    public void printGames(){
        Scanner scanner = new Scanner(System.in);
        String input = "";
        HashMap<Integer, Game> gameMap = league.buildMap(this.userTeam);
        Set<String> validInputSet = new HashSet<>(Arrays.asList("done", "Done", "d", "D"));
        while(!validInputSet.contains(input)){
            System.out.println("Enter which game you would like to see the box score of (enter done to exit)");
            System.out.print("> ");
            input = scanner.nextLine();
            if(!validInputSet.contains(input)){
                try{
                    if(!gameMap.containsKey(Integer.parseInt(input))){
                        System.out.println("Error: Enter a valid game number");
                        System.out.println("");
                    } else{
                        System.out.println("");
                        Game game = gameMap.get(Integer.parseInt(input));
                        game.printTotalResults();
                    }
                }catch (NumberFormatException e){
                    System.out.println("Error: Enter only a number");
                    System.out.println("");
                }
            }
        }
        System.out.println("");
    }

    /**
     * Prompt user if they would like to see the games of their chosen team
     * @return If user wants to see games or not
     */
    public boolean seeUserGames(){
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
                System.out.println("");
            }
        }
        System.out.println("");
        boolean bool = false;
        if(yesInputSet.contains(input)){
            bool = true;
        }
        return bool;
    }

    /**
     * Prompt user if they would like to simulate another season
     * @return If user wants to simulate another season or not
     */
    public boolean newSeasonPrompt(){
        Scanner scanner = new Scanner(System.in);
        String input = "";
        Set<String> yesInputSet = new HashSet<>(Arrays.asList("yes", "y", "Yes", "Y"));
        Set<String> noInputSet = new HashSet<>(Arrays.asList("no", "No", "n", "N"));
        while(!yesInputSet.contains(input) && !noInputSet.contains(input)){
            System.out.println("Would you like to simulate another season?");
            System.out.print("> ");
            input = scanner.nextLine();
            if(!yesInputSet.contains(input) && !noInputSet.contains(input)){
                System.out.println("Error: Enter yes or no");
                System.out.println("");
            }
        }
        System.out.println("");
        boolean bool = false;
        if(yesInputSet.contains(input)){
            bool = true;
        }
        return bool;
    }

    /**
     * Prompt user if they would like to monitor another team
     * @return If user wants to monitor another team or not
     */
    public boolean newTeamPrompt(){
        Scanner scanner = new Scanner(System.in);
        String input = "";
        Set<String> yesInputSet = new HashSet<>(Arrays.asList("yes", "y", "Yes", "Y"));
        Set<String> noInputSet = new HashSet<>(Arrays.asList("no", "No", "n", "N"));
        while(!yesInputSet.contains(input) && !noInputSet.contains(input)){
            System.out.println("Would you like to monitor a different team this season?");
            System.out.print("> ");
            input = scanner.nextLine();
            if(!yesInputSet.contains(input) && !noInputSet.contains(input)){
                System.out.println("Error: Enter yes or no");
                System.out.println("");
            }
        }
        System.out.println("");
        return yesInputSet.contains(input);
    }

    /**
     * Starts league and simulates
     */
    public void startLeague(){
        this.league = new League(this.teamList);
        boolean runLeague = true;
        Scanner scanner = new Scanner(System.in);
        while (runLeague){
            league.simulateNewSeason();
            if(seeUserGames()){
                printGames();
            }
            if(newSeasonPrompt()){
                if (newTeamPrompt()) {
                    chooseTeam();
                }
                league.addYear();
            } else{
                runLeague = false;
            }
        }
        System.out.println("Goodbye!");
    }
}
