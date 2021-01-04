package tests;

import model.Player;
import model.PlayerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("Lebron James", 35, PlayerType.WELL_ROUNDED);
    }

    @Test
    void getType() {
        assertEquals(PlayerType.WELL_ROUNDED, player.getType());
    }

    @Test
    void increaseAge() {
        player.increaseAge();
        assertEquals(36, player.getAge());
    }

}