package tests;

import model.*;
import model.Player.Player;
import model.Player.Position;
import model.Player.Role;
import model.Player.Type;
import model.Simulations.TeamTotals;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamTotalsTest {

    @Test
    void TeamStats(){
        Player curry = new Player("Curry", 31, Type.OFFENSIVE_PLAYMAKER,
                Role.STAR, Position.POINT_GUARD);
        Player draymond = new Player("Draymond", 31, Type.DEFENSIVE_PLAYMAKER,
                Role.STARTER, Position.POWER_FORWARD);
        Player durant = new Player("Durant", 33, Type.THREE_LEVEL_SCORER,
                Role.STAR, Position.SMALL_FORWARD);
        Coach kerr = new Coach("Kerr", 50);
        Team warriors = new Team("Warriors", kerr);
        warriors.addPlayer(curry);
        warriors.addPlayer(draymond);
        warriors.addPlayer(durant);
        TeamTotals stats = new TeamTotals(warriors);
        assertTrue(stats.getInsideDefenseAverage() < 100);
    }

}