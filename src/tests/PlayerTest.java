package tests;

import model.Player;
import model.PlayerRole;
import model.PlayerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("Lebron James", 35, PlayerType.ALL_AROUND, PlayerRole.STAR);
    }

    @Test
    void getType() {
        assertEquals(PlayerType.ALL_AROUND, player.getType());
    }

    @Test
    void increaseAge() {
        player.increaseAge();
        assertEquals(36, player.getAge());
    }

}