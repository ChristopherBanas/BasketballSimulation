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
        Player benSimmons = new Player("Ben Simmons", 25, Type.Defensive_playmaker,
                Role.Star, Position.Point_guard);
        Player joelEmbiid = new Player("Joel Embiid", 26, Type.Paint_beast,
                Role.Superstar, Position.Center);
        Player sethCurry = new Player("Seth Curry", 30, Type.Pure_shooter,
                Role.Starter, Position.Shooting_guard);
        Player dannyGreen = new Player("Danny Green", 33, Type.Three_and_D,
                Role.Starter, Position.Small_forward);
        Player tobiasHarris = new Player("Tobias Harris", 30, Type.Three_level_scorer,
                Role.Starter, Position.Power_forward);
        Player dwightHoward = new Player("Dwight Howard", 35, Type.Energetic_rebounder,
                Role.Bench, Position.Center);
        Player matisseThybulle = new Player("Matisse Thybulle", 20, Type.Perimeter_defender,
                Role.Bench, Position.Small_forward);
        Player shakeMilton = new Player("Shake Milton", 20, Type.Offensive_playmaker,
                Role.Sixth_man, Position.Shooting_guard);
        Player tyreseMaxey = new Player("Tyrese Maxey", 20, Type.Playmaker,
                Role.Bench, Position.Point_guard);
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
        Player lebronJames = new Player("Lebron James", 36, Type.Balanced_superstar,
                Role.Superstar, Position.Small_forward);
        Player anthonyDavis = new Player("Anthony Davis", 28, Type.Two_way_superstar,
                Role.Superstar, Position.Power_forward);
        Player dennisShroder = new Player("Dennis Shroder", 27, Type.Offensive_playmaker,
                Role.Starter, Position.Point_guard);
        Player kentPope = new Player("Pope", 30, Type.Pure_shooter,
                Role.Starter, Position.Shooting_guard);
        Player marcGasol = new Player("Marc Gasol", 38, Type.Inside_defender,
                Role.Starter, Position.Center);
        Player montrezHarrell = new Player("Montrez Harrell", 30, Type.Energetic_rebounder,
                Role.Sixth_man, Position.Center);
        Player kyleKuzma = new Player("Kyle Kuzma", 25, Type.Pure_shooter,
                Role.Bench, Position.Small_forward);
        Player caruso = new Player("Alex Caruso", 30, Type.Defensive_playmaker,
                Role.Bench, Position.Point_guard);
        Player wesMatthews = new Player("Wesley Matthews", 35, Type.Pure_shooter,
                Role.Bench, Position.Shooting_guard );
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
        game.printTotalResults();
    }
}