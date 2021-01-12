package tests;

import model.Autogeneration.GenerateTeam;
import model.Games.Season;
import model.Player.Position;
import model.Team.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeasonTest {

    Season season;

    @BeforeEach
    void setUp() {
        GenerateTeam generator = new GenerateTeam();
        List<Team> teams = new ArrayList<>();
        teams.add(generator.createTeam());
        teams.add(generator.createTeam());
        teams.add(generator.createTeam());
        teams.add(generator.createTeam());
        ArrayList<Team> teamList = new ArrayList<>(teams);
        season = new Season(teamList, 2020);
    }

    @Test
    void arrangeGames() {
        season.arrangeGames();
        assertEquals(12, season.getGameList().size());
    }

    @Test
    void parseGameStats(){
        season.arrangeGames();
        season.playGames();
        season.parseGameStats();
        int num = season.getPlayerStatsMap().size();
        assertEquals(36, num);
    }

    @Test
    void parseSeasonStats(){
        season.simulateSeason();
        season.simulatePlayoffs();
    }
}