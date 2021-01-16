package tests;

import model.Player.Player;
import model.Player.Position;
import model.Player.Role;
import model.Player.Type;
import model.Team.Coach;
import model.Team.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {
    private Team team;

    @BeforeEach
    void setUp() {
        Coach coach = new Coach("Phil Jackson", 65);
        team = new Team("Lakers");
        coach.setTeam(team);
        team.setCoach(coach);
    }

    @Test
    void addWin() {
        team.addWin();
        assertEquals(1, team.getWins());
    }

    @Test
    void addLoss() {
        team.addLoss();
        assertEquals(1, team.getLosses());
    }

    @Test
    void getCoach() {
        Coach coach1 = new Coach("Phil Jackson", 65);
        Coach coach2 = new Coach("Phil Jackson", 65, team);
        assertAll(() -> assertNotEquals(coach1, team.getCoach()),
                () -> assertEquals(coach2, team.getCoach()));
    }

    @Test
    void addPlayer() {
        Player player = new Player("Lebron James", 35, Type.All_around,
                Role.Star, Position.Small_forward);
        team.addPlayer(player);
        assertAll(() -> assertEquals(1, team.getRoster().size()),
                () -> assertEquals(player, team.getRoster().get(0)));
    }

    @Test
    void removePlayer() {
        Player player1 = new Player("Lebron James", 35, Type.All_around,
                Role.Star, Position.Small_forward);
        Player player2 = new Player("Lebron James2", 37, Type.All_around,
                Role.Star, Position.Small_forward);
        team.addPlayer(player1);
        team.removePlayer(player2);
        assertEquals(1, team.getRoster().size());
        team.removePlayer(player1);
        assertEquals(0, team.getRoster().size());
    }

}