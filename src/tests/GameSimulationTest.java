package tests;

import model.*;
import model.Simulations.GameSimulation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameSimulationTest {

    private Team sixers;
    private Team lakers;
    private Game game;

    @BeforeEach
    void setUp() {
        Coach docRivers = new Coach("Doc Rivers", 50);
        Player benSimmons = new Player("Ben Simmons", 25, PlayerType.DEFENSIVE_PLAYMAKER, PlayerRole.STAR);
        Player joelEmbiid = new Player("Joel Embiid", 26, PlayerType.PAINT_BEAST, PlayerRole.STAR);
        Player sethCurry = new Player("Seth Curry", 30, PlayerType.PURE_SHOOTER, PlayerRole.STARTER);
        Player dannyGreen = new Player("Danny Green", 33, PlayerType.THREE_AND_D, PlayerRole.STARTER);
        Player tobiasHarris = new Player("Tobias Harris", 30, PlayerType.THREE_LEVEL_SCORER, PlayerRole.STARTER);
        Player dwightHoward = new Player("Dwight Howard", 35, PlayerType.HIGH_ENERGY, PlayerRole.BENCH);
        Player matisseThybulle = new Player("Matisse Thybulle", 20, PlayerType.DEFENSIVE_MINDED, PlayerRole.BENCH);
        Player shakeMilton = new Player("Shake Milton", 20, PlayerType.OFFENSIVE_PLAYMAKER, PlayerRole.SIXTH_MAN);
        Player tyreseMaxey = new Player("Tyrese Maxey", 20, PlayerType.HIGH_ENERGY, PlayerRole.BENCH);
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
        this.sixers = sixers;

        Coach frankVogel = new Coach("Frank Vogel", 60);
        Player lebronJames = new Player("Lebron James", 36, PlayerType.ALL_AROUND, PlayerRole.STAR);
        Player anthonyDavis = new Player("Anthony Davis", 28, PlayerType.PAINT_BEAST, PlayerRole.STAR);
        Player dennisShroder = new Player("Dennis Shroder", 27, PlayerType.OFFENSIVE_PLAYMAKER, PlayerRole.STARTER);
        Player kentPope = new Player("Pope", 30, PlayerType.PURE_SHOOTER, PlayerRole.STARTER);
        Player marcGasol = new Player("Marc Gasol", 38, PlayerType.DEFENSIVE_MINDED, PlayerRole.STARTER);
        Player montrezHarrell = new Player("Montrez Harrell", 30, PlayerType.HIGH_ENERGY, PlayerRole.SIXTH_MAN);
        Player kyleKuzma = new Player("Kyle Kuzma", 25, PlayerType.PURE_SHOOTER, PlayerRole.BENCH);
        Player caruso = new Player("Alex Caruso", 30, PlayerType.DEFENSIVE_PLAYMAKER, PlayerRole.BENCH);
        Player wesMatthews = new Player("Wesley Matthews", 35, PlayerType.PURE_SHOOTER, PlayerRole.BENCH);
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
        this.lakers = lakers;

        game = new Game(lakers, sixers);
        game.play();

    }

    @Test
    void runSimulation() {

    }
}