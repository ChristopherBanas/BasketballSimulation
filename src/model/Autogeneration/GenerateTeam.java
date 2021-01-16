package model.Autogeneration;

import model.Autogeneration.data.TeamList;
import model.Team.Coach;
import model.Player.Player;
import model.Player.Position;
import model.Player.Role;
import model.Player.Type;
import model.Team.Team;
import model.Team.TeamType;

import java.util.*;

/**
 * Desc: Class for team generation
 * Author: Christopher Banas
 */
public class GenerateTeam {

    /** Set of all the names generated so far */
    private HashSet<String> nameSet;
    /** Player generator */
    private GeneratePlayer playerGenerator;
    /** Coach generator */
    private GenerateCoach coachGenerator;
    /** Global variable that sets how many players are in a team */
    private int ROSTER_SIZE = 9;

    /**
     * Constructor for GenerateTeam
     */
    public GenerateTeam(){
        this.nameSet = new HashSet<>();
        this.playerGenerator = new GeneratePlayer();
        this.coachGenerator = new GenerateCoach();
    }

    /**
     * Generates a unique team name
     * @return Name of team
     */
    public String generateName(){
        String name = "";
        int listLength = 4;
        while (name.equals("")){
            int random = new Random().nextInt(listLength);
            name = TeamList.teamNameList[random]; //O(1) time complexity
            if(nameSet.contains(name)){ //O(1) time complexity
                name = "";
            }
        }
        nameSet.add(name);
        return name;
    }

    /**
     * Generates a coach
     * @return Coach
     */
    public Coach generateCoach(){
        return coachGenerator.createCoach();
    }

    /**
     * Generates a position list
     * @return List of positions
     */
    public ArrayList<Position> generatePositionList(){
        List<Position> positions = new ArrayList<>();
        positions.add(Position.Point_guard);
        positions.add(Position.Shooting_guard);
        positions.add(Position.Small_forward);
        positions.add(Position.Power_forward);
        positions.add(Position.Center);
        return new ArrayList<>(positions);
    }

    /**
     * Generates a bench player
     * @param position Position of player
     * @param role Role of player
     * @return Bench player
     */
    public Player generateBenchPlayer(Position position, Role role){
        return playerGenerator.createPlayer(position, role);
    }

    /**
     * Generates a bench for a team
     * @param team Team that this bench belongs to
     * @return Team with bench players added
     */
    public Team generateBench(Team team){
        ArrayList<Position> positionList = generatePositionList();

        for(int i=0; i<ROSTER_SIZE-5; i++){ //create bench
            Position position = positionList.remove(new Random().nextInt(positionList.size()));
            if(i == 0){ //sixth man
                team.addPlayer(generateBenchPlayer(position, Role.Sixth_man));
            } else{
                team.addPlayer(generateBenchPlayer(position, Role.Bench));
            }
        }
        return team;
    }

    /**
     * Generates a god team (5 god players)
     * @return God team
     */
    public Team generateGodTeam(){
        Team team = new Team(generateName(), generateCoach(), TeamType.God_team);

        ArrayList<Position> positionList = generatePositionList();

        for(int i=0; i<5; i++){ //create starting 5
            Position position = positionList.remove(new Random().nextInt(positionList.size()));
            Player player = playerGenerator.createPlayer(position, Role.Superstar, Type.God);
            team.addPlayer(player);
        }
        return generateBench(team);
    }

    /**
     * Generates a super team (2 superstars, 1 star)
     * @return Super team
     */
    public Team generateSuperTeam(){
        Team team = new Team(generateName(), generateCoach(), TeamType.Super_team);

        ArrayList<Position> positionList = generatePositionList();

        for(int i=0; i<5; i++){ //create starting 5
            Position position = positionList.remove(new Random().nextInt(positionList.size()));
            Role role = Role.Starter;
            if(i < 2){ //2 superstars needed for super team
                role = Role.Superstar;
            } else if(i == 2){ //1 star needed for super team
                role = Role.Star;
            }
            Player player = playerGenerator.createPlayer(position, role);
            team.addPlayer(player);
        }
        return generateBench(team);
    }

    /**
     * Generates a contending team (1-2 superstars / stars)
     * @return Contending team
     */
    public Team generateContendingTeam(){
        Team team = new Team(generateName(), generateCoach(), TeamType.Contending_team);

        ArrayList<Position> positionList = generatePositionList();

        int numOfSuperstars = (int) (Math.random() * (2 - 1 + 1) + 1);
        for(int i=0; i<5; i++){ //create starting 5
            Position position = positionList.remove(new Random().nextInt(positionList.size()));
            Role role = Role.Starter;
            if(i < numOfSuperstars){ //1 or 2 superstars needed for contending team
                role = Role.Superstar;
            } else if(i == numOfSuperstars && numOfSuperstars == 1){ //1 star needed for with super star
                role = Role.Star;
            }
            Player player = playerGenerator.createPlayer(position, role);
            team.addPlayer(player);
        }
        return generateBench(team);
    }

    /**
     * Generates a playoff team (1-2 stars)
     * @return Playoff team
     */
    public Team generatePlayoffTeam(){
        Team team = new Team(generateName(), generateCoach(), TeamType.Playoff_team);

        ArrayList<Position> positionList = generatePositionList();

        int numOfStars = (int) (Math.random() * (2 - 1 + 1) + 1);
        for(int i=0; i<5; i++){ //create starting 5
            Position position = positionList.remove(new Random().nextInt(positionList.size()));
            Role role = Role.Starter;
            if(i < numOfStars){ //1 or 2 stars needed for playoff team
                role = Role.Star;
            }
            Player player = playerGenerator.createPlayer(position, role);
            team.addPlayer(player);
        }
        return generateBench(team);
    }

    /**
     * Generates an average team (5 starters)
     * @return Average team
     */
    public Team generateAverageTeam(){
        Team team = new Team(generateName(), generateCoach(), TeamType.Average_team);

        ArrayList<Position> positionList = generatePositionList();

        for(int i=0; i<5; i++){ //create starting 5
            Position position = positionList.remove(new Random().nextInt(positionList.size()));
            Player player = playerGenerator.createPlayer(position, Role.Starter);
            team.addPlayer(player);
        }
        return generateBench(team);
    }

    /**
     * Generates a random team type
     * @return Type of team
     */
    public TeamType generateRandomTeamType(){
        int random = new Random().nextInt(200);
        if(random <= 5){ //0-5, very rare
            return TeamType.Super_team;
        } else if(random <= 40){ //6-40, rare
            return TeamType.Contending_team;
        } else if(random <= 110){ //41-110, average
            return TeamType.Playoff_team;
        } else{ //111-200, common
            return TeamType.Average_team;
        }
    }

    /**
     * Generates a team given a team type
     * @param teamType Type of team
     * @return Newly generated team
     */
    public Team generateTeam(TeamType teamType){
        if(teamType == null){
            teamType = generateRandomTeamType();
        }
        switch (teamType) {
            case God_team:
                return generateGodTeam();
            case Super_team:
                return generateSuperTeam();
            case Contending_team:
                return generateContendingTeam();
            case Playoff_team:
                return generatePlayoffTeam();
            case Average_team:
                return generateAverageTeam();
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * Creates a completely random team
     * @return Team
     */
    public Team createTeam(){
        return generateTeam(generateRandomTeamType());
    }

    /**
     * Creates a team given a team type
     * @param type Type of team
     * @return Team
     */
    public Team createTeam(TeamType type){
        return generateTeam(type);
    }

}
