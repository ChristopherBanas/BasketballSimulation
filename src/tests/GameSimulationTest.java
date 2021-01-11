package tests;

import model.Games.Game;
import model.Player.Player;
import model.Player.Position;
import model.Player.Role;
import model.Player.Type;
import model.Team.Coach;
import model.Team.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class GameSimulationTest {

    private Game game;

    @BeforeEach
    void setUp() {
        Coach docRivers = new Coach("Doc Rivers", 50);
        Player benSimmons = new Player("Ben Simmons", 25, Type.DEFENSIVE_PLAYMAKER,
                Role.STAR, Position.POINT_GUARD);
        Player joelEmbiid = new Player("Joel Embiid", 26, Type.PAINT_BEAST,
                Role.SUPERSTAR, Position.CENTER);
        Player sethCurry = new Player("Seth Curry", 30, Type.PURE_SHOOTER,
                Role.STARTER, Position.SHOOTING_GUARD);
        Player dannyGreen = new Player("Danny Green", 33, Type.THREE_AND_D,
                Role.STARTER, Position.SMALL_FORWARD);
        Player tobiasHarris = new Player("Tobias Harris", 30, Type.THREE_LEVEL_SCORER,
                Role.STARTER, Position.POWER_FORWARD);
        Player dwightHoward = new Player("Dwight Howard", 35, Type.ENERGETIC_REBOUNDER,
                Role.BENCH, Position.CENTER);
        Player matisseThybulle = new Player("Matisse Thybulle", 20, Type.PERIMETER_DEFENDER,
                Role.BENCH, Position.SMALL_FORWARD);
        Player shakeMilton = new Player("Shake Milton", 20, Type.OFFENSIVE_PLAYMAKER,
                Role.SIXTH_MAN, Position.SHOOTING_GUARD);
        Player tyreseMaxey = new Player("Tyrese Maxey", 20, Type.PLAYMAKER,
                Role.BENCH, Position.POINT_GUARD);
        Team sixers = new Team("Sixers", docRivers);
        ArrayList<Player> playerList = new ArrayList<>();
        playerList.add(benSimmons);
        playerList.add(joelEmbiid);
        playerList.add(sethCurry);
        playerList.add(dannyGreen);
        playerList.add(tobiasHarris);
        playerList.add(dwightHoward);
        playerList.add(matisseThybulle);
        playerList.add(shakeMilton);
        playerList.add(tyreseMaxey);
        sixers.addMultiplePlayers(playerList);

        Coach frankVogel = new Coach("Frank Vogel", 60);
        Player lebronJames = new Player("Lebron James", 36, Type.BALANCED_SUPERSTAR,
                Role.SUPERSTAR, Position.SMALL_FORWARD);
        Player anthonyDavis = new Player("Anthony Davis", 28, Type.TWO_WAY_SUPERSTAR,
                Role.SUPERSTAR, Position.POWER_FORWARD);
        Player dennisShroder = new Player("Dennis Shroder", 27, Type.OFFENSIVE_PLAYMAKER,
                Role.STARTER, Position.POINT_GUARD);
        Player kentPope = new Player("Pope", 30, Type.PURE_SHOOTER,
                Role.STARTER, Position.SHOOTING_GUARD);
        Player marcGasol = new Player("Marc Gasol", 38, Type.INSIDE_DEFENDER,
                Role.STARTER, Position.CENTER);
        Player montrezHarrell = new Player("Montrez Harrell", 30, Type.ENERGETIC_REBOUNDER,
                Role.SIXTH_MAN, Position.CENTER);
        Player kyleKuzma = new Player("Kyle Kuzma", 25, Type.PURE_SHOOTER,
                Role.BENCH, Position.SMALL_FORWARD);
        Player caruso = new Player("Alex Caruso", 30, Type.DEFENSIVE_PLAYMAKER,
                Role.BENCH, Position.POINT_GUARD);
        Player wesMatthews = new Player("Wesley Matthews", 35, Type.PURE_SHOOTER,
                Role.BENCH, Position.SHOOTING_GUARD );
        Team lakers = new Team("Lakers", frankVogel);
        ArrayList<Player> playerList2 = new ArrayList<>();
        playerList2.add(lebronJames);
        playerList2.add(anthonyDavis);
        playerList2.add(dennisShroder);
        playerList2.add(kentPope);
        playerList2.add(marcGasol);
        playerList2.add(montrezHarrell);
        playerList2.add(kyleKuzma);
        playerList2.add(caruso);
        playerList2.add(wesMatthews);
        lakers.addMultiplePlayers(playerList2);

        game = new Game(lakers, sixers);
        game.play();

    }

    @Test
    void runSimulation() {
        System.out.println(game.getTeam2().toString());
        System.out.println(game.getTeam1());
    }
}