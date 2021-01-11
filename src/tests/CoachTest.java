package tests;

import model.Team.Coach;
import model.Team.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Desc: Test class for Coach class
 * Author: Christopher Banas
 */
class CoachTest {

    private Coach coach;

    @BeforeEach
    void setUp() {
        coach = new Coach("Phil Jackson", 65, new Team("Bulls"));
    }

    @Test
    void getName() {
        assertEquals("Phil Jackson", coach.getName());
    }

    @Test
    void setName() {
        coach.setName("Greg Pop");
        assertEquals("Greg Pop", coach.getName());
    }

    @Test
    void getAge() {
        assertEquals(65, coach.getAge());
    }

    @Test
    void setAge() {
        coach.increaseAge();
        assertEquals(66, coach.getAge());
    }

    @Test
    void getTeam() {
        Team team = new Team("Bulls");
        assertEquals(team, coach.getTeam());
    }

    @Test
    void setTeam() {
        Team team = new Team("Lakers");
        coach.setTeam(team);
        assertEquals(team, coach.getTeam());
    }
}