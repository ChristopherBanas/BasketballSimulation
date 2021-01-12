package tests;

import model.Autogeneration.GenerateTeam;
import model.Games.Playoffs;
import model.Team.Team;
import model.Team.TeamType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayoffsTest {
    private Playoffs playoffs;
    private GenerateTeam generator;

    @BeforeEach
    void setUp() {
        generator = new GenerateTeam();
        ArrayList<Team> teamList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Team team = generator.createTeam();
            teamList.add(team);
        }
        playoffs = new Playoffs(teamList, 2020);
    }

    @Test
    void simulateRound() {
        playoffs.simulate();
    }
}