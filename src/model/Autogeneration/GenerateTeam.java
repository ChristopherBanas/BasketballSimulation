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
            name = TeamList.teamNameList.get(random); //O(1) time complexity
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
        ArrayList<Position> positionList = new ArrayList<>(List.of(Position.POINT_GUARD, Position.SHOOTING_GUARD,
                Position.SMALL_FORWARD, Position.POWER_FORWARD, Position.CENTER));

        for(int i=0; i<ROSTER_SIZE-5; i++){ //create bench
            Position position = positionList.remove(new Random().nextInt(positionList.size()));
            if(i == 0){ //sixth man
                team.addPlayer(generateBenchPlayer(position, Role.SIXTH_MAN));
            } else{
                team.addPlayer(generateBenchPlayer(position, Role.BENCH));
            }
        }
        return team;
    }

    /**
     * Generates a god team (5 god players)
     * @return God team
     */
    public Team generateGodTeam(){
        Team team = new Team(generateName(), generateCoach(), TeamType.GOD_TEAM);

        ArrayList<Position> positionList = new ArrayList<>(List.of(Position.POINT_GUARD, Position.SHOOTING_GUARD,
                Position.SMALL_FORWARD, Position.POWER_FORWARD, Position.CENTER));

        for(int i=0; i<5; i++){ //create starting 5
            Position position = positionList.remove(new Random().nextInt(positionList.size()));
            Player player = playerGenerator.createPlayer(position, Role.SUPERSTAR, Type.GOD);
            team.addPlayer(player);
        }
        return generateBench(team);
    }

    /**
     * Generates a super team (2 superstars, 1 star)
     * @return Super team
     */
    public Team generateSuperTeam(){
        Team team = new Team(generateName(), generateCoach(), TeamType.SUPER_TEAM);

        ArrayList<Position> positionList = new ArrayList<>(List.of(Position.POINT_GUARD, Position.SHOOTING_GUARD,
                Position.SMALL_FORWARD, Position.POWER_FORWARD, Position.CENTER));

        for(int i=0; i<5; i++){ //create starting 5
            Position position = positionList.remove(new Random().nextInt(positionList.size()));
            Role role = Role.STARTER;
            if(i < 2){ //2 superstars needed for super team
                role = Role.SUPERSTAR;
            } else if(i == 2){ //1 star needed for super team
                role = Role.STAR;
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
        Team team = new Team(generateName(), generateCoach(), TeamType.CONTENDING_TEAM);

        ArrayList<Position> positionList = new ArrayList<>(List.of(Position.POINT_GUARD, Position.SHOOTING_GUARD,
                Position.SMALL_FORWARD, Position.POWER_FORWARD, Position.CENTER));

        int numOfSuperstars = (int) (Math.random() * (2 - 1 + 1) + 1);
        for(int i=0; i<5; i++){ //create starting 5
            Position position = positionList.remove(new Random().nextInt(positionList.size()));
            Role role = Role.STARTER;
            if(i < numOfSuperstars){ //1 or 2 superstars needed for contending team
                role = Role.SUPERSTAR;
            } else if(i == numOfSuperstars && numOfSuperstars == 1){ //1 star needed for with super star
                role = Role.STAR;
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
        Team team = new Team(generateName(), generateCoach(), TeamType.PLAYOFF_TEAM);

        ArrayList<Position> positionList = new ArrayList<>(List.of(Position.POINT_GUARD, Position.SHOOTING_GUARD,
                Position.SMALL_FORWARD, Position.POWER_FORWARD, Position.CENTER));

        int numOfStars = (int) (Math.random() * (2 - 1 + 1) + 1);
        for(int i=0; i<5; i++){ //create starting 5
            Position position = positionList.remove(new Random().nextInt(positionList.size()));
            Role role = Role.STARTER;
            if(i < numOfStars){ //1 or 2 stars needed for playoff team
                role = Role.STAR;
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
        Team team = new Team(generateName(), generateCoach(), TeamType.AVERAGE_TEAM);

        ArrayList<Position> positionList = new ArrayList<>(List.of(Position.POINT_GUARD, Position.SHOOTING_GUARD,
                Position.SMALL_FORWARD, Position.POWER_FORWARD, Position.CENTER));

        for(int i=0; i<5; i++){ //create starting 5
            Position position = positionList.remove(new Random().nextInt(positionList.size()));
            Player player = playerGenerator.createPlayer(position, Role.STARTER);
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
            return TeamType.SUPER_TEAM;
        } else if(random <= 40){ //6-40, rare
            return TeamType.CONTENDING_TEAM;
        } else if(random <= 110){ //41-110, average
            return TeamType.PLAYOFF_TEAM;
        } else{ //111-200, common
            return TeamType.AVERAGE_TEAM;
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
        return switch (teamType){
            case GOD_TEAM -> generateGodTeam();
            case SUPER_TEAM -> generateSuperTeam();
            case CONTENDING_TEAM -> generateContendingTeam();
            case PLAYOFF_TEAM -> generatePlayoffTeam();
            case AVERAGE_TEAM -> generateAverageTeam();
        };
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
