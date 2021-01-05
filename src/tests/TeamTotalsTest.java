package tests;

import model.*;
import model.Simulations.TeamTotals;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamTotalsTest {

    @Test
    void TeamStats(){
        Player curry = new Player("Curry", 31, PlayerType.OFFENSIVE_PLAYMAKER, PlayerRole.STAR);
        Player draymond = new Player("Draymond", 31, PlayerType.DEFENSIVE_PLAYMAKER, PlayerRole.STARTER);
        Player durant = new Player("Durant", 33, PlayerType.THREE_LEVEL_SCORER, PlayerRole.STAR);
        Coach kerr = new Coach("Kerr", 50);
        Team warriors = new Team("Warriors", kerr);
        warriors.addPlayer(curry);
        warriors.addPlayer(draymond);
        warriors.addPlayer(durant);
        TeamTotals stats = new TeamTotals(warriors);
        assertTrue(stats.getInsideDefenseAverage() < 100);
    }

}