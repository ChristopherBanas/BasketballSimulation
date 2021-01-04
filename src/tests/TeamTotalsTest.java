package tests;

import model.Coach;
import model.Player;
import model.PlayerType;
import model.TeamTotals;
import model.Team;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamTotalsTest {

    @Test
    void TeamStats(){
        Player curry = new Player("Curry", 31, PlayerType.SHARPSHOOTER);
        Player draymond = new Player("Draymond", 31, PlayerType.PLAYMAKER);
        Player durant = new Player("Durant", 33, PlayerType.WELL_ROUNDED);
        Coach kerr = new Coach("Kerr", 50);
        Team warriors = new Team("Warriors", kerr);
        warriors.addPlayer(curry);
        warriors.addPlayer(draymond);
        warriors.addPlayer(durant);
        TeamTotals stats = new TeamTotals(warriors);
        assertTrue(stats.getInsideDefenseAverage() < 100);
    }

}