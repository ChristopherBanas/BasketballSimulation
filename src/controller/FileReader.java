package controller;

import controller.ValidInputs.PlayerInputs;
import controller.ValidInputs.TeamInputs;
import model.Player.Player;
import model.Team.Coach;
import model.Team.Team;


import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileReader {

    private ArrayList<Team> teamList;
    private Team currentTeam;

    public FileReader(){
        this.teamList = new ArrayList<>();
    }

    public String chooseFile(){
        FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        return dialog.getDirectory()+dialog.getFile();
    }

    public boolean properLineFormat(ArrayList<String> line){
        boolean proper = false; //assume wrong
        switch (line.get(0)){
            case "START_TEAM":
            case "END_TEAM":
                if(line.size() == 1){
                    proper = true;
                }
                break;
            case "Team":
                if(line.size() == 3){ //line size must be 3
                    String team = line.get(1);
                    //must be a valid team name
                    if(TeamInputs.lakersSet.contains(team) || TeamInputs.warriorsSet.contains(team) ||
                            TeamInputs.sixersSet.contains(team) || TeamInputs.cetlicsSet.contains(team)){
                        //must have a number at end of team line
                        try {
                            Integer.parseInt(line.get(2));
                            proper = true;
                        } catch (NumberFormatException ignored){
                        }
                    }
                }
                break;
            case "Coach":
                if(line.size() == 3){ //line size must be 3
                    //must have a number at end of coach line for age
                    try {
                        Integer.parseInt(line.get(2));
                        proper = true;
                    } catch (NumberFormatException ignored){
                    }
                }
                break;
            case "Player":
                if(line.size() == 6){ //line size must be 5
                    //second element must be player age
                    try {
                        Integer.parseInt(line.get(2));
                        if(PlayerInputs.typeSet.contains(line.get(3))){ //valid type
                            if(PlayerInputs.roleSet.contains(line.get(4))){ //valid role
                                if(PlayerInputs.positionSet.contains(line.get(5))){ //valid position
                                    proper = true;
                                }
                            }
                        }
                    } catch (NumberFormatException ignored){
                    }
                }
                break;
        }
        if(!proper){
            System.out.println("Error reading file: " + line.toString());
        }
        return proper;
    }

    public boolean properFileFormat(Scanner file){
        int count = 0;
        int lineNumber = 0;
        boolean proper = false;
        while (file.hasNextLine()){
            String line = file.nextLine();
            lineNumber++;
            ArrayList<String> lineList = new ArrayList<>(Arrays.asList(line.split(",")));
            if(properLineFormat(lineList)){
                String item = lineList.get(0);
                count++;
                if(item.equals("START_TEAM")){
                    count = 0;
                } else if(item.equals("END_TEAM")){
                    if(count == 12){
                        proper = true;
                    } else{
                        System.out.printf("Error on line %s, incorrect team information%n", lineNumber);
                        return false;
                    }
                } else if(count == 1){ //second line must be team
                    if(!item.equals("Team")){
                        System.out.printf("Error on line %s, should be Team%n", lineNumber);
                        return false;
                    }
                } else if(count == 2){ //second line must be coach
                    if(!item.equals("Coach")){
                        System.out.printf("Error on line %s, should be Coach%n", lineNumber);
                        return false;
                    }
                } else if(count >=3 && count <= 11){ //lines 3-11 must be players
                    if(!item.equals("Player")){
                        System.out.printf("Error on line %s, should be Player%n", lineNumber);
                        return false;
                    }
                }
            }
        }
        return proper;
    }

    public void buildLeague(Scanner file){
        while (file.hasNextLine()){
            String line = file.nextLine();
            ArrayList<String> lineList = new ArrayList<>(Arrays.asList(line.split(",")));
            String item = lineList.get(0);
            switch (item){
                case "Team":
                    this.currentTeam = new Team(lineList.get(1), Integer.parseInt(lineList.get(2)));
                    break;
                case "Coach":
                    Coach coach = new Coach(lineList.get(1), Integer.parseInt(lineList.get(2)));
                    this.currentTeam.setCoach(coach);
                    break;
                case "Player":
                    break;
                case "END_TEAM":
                    break;
            }
        }
    }

    public void parseFile(String filePath){
        try (Scanner teamFile = new Scanner(new File(filePath))){
            if(properFileFormat(teamFile)){
                buildLeague(teamFile);
            } else{
                System.out.println("");
                System.out.println("Fix file and rerun program");
                System.exit(0);
            }
        }
        catch(FileNotFoundException e){
            System.out.println(e.toString());
            System.exit(0);
        }
    }

    public ArrayList<Team> run() {
        String filePath = chooseFile();
        parseFile(filePath);
        return this.teamList;
    }
}
